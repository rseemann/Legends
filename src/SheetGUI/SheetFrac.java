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
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Ficha.RPGCharacter;
import SheetGUI.Sheet.NewRPGCharacter;

public class SheetFrac{
	private JFrame mainWindow;
	private JPanel topPanel;
	private JPanel rightPanel;
	private RPGCharacter rpgChar = new RPGCharacter();
	private Map<String, Integer> traitsMap = new HashMap<String, Integer>(); 
	
	public void addMainWindowItems(Container pane) {

		// ---menu----

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load");
		loadMenuItem.addActionListener(new LoadMenuItemListener());
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(new SaveMenuItemListener());

		fileMenu.add(loadMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		mainWindow.setJMenuBar(menuBar);

		// -----top panel-----
		
		topPanel = new TopPanel().CreateTopPanel(rpgChar);
		
		pane.add(BorderLayout.NORTH, topPanel);
		

	}
	
	class SaveMenuItemListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			//RPGCharacter tmpCharToSave = new NewRPGCharacter().generateCharacterFromSheet();

			JFileChooser saveChar = new JFileChooser();
			saveChar.showSaveDialog(mainWindow);

			ObjectOutputStream os;

			try {
				os = new ObjectOutputStream(new FileOutputStream(saveChar
						.getSelectedFile()));
				//os.writeObject(tmpCharToSave);
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
				ObjectInputStream is = new ObjectInputStream(
						new FileInputStream(loadChar.getSelectedFile()));

				rpgChar = (RPGCharacter) is.readObject();



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
	
	
	public void updateInfoDataFromSheet(Map<String, String> insertedData){
		rpgChar.setName(insertedData.get("name"));
		rpgChar.setClan(insertedData.get("clan"));
		rpgChar.setSchool(insertedData.get("scho"));
	}
		
	public void updateTraitsDataFromSheet(Map<String, Integer> insertedData){
		rpgChar.setStamina(insertedData.get("stam"));
		rpgChar.setWillpower(insertedData.get("will"));
		rpgChar.setStrength(insertedData.get("stre"));
		rpgChar.setPerception(insertedData.get("perc"));
		rpgChar.setAgility(insertedData.get("agil"));
		rpgChar.setIntelligence(insertedData.get("inte"));
		rpgChar.setReflexes(insertedData.get("refl"));
		rpgChar.setAwareness(insertedData.get("awar"));
		rpgChar.setVoidRing(insertedData.get("void"));
		
		rpgChar.calcRings();
		
}
	
	public RPGCharacter getRpgChar(){
		return rpgChar;
	}
	
	
	
	
	
	public void createNShowGUI() {

		mainWindow = new JFrame("Character Sheet");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addMainWindowItems(mainWindow.getContentPane());

		// Display the window.
		mainWindow.pack();
		mainWindow.setVisible(true);

	}
	public static void main(String[] args) {
		SheetFrac gui = new SheetFrac();
		gui.createNShowGUI();

	}

}
