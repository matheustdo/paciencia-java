package model;

import java.util.Stack;

/*
* Esta classe representa um monte de cartas.
*/
public class MonteDeCartas {
	
	protected Stack<Carta> cartas; // um monte é representado por uma pilha
	
	public MonteDeCartas() {
		this.cartas = new Stack<Carta>();
	}
	
	/**
	* Esta função define como o monte de cartas deve receber uma carta.
	* @param carta a ser recebida.
	* @param monte de origem.
	* @return se a carta foi recebida ou nÃ£o
	*/
	public boolean receberCarta(Carta carta, MonteDeCartas origem) {
		this.cartas.push(carta);
		return true;
	}
	
	/*
	* Esta função permite retirar uma carta do topo.
	* @return carta do topo que foi retirada.
	*/
	public Carta retirarCartaDoTopo() {
		if (!cartas.isEmpty()) {
			return this.cartas.pop();
		}
		return null;
	}
	
	/*
	* Esta função permite visualizar uma carta do topo.
	* @return carta do topo para visualização.
	*/
	public Carta visualizarCartaDoTopo() {
		if (!cartas.isEmpty()) {
			return this.cartas.peek();
		}
		return null;
	}
	
	/*
	* Esta função permite virar uma carta do topo.
	* @return carta do topo que foi virada.
	*/
	public Carta virarCartaDoTopo() {
		Carta topo = visualizarCartaDoTopo();
		
		if(!estaVazio()) {
			topo.mostrar();
		}
		
		return topo;
	}
	
	/*
	* Esta função retorna se o monte está vazio.
	* @return se está vazio ou não.
	*/
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
