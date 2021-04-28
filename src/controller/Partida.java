package controller;

import java.util.Collections;
import java.util.Stack;
import java.util.ArrayList;

import model.Fileira;
import model.Carta;
import model.Naipe;
import model.Valor;

public class Partida {
	private Stack<Carta> baralho = new Stack<>();
	private ArrayList<Fileira> fileiras = new ArrayList<Fileira>(7);
	
	public Partida() {
		for (Naipe naipe : Naipe.values()) {
			for (Valor valor : Valor.values()) {
				Carta carta = new Carta(naipe, valor);
				baralho.push(carta);
			}
		}
		Collections.shuffle(baralho);
		
		for (int i = 0; i < 7; i++) {
			Fileira f = new Fileira();
			fileiras.add(f);
		}
		
		for(int i = 0; i < fileiras.size(); i++) {
			Fileira fileira = fileiras.get(i);
			for(int j = 0; j <= i; j++) {
				Carta carta = baralho.pop();
				fileira.receberCarta(carta);
			}
			fileira.virarCartaDoTopo();
		}	
		
		System.out.println(fileiras.get(6).toString());
			
	}
}
