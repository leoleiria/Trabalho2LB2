package model;

public class Aviao {
	private int id;
	private String nome;
	private int nroAssentos;

	public Aviao(String nome, int nroAssentos) {
		this.nome = nome;
		this.nroAssentos = nroAssentos;
		this.id = 0;
	}
	
	public Aviao(int id, String nome, int nroAssentos) {
		this.nome = nome;
		this.nroAssentos = nroAssentos;
		this.id = id;
	}

	public int getId() {
		return id;
	}
	public String getIdString() {
		return String.valueOf(id);
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

	public String getNroAssentosString() {
		return String.valueOf(nroAssentos);
	}

}
