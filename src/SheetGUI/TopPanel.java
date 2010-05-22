package SheetGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Ficha.RPGCharacter;



public class TopPanel{
	
	private JPanel topPanel;
		
	public JPanel CreateTopPanel(SheetFrac rpgSheet) {
		topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(Color.lightGray);

		// -------Character Info Panel--------
				
		JPanel topPanelInfo = new TopPanelInfo().CreateTopPanelInfo(rpgSheet);
		
		// ----Character Traits and Rings Panel----
		
		JPanel topPanelRings = new TopPanelRings().CreateTopPanelRing(rpgSheet);

		// addings panels to topPanel
		topPanel.add(BorderLayout.NORTH, topPanelInfo);
		topPanel.add(BorderLayout.CENTER, topPanelRings);
		return topPanel;
	}
	
	//testing
	
	
	/*public String getClan() {
		return panelInfo.getClanField();
	}

	public void setClan(String clan) {
		panelInfo.setClanField(clan);
	}

	public String getName() {
		return panelInfo.getClanField();
	}

	public void setName(String arg0) {
		panelInfo.setNameField(arg0);
	}

	public String getSchool() {
		return panelInfo.getSchoolField();
	}

	public void setSchool(String arg0) {
		panelInfo.setSchoolField(arg0);
	}

	public String getRank() {
		return panelInfo.getRankField();
	}

	public void setRank(String arg0) {
		panelInfo.setRankField(arg0);
	}

	public String getInsight() {
		return panelInfo.getInsightField();
	}

	public void setInsight(String arg0) {
		panelInfo.setInsightField(arg0);
	}
	
	//endtesting info
	
	
	
	
	
	*/
}
