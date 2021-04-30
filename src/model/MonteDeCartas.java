package model;

import java.util.Stack;

public class MonteDeCartas {
	
	protected Stack<Carta> cartas;
	
	public MonteDeCartas() {
		this.cartas = new Stack<Carta>();
	}
	
	public boolean receberCarta(Carta carta) {
		this.cartas.push(carta);
		return true;
	}

	public Carta retirarCarta() {
		if (!cartas.isEmpty()) {
			return this.cartas.pop();
		}
		return null;
	}
	
	public Carta virarCartaDoTopo() {
		Carta topo = this.cartas.peek();
		topo.mostrar();
		return topo;
	}
	
	public boolean estaVazio() {
		return cartas.isEmpty();
	}
	
	
	@Override
	public String toString() {
		String visualizacao = cartas.toString();
		
		if (visualizacao.length() > 2) return visualizacao.substring(1, visualizacao.length() - 1);
		return "";
	}
	
}
