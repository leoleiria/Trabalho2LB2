package model;

import java.util.HashMap;
import java.util.Map;

public class Contexto {
	private static Contexto contexto;
	private Map<String, Object> valores;

	private Contexto() {
		valores = new HashMap<String, Object>();
	}

	public static Contexto getContexto() {
		if (contexto == null) {
			contexto = new Contexto();
		}
		return contexto;
	}

	public void setValor(String attr, Object valor) {
		valores.put(attr, valor);
	}

	public Object getValor(String attr) {
		return (valores.get(attr));
	}
}
