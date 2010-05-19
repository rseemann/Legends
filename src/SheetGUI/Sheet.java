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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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

public class Sheet implements FocusListener{
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

	// 1024x768?

	public void addMainWindowItems(Container pane) {

		// -----top panel-----
		topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(Color.lightGray);

		// ---menu----

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("Edit");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(new SaveMenuItemListener());

		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		mainWindow.setJMenuBar(menuBar);

		// -------Character Info Panel--------

		JPanel topPanelInfo = new JPanel(new GridBagLayout());
		GridBagConstraints tpi = new GridBagConstraints();
		topPanelInfo.setBackground(Color.lightGray);

		tpi.insets = new Insets(10, 0, 0, 0);

		JLabel nameLabel = new JLabel("Name: ");
		nameField = new JTextField(16);

		JLabel clanLabel = new JLabel("Clan: ");
		clanField = new JTextField(8);

		JLabel schoolLabel = new JLabel("School: ");
		schoolField = new JTextField(10);

		JLabel rankLabel = new JLabel("Rank: ");
		rankField = new JTextField(
				String.valueOf(new RPGCharacter().getRank()), 1);

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
		staminaField = new JTextField("0",3);
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
		waterRingField = new JTextField("0",3);
		waterRingField.setEditable(false);
		JLabel strengthLabel = new JLabel("Strength: ");
		strengthField = new JTextField("0",3);
		strengthField.addFocusListener(this);
		JLabel perceptionLabel = new JLabel("Perception: ");
		perceptionField = new JTextField("0",3);
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
		fireRingField = new JTextField("0",3);
		fireRingField.setEditable(false);
		JLabel agilityLabel = new JLabel("Agility: ");
		agilityField = new JTextField("0",3);
		agilityField.addFocusListener(this);
		JLabel intelligenceLabel = new JLabel("Intelligence: ");
		intelligenceField = new JTextField("0",3);
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
		airRingField = new JTextField("0",3);
		airRingField.setEditable(false);
		JLabel reflexesLabel = new JLabel("Reflexes: ");
		reflexesField = new JTextField("0",3);
		reflexesField.addFocusListener(this);
		JLabel awarenessLabel = new JLabel("Awareness: ");
		awarenessField = new JTextField("0",3);
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

		voidRingField = new JTextField("0",3);
		JLabel pointsSpentLabel = new JLabel("Points Spent: ");
		pointsSpentField = new JTextField("0",3);

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

		// skills panel
		centerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints sp = new GridBagConstraints();
		centerPanel.setBackground(Color.red);

		// abilities panel
		rightPanel = new JPanel(new GridBagLayout());
		GridBagConstraints ap = new GridBagConstraints();
		rightPanel.setBackground(Color.orange);

		// adding panels
		pane.add(BorderLayout.WEST, rightPanel);
		pane.add(BorderLayout.CENTER, centerPanel);
		pane.add(BorderLayout.NORTH, topPanel);

		// action listeners//

	}

	class NewRPGCharacter{
		
		public RPGCharacter generateCharacter(){
			RPGCharacter rpgChar = new RPGCharacter();
			
			rpgChar.setName(nameField.getText());
			rpgChar.setClan(clanField.getText());
			rpgChar.setSchool(schoolField.getText());
			rpgChar.setStamina(Integer.parseInt(staminaField.getText()));
			rpgChar.setWillpower(Integer.parseInt(willpowerField.getText()));
			rpgChar.setStrength(Integer.parseInt(strengthField.getText()));
			rpgChar.setPerception(Integer.parseInt(perceptionField.getText()));
			rpgChar.setAgility(Integer.parseInt(agilityField.getText()));
			rpgChar.setIntelligence(Integer.parseInt(intelligenceField
					.getText()));
			rpgChar.setReflexes(Integer.parseInt(reflexesField.getText()));
			rpgChar.setAwareness(Integer.parseInt(awarenessField.getText()));
			rpgChar.setVoidTrait(Integer.parseInt(voidRingField.getText()));
			rpgChar.calcRings();
			return rpgChar;
		}
		
	}
	
	class SaveMenuItemListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			NewRPGCharacter newChar = new NewRPGCharacter();
			
			newChar.generateCharacter();
			
			JFileChooser saveChar = new JFileChooser();
			saveChar.showSaveDialog(mainWindow);
			
			ObjectOutputStream os;
			
			try {
				os = new ObjectOutputStream(new FileOutputStream(saveChar.getSelectedFile()));
				os.writeObject(newChar);
				os.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			
		}
	}

	public void createNShowGUI() {

		mainWindow = new JFrame("Character Sheet");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// mainWindow.setSize(200, 200);

		// Set up the content pane.
		addMainWindowItems(mainWindow.getContentPane());

		// Display the window.
		mainWindow.pack();
		mainWindow.setVisible(true);

	}

	public static void main(String[] args) {
		Sheet gui = new Sheet();
		gui.createNShowGUI();
		

	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		RPGCharacter tempRPGChar = new NewRPGCharacter().generateCharacter(); //necessary to update the ring values	
		tempRPGChar.calcRings();
		earthRingField.setText(String.valueOf(tempRPGChar.getEarthRing()));
		waterRingField.setText(String.valueOf(tempRPGChar.getWaterRing()));
		fireRingField.setText(String.valueOf(tempRPGChar.getFireRing()));
		airRingField.setText(String.valueOf(tempRPGChar.getAirRing()));
		voidRingField.setText(String.valueOf(tempRPGChar.getVoidRing()));
		
		System.out.println(tempRPGChar.getEarthRing());
			
	}

}
