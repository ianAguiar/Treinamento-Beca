package Beca1;

import java.util.Scanner;
public class InverterFrase {
	public static void main(String[] args) {
		/*Scanner input = new Scanner(System.in);
        
		System.out.println("Informe a frase desejada: ");
		String frase = input.nextLine();
       
		System.out.println(frase);
		
		int tam = frase.length() -1;
		
		while (tam >= 0) 
		{
			System.out.print(frase.charAt(tam));
			tam--;
		}*/
		
		//Utilizando for
		
		Scanner input = new Scanner(System.in);
        
		System.out.println("Informe a frase desejada: ");
		String frase = input.nextLine();
		String fraseInvertida = "";
       
		System.out.println(frase);
		
		for(int i = frase.length()-1; i>=0; i--)
		{
			//System.out.println(frase.charAt(i));
			fraseInvertida = fraseInvertida + frase.charAt(i);
		}
        
		System.out.println(fraseInvertida);
	}

}
