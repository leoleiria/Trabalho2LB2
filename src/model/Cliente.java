package model;

public class Cliente {
	private int rg;
	private String nome;
	private String telefone;

	public Cliente(int rg, String nome, String telefone) {
		this.rg = rg;
		this.nome = nome;
		this.telefone = telefone;
	}

	public int getRg() {
		return rg;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Rg: " + rg + ", Telefone: " + telefone;

	}

}
