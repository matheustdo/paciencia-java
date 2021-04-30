package model;

import java.util.Stack;

public class MonteDeCartas {
	
	protected Stack<Carta> cartas;
	
	public MonteDeCartas() {
		this.cartas = new Stack<Carta>();
	}
	
	public boolean receberCarta(Carta carta, Class classeOrigem) {
		System.out.println(classeOrigem);
		this.cartas.push(carta);
		return true;
	}

	public Carta retirarCartaDoTopo() {
		if (!cartas.isEmpty()) {
			return this.cartas.pop();
		}
		return null;
	}
	
	public Carta visualizarCartaDoTopo() {
		if (!cartas.isEmpty()) {
			return this.cartas.peek();
		}
		return null;
	}
	
	public Carta virarCartaDoTopo() {
		Carta topo = visualizarCartaDoTopo();
		if (topo.getLado() == Lado.BAIXO)
			topo.mostrar();
		else {
			topo.esconder();
		}
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
