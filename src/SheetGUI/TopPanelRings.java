package SheetGUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Ficha.RPGCharacter;
import SheetGUI.Sheet.NewRPGCharacter;

public class TopPanelRings implements FocusListener {
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
	private RPGCharacter rpgChar;

	public JPanel CreateTopPanelRing(RPGCharacter rpgChar) {

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
		earthRingField = new JTextField(String.valueOf(rpgChar.getEarthRing()),
				3);
		earthRingField.setEditable(false);
		JLabel staminaLabel = new JLabel("Stamina: ");
		staminaField = new JTextField(String.valueOf(rpgChar.getStamina()), 3);
		staminaField.addFocusListener(this);

		JLabel willpowerLabel = new JLabel("Willpower: ");
		willpowerField = new JTextField(String.valueOf(rpgChar.getWillpower()),
				3);
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
		waterRingField = new JTextField(String.valueOf(rpgChar.getWaterRing()),
				3);
		waterRingField.setEditable(false);
		JLabel strengthLabel = new JLabel("Strength: ");
		strengthField = new JTextField(String.valueOf(rpgChar.getStength()), 3);
		strengthField.addFocusListener(this);
		JLabel perceptionLabel = new JLabel("Perception: ");
		perceptionField = new JTextField(String
				.valueOf(rpgChar.getPerception()), 3);
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
		fireRingField = new JTextField(String.valueOf(rpgChar.getFireRing()), 3);
		fireRingField.setEditable(false);
		JLabel agilityLabel = new JLabel("Agility: ");
		agilityField = new JTextField(String.valueOf(rpgChar.getAgility()), 3);
		agilityField.addFocusListener(this);
		JLabel intelligenceLabel = new JLabel("Intelligence: ");
		intelligenceField = new JTextField(String.valueOf(rpgChar
				.getIntelligence()), 3);
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
		airRingField = new JTextField(String.valueOf(rpgChar.getAirRing()), 3);
		airRingField.setEditable(false);
		JLabel reflexesLabel = new JLabel("Reflexes: ");
		reflexesField = new JTextField(String.valueOf(rpgChar.getReflexes()), 3);
		reflexesField.addFocusListener(this);
		JLabel awarenessLabel = new JLabel("Awareness: ");
		awarenessField = new JTextField(String.valueOf(rpgChar.getAwareness()),
				3);
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

		voidRingField = new JTextField(String.valueOf(rpgChar.getVoidRing()), 3);
		JLabel pointsSpentLabel = new JLabel("Points Spent: ");
		voidRingField.addFocusListener(this);
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

		return topPanelRings;
	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		new SheetFrac().updateTraitsDataFromSheet(getInsertedTraitsData());
		rpgChar = new SheetFrac().getRpgChar();
		System.out.println(rpgChar.getEarthRing());
		
	}

	public Map<String, Integer> getInsertedTraitsData() {
		Map<String, Integer> insertedData = new HashMap<String, Integer>();

		insertedData.put("stam", Integer.parseInt(staminaField.getText()));
		insertedData.put("will", Integer.parseInt(willpowerField.getText()));
		insertedData.put("stre", Integer.parseInt(strengthField.getText()));
		insertedData.put("perc", Integer.parseInt(perceptionField.getText()));
		insertedData.put("agil", Integer.parseInt(agilityField.getText()));
		insertedData.put("inte", Integer.parseInt(intelligenceField.getText()));
		insertedData.put("refl", Integer.parseInt(reflexesField.getText()));
		insertedData.put("awar", Integer.parseInt(awarenessField.getText()));
		insertedData.put("void", Integer.parseInt(voidRingField.getText()));

		return insertedData;
	}

	// getters e setters

	public void setEarthRingField(String earthRingField) {
		this.earthRingField.setText(earthRingField);
	}

	public void setWaterRingField(String waterRingField) {
		this.waterRingField.setText(waterRingField);
	}

	public void setFireRingField(String fireRingField) {
		this.fireRingField.setText(fireRingField);
	}

	public void setAirRingField(String airRingField) {
		this.airRingField.setText(airRingField);
	}

	public void setVoidRingField(String voidRingField) {
		this.voidRingField.setText(voidRingField);
	}

	/*
	 * public String getEarthRingField() { return earthRingField.getText(); }
	 * 
	 * public String getStaminaField() { return staminaField.getText(); }
	 * 
	 * public void setStaminaField(String staminaField) {
	 * this.staminaField.setText(staminaField); }
	 * 
	 * public String getWillpowerField() { return willpowerField.getText(); }
	 * 
	 * public void setWillpowerField(String willpowerField) {
	 * this.willpowerField.setText(willpowerField); }
	 * 
	 * public String getStrengthField() { return strengthField.getText(); }
	 * 
	 * public void setStrengthField(String strengthField) {
	 * this.strengthField.setText(strengthField); }
	 * 
	 * public String getPerceptionField() { return perceptionField.getText(); }
	 * 
	 * public void setPerceptionField(String perceptionField) {
	 * this.perceptionField.setText(perceptionField); }
	 * 
	 * public String getFireRingField() { return fireRingField.getText(); }
	 * 
	 * public String getAgilityField() { return agilityField.getText(); }
	 * 
	 * public void setAgilityField(String agilityField) {
	 * this.agilityField.setText(agilityField); }
	 * 
	 * public String getIntelligenceField() { return
	 * intelligenceField.getText(); }
	 * 
	 * public void setIntelligenceField(String intelligenceField) {
	 * this.intelligenceField.setText(intelligenceField); }
	 * 
	 * public String getAirRingField() { return airRingField.getText(); }
	 * 
	 * public String getReflexesField() { return reflexesField.getText(); }
	 * 
	 * public void setReflexesField(String reflexesField) {
	 * this.reflexesField.setText(reflexesField); }
	 * 
	 * public String getAwarenessField() { return awarenessField.getText(); }
	 * 
	 * public void setAwarenessField(String awarenessField) {
	 * this.awarenessField.setText(awarenessField); }
	 * 
	 * public String getVoidRingField() { return voidRingField.getText(); }
	 * public String getPointsSpentField() { return pointsSpentField.getText();
	 * }
	 * 
	 * public void setPointsSpentField(String pointsSpentField) {
	 * this.pointsSpentField.setText(pointsSpentField); }
	 */
}
