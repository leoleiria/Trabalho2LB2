package model;

public class Aviao {

	private String nome;
	private int nroAssentos;

	public Aviao(String nome, int nroAssentos) {
		
		this.nome = nome;
		this.nroAssentos = nroAssentos;
	}

	public String getNome() {
		return nome;
	}

	public int getNroAssentos() {
		return nroAssentos;
	}

	public void setNroAssentos(int nroAssentos) {
		this.nroAssentos = nroAssentos;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Nro de assentos: " + nroAssentos;
	}

}
