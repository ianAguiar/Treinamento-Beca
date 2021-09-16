package Beca1;

import java.util.Scanner;

public class Repeticao {
	public static void main(RetiraEspaco[] args) {
		Scanner lerNumero = new Scanner(System.in);
		int num = 0;
		
		System.out.println("informe um número: ");
		num  = lerNumero.nextInt();
		
		for(int i = 0; i<= num;i++){
			
			if(i%2 == 0) {
				System.out.println( i + " é um número PAR.");
			} else {
				System.out.println( i + " é um número IMPAR.");
			}
		}
	}
}
