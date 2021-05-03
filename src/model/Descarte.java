package model;
import model.Estoque;

/**
* Esta classe representa um Monte de Cartas do tipo Descarte.
*/
public class Descarte extends MonteDeCartas{
	
	public Descarte () {
		super();
	}
	
	/*
	* Esta função sobrescrita implementa como Descarte recebe uma carta.
	* @param carta a ser recebida.
	* @param monte de origem.
	* @return se a carta foi recebida ou não.
	*/
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
