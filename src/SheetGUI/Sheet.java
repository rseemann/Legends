package SheetGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Ficha.RPGCharacter;
import RoladorDeDadosL5RGUI.Display;

public class Sheet {
	private JFrame mainWindow;
	private JPanel topPanel;
	private JPanel centerPanel;
	private JPanel rightPanel;

	// 1024x768

	public void addMainWindowItems(Container pane) {

		// -----trait panel-----
		topPanel = new JPanel();
		topPanel.setBackground(Color.white);
		
		JPanel topPanelInfo = new JPanel(new GridBagLayout());
		GridBagConstraints tpi = new GridBagConstraints();
		topPanelInfo.setBackground(Color.red);
		
		JLabel nameLabel = new JLabel("Name: ");
		JTextField nameField = new JTextField(16);

		JLabel clanLabel = new JLabel("Clan: ");
		JTextField clanField = new JTextField(8);

		JLabel schoolLabel = new JLabel("School: ");
		JTextField schoolField = new JTextField(10);

		JLabel rankLabel = new JLabel("Rank: ");
		JTextField rankField = new JTextField(String.valueOf(new RPGCharacter()
				.getRank()), 1);

		JLabel insightLabel = new JLabel("Insight Rank: ");
		JTextField insightField = new JTextField(3);

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

		//----rings jpegs----
		JPanel topPanelRings = new JPanel(new GridBagLayout());
		GridBagConstraints tpr = new GridBagConstraints();
		topPanelRings.setBackground(Color.green);
		
		String imagesPath = "resources/img/images/pics/";
		JLabel earthRingJPEG = new JLabel(new ImageIcon(imagesPath+"RingOfEarth.jpg"));
		
		tpr.ipadx = 10;
		tpr.gridx = 0;
		tpr.gridy = 0;
		//topPanelRings.add(earthRingJPEG, tpr);
		
		
		//addings panels to topPanel
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

	}

	public void createNShowGUI() {

		mainWindow = new JFrame("Character Sheet");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(200, 200);

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

}
