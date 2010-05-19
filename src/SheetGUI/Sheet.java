package SheetGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Ficha.RPGCharacter;

public class Sheet implements FocusListener {
	private JFrame mainWindow;
	private JPanel topPanel;
	private JPanel centerPanel;
	private JPanel rightPanel;
	private JTextField clanField;
	private JTextField nameField;
	private JTextField schoolField;
	private JTextField rankField;
	private JTextField insightField;
	private JTextField earthRingField;
	private JTextField staminaField;
	private JTextField willpowerField;
	private JTextField waterRingField;
	private JTextField strengthField;
	private JTextField perceptionField;
	private JTextField fireRingField;
	private JTextField agilityField;
	private JTextField intelligenceField;
	private JTextField airRingField;
	private JTextField reflexesField;
	private JTextField awarenessField;
	private JTextField voidRingField;
	private JTextField pointsSpentField;
	private NewRPGCharacter updater = new NewRPGCharacter();
	private RPGCharacter activeCharacter;

	// 1024x768?

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

		topPanel = CreateTopPanel();

		// skills panel
		centerPanel = CreateCenterPanel();

		// abilities panel
		rightPanel = CreateRightPanel();

		// adding panels
		pane.add(BorderLayout.EAST, rightPanel);
		pane.add(BorderLayout.CENTER, centerPanel);
		pane.add(BorderLayout.NORTH, topPanel);

	}

	private JPanel CreateRightPanel() {
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridBagLayout());
		GridBagConstraints ap = new GridBagConstraints();

		activeCharacter = updater.generateCharacterFromSheet();
		
		

		JLabel woundsTitle = new JLabel("Wounds");
		rightPanel.add(woundsTitle);
		rightPanel.setBackground(Color.orange);

		return rightPanel;
	}

	private JPanel CreateCenterPanel() {
		centerPanel = new JPanel(new GridBagLayout());
		// GridBagConstraints sp = new GridBagConstraints();
		centerPanel.setBackground(Color.red);
		return centerPanel;
	}

	// creates the top panel
	private JPanel CreateTopPanel() {
		topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(Color.lightGray);

		// -------Character Info Panel--------
		JPanel topPanelInfo = new JPanel(new GridBagLayout());
		GridBagConstraints tpi = new GridBagConstraints();
		topPanelInfo.setBackground(Color.lightGray);

		tpi.insets = new Insets(10, 0, 0, 0);

		JLabel nameLabel = new JLabel("Name: ");
		nameField = new JTextField("",16);

		JLabel clanLabel = new JLabel("Clan: ");
		clanField = new JTextField("",8);

		JLabel schoolLabel = new JLabel("School: ");
		schoolField = new JTextField("",10);

		JLabel rankLabel = new JLabel("Rank: ");
		rankField = new JTextField("0", 1);

		JLabel insightLabel = new JLabel("Insight Rank: ");
		insightField = new JTextField(3);

		tpi.ipadx = 10;
		tpi.gridx = 0;
		topPanelInfo.add(nameLabel, tpi);

		tpi.gridx = 1;
		topPanelInfo.add(nameField, tpi);

		tpi.gridx = 2;
		topPanelInfo.add(clanLabel, tpi);

		tpi.gridx = 3;
		topPanelInfo.add(clanField, tpi);

		tpi.gridx = 4;
		topPanelInfo.add(schoolLabel, tpi);

		tpi.gridx = 5;
		topPanelInfo.add(schoolField, tpi);

		tpi.gridx = 6;
		topPanelInfo.add(rankLabel, tpi);

		tpi.gridx = 7;
		topPanelInfo.add(rankField, tpi);

		tpi.gridx = 8;
		topPanelInfo.add(insightLabel, tpi);

		tpi.gridx = 9;
		topPanelInfo.add(insightField, tpi);

		// ----Character Traits and Rings Panel----
		JPanel topPanelRings = new JPanel(new GridBagLayout());
		GridBagConstraints tpr = new GridBagConstraints();
		topPanelRings.setBackground(Color.lightGray);

		String imagesPath = "resources/img/images/pics/";
		JLabel earthRingJPEG = new JLabel(new ImageIcon(imagesPath
				+ "RingOfEarth.jpg"));
		JLabel waterRingJPEG = new JLabel(new ImageIcon(imagesPath
				+ "RingOfWater.jpg"));
		JLabel fireRingJPEG = new JLabel(new ImageIcon(imagesPath
				+ "RingOfFire.jpg"));
		JLabel airRingJPEG = new JLabel(new ImageIcon(imagesPath
				+ "RingOfAir.jpg"));
		JLabel voidRingJPEG = new JLabel(new ImageIcon(imagesPath
				+ "RingOftheVoid.jpg"));

		// earth ring
		tpr.insets = new Insets(10, 0, 0, 0);
		tpr.ipadx = 10;
		tpr.gridx = 0;
		tpr.gridy = 0;
		tpr.gridwidth = 2;
		topPanelRings.add(earthRingJPEG, tpr);
		tpr.insets = new Insets(3, 0, 0, 0);

		JLabel earthRingLabel = new JLabel("Earth: ");
		earthRingField = new JTextField("0", 3);
		earthRingField.setEditable(false);
		JLabel staminaLabel = new JLabel("Stamina: ");
		staminaField = new JTextField("0", 3);
		staminaField.addFocusListener(this);

		JLabel willpowerLabel = new JLabel("Willpower: ");
		willpowerField = new JTextField("0", 3);
		willpowerField.addFocusListener(this);
		tpr.gridwidth = 1;

		tpr.gridy = 1;
		tpr.gridx = 0;
		topPanelRings.add(earthRingLabel, tpr);

		tpr.gridy = 1;
		tpr.gridx = 1;
		topPanelRings.add(earthRingField, tpr);

		tpr.gridy = 2;
		tpr.gridx = 0;
		topPanelRings.add(staminaLabel, tpr);

		tpr.gridy = 2;
		tpr.gridx = 1;
		topPanelRings.add(staminaField, tpr);

		tpr.gridy = 3;
		tpr.gridx = 0;
		topPanelRings.add(willpowerLabel, tpr);

		tpr.gridy = 3;
		tpr.gridx = 1;
		topPanelRings.add(willpowerField, tpr);

		// water Ring
		tpr.insets = new Insets(10, 0, 0, 0);
		tpr.gridy = 0;
		tpr.gridx = 2;
		tpr.gridwidth = 2;
		topPanelRings.add(waterRingJPEG, tpr);
		tpr.insets = new Insets(3, 0, 0, 0);

		JLabel waterRingLabel = new JLabel("Water: ");
		waterRingField = new JTextField("0", 3);
		waterRingField.setEditable(false);
		JLabel strengthLabel = new JLabel("Strength: ");
		strengthField = new JTextField("0", 3);
		strengthField.addFocusListener(this);
		JLabel perceptionLabel = new JLabel("Perception: ");
		perceptionField = new JTextField("0", 3);
		perceptionField.addFocusListener(this);

		tpr.gridwidth = 1;
		tpr.gridy = 1;
		tpr.gridx = 2;
		topPanelRings.add(waterRingLabel, tpr);

		tpr.gridy = 1;
		tpr.gridx = 3;
		topPanelRings.add(waterRingField, tpr);

		tpr.gridy = 2;
		tpr.gridx = 2;
		topPanelRings.add(strengthLabel, tpr);

		tpr.gridy = 2;
		tpr.gridx = 3;
		topPanelRings.add(strengthField, tpr);

		tpr.gridy = 3;
		tpr.gridx = 2;
		topPanelRings.add(perceptionLabel, tpr);

		tpr.gridy = 3;
		tpr.gridx = 3;
		topPanelRings.add(perceptionField, tpr);

		// fire ring
		tpr.insets = new Insets(10, 0, 0, 0);
		tpr.gridy = 0;
		tpr.gridx = 4;
		tpr.gridwidth = 2;
		topPanelRings.add(fireRingJPEG, tpr);
		tpr.insets = new Insets(3, 0, 0, 0);

		tpr.gridwidth = 1;
		JLabel fireRingLabel = new JLabel("Fire: ");
		fireRingField = new JTextField("0", 3);
		fireRingField.setEditable(false);
		JLabel agilityLabel = new JLabel("Agility: ");
		agilityField = new JTextField("0", 3);
		agilityField.addFocusListener(this);
		JLabel intelligenceLabel = new JLabel("Intelligence: ");
		intelligenceField = new JTextField("0", 3);
		intelligenceField.addFocusListener(this);

		tpr.gridwidth = 1;
		tpr.gridy = 1;
		tpr.gridx = 4;
		topPanelRings.add(fireRingLabel, tpr);

		tpr.gridy = 1;
		tpr.gridx = 5;
		topPanelRings.add(fireRingField, tpr);

		tpr.gridy = 2;
		tpr.gridx = 4;
		topPanelRings.add(agilityLabel, tpr);

		tpr.gridy = 2;
		tpr.gridx = 5;
		topPanelRings.add(agilityField, tpr);

		tpr.gridy = 3;
		tpr.gridx = 4;
		topPanelRings.add(intelligenceLabel, tpr);

		tpr.gridy = 3;
		tpr.gridx = 5;
		topPanelRings.add(intelligenceField, tpr);

		// air ring
		tpr.insets = new Insets(10, 0, 0, 0);
		tpr.gridy = 0;
		tpr.gridx = 6;
		tpr.gridwidth = 2;
		topPanelRings.add(airRingJPEG, tpr);
		tpr.insets = new Insets(3, 0, 0, 0);
		tpr.gridwidth = 1;

		JLabel airRingLabel = new JLabel("Air: ");
		airRingField = new JTextField("0", 3);
		airRingField.setEditable(false);
		JLabel reflexesLabel = new JLabel("Reflexes: ");
		reflexesField = new JTextField("0", 3);
		reflexesField.addFocusListener(this);
		JLabel awarenessLabel = new JLabel("Awareness: ");
		awarenessField = new JTextField("0", 3);
		awarenessField.addFocusListener(this);

		tpr.gridwidth = 1;
		tpr.gridy = 1;
		tpr.gridx = 6;
		topPanelRings.add(airRingLabel, tpr);

		tpr.gridy = 1;
		tpr.gridx = 7;
		topPanelRings.add(airRingField, tpr);

		tpr.gridy = 2;
		tpr.gridx = 6;
		topPanelRings.add(reflexesLabel, tpr);

		tpr.gridy = 2;
		tpr.gridx = 7;
		topPanelRings.add(reflexesField, tpr);

		tpr.gridy = 3;
		tpr.gridx = 6;
		topPanelRings.add(awarenessLabel, tpr);

		tpr.gridy = 3;
		tpr.gridx = 7;
		topPanelRings.add(awarenessField, tpr);

		// void ring
		tpr.insets = new Insets(10, 0, 0, 0);
		tpr.gridy = 0;
		tpr.gridx = 8;
		tpr.gridwidth = 2;
		topPanelRings.add(voidRingJPEG, tpr);
		tpr.insets = new Insets(3, 0, 0, 0);
		tpr.gridwidth = 1;

		JLabel voidRingLabel = new JLabel("Void: ");

		voidRingField = new JTextField("0", 3);
		JLabel pointsSpentLabel = new JLabel("Points Spent: ");
		pointsSpentField = new JTextField("0", 3);

		tpr.gridwidth = 1;
		tpr.gridy = 1;
		tpr.gridx = 8;
		topPanelRings.add(voidRingLabel, tpr);

		tpr.gridy = 1;
		tpr.gridx = 9;
		topPanelRings.add(voidRingField, tpr);

		tpr.gridy = 2;
		tpr.gridx = 8;
		topPanelRings.add(pointsSpentLabel, tpr);

		tpr.gridy = 2;
		tpr.gridx = 9;
		topPanelRings.add(pointsSpentField, tpr);

		// addings panels to topPanel
		topPanel.add(BorderLayout.NORTH, topPanelInfo);
		topPanel.add(BorderLayout.CENTER, topPanelRings);
		return topPanel;
	}

	class NewRPGCharacter {
		// this class exists only to get the data inserted in the sheet

		RPGCharacter tmpChar = new RPGCharacter();

		public void updateAll() {
			updateTopFields(); // first fields with traits and info
			updateRings(); // only then rings can be updated
			updateWounds();
			activeCharacter = updater.generateCharacterFromSheet();
		}

		public RPGCharacter generateCharacterFromSheet() {

			tmpChar.setName(nameField.getText());
			tmpChar.setClan(clanField.getText());
			tmpChar.setSchool(schoolField.getText());
			tmpChar.setStamina(Integer.parseInt(staminaField.getText()));
			tmpChar.setWillpower(Integer.parseInt(willpowerField.getText()));
			tmpChar.setStrength(Integer.parseInt(strengthField.getText()));
			tmpChar.setPerception(Integer.parseInt(perceptionField.getText()));
			tmpChar.setAgility(Integer.parseInt(agilityField.getText()));
			tmpChar.setIntelligence(Integer.parseInt(intelligenceField
					.getText()));
			tmpChar.setReflexes(Integer.parseInt(reflexesField.getText()));
			tmpChar.setAwareness(Integer.parseInt(awarenessField.getText()));
			tmpChar.setVoidTrait(Integer.parseInt(voidRingField.getText()));
			tmpChar.calcRings();
			return tmpChar;

		}

		public void updateTopFields() { // not updating the rings' values, use
			// updateRings() instead
			nameField.setText(activeCharacter.getName());
			clanField.setText(activeCharacter.getClan());
			schoolField.setText(activeCharacter.getSchool());
			staminaField.setText(String.valueOf(activeCharacter.getStamina()));
			willpowerField.setText(String.valueOf(activeCharacter
					.getWillpower()));
			strengthField.setText(String.valueOf(activeCharacter.getStength()));
			perceptionField.setText(String.valueOf(activeCharacter
					.getPerception()));
			agilityField.setText(String.valueOf(activeCharacter.getAgility()));
			intelligenceField.setText(String.valueOf(activeCharacter
					.getIntelligence()));
			reflexesField
					.setText(String.valueOf(activeCharacter.getReflexes()));
			awarenessField.setText(String.valueOf(activeCharacter
					.getAwareness()));
			voidRingField.setText(String
					.valueOf(activeCharacter.getVoidTrait()));

		}

		public void updateRings() {
			RPGCharacter tempRPGCharToUpdateRings = new NewRPGCharacter()
					.generateCharacterFromSheet();
			// necessary to update the rings' values

			tempRPGCharToUpdateRings.calcRings();
			earthRingField.setText(String.valueOf(tempRPGCharToUpdateRings
					.getEarthRing()));
			waterRingField.setText(String.valueOf(tempRPGCharToUpdateRings
					.getWaterRing()));
			fireRingField.setText(String.valueOf(tempRPGCharToUpdateRings
					.getFireRing()));
			airRingField.setText(String.valueOf(tempRPGCharToUpdateRings
					.getAirRing()));
			voidRingField.setText(String.valueOf(tempRPGCharToUpdateRings
					.getVoidRing()));
		}

		public void updateWounds() {
			activeCharacter.setWounds(Integer.parseInt(earthRingField.getText()));
			activeCharacter.getWounds();
			System.out.println(activeCharacter.getWounds());
		}
	}

	// action listeners//
	class SaveMenuItemListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			RPGCharacter tmpCharToSave = new NewRPGCharacter()
					.generateCharacterFromSheet();

			JFileChooser saveChar = new JFileChooser();
			saveChar.showSaveDialog(mainWindow);

			ObjectOutputStream os;

			try {
				os = new ObjectOutputStream(new FileOutputStream(saveChar
						.getSelectedFile()));
				os.writeObject(tmpCharToSave);
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

				activeCharacter = (RPGCharacter) is.readObject();

				updater.updateAll();

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

	public void createNShowGUI() {

		mainWindow = new JFrame("Character Sheet");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addMainWindowItems(mainWindow.getContentPane());

		// Display the window.
		mainWindow.pack();
		mainWindow.setVisible(true);

	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		updater.updateRings();
		updater.updateWounds();

	}

	public static void main(String[] args) {
		Sheet gui = new Sheet();
		gui.createNShowGUI();

	}
}