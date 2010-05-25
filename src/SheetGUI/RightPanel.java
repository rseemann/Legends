package SheetGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Ficha.RPGCharacter;
import Interfaces.IListener;

public class RightPanel implements IListener, KeyListener {
	private JPanel rightPanel;
	private Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	private TitledBorder titleWounds;
	private RPGCharacter rpgChar;
	private JLabel lvl1 = new JLabel();
	private JLabel lvl2 = new JLabel();
	private JLabel lvl3 = new JLabel();
	private JLabel lvl4 = new JLabel();
	private JLabel lvl5 = new JLabel();
	private JLabel lvl6 = new JLabel();
	private JLabel lvl7 = new JLabel();
	private JLabel lvl8 = new JLabel();
	private JTextField currentDmg = new JTextField("0", 5);
	private ArrayList<JLabel> woundLevels = new ArrayList<JLabel>();

	public JPanel createRightPanel(SheetFrac sheet) {
		rpgChar = sheet.getRpgChar();
		rightPanel = new JPanel(new GridBagLayout());
		GridBagConstraints rp = new GridBagConstraints();
		titleWounds = BorderFactory.createTitledBorder(loweredetched, "WOUNDS");
		rightPanel.setBorder(titleWounds);

		
		rp.ipadx = 10;
		rp.gridx = 0;
		rp.gridy = 0;
		rightPanel.add(createWoundsLvlPanel(), rp);

		rp.gridx = 1;
		rp.gridy = 0;
		rightPanel.add(createMaxWoundsPerLvlPanel(), rp);
		
		rp.insets = new Insets(10, 0, 0, 0);
		rp.gridx = 0;
		rp.gridy = 1;
		JPanel comp = new JPanel();
		JLabel dmgRecieved = new JLabel("Current Dmg", JLabel.CENTER);
		dmgRecieved.setForeground(Color.WHITE);
		comp.add(dmgRecieved);
		comp.setBackground(Color.darkGray);
		comp.setBorder(loweredetched);
		rightPanel.add(comp, rp);

		rp.gridx = 1;
		rp.gridy = 1;
		currentDmg.setHorizontalAlignment(JTextField.CENTER);
		currentDmg.addKeyListener(this);
		rightPanel.add(currentDmg, rp);

		rightPanel.setBackground(Color.orange);

		return rightPanel;
	}

	public JPanel createWoundsLvlPanel() {
		JPanel woundsPanel = new JPanel();
		woundsPanel.setLayout(new BoxLayout(woundsPanel, BoxLayout.Y_AXIS));

		addWoundLvlComponent(loweredetched, "WOUND LVL", woundsPanel);
		addWoundLvlComponent(loweredetched, "Healthy (+0)", woundsPanel);
		addWoundLvlComponent(loweredetched, "Nicked (+3)", woundsPanel);
		addWoundLvlComponent(loweredetched, "Grazed (+5)", woundsPanel);
		addWoundLvlComponent(loweredetched, "Hurt (+10)", woundsPanel);
		addWoundLvlComponent(loweredetched, "Injured (+15)", woundsPanel);
		addWoundLvlComponent(loweredetched, "Crippled (+20)", woundsPanel);
		addWoundLvlComponent(loweredetched, "Down (+40)", woundsPanel);
		addWoundLvlComponent(loweredetched, "Out", woundsPanel);

		return woundsPanel;
	}

