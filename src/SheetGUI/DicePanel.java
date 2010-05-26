package SheetGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import RoladorDeDadosL5RGUI.RolaDados;

public class DicePanel {
	private JFrame window;
	private JPanel panel;
	private JTextArea rollingTxtArea;
	private ArrayList<Integer> roll;
	private RolaDados rolagem = new RolaDados();
	private String[] nOfDicesRoll = new String[20];
	private String[] nOfDicesKeep = new String[20];
	private JComboBox boxToRoll;
	private JComboBox boxToKeep;
	private JTextField bonusField;
	private int bonus;
	int rolledDices = 1;
	int keptDices = 1;
	
	public JPanel createRollingPanel() {
		// ----panel Layout---
		
		panel = new JPanel(new BorderLayout());
		
		//GridBagConstraints c = new GridBagConstraints();
		

		// --------------------------adicionando elementos
		// combobox XkY
		
		JPanel rollAndBonusPanel = new JPanel();
		
		nOfDicesRoll = new SelecionaRolagem().preencheRolagem();
		nOfDicesKeep = new SelecionaRolagem().preencheSegurados();

		JComboBox boxRolar = new JComboBox(nOfDicesRoll);
		boxRolar.addActionListener(new BoxRola());
		
		rollAndBonusPanel.add(boxRolar);
		
		JLabel k = new JLabel(" K");
		Font fontLabel = new Font(" SansSerif", Font.ITALIC, 28);
		k.setFont(fontLabel);
		k.setForeground(Color.white);
		
		rollAndBonusPanel.add(k);
		
		JComboBox boxSegurar = new JComboBox(nOfDicesKeep);
		boxSegurar.addActionListener(new BoxSegura());
		
		rollAndBonusPanel.add(boxSegurar);
		
		//bonus field
		Font fontBonus = new Font("SansSerif", Font.ITALIC, 8);
		bonusField = new JTextField("0",3);
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder titleBonus = BorderFactory.createTitledBorder(loweredetched, "Bonus");
		titleBonus.setTitleColor(Color.white);
		titleBonus.setTitleFont(fontBonus);
		bonusField.setBorder(titleBonus);
		bonusField.setForeground(Color.white);
		bonusField.setBackground(Color.darkGray);
		bonusField.setHorizontalAlignment(JTextField.CENTER);
		rollAndBonusPanel.add(bonusField);
		
		rollAndBonusPanel.setBackground(Color.darkGray);
		panel.add(BorderLayout.NORTH, rollAndBonusPanel);
		
	
		// -----botão de rolagem-------
		JPanel clearAndRollButtonsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		JButton botaoRola = new JButton("Roll!");
		botaoRola.addActionListener(new BotaoRola());
		Font fonteBotaoRola = new Font(" SansSerif", Font.ITALIC, 18);
		botaoRola.setFont(fonteBotaoRola);

		clearAndRollButtonsPanel.add(botaoRola, c);

		// -----botao de limpar------
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 1.0;
		//c.anchor = GridBagConstraints.PAGE_END; 
		c.gridy = 1;
		JButton botaoLimpa = new JButton("Clear");
		botaoLimpa.addActionListener(new BotaoLimpa());
		
		clearAndRollButtonsPanel.setBackground(Color.darkGray);
		clearAndRollButtonsPanel.add(botaoLimpa,c);

		panel.add(BorderLayout.EAST, clearAndRollButtonsPanel);
		
		// -----caixa de texto------
		JPanel scrollAndTextPanel = new JPanel();
		
		rollingTxtArea = new JTextArea(12, 18);
		rollingTxtArea.setEditable(false);
		rollingTxtArea.setLineWrap(true);
		rollingTxtArea.setWrapStyleWord(true);

		JScrollPane scroll = new JScrollPane(rollingTxtArea);

		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollAndTextPanel.setBackground(Color.darkGray);
		scrollAndTextPanel.add(scroll);
		panel.add(BorderLayout.CENTER, scrollAndTextPanel);// só adiciona o scroll, o texto tah
											// dentro dele.
		
		return panel;

	}

	class BotaoRola implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// caixaDeTexto.removeAll();
			// System.out.println((String)(boxRolar.getSelectedItem()));
			// int dadosRolados =
			// Integer.parseInt((String)(boxRolar.getSelectedItem()));
			// int dadosSegurados =
			// Integer.parseInt((String)(boxSegurar.getSelectedItem()));;
			bonus = Integer.parseInt(bonusField.getText());
			rolagem.fazRolagem(rolledDices, keptDices, bonus);
			rollingTxtArea
					.append("--------------------------------------------\n");
			for (int i = 0; i < rolagem.getImprimir().size(); i++) {
				rollingTxtArea.append(String.valueOf((rolagem.getImprimir())
						.get(i))
						+ "\n");
			}
			rollingTxtArea.append("\n");

			//JanelaErro janelaErro = new JanelaErro();
			//janelaErro.adicionaElementosErro(testaRolagem.getMensagemErro());

		}
	}

	class BotaoLimpa implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rollingTxtArea.setText("");
		}
	}

	class SelecionaRolagem {

		public String[] preencheRolagem() {
			for (int i = 0; i < 20; i++) {
				nOfDicesRoll[i] = String.valueOf(i + 1);
			}
			return nOfDicesRoll;
		}

		public String[] preencheSegurados() {
			for (int i = 0; i < 20; i++) {
				nOfDicesKeep[i] = String.valueOf(i + 1);
			}
			return nOfDicesKeep;
		}
	}

	class BoxRola implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JComboBox cb1 = (JComboBox) e.getSource();
			rolledDices = Integer.parseInt((String) cb1.getSelectedItem());
		}

	}

	class BoxSegura implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JComboBox cb2 = (JComboBox) e.getSource();
			keptDices = Integer.parseInt((String) cb2.getSelectedItem());
		}

	}
}
