package Beca1;

import java.util.Random;
import java.util.Scanner;
/* Fazer um algoritmo para buscar determinado n�mero, em um vetor de 100 posi��es preenchidos de
 * forma rand�mica e exibir em qual posi��o est� o n�mero buscado.
 */

public class VetorRandomico {
	static Random random = new Random();

	public static Integer[] criarVetorAleat(int tamVetor) 
	{
		Integer vetorNum[] = new Integer[tamVetor];

		for (int i = 0; i < vetorNum.length; i++)
		{
			vetorNum[i] = random.nextInt(100);
			System.out.println("Valor: " + vetorNum[i]);
		}
		return vetorNum;

	}

	public static int buscaPosicao(Integer vetorNum[], int num) 
	{
		int posi = -1;

		for (int i = 0; i < vetorNum.length; i++) 
		{
			if (num == vetorNum[i]) 
			{
				posi = i;
				break;
			}
		}
		return posi;
	}

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int numeroBuscado, posicao;

		// Traz o vetor aleat�rio
		Integer vet[] = criarVetorAleat(100);
		// Entrar com o n�mero para buscar no vetor
		System.out.println("Informar o n�mero que deseja buscar a posi��o: ");
		numeroBuscado = input.nextInt();

		posicao = buscaPosicao(vet, numeroBuscado);

		if (posicao == -1) 
		{
			System.out.println("O n�mero buscado n�o foi encontrado no vetor!");
		} else 
		{
			System.out.println("Valor buscado: " + vet[posicao] + "\nPosi��o: " + posicao);
		}
	}
}