	public JPanel createMaxWoundsPerLvlPanel() {
		JPanel woundsMaxPerLevel = new JPanel();
		woundsMaxPerLevel.setLayout(new BoxLayout(woundsMaxPerLevel,
				BoxLayout.Y_AXIS));

		addWoundLvlComponent(loweredetched, "MAX WOUNDS", woundsMaxPerLevel);
		rpgChar.setWounds();

		JPanel comp = new JPanel();
		lvl1 = new JLabel(rpgChar.getWounds().get("Healthy") + "",
				JLabel.CENTER);
		comp.add(lvl1);
		comp.setBorder(loweredetched);
		woundsMaxPerLevel.add(comp);

		comp = new JPanel();
		lvl2 = new JLabel(rpgChar.getWounds().get("Nicked") + "", JLabel.CENTER);
		comp.add(lvl2);
		comp.setBorder(loweredetched);
		woundsMaxPerLevel.add(comp);

		comp = new JPanel();
		lvl3 = new JLabel(rpgChar.getWounds().get("Grazed") + "", JLabel.CENTER);
		comp.add(lvl3);
		comp.setBorder(loweredetched);
		woundsMaxPerLevel.add(comp);

		comp = new JPanel();
		lvl4 = new JLabel(rpgChar.getWounds().get("Hurt") + "", JLabel.CENTER);
		comp.add(lvl4);
		comp.setBorder(loweredetched);
		woundsMaxPerLevel.add(comp);

		comp = new JPanel();
		lvl5 = new JLabel(rpgChar.getWounds().get("Injured") + "",
				JLabel.CENTER);
		comp.add(lvl5);
		comp.setBorder(loweredetched);
		woundsMaxPerLevel.add(comp);

		comp = new JPanel();
		lvl6 = new JLabel(rpgChar.getWounds().get("Crippled") + "",
				JLabel.CENTER);
		comp.add(lvl6);
		comp.setBorder(loweredetched);
		woundsMaxPerLevel.add(comp);

		comp = new JPanel();
		lvl7 = new JLabel(rpgChar.getWounds().get("Down") + "", JLabel.CENTER);
		comp.add(lvl7);
		comp.setBorder(loweredetched);
		woundsMaxPerLevel.add(comp);

		comp = new JPanel();
		lvl8 = new JLabel(rpgChar.getWounds().get("Out") + "", JLabel.CENTER);
		comp.add(lvl8);
		comp.setBorder(loweredetched);
		woundsMaxPerLevel.add(comp);

		return woundsMaxPerLevel;
	}

	public void updateWoundsLevels() {
		rpgChar.setWounds();
		System.out.println(rpgChar.getWounds());

		lvl1.setText(String.valueOf(rpgChar.getWounds().get("Healthy")));
		lvl2.setText(String.valueOf(rpgChar.getWounds().get("Nicked")));
		lvl3.setText(String.valueOf(rpgChar.getWounds().get("Grazed")));
		lvl4.setText(String.valueOf(rpgChar.getWounds().get("Hurt")));
		lvl5.setText(String.valueOf(rpgChar.getWounds().get("Injured")));
		lvl6.setText(String.valueOf(rpgChar.getWounds().get("Crippled")));
		lvl7.setText(String.valueOf(rpgChar.getWounds().get("Down")));
		lvl8.setText(String.valueOf(rpgChar.getWounds().get("Out")));
	}

	public JPanel createCurrentWounds() {
		JPanel currentWounds = new JPanel();
		currentWounds.setLayout(new BoxLayout(currentWounds,
				BoxLayout.PAGE_AXIS));
		titleWounds = BorderFactory.createTitledBorder(loweredetched,
				"Current Wounds");

		return currentWounds;
	}

	public void addWoundLvlComponent(Border border, String description,
			Container container) {
		JPanel comp = new JPanel();
		JLabel label = new JLabel(description, JLabel.CENTER);
		label.setForeground(Color.WHITE);
		comp.add(label);
		comp.setBackground(Color.darkGray);

		comp.setBorder(border);

		// container.add(Box.createRigidArea(new Dimension(0, 0)));
		container.add(comp);
	}

	public void addMaxWounds(Border border, JLabel label, int maxWound,
			Container container) {
		JPanel comp = new JPanel();
		label = new JLabel(maxWound + "", JLabel.CENTER);
		comp.add(label);
		comp.setBorder(border);
		container.add(comp);
	}

	public void checkWoundsLevel() {

		int damage = Integer.parseInt(currentDmg.getText());

		for (JLabel label : woundLevels) {
			if (damage > Integer.parseInt(label.getText())) {
				label.setForeground(Color.RED);
			} else {
				label.setForeground(Color.BLACK);
			}
		}
	}

	public void createWoundLevelList() {
		woundLevels.add(lvl1);
		woundLevels.add(lvl2);
		woundLevels.add(lvl3);
		woundLevels.add(lvl4);
		woundLevels.add(lvl5);
		woundLevels.add(lvl6);
		woundLevels.add(lvl7);
		woundLevels.add(lvl8);
	}

	@Override
	public void dataUpdated() {
		updateWoundsLevels();
		checkWoundsLevel();
	}

	@Override
	public void loadNewCharacter() {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		createWoundLevelList();
		checkWoundsLevel();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
