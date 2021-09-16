package Beca1;

import java.util.Scanner;

public class Calculadora {
	
	public double somar(double num1, double num2)
	{
		return num1 + num2;
	}
	
	public double subtrair(double num1, double num2)
	{
		return num1 - num2;
	}
	
	public double dividir(double num1, double num2)
	{
		return num1 / num2;
	}
	
	public double multiplicar(double num1, double num2)
	{
		return num1 * num2;
	}
	
	public static void main (String Args[])
	{
		Scanner input = new Scanner(System.in);
		
		//Variáveis
		int opcao = 1;
		double valor1 = 0, valor2 = 0;
		double resultado = 0;
		
		//Objeto
		Calculadora calc = new Calculadora();
		String menu = "Calculadora\n\n"+
						"1 - Somar\n"+
						"2 - Subtrair\n"+
						"3 - Multiplicar\n"+
						"4 - Dividir\n"+
						"0 - Sair\n";

		
		while (opcao != 0)
		{
			System.out.println(menu);
			
			opcao = input.nextInt();
			
			System.out.println("Digite o primeiro número: ");
			valor1 = input.nextDouble();
			
			System.out.println("Digite o segundo número: ");
			valor2 = input.nextDouble();
			
			switch (opcao)
			{
				
				case 1: //Somar
					
					resultado = calc.somar(valor1, valor2);
					System.out.println(resultado);
					break;
				
				case 2: //Subtrair
					
					resultado = calc.subtrair(valor1, valor2);
					System.out.println(resultado);
					break;
				
				case 3: //Multiplicar
					
					resultado = calc.multiplicar(valor1, valor2);
					System.out.println(resultado);
					break;
				
				case 4: //Dividir
			
					resultado = calc.dividir(valor1, valor2);
					System.out.println(resultado);
					break;
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
	
	

