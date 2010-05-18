package RoladorDeDadosL5RGUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RolaDados {
	private int rolagem;
	private ArrayList<Integer> rolls = new ArrayList<Integer>();
	private int resultadoDoDadoRolado;
	private int dadosRolados = 0;
	private int dadosSegurados = 1;
	private ArrayList<Integer> rolagensSeguradas = new ArrayList<Integer>();
	private int numeroDeDez = 0;
	private int somaDaRolagem = 0;
	private int maximoDeDadosSegurados = 10;
	private ArrayList imprimir = new ArrayList();
	private String mensagemErro;
	private int bonusRolagem;

	// ----- methods ------------
	public int rolaDado() {
		this.rolagem = (1 + (int) (Math.random() * 10));
		return this.rolagem;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}
	

	public ArrayList<Integer> fazRolagem(int dadosRolados, int dadosSegurados) {
		// Informa quantos dados estãoo sendo rolados e os rola
		rolagensSeguradas.clear();
		rolls.clear();
		imprimir.clear();
		rolagem = 0;
		numeroDeDez = 0;
		somaDaRolagem = 0;
		bonusRolagem = 0;
		
		if (dadosRolados > 10) {
			dadosSegurados += (int) (dadosRolados - 10) / 2;
			dadosRolados = 10;
			imprimir.add("Recalculagem dos dados...\n");
		}
		
		if (dadosSegurados > maximoDeDadosSegurados) {
			//mensagemErro = "A maior rolagem possível é de 10k10.\n(Lembrando que para 2 dados rolados acima de 10, você segura um dado a mais...) \nInsira nova rolagem.";
			bonusRolagem = (dadosSegurados - maximoDeDadosSegurados)*5;
			dadosSegurados = maximoDeDadosSegurados;
		}
		
		if (dadosRolados < dadosSegurados) {
			imprimir.add("Redefinindo rolagem...");
			dadosSegurados= dadosRolados;
		}
		
		imprimir.add("Rolando " + dadosRolados + "k" + dadosSegurados);
		for (int i = 0; i < dadosRolados; i++) {
			resultadoDoDadoRolado = rolaDado();
			rolls.add(resultadoDoDadoRolado);
		}
		// resultado da rolagem
		imprimir.add(rolls);
		Collections.sort(rolls, Collections.reverseOrder());

		// armazena os maiores numeros da rolagem
		for (int i = 0; i < dadosSegurados; i++) {
			rolagensSeguradas.add(rolls.get(i));
		}

		// Imprime mensagem escolhendo os maiores numeros segurados
		if (dadosRolados != dadosSegurados) {
			imprimir.add("As " + dadosSegurados + " maiores rolagens são: ");
			imprimir.add(String.valueOf(rolagensSeguradas)); // esse stringvalue
																// eh para ele n
																// imprimir o
																// valor com a
																// rerrolagem
																// jah calculada

		}
		// mostra as rerrolagens dos 10
		for (int i = 0; i < dadosSegurados; i++) {
			if (rolagensSeguradas.get(i) == 10) {
				numeroDeDez++;
				imprimir.add("Rerrolando o " + numeroDeDez + "° dez.");
				rolagensSeguradas
						.set(i, testaRolagem(rolagensSeguradas.get(i)));
			}
			somaDaRolagem += rolagensSeguradas.get(i);
		}

		imprimir.add("Resultado Final das Rolagens");
		imprimir.add(rolagensSeguradas);
		
		if (bonusRolagem != 0){
			imprimir.add("\n+"+bonusRolagem+" (por segurar mais do que 10 dados)\n");
			String teste = "lalala";
			
			imprimir.add("Soma da rolagem: " + (somaDaRolagem + bonusRolagem));
		}
		else{
			imprimir.add("\nSoma da rolagem: " + somaDaRolagem+"\n");
		}
		
		return rolls;
	}

	public int testaRolagem(int rolagem) {

		int rolagemAcumulada = 0;
		// imprimir.add(rolagem);

		if (rolagem == 10) {
			while (rolagem == 10) {
				rolagem = rolaDado();
				rolagemAcumulada += rolagem;
				imprimir.add("Rerrolagem = " + rolagem);
			}
			imprimir.add("Soma = " + (rolagemAcumulada + 10));
			return (rolagemAcumulada + 10);
		} else {
			rolagemAcumulada = rolagem;
			imprimir.add("Rolagem = " + rolagem);
			return rolagemAcumulada;
		}

	}

	// ------------set e getters

	public void setDadosRolados(int dadosRolados) {
		this.dadosRolados = dadosRolados;
	}

	public void setDadosSegurados(int dadosSegurados) {
		this.dadosSegurados = dadosSegurados;
	}

	public ArrayList getImprimir() {
		return imprimir;
	}

}
