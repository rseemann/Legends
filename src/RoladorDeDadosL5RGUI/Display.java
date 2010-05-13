package RoladorDeDadosL5RGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Display {
	private JFrame window;
	private JPanel panel;
	private JTextArea rollingTxtArea;
	private ArrayList<Integer> roll;
	private RolaDados rolagem = new RolaDados();
	private String[] nOfDicesRoll = new String[20];
	private String[] nOfDicesKeep = new String[20];
	private JComboBox boxToRoll;
	private JComboBox boxToKeep;
	int rolledDices = 1;
	int keptDices = 1;

	public void adicionaElementos(Container pane) {
		// ----layout do painelll---

		panel = new JPanel(new GridBagLayout());
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		panel.setBackground(Color.darkGray);

		// --------------------------adicionando elementos
		// combobox XkY
		nOfDicesRoll = new SelecionaRolagem().preencheRolagem();
		nOfDicesKeep = new SelecionaRolagem().preencheSegurados();

		JComboBox boxRolar = new JComboBox(nOfDicesRoll);
		boxRolar.addActionListener(new BoxRola());
		JComboBox boxSegurar = new JComboBox(nOfDicesKeep);
		boxSegurar.addActionListener(new BoxSegura());

		c.weightx = 0.5;
		c.ipadx = 10;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(boxRolar, c);

		JLabel k = new JLabel(" K");
		Font fontLabel = new Font(" SansSerif", Font.ITALIC, 28);
		k.setFont(fontLabel);
		k.setForeground(Color.white);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(k, c);

		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		panel.add(boxSegurar, c);

		// -----botão de rolagem-------
		JButton botaoRola = new JButton("Rola!");
		botaoRola.addActionListener(new BotaoRola());
		Font fonteBotaoRola = new Font(" SansSerif", Font.ITALIC, 20);
		botaoRola.setFont(fonteBotaoRola);

		c.weighty = 1.0;
		c.ipady = 10;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(botaoRola, c);

		// -----botao de limpar------
		JButton botaoLimpa = new JButton("Apagar");
		botaoLimpa.addActionListener(new BotaoLimpa());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0; // reset to default
		c.weighty = 1.0; // request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		// c.insets = new Insets(10,0,0,0); //top padding
		c.gridx = 1; // aligned with button 2
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 2;
		panel.add(botaoLimpa, c);

		// -----caixa de texto------
		rollingTxtArea = new JTextArea(20, 22);
		rollingTxtArea.setEditable(false);
		rollingTxtArea.setLineWrap(true);
		rollingTxtArea.setWrapStyleWord(true);

		JScrollPane scroll = new JScrollPane(rollingTxtArea);

		scroll
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		pane.add(BorderLayout.WEST, panel);
		pane.add(BorderLayout.EAST, scroll);// só adiciona o scroll, o texto tah
											// dentro dele.

	}

	public void createNShowGUI() {

		window = new JFrame("Rolagem de Dados");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(200, 200);

		// Set up the content pane.
		adicionaElementos(window.getContentPane());

		// Display the window.
		window.pack();
		window.setVisible(true);

	}

	class BotaoRola implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// caixaDeTexto.removeAll();
			// System.out.println((String)(boxRolar.getSelectedItem()));
			// int dadosRolados =
			// Integer.parseInt((String)(boxRolar.getSelectedItem()));
			// int dadosSegurados =
			// Integer.parseInt((String)(boxSegurar.getSelectedItem()));;

			rolagem.fazRolagem(rolledDices, keptDices);
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

	public static void main(String[] args) {
		Display gui = new Display();
		gui.createNShowGUI();

	}
}
