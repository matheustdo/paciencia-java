package model;

import java.util.Collections;
import model.Descarte;

public class Estoque extends MonteDeCartas {
	

	public Estoque () {
		super();
		/* Preenche o estoque com todas as 52 cartas disponíveis no jogo. */
		for (Naipe naipe : Naipe.values()) {
			for (Numeracao valor : Numeracao.values()) {
				Carta carta = new Carta(naipe, valor);
				this.cartas.push(carta);
			}
		}
		Collections.shuffle(cartas); // embaralha as cartas!!
	}
	
	/*
	* Esta fun��o sobrescrita implementa como Estoque recebe uma carta.
	* @param carta a ser recebida.
	* @param monte de origem.
	* @return se a carta foi recebida ou não.
	*/
	@Override
	public boolean receberCarta(Carta carta, MonteDeCartas origem) {
		return false; // estoque não recebe carta!!!
	}
	
	/*
	* Esta fun��o sobrescrita implementa como Estoque vira a carta do topo.
	* @return carta do topo.
	*/
	@Override
	public Carta virarCartaDoTopo() {
		Carta topo = visualizarCartaDoTopo();
		
		if(!estaVazio()) {
			topo.esconder();
		}
		
		return topo;
	}
	
	/*
	* Esta função permite o estoque se reestabelecer quando é esgotado, através do Descarte.
	* @param carta a ser inserida.
	* @param monte de origem.
	* @return se a carta foi reestabelecida ou não.
	*/
	public boolean restabelecer (Carta carta, MonteDeCartas origem) {
		if (origem instanceof Descarte) {
			carta.esconder();
			this.cartas.push(carta);
			return true;
		}
		return false;
	}

}
