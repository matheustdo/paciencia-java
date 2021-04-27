package controller;

import java.util.Stack;

import model.Carta;
import model.Naipe;
import model.Valor;

public class Partida {
	Stack<Carta> baralho = new Stack<>();
	
	public Partida() {
		for (Naipe naipe : Naipe.values()) {
			for (Valor valor : Valor.values()) {
				Carta carta = new Carta(naipe, valor);
				baralho.push(carta);
			}
		}
	}
}
