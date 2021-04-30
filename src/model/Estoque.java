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
	public boolean receberCarta(Carta carta, Class classeOrigem) {
		return false;
	}
	
	public boolean restabelecer (Carta carta, Class classeOrigem) {
		if (classeOrigem == new Descarte().getClass()) {
			carta.esconder();
			this.cartas.push(carta);
			return true;
		}
		return false;
	}

}
