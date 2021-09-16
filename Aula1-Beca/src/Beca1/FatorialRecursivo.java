package Beca1;

public class FatorialRecursivo {
	
	static int fatorial(int n) 
	{
		if(n==1)
		{
			return 1;
		}
		return n*fatorial(n-1);
	}
	
	public static void main(RetiraEspaco[] args) {
		System.out.println(fatorial(10));
	}

}
