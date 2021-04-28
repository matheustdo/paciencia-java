package model;

import java.util.Stack;

public class Fileira {
	private Stack<Carta> cartas;
	
	public Fileira() {
		cartas = new Stack<>();
	}
	
	public void receberCarta(Carta carta) {
		cartas.push(carta);
	}
	
	public void virarCartaDoTopo() {
		Carta topo = cartas.peek();
		topo.setLado(Lado.CIMA);
	}
	
	public int tamanho() {
		return cartas.size();
	}
	
	@Override
	public String toString() {
		return cartas.toString();
	}
	
}
