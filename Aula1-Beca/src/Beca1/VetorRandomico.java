package Beca1;

import java.util.Random;
import java.util.Scanner;
/* Fazer um algoritmo para buscar determinado número, em um vetor de 100 posições preenchidos de
 * forma randômica e exibir em qual posição está o número buscado.
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

		// Traz o vetor aleatório
		Integer vet[] = criarVetorAleat(100);
		// Entrar com o número para buscar no vetor
		System.out.println("Informar o número que deseja buscar a posição: ");
		numeroBuscado = input.nextInt();

		posicao = buscaPosicao(vet, numeroBuscado);

		if (posicao == -1) 
		{
			System.out.println("O número buscado não foi encontrado no vetor!");
		} else 
		{
			System.out.println("Valor buscado: " + vet[posicao] + "\nPosição: " + posicao);
		}
	}
}
