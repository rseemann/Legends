package SheetGUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Ficha.RPGCharacter;
import Interfaces.IListener;
import Skills.Skill;

public class CenterPanel implements IListener {
	private JPanel centerPanel;
	private JFrame addSkillWindow;
	private JFrame editSkillWindow;
	private JFrame editingSkillWindow;
	private RPGCharacter rpgChar;
	private Border loweredetched = BorderFactory
			.createEtchedBorder(EtchedBorder.LOWERED);
	private JTextField newSkillName;
	private SkillFields editingSkillField;
	private JTextField editingSkillName;
	private JTextField editingSkillRank;
	private JTextField editSkillNameField;
	private JTextField newSkillRank;
	private ArrayList<SkillFields> skillFieldsList = new ArrayList<SkillFields>();

	public JPanel createCenterPanel(SheetFrac sheet) {
		rpgChar = sheet.getRpgChar();
		centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));

		// centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		// centerPanel.setBackground(Color.red);

		return centerPanel;
	}

	// creates the frame and get the contents for the skill the user wants to
	// add
	public void showNewSkillWindow() {

		addSkillWindow = new JFrame("Add new Skill");
		// addSkillWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addSkillWindowItems(addSkillWindow.getContentPane());
		addSkillWindow.pack();
		addSkillWindow.setLocationRelativeTo(null);
		addSkillWindow.setVisible(true);

	}

	public void showEditingSkillWindow(int index) {
		editingSkillWindow = new JFrame("Edit the choosen skill");
		// addSkillWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addEditingSkillWindowItems(editingSkillWindow.getContentPane(), index);
		editingSkillWindow.pack();
		editingSkillWindow.setLocationRelativeTo(null);
		editingSkillWindow.setVisible(true);
	}

	// creates a frame that let the user edit a skill
	public void showEditSkillWindow() {
		editSkillWindow = new JFrame("Edit Skill");
		// addSkillWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addEditSkillWindowItems(editSkillWindow.getContentPane());
		editSkillWindow.pack();
		editSkillWindow.setLocationRelativeTo(null);
		editSkillWindow.setVisible(true);
	}

	// creates the interface the use uses to add the skill
	private void addSkillWindowItems(Container pane) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));

		TitledBorder titleSkillName = BorderFactory.createTitledBorder(
				loweredetched, "Skill Name");
		newSkillName = new JTextField("", 12);
		newSkillName.setBorder(titleSkillName);

		TitledBorder titleSkillRank = BorderFactory.createTitledBorder(
				loweredetched, "Rank");
		newSkillRank = new JTextField("0", 3);
		newSkillRank.setHorizontalAlignment(JTextField.CENTER);
		newSkillRank.setBorder(titleSkillRank);

		JButton saveButton = new JButton("Ok");
		saveButton.addActionListener(new saveSkillActionListener());

		pane.add(newSkillName);
		pane.add(newSkillRank);
		pane.add(saveButton);

	}

	private void addEditingSkillWindowItems(Container pane, int index) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));

		TitledBorder titleSkillName = BorderFactory.createTitledBorder(
				loweredetched, "Skill Name");
		editingSkillName = new JTextField(skillFieldsList.get(index).getSkill()
				.getName(), 12);
		editingSkillName.setBorder(titleSkillName);

		TitledBorder titleSkillRank = BorderFactory.createTitledBorder(
				loweredetched, "Rank");
		editingSkillRank = new JTextField(skillFieldsList.get(index).getSkill()
				.getRank()
				+ "", 3);
		editingSkillRank.setHorizontalAlignment(JTextField.CENTER);
		editingSkillRank.setBorder(titleSkillRank);

		JButton saveButton = new JButton("Ok");
		saveButton.addActionListener(new saveEditedSkillActionListener());

		pane.add(editingSkillName);
		pane.add(editingSkillRank);
		pane.add(saveButton);
	}

	private void addEditSkillWindowItems(Container pane) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));

		TitledBorder titleSkillName = BorderFactory.createTitledBorder(
				loweredetched, "Enter the skill name");
		editSkillNameField = new JTextField("", 12);
		editSkillNameField.setBorder(titleSkillName);

		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new editSkillActionListener());
		pane.add(editSkillNameField);
		pane.add(okButton);

	}

	class saveEditedSkillActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(editSkillNameField.getText());
			rpgChar.removeSkill(editSkillNameField.getText());
			addSkillToChar(rpgChar, editingSkillName, editingSkillRank);
			
		}

	}

	// user clicks the save button
	class saveSkillActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) { // addskill window ok
			addSkillToChar(rpgChar, newSkillName, newSkillRank);
			addSkillWindow.dispose();
		}
	}

	class editSkillActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) { // addskill window ok
			int index = findSkillLocation(editSkillNameField.getText());
			showEditingSkillWindow(index);
			editSkillWindow.dispose();
		}

		private int findSkillLocation(String skillName) {
			int fieldIndex = 0;
			for (SkillFields field : skillFieldsList) {
				if (skillName.equalsIgnoreCase(field.getSkill().getName())) {
					editingSkillField = field;
					fieldIndex = skillFieldsList.indexOf(editingSkillField);
				}
			}
			return fieldIndex;
		}
	}

	// if the skill is new add it to the char and creates a clone of it to the
	// panel.
	private void addSkillToChar(RPGCharacter rpgChar, JTextField nameField,	JTextField rankField) {
		if (checkIfSkillIsNew(nameField.getText())) {
			rpgChar.addSkill(nameField.getText(), Integer.parseInt(rankField.getText()));
			Skill addedSkill = new Skill(nameField.getText(), Integer.parseInt(rankField.getText()));
			addSkillToCollection(addedSkill);
		} else {
			showNewSkillWindow();
		}

	}

	// check if the skill is new
	private boolean checkIfSkillIsNew(String newSkillName) {
		for (Skill existingSkill : rpgChar.getSkills()) {
			if (existingSkill.getName().equalsIgnoreCase(newSkillName)) {
				return false;
			}
		}
		return true;
	}

	// the new skill now needs to be added to the list of skills that will be
	// shown in the panel
	public void addSkillToCollection(Skill skill) {
		SkillFields newSkillField = new SkillFields(skill); // read the class'
		// description
		skillFieldsList.add(newSkillField);
		addSkillToCenterPanelFromCollection(skill);

	}

	// gets the skill from the list and puts it in the centerPanel
	private void addSkillToCenterPanelFromCollection(Skill skill) {

		for (SkillFields skillField : skillFieldsList) {
			if (skillField.getSkill() == skill) {
				centerPanel.add(skillField.getSkillPanel());
				centerPanel.validate();
				centerPanel.repaint();
			}

		}
	}

	// in case a new character is loaded, we add all skill with this iterator
	private void addAllFieldsToCenterPanel() {
		for (Skill eachSkill : rpgChar.getSkills()) {
			addSkillToCollection(eachSkill);
		}
	}

	class SkillFields {
		private Skill skill;
		private JTextField skillNameField;
		private JPanel skillPanel;
		private JTextField skillRankField;

		// creates 2 labels from the skill information and put them in a panel
		// that will be added to the centerPanel later
		public SkillFields(Skill newSkill) {
			skill = newSkill;

			String skillName = newSkill.getName();
			int skillRank = newSkill.getRank();

			skillNameField = new JTextField(skillName, 12);
			TitledBorder titleSkillName = BorderFactory.createTitledBorder(
					loweredetched, "Skill Name");
			skillNameField.setBorder(titleSkillName);
			skillNameField.setEditable(false);
			skillNameField.setHorizontalAlignment(JTextField.CENTER);

			skillRankField = new JTextField(skillRank + "", 3);
			TitledBorder titleSkillRank = BorderFactory.createTitledBorder(
					loweredetched, "Rank");
			skillRankField.setBorder(titleSkillRank);
			skillRankField.setEditable(false);
			skillRankField.setHorizontalAlignment(JTextField.CENTER);

			skillPanel = new JPanel();
			// skillPanel.setBorder(loweredetched);
			skillPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			// skillPanel.addFocusListener(this);
			skillPanel.add(skillNameField);
			skillPanel.add(skillRankField);
		}

		public JTextField getSkillNameField() {
			return skillNameField;
		}

		public JTextField getSkillRankField() {
			return skillRankField;
		}

		public JPanel getSkillPanel() {
			return skillPanel;
		}

		public Skill getSkill() {
			return skill;
		}

	}

	@Override
	public void dataUpdated() {
		System.out.println("updating center");
	}

	@Override
	public void loadNewCharacter() {
		System.out.println("updating new center");
		skillFieldsList = new ArrayList<SkillFields>();
		addAllFieldsToCenterPanel();
	}

}

