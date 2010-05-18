package RoladorDeDadosCMD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainRolaDados {
	public static void main(String[] args) {
		int[] rolagem = new int[2];

		// --------------------------------------

		// --------------------------------------
		
		rolagem = RolaDados.qualRolagem();
		
		int roll = rolagem[0];
		int keep = rolagem[1];
		
		RolaDados.fazRolagem(roll, keep);
		
		
		
	}
	

}
