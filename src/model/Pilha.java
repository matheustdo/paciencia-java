package model;

import java.util.Stack;

public class Pilha {
	private Stack<Carta> cartas;
	
	public Pilha() {
		this.cartas = new Stack<>();
	}
	
	public void colocarCarta(Carta carta) {
		this.cartas.push(carta);
	}

	public Carta retirarCarta() {
		return this.cartas.pop();
	}
	
	public void virarCartaDoTopo() {
		Carta topo = this.cartas.peek();
		topo.mostrar();
	}
	
	public boolean isEmpty() {
		return cartas.isEmpty();
	}
	
	@Override
	public String toString() {
		String visualizacao = this.cartas.toString();
		
		if (visualizacao.length() > 2) return visualizacao.substring(1, visualizacao.length() - 1);
		return "";
	}
	
}