/*
 * 
 * 
 * }
 * 
 * }
 */

/*
 * JTextField skillNameField; JPanel skillPanel; JTextField skillRankField;
 * 
 * skillNameField = new JTextField(skillName, 12);
 * 
 * TitledBorder titleSkillName = BorderFactory.createTitledBorder(
 * loweredetched, "Skill Name"); skillNameField.setBorder(titleSkillName);
 * //skillNameField.setEditable(false);
 * skillNameField.setHorizontalAlignment(JTextField.CENTER);
 * 
 * skillRankField = new JTextField(skillRank + "", 3); TitledBorder
 * titleSkillRank = BorderFactory.createTitledBorder(loweredetched, "Rank");
 * skillRankField.setBorder(titleSkillRank);
 * //skillRankField.setEditable(false);
 * skillRankField.setHorizontalAlignment(JTextField.CENTER);
 * 
 * skillPanel = new JPanel(); //skillPanel.setBorder(loweredetched);
 * skillPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
 * 
 * skillPanel.add(skillNameField); skillPanel.add(skillRankField);
 * 
 * centerPanel.add(skillPanel); centerPanel.validate(); centerPanel.repaint();
 * 
 * 
 * private JTextField sk1 = new JTextField("", 12); private JTextField sk2 = new
 * JTextField("", 12); private JTextField sk3 = new JTextField("", 12); private
 * JTextField sk4 = new JTextField("", 12); private JTextField sk5 = new
 * JTextField("", 12); private JTextField sk6 = new JTextField("", 12); private
 * JTextField sk7 = new JTextField("", 12); private JTextField sk8 = new
 * JTextField("", 12); private JTextField sk9 = new JTextField("", 12); private
 * JTextField sk10 = new JTextField("", 12); private JTextField sk11 = new
 * JTextField("", 12); private JTextField sk12 = new JTextField("", 12); private
 * JTextField sk13 = new JTextField("", 12); private JTextField sk14 = new
 * JTextField("", 12); private JTextField sk15 = new JTextField("", 12); private
 * JTextField sk16 = new JTextField("", 12); private JTextField sk17 = new
 * JTextField("", 12); private JTextField sk18 = new JTextField("", 12); private
 * JTextField sk19 = new JTextField("", 12); private JTextField sk20 = new
 * JTextField("", 12); private JTextField sk21 = new JTextField("", 12); private
 * JTextField sk22 = new JTextField("", 12); private JTextField sk23 = new
 * JTextField("", 12); private JTextField sk24 = new JTextField("", 12);
 * 
 * private JTextField skr1 = new JTextField("", 3); private JTextField skr2 =
 * new JTextField("", 3); private JTextField skr3 = new JTextField("", 3);
 * private JTextField skr4 = new JTextField("", 3); private JTextField skr5 =
 * new JTextField("", 3); private JTextField skr6 = new JTextField("", 3);
 * private JTextField skr7 = new JTextField("", 3); private JTextField skr8 =
 * new JTextField("", 3); private JTextField skr9 = new JTextField("", 3);
 * private JTextField skr10 = new JTextField("", 3); private JTextField skr11 =
 * new JTextField("", 3); private JTextField skr12 = new JTextField("", 3);
 * private JTextField skr13 = new JTextField("", 3); private JTextField skr14 =
 * new JTextField("", 3); private JTextField skr15 = new JTextField("", 3);
 * private JTextField skr16 = new JTextField("", 3); private JTextField skr17 =
 * new JTextField("", 3); private JTextField skr18 = new JTextField("", 3);
 * private JTextField skr19 = new JTextField("", 3); private JTextField skr20 =
 * new JTextField("", 3); private JTextField skr21 = new JTextField("", 3);
 * private JTextField skr22 = new JTextField("", 3); private JTextField skr23 =
 * new JTextField("", 3); private JTextField skr24 = new JTextField("", 3);
 * JPanel skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,-2,5)); sk1.setBorder(titleSkillName);
 * sk1.setEditable(false); sk1.setHorizontalAlignment(JTextField.CENTER);
 * skr1.setBorder(titleSkillRank); skr1.setEditable(false);
 * skr1.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk1);
 * skillPanel.add(skr1); skillPanel.setBorder(loweredetched);
 * skr1.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk2.setBorder(titleSkillName);
 * sk2.setEditable(false); sk2.setHorizontalAlignment(JTextField.CENTER);
 * skr2.setBorder(titleSkillRank); skr2.setEditable(false);
 * skr2.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk2);
 * skillPanel.add(skr2); skillPanel.setBorder(loweredetched);
 * skr2.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk3.setBorder(titleSkillName);
 * sk3.setEditable(false); sk3.setHorizontalAlignment(JTextField.CENTER);
 * skr3.setBorder(titleSkillRank); skr3.setEditable(false);
 * skr3.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk3);
 * skillPanel.add(skr3); skillPanel.setBorder(loweredetched);
 * skr3.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk4.setBorder(titleSkillName);
 * sk4.setEditable(false); sk4.setHorizontalAlignment(JTextField.CENTER);
 * skr4.setBorder(titleSkillRank); skr4.setEditable(false);
 * skr4.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk4);
 * skillPanel.add(skr4); skillPanel.setBorder(loweredetched);
 * skr4.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk5.setBorder(titleSkillName);
 * sk5.setEditable(false); sk5.setHorizontalAlignment(JTextField.CENTER);
 * skr5.setBorder(titleSkillRank); skr5.setEditable(false);
 * skr5.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk5);
 * skillPanel.add(skr5); skillPanel.setBorder(loweredetched);
 * skr5.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk6.setBorder(titleSkillName);
 * sk6.setEditable(false); sk6.setHorizontalAlignment(JTextField.CENTER);
 * skr6.setBorder(titleSkillRank); skr6.setEditable(false);
 * skr6.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk6);
 * skillPanel.add(skr6); skillPanel.setBorder(loweredetched);
 * skr6.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk7.setBorder(titleSkillName);
 * sk7.setEditable(false); sk7.setHorizontalAlignment(JTextField.CENTER);
 * skr7.setBorder(titleSkillRank); skr7.setEditable(false);
 * skr7.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk7);
 * skillPanel.add(skr7); skillPanel.setBorder(loweredetched);
 * skr7.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk8.setBorder(titleSkillName);
 * sk8.setEditable(false); sk8.setHorizontalAlignment(JTextField.CENTER);
 * skr8.setBorder(titleSkillRank); skr8.setEditable(false);
 * skr8.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk8);
 * skillPanel.add(skr8); skillPanel.setBorder(loweredetched);
 * skr8.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk9.setBorder(titleSkillName);
 * sk9.setEditable(false); sk9.setHorizontalAlignment(JTextField.CENTER);
 * skr9.setBorder(titleSkillRank); skr9.setEditable(false);
 * skr9.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk9);
 * skillPanel.add(skr9); skillPanel.setBorder(loweredetched);
 * skr9.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk10.setBorder(titleSkillName);
 * sk10.setEditable(false); sk10.setHorizontalAlignment(JTextField.CENTER);
 * skr10.setBorder(titleSkillRank); skr10.setEditable(false);
 * skr10.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk10);
 * skillPanel.add(skr10); skillPanel.setBorder(loweredetched);
 * skr10.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk11.setBorder(titleSkillName);
 * sk11.setEditable(false); sk11.setHorizontalAlignment(JTextField.CENTER);
 * skr11.setBorder(titleSkillRank); skr11.setEditable(false);
 * skr11.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk11);
 * skillPanel.add(skr11); skillPanel.setBorder(loweredetched);
 * skr11.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk12.setBorder(titleSkillName);
 * sk12.setEditable(false); sk12.setHorizontalAlignment(JTextField.CENTER);
 * skr12.setBorder(titleSkillRank); skr12.setEditable(false);
 * skr12.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk12);
 * skillPanel.add(skr12); skillPanel.setBorder(loweredetched);
 * skr12.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk13.setBorder(titleSkillName);
 * sk13.setEditable(false); sk13.setHorizontalAlignment(JTextField.CENTER);
 * skr13.setBorder(titleSkillRank); skr13.setEditable(false);
 * skr13.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk13);
 * skillPanel.add(skr13); skillPanel.setBorder(loweredetched);
 * skr13.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk14.setBorder(titleSkillName);
 * sk14.setEditable(false); sk14.setHorizontalAlignment(JTextField.CENTER);
 * skr14.setBorder(titleSkillRank); skr14.setEditable(false);
 * skr14.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk14);
 * skillPanel.add(skr14); skillPanel.setBorder(loweredetched);
 * skr14.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk15.setBorder(titleSkillName);
 * sk15.setEditable(false); sk15.setHorizontalAlignment(JTextField.CENTER);
 * skr15.setBorder(titleSkillRank); skr15.setEditable(false);
 * skr15.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk15);
 * skillPanel.add(skr15); skillPanel.setBorder(loweredetched);
 * skr15.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk16.setBorder(titleSkillName);
 * sk16.setEditable(false); sk16.setHorizontalAlignment(JTextField.CENTER);
 * skr16.setBorder(titleSkillRank); skr16.setEditable(false);
 * skr16.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk16);
 * skillPanel.add(skr16); skillPanel.setBorder(loweredetched);
 * skr16.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk17.setBorder(titleSkillName);
 * sk17.setEditable(false); sk17.setHorizontalAlignment(JTextField.CENTER);
 * skr17.setBorder(titleSkillRank); skr17.setEditable(false);
 * skr17.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk17);
 * skillPanel.add(skr17); skillPanel.setBorder(loweredetched);
 * skr17.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk18.setBorder(titleSkillName);
 * sk18.setEditable(false); sk18.setHorizontalAlignment(JTextField.CENTER);
 * skr18.setBorder(titleSkillRank); skr18.setEditable(false);
 * skr18.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk18);
 * skillPanel.add(skr18); skillPanel.setBorder(loweredetched);
 * skr18.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk19.setBorder(titleSkillName);
 * sk19.setEditable(false); sk19.setHorizontalAlignment(JTextField.CENTER);
 * skr19.setBorder(titleSkillRank); skr19.setEditable(false);
 * skr19.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk19);
 * skillPanel.add(skr19); skillPanel.setBorder(loweredetched);
 * skr19.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk20.setBorder(titleSkillName);
 * sk20.setEditable(false); sk20.setHorizontalAlignment(JTextField.CENTER);
 * skr20.setBorder(titleSkillRank); skr20.setEditable(false);
 * skr20.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk20);
 * skillPanel.add(skr20); skillPanel.setBorder(loweredetched);
 * skr20.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk21.setBorder(titleSkillName);
 * sk21.setEditable(false); sk21.setHorizontalAlignment(JTextField.CENTER);
 * skr21.setBorder(titleSkillRank); skr21.setEditable(false);
 * skr21.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk21);
 * skillPanel.add(skr21); skillPanel.setBorder(loweredetched);
 * skr21.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk22.setBorder(titleSkillName);
 * sk22.setEditable(false); sk22.setHorizontalAlignment(JTextField.CENTER);
 * skr22.setBorder(titleSkillRank); skr22.setEditable(false);
 * skr22.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk22);
 * skillPanel.add(skr22); skillPanel.setBorder(loweredetched);
 * skr22.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk23.setBorder(titleSkillName);
 * sk23.setEditable(false); sk23.setHorizontalAlignment(JTextField.CENTER);
 * skr23.setBorder(titleSkillRank); skr23.setEditable(false);
 * skr23.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk23);
 * skillPanel.add(skr23); skillPanel.setBorder(loweredetched);
 * skr23.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 * 
 * skillPanel = new JPanel(); skillPanel.setLayout(new
 * FlowLayout(FlowLayout.CENTER,0,5)); sk24.setBorder(titleSkillName);
 * sk24.setEditable(false); sk24.setHorizontalAlignment(JTextField.CENTER);
 * skr24.setBorder(titleSkillRank); skr24.setEditable(false);
 * skr24.setHorizontalAlignment(JTextField.CENTER); skillPanel.add(sk24);
 * skillPanel.add(skr24); skillPanel.setBorder(loweredetched);
 * skr24.setHorizontalAlignment(JTextField.CENTER); centerPanel.add(skillPanel);
 */
