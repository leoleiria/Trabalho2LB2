package model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import model.*;

public class Bilhete {
	private String localizador;
	private int cliente;
	private int voo;
	private String dataHora;

	public Bilhete(String localizador, int cliente, int voo, String dataHora) {
		this.localizador = localizador;
		this.cliente = cliente;
		this.voo = voo;
		this.dataHora = dataHora;
	}

	public String getLocalizador() {
		return localizador;
	}

	public int getCliente() {
		return cliente;
	}

	public int getVoo() {
		return voo;
	}

	public String getDataHora() {
		return dataHora;
	}

	@Override
	public String toString() {
		return "Localizador: " + localizador + ", cliente: " + cliente + ", voo: " + voo + "Data e hora: " + dataHora;
	}

}
