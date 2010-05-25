package SheetGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Ficha.RPGCharacter;
import Interfaces.IListener;

public class CenterPanel{
	private JPanel centerPanel;
	private JFrame addSkillWindow;
	private RPGCharacter rpgChar; 
	
	private void addMainWindowItems(Container pane, RPGCharacter rpgChar) {
		
		
		
		pane.add(new JLabel("Há!!"));
		
	}
	
	public JPanel createCenterPanel(SheetFrac sheet) {
		centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(Color.red);
		return centerPanel;
	}
	
	public void showNewSkillWindow() {
		
		addSkillWindow = new JFrame("Add new Skill");
		//addSkillWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMainWindowItems(addSkillWindow.getContentPane(), rpgChar);
		addSkillWindow.pack();
		addSkillWindow.setVisible(true);
		
	}

	
}
