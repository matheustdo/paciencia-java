package view;

import model.Carta;
import model.Naipe;
import model.Valor;

public class Main {
	public static void main(String[] args) {
		Carta c = new Carta(Naipe.COPAS, Valor.AS);
		System.out.println(c.getNaipe());
	}
}
