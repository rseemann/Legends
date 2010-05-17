package RoladorDeDadosCMD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RolaDados {
	private static int rolagem;
	private static ArrayList<Integer> rolagens = new ArrayList<Integer>();
	private static int resultadoDoDadoRolado;
	private static int dadosRolados = 0;
	private static int dadosSegurados = 1;
	private static ArrayList<Integer> rolagensSeguradas = new ArrayList<Integer>();
	private static int numeroDeDez = 0;
	private static int somaDaRolagem = 0;

	// ----- methods ------------
	public static int rolaDado() {
		rolagem = (1 + (int) (Math.random() * 10));
		return rolagem;
	}

	public static int[] qualRolagem() {
		Scanner entrada = new Scanner(System.in);

		while (dadosRolados < dadosSegurados) {
			System.out.println("Quantos dados você vai rolar?");
			dadosRolados = Integer.parseInt(entrada.nextLine());

			System.out.println("Quantos dados você vai segurar?");
			dadosSegurados = Integer.parseInt(entrada.nextLine());

			if (dadosRolados < dadosSegurados) {
				System.out
						.println("Erro - O número de dados segurados jamais pode exceder o número de dados rolados. Tente novamente...");
				System.out.println();

			}
			if (dadosRolados > 10) {
				dadosSegurados += (int) (dadosRolados - 10) / 2;
				dadosRolados = 10;
				if (dadosSegurados > 10) {
					System.out
							.println("Erro - A maior rolagem poss�vel � de 10k10.\n(Lembrando que para 2 dados rolados acima de 10, voc� segura um dado a mais...) \nInsira nova rolagem.");
					System.out.println("...");
				}
			}

		}

		int[] xky = new int[] { dadosRolados, dadosSegurados };
		return xky;

	}

	public static ArrayList<Integer> fazRolagem(int dadosRolados, int dadosSegurados) {
		//Informa quantos dados est�o sendo rolados e os rola
		System.out.println("Rolando " + dadosRolados + "k" + dadosSegurados);
		for (int i = 0; i < dadosRolados; i++) {
			resultadoDoDadoRolado = rolaDado();
			rolagens.add(resultadoDoDadoRolado);
		}
		//resultado da rolagem
		System.out.println(rolagens);
		Collections.sort(rolagens, Collections.reverseOrder());
		
		//armazena os maiores numeros da rolagem
			for (int i = 0; i < dadosSegurados; i++) {
			rolagensSeguradas.add(rolagens.get(i));
		}
		
		//Imprime mensagem escolhendo os maiores numeros segurados
		if (dadosRolados != dadosSegurados) {
			System.out.println("As " + dadosSegurados
					+ " maiores rolagens são: ");
			System.out.println(rolagensSeguradas);

		}
		//mostra as rerrolagens dos 10
		for (int i = 0; i < dadosSegurados; i++) {
			if (rolagensSeguradas.get(i) == 10) {
				numeroDeDez++;
				System.out.println("Rerrolando o " + numeroDeDez + "° dez.");
				rolagensSeguradas
						.set(i, testaRolagem(rolagensSeguradas.get(i)));
			}
			somaDaRolagem += rolagensSeguradas.get(i);
		}

		System.out.println("Resultado Final das Rolagens");
		System.out.println(rolagensSeguradas);
		System.out.println("Soma da rolagem: " + somaDaRolagem);
		return rolagens;
	}
	
	static int testaRolagem(int rolagem) {

		int rolagemAcumulada = 0;
		// System.out.println(rolagem);

		if (rolagem == 10) {
			while (rolagem == 10) {
				rolagem = RolaDados.rolaDado();
				rolagemAcumulada += rolagem;
				System.out.println("Rerrolagem = " + rolagem);
			}
			System.out.println("Soma = " + (rolagemAcumulada + 10));
			return (rolagemAcumulada + 10);
		} else {
			rolagemAcumulada = rolagem;
			System.out.println("Rolagem = " + rolagem);
			return rolagemAcumulada;
		}

	}
	
	//------------set e getters
	
	public static void setDadosRolados(int dadosRolados) {
		RolaDados.dadosRolados = dadosRolados;
	}
	
	public static void setDadosSegurados(int dadosSegurados) {
		RolaDados.dadosSegurados = dadosSegurados;
	}

}
