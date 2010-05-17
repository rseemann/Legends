package RoladorDeDadosCMD;
class Rolagem {
	public static void main(String[] args) {
		double acumulado = 0;
		double media = 0;
		int rolagem = 0;

		for (int i = 1; i <= 20000; i++) {
			System.out.println(i + "ª Rolagem");
			rolagem = rolaDado();
			acumulado += testaRolagem(rolagem);
			media = (acumulado / i);
			System.out.println("Média : " + media);
		}

		//System.out.println("Média : " + media);

	}

	static int rolaDado() {
		int rolagem = (1 + (int) (Math.random() * 10));
		return rolagem;
	}

	static int testaRolagem(int rolagem) {
		
		int rolagemAcumulada = 0;
		System.out.println("1k1 = " + rolagem);
		
		if (rolagem == 10) {
			while (rolagem == 10) {
				//System.out.println("EXPLODIU!!!");
				rolagem = rolaDado();
				rolagemAcumulada += rolagem;
				System.out.println("Rerrolagem do 10 = " + rolagem);
				System.out.println("Soma = " + (rolagemAcumulada+10));
			}
			System.out.println("Soma total da rolagem = " + (rolagemAcumulada+10));
			return (rolagemAcumulada+10);
		}
		else{
			rolagemAcumulada = rolagem;
			System.out.println("Soma total da rolagem = " + rolagem);
			return rolagemAcumulada;
		}
		
		

	}
}
