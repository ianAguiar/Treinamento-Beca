package Beca1;

import java.util.Scanner;

public class numerosParImpar {

	public static void main(RetiraEspaco[] args) {
		Scanner ler = new Scanner(System.in);
		
		int numero;
		
		System.out.println("informe um n�mero: ");
		numero  = ler.nextInt();
		
		if(numero % 2 == 0) {
			System.out.println("O n�mero " + numero + " � par.");
		} else {
			System.out.println("O n�mero " + numero + " � impar.");
		}

	}

}
