package Beca1;

import java.util.Scanner;

public class Fatorial {

	public static void main(RetiraEspaco[] args) {
		Scanner lerNumero = new Scanner(System.in);
		
		int numero, fat = 1;
		
		System.out.println("Digite um nº:");
		numero = lerNumero.nextInt();
		
		for (int i = 1; i <= numero; i++) {
				fat = fat * i;
		}
            
		System.out.println("Fatorial de " + numero + " = " + fat);
	}
}
