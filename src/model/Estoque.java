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
		Collections.shuffle(cartas);
	}
	
	@Override
	public boolean receberCarta(Carta carta, MonteDeCartas origem) {
		return false;
	}
	
	@Override
	public Carta virarCartaDoTopo() {
		Carta topo = visualizarCartaDoTopo();
		
		if(!estaVazio()) {
			topo.esconder();
		}
		
		return topo;
	}
	
	public boolean restabelecer (Carta carta, MonteDeCartas origem) {
		if (origem instanceof Descarte) {
			carta.esconder();
			this.cartas.push(carta);
			return true;
		}
		return false;
	}

}
