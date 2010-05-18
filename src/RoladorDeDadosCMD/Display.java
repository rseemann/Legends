package RoladorDeDadosCMD;

import javax.swing.*;

public class Display {
	public static void main(String[] args) {
		JFrame tela = new JFrame();
		JButton botao = new JButton("Clique aqui!");

		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tela.getContentPane().add(botao);
		tela.setSize(300, 300);
		tela.setVisible(true);
	}

}