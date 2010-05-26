package SheetGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import RoladorDeDadosL5RGUI.Display;

public class SheetFrac implements Serializable {
	private JFrame mainWindow;
	private JPanel topPanel;
	private static RPGCharacter rpgChar;
	private Map<String, Integer> traitsMap = new HashMap<String, Integer>();
	private static SheetFrac sheet;
	private TopPanelRings ringsPanel = new TopPanelRings();
	private TopPanelInfo infoPanel = new TopPanelInfo();
	private RightPanel rightPanel = new RightPanel();
	private CenterPanel centerSkillPanel = new CenterPanel();

	public void addMainWindowItems(Container pane, RPGCharacter rpgChar) {

		// ---menu----
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.addActionListener(new NewMenuItemListener());
		// JMenuItem newCharMenuItem = new JMenuItem("Character");
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Character");
		JMenuItem loadMenuItem = new JMenuItem("Load");
		loadMenuItem.addActionListener(new LoadMenuItemListener());
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(new SaveMenuItemListener());

		fileMenu.add(newMenuItem);
		// newMenuItem.add(newCharMenuItem);
		fileMenu.add(loadMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		mainWindow.setJMenuBar(menuBar);

		// skill menu

		JMenu skillMenu = new JMenu("Skill");
		JMenuItem newSkillMenuItem = new JMenuItem("New");
		newSkillMenuItem.addActionListener(new NewSkillMenuItemListener());
		skillMenu.add(newSkillMenuItem);
		menuBar.add(skillMenu);

		// -----top panel-----
		topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(Color.lightGray);

		JPanel topPanelRings = ringsPanel.createTopPanelRing(sheet);
		JPanel topPanelInfo = infoPanel.createTopPanelInfo(sheet);
		addListeners(rpgChar);
		
		//rolling panel
		JPanel rollPanel = new DicePanel().createRollingPanel();
		
		topPanel.add(BorderLayout.EAST, rollPanel);
		topPanel.add(BorderLayout.NORTH, topPanelInfo);
		topPanel.add(BorderLayout.CENTER, topPanelRings);

		// right panel
		JPanel woundsPanel = rightPanel.createRightPanel(sheet);

		// center panel

		JPanel skillsPanel = centerSkillPanel.createCenterPanel(sheet);
		
		//roll panel
		
		
		
		
		pane.add(BorderLayout.CENTER, skillsPanel);
		pane.add(BorderLayout.EAST, woundsPanel);
		pane.add(BorderLayout.NORTH, topPanel);
	}

	class NewSkillMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			centerSkillPanel.showNewSkillWindow();
		}

	}

	class SaveMenuItemListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			JFileChooser saveChar = new JFileChooser();
			saveChar.showSaveDialog(mainWindow);
			ObjectOutputStream os;
			try {
				os = new ObjectOutputStream(new FileOutputStream(saveChar
						.getSelectedFile()));
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
				ObjectInputStream is = new ObjectInputStream(
						new FileInputStream(loadChar.getSelectedFile()));
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

	class NewMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// if (rpgChar != new RPGCharacter()){
			rpgChar = new RPGCharacter();
			addListeners(rpgChar);
			createNewSheet();
			rpgChar.notifyNewCharacter();
		}

	}

	public void addListeners(RPGCharacter rpgChar) {
		rpgChar.addListener(infoPanel);
		rpgChar.addListener(ringsPanel);
		rpgChar.addListener(rightPanel);
		rpgChar.addListener(centerSkillPanel);

	}

	public RPGCharacter getRpgChar() {
		return rpgChar;
	}

	public void createNewSheet() {
		mainWindow.setVisible(false);
		sheet.createNShowGUI(rpgChar);
		mainWindow.setVisible(true);
	}

	public void createNShowGUI(RPGCharacter rpgChar) {

		mainWindow = new JFrame("Character Sheet");
		mainWindow.setPreferredSize(new Dimension(1024, 768));
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addMainWindowItems(mainWindow.getContentPane(), rpgChar);

		// Display the window.
		mainWindow.pack();
		mainWindow.setLocationRelativeTo(null); // centers window
		mainWindow.setVisible(true);

	}

	public static void main(String[] args) {
		sheet = new SheetFrac();
		rpgChar = new RPGCharacter();
		sheet.createNShowGUI(rpgChar);

	}

}
