package RoladorDeDadosL5RGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaErro {
	
	JFrame telaErro = new JFrame("Erro");

	
	public void adicionaElementosErro(String mensagemErro) {
		telaErro.setSize((7*mensagemErro.length()),100);
		telaErro.setVisible(true);
		telaErro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton botaoErro = new JButton("Ok");
		botaoErro.addActionListener(new BotaoErro());
		JPanel painelErro = new JPanel(new GridBagLayout());
		JLabel msgErroJanela = new JLabel();
		msgErroJanela.setText(mensagemErro);
		//System.out.println(msgErroJanela.getText().length());		
		
		
		//painelErro.setBackground(Color.darkGray);
		painelErro.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//adicionando componentes do painel de erro
		c.weightx = 0.5;
		c.ipadx = 10;
		c.gridx = 0;
		c.gridy = 0;
		painelErro.add(msgErroJanela,c);
		
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 1;
		painelErro.add(botaoErro, c);
		
		
		//adicionando painel a tela de erro
		telaErro.getContentPane().add(painelErro);
		//telaErro.getContentPane().add(msgErroJanela);
		//System.out.println(RolaDados().getMensagemErro());

	}
	public static void main(String[] args) {
		JanelaErro teste = new JanelaErro();
		teste.adicionaElementosErro("Teste de errweaaaaaaaaaaaakldjsafhaskjlhbaskhalwkryvaiaaaaaaaaaa123o!");
		
	}
	public class BotaoErro implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			telaErro.dispose();
			
		}
		
	}
}
