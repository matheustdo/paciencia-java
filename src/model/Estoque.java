package model;

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
	}
}
