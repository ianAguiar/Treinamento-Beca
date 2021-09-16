package Beca1;

import java.util.Scanner;

public class numerosParImpar {

	public static void main(RetiraEspaco[] args) {
		Scanner ler = new Scanner(System.in);
		
		int numero;
		
		System.out.println("informe um número: ");
		numero  = ler.nextInt();
		
		if(numero % 2 == 0) {
			System.out.println("O número " + numero + " é par.");
		} else {
			System.out.println("O número " + numero + " é impar.");
		}

	}

}
