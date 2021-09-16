package Beca1;

import java.util.Random;

public class Matriz {
	public static void main(RetiraEspaco[] args) {
		Random gerador = new Random();
		int matriz [][] = new int [3][3];
		//int x = 0;
		//x = gerador.nextInt(10);
		
		//System.out.println(x);
		
		for(int i = 0; i < 3 ; i++)
		{  
			for(int j = 0; j < 3 ; j++)
			{  
	            matriz[i][j] = gerador.nextInt(10);  
	        }  
	            
	     }
		
		for(int i = 0; i < 3 ; i++)
		{
			System.out.println();
			for(int j = 0; j < 3 ; j++)
			{  
				System.out.print(matriz[i][j] + " ");
			}

		}
	}

}
