package SheetGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Ficha.RPGCharacter;

public class SheetFrac implements Serializable{
	private JFrame mainWindow;
	private JPanel topPanel;
	private JPanel rightPanel;
	private static RPGCharacter rpgChar;
	private Map<String, Integer> traitsMap = new HashMap<String, Integer>(); 
	private static SheetFrac sheet;
	private TopPanelRings ringsPanel = new TopPanelRings();
	private TopPanelInfo infoPanel = new TopPanelInfo();
	
	public void addMainWindowItems(Container pane, RPGCharacter rpgChar) {
				
		// ---menu----
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.addActionListener(new NewMenuItemListener());
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load");
		loadMenuItem.addActionListener(new LoadMenuItemListener());
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(new SaveMenuItemListener());

		fileMenu.add(newMenuItem);
		fileMenu.add(loadMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		mainWindow.setJMenuBar(menuBar);

		// -----top panel-----
		topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(Color.lightGray);		
		
		JPanel topPanelRings = ringsPanel.createTopPanelRing(sheet);
		JPanel topPanelInfo = infoPanel.createTopPanelInfo(sheet);
		
		addListeners(rpgChar);
		
		topPanel.add(BorderLayout.NORTH, topPanelInfo);
		topPanel.add(BorderLayout.CENTER, topPanelRings);
		
		pane.add(BorderLayout.NORTH, topPanel);
	}
	
	class SaveMenuItemListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
						
			JFileChooser saveChar = new JFileChooser();
			
			saveChar.showSaveDialog(mainWindow);

			ObjectOutputStream os;

			try {
				os = new ObjectOutputStream(new FileOutputStream(saveChar.getSelectedFile()));
				//os = new ObjectOutputStream(new FileOutputStream("testandooooo"));
				os.writeObject(rpgChar);
				os.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	class LoadMenuItemListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			JFileChooser loadChar = new JFileChooser();
			loadChar.showOpenDialog(mainWindow);
			
			try {
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(loadChar.getSelectedFile()));

				//ObjectInputStream is = new ObjectInputStream(new FileInputStream("testandooooo"));
				
				rpgChar = (RPGCharacter) is.readObject();
				addListeners(rpgChar);
				createNewSheet();
				rpgChar.notifyNewCharacter();
				
			
								
				is.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
			
		}
	}
	
	class NewMenuItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//if (rpgChar != new RPGCharacter()){
				rpgChar = new RPGCharacter();
				addListeners(rpgChar);
				createNewSheet();
				rpgChar.notifyNewCharacter();
		}
		
	}
	
	public void addListeners(RPGCharacter rpgChar){
		rpgChar.addListener(infoPanel);
		rpgChar.addListener(ringsPanel);
	}
	
	public RPGCharacter getRpgChar() {
		return rpgChar;
	}
	
	public void createNewSheet(){
		mainWindow.setVisible(false);
		sheet.createNShowGUI(rpgChar);
		mainWindow.setVisible(true);
	}
	
	public void createNShowGUI(RPGCharacter rpgChar) {

		mainWindow = new JFrame("Character Sheet");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addMainWindowItems(mainWindow.getContentPane(), rpgChar);

		// Display the window.
		mainWindow.pack();
		mainWindow.setVisible(true);

	}
	
	public static void main(String[] args) {
		sheet = new SheetFrac();
		rpgChar = new RPGCharacter();
		sheet.createNShowGUI(rpgChar);
		
		
	}

}
