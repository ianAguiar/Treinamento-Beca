package Beca1;

import java.util.Scanner;

public class RetiraEspaco {

	public static void main(java.lang.String[] args) {

		retirarEspaco(receberString());
	}
	
	public static String receberString()
	{
		String frase;
		Scanner receberString = new Scanner(System.in);
		System.out.println("Digite uma frase: ");
		frase = receberString.nextLine();
		return frase;
	}
	
	public static String retirarEspaco(String frase)
	{
		String limpaFrase;
		limpaFrase = frase.replace(" ","");
		System.out.println(limpaFrase);
		return limpaFrase;
	}

}
