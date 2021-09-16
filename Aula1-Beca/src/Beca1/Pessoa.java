package Beca1;

public class Pessoa {
	public String nome, sexo, corOlho;
	public int idade;
	
	public Pessoa(String nome, String sexo, int idade) {
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		
	}
	
	public String getCorOlho() {
		return corOlho;
	}

	public void setCorOlho(String corOlho) {
		this.corOlho = corOlho;
	}

	public static void main(String[] args) {
		Pessoa cidadao1 = new Pessoa("Ian Victor","Masc",22);
		cidadao1.setCorOlho("Castanho Claro");
		
		Pessoa cidadao2 = new Pessoa("João Fernandes","Masc",33);
		cidadao2.setCorOlho("Verde");
		
		System.out.println(cidadao1.nome);
		System.out.println(cidadao1.sexo);
		System.out.println(cidadao1.idade);
		System.out.println(cidadao1.corOlho);
		
		System.out.println(cidadao2.nome);
		System.out.println(cidadao2.sexo);
		System.out.println(cidadao2.idade);
		System.out.println(cidadao2.corOlho);
	}

}
