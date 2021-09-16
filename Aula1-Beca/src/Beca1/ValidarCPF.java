package Beca1;

import javax.swing.JOptionPane;

public class ValidarCPF {
	// Limpar a String
	public static String limpaString(String inicial) 
	{
		String limpa = "";
		for (int i = 0; i < inicial.length(); i++) 
		{
			if (Character.isDigit(inicial.charAt(i))) 
			{
				limpa = limpa + inicial.charAt(i);
			}
		}
		while (limpa.length() < 11) 
		{
			limpa = "0" + limpa;
		}
		return limpa;
	}
	
	//Verifica o primeiro(10) digito do CPF
	public static boolean verificaPrimeiroDigito(String cpf)
	{
		int primeiroDigito;
		int multiplicador[] = {10, 9, 8, 7, 6, 5, 4, 3, 2};
		int soma = 0;
		
		for(int i = 0; i<multiplicador.length; i++)
		{
			soma = soma + multiplicador[i] * Character.getNumericValue(cpf.charAt(i));
		}
		int resto = soma % 11;
		//primeiroDigito=(resto<2) : 0:11-resto
		if(resto < 2)
		{
			primeiroDigito = 0;
		} else {
			primeiroDigito = 11 - resto;
		}
		
		if(primeiroDigito == Character.getNumericValue(cpf.charAt(9)))
		{
			return true;
		} else {
			return false;
		}
	}
		//Verifica o segundo digito(11) do CPF
		public static boolean verificaSegundoDigito(String cpf)
		{
			int segundoDigito;
			int multiplicador[] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
			int soma = 0;
			
			for(int i = 0; i<multiplicador.length; i++)
			{
				soma = soma + multiplicador[i] * Character.getNumericValue(cpf.charAt(i));
			}
			int resto = soma % 11;
			//segundoDigito=(resto<2) : 0:11-resto
			if(resto < 2)
			{
				segundoDigito = 0;
			} else {
				segundoDigito = 11 - resto;
			}
			
			if(segundoDigito == Character.getNumericValue(cpf.charAt(10)))
			{
				return true;
			} else {
				return false;
			}
		}
	public static void main(String args[]) {
		String cpf, inicial;
		
		do 
		{
			inicial = JOptionPane.showInputDialog("Digite o cpf: ");
			cpf = limpaString(inicial);
			
			if(cpf.length() > 11)
			{
				JOptionPane.showMessageDialog(null, "O CPF digitado possui mais de 11 digitos");
			}	
		} while (cpf.length() > 11);
		{
			JOptionPane.showMessageDialog(null, "CPF Limpo: " + cpf);
		} 
		if (verificaPrimeiroDigito(cpf) && verificaSegundoDigito(cpf))
		{
			JOptionPane.showMessageDialog(null, "CPF Válido!");
		} else {
			JOptionPane.showMessageDialog(null, "CPF Inválido!");
		}
		
	}

}
