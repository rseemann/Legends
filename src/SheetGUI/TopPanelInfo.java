package SheetGUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Ficha.RPGCharacter;

public class TopPanelInfo implements FocusListener{
	private JTextField clanField;
	private JTextField nameField;
	private JTextField schoolField;
	private JTextField rankField;
	private JTextField insightField;

	public JPanel CreateTopPanelInfo(RPGCharacter rpgChar){
		JPanel topPanelInfo = new JPanel(new GridBagLayout());
		GridBagConstraints tpi = new GridBagConstraints();
		topPanelInfo.setBackground(Color.lightGray);

		tpi.insets = new Insets(10, 0, 0, 0);

		JLabel nameLabel = new JLabel("Name: ");
		nameField = new JTextField(rpgChar.getName(), 16);

		JLabel clanLabel = new JLabel("Clan: ");
		clanField = new JTextField(rpgChar.getClan(), 8);

		JLabel schoolLabel = new JLabel("School: ");
		schoolField = new JTextField(rpgChar.getSchool(), 10);

		JLabel rankLabel = new JLabel("Rank: ");
		rankField = new JTextField(String.valueOf(rpgChar.getRank()), 1);

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

		return topPanelInfo;
	}
	
	public Map<String, String> getInsertedInfoData(){
		Map <String, String> insertedData = new HashMap<String, String>();
		insertedData.put("name", nameField.getText());
		insertedData.put("scho", schoolField.getText());
		insertedData.put("clan", clanField.getText());
		return insertedData;
		
	}
	
	public void focusLost(FocusEvent arg0) {
		new SheetFrac().updateInfoDataFromSheet(getInsertedInfoData());
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/*public String getClanField() {
		return clanField.getText();
	}

	public void setClanField(String clan) {
		clanField.setText(clan);
	}

	public String getNameField() {
		return nameField.getText();
	}

	public void setNameField(String arg0) {
		nameField.setText(arg0);
	}

	public String getSchoolField() {
		return schoolField.getText();
	}

	public void setSchoolField(String arg0) {
		schoolField.setText(arg0);
	}

	public String getRankField() {
		return rankField.getText();
	}

	public void setRankField(String arg0) {
		rankField.setText(arg0);
	}

	public String getInsightField() {
		return insightField.getText();
	}

	public void setInsightField(String arg0) {
		insightField.setText(arg0);
	}
	*/
	
	
}