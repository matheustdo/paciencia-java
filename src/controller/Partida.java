package controller;

public class Partida {
	private Paciencia paciencia = null;
	
	public boolean temPartidaAtiva() {
		return this.paciencia != null;
	}
	
	public void iniciarPartida() {
		this.paciencia = new Paciencia();
	}
	
	public void encerrarPartida() {
		this.paciencia = null;
	}
	
	public String visualizarMesa() {
		return paciencia.toString();
	}
	
	public boolean moverCarta(int idOrigem, int idDestino) {
		return paciencia.moverCarta(idOrigem, 0idDestino);
	}
}
