package model;

public class Fileira extends MonteDeCartas {
	
	public Fileira () {
		super();
	}
	
	@Override
	public boolean receberCarta(Carta carta, Class classeOrigem) {
		Carta topo = this.cartas.peek();
		if (carta.getNumeracao().getValor() - topo.getNumeracao().getValor() == -1) {
			if(!carta.getNaipe().getCor().equals(topo.getNaipe().getCor())) {
				this.cartas.push(carta);
				return true;
			}
		}
		
		return false;
	}
	
	public void preencher(Carta carta) {
		this.cartas.push(carta);
	}
	
}
