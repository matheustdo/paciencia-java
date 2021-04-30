package model;

public class Fundacao extends MonteDeCartas{

	public Fundacao () {
		super();
	}
	
	@Override
	public boolean receberCarta(Carta carta, MonteDeCartas origem) {
		if (!(origem instanceof Estoque)) {
			Carta topo = visualizarCartaDoTopo();
			if (topo != null) {
				if (carta.getNumeracao().getValor() - topo.getNumeracao().getValor() == 1) {
					if(carta.getNaipe().getCor().equals(topo.getNaipe().getCor())) {
						this.cartas.push(carta);
						return true;
					}
				}	
				return false;
			} else if (carta.getNumeracao() == Numeracao.AS) {
				this.cartas.push(carta);
				return true;
			}
		}
		return false;
	}
	
	public boolean estaCompleta() {
		return (cartas.size() == 13);
	}
	
}
