package model;
import model.Estoque;

public class Descarte extends MonteDeCartas{
	
	public Descarte () {
		super();
	}
	
	@Override
	public boolean receberCarta(Carta carta, MonteDeCartas origem) {
		if (origem instanceof Estoque) {
			carta.mostrar();
			this.cartas.push(carta);
			return true;
		}
		return false;
	}
	
}
