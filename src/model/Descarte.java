package model;
import model.Estoque;

public class Descarte extends MonteDeCartas{
	
	public Descarte () {
		super();
	}
	
	@Override
	public boolean receberCarta(Carta carta, Class classeOrigem) {
		if (classeOrigem == new Estoque().getClass()) {
			carta.mostrar();
			this.cartas.push(carta);
			return true;
		}
		return false;
	}
	
}
