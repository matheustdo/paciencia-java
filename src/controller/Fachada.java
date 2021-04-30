package controller;

public class Fachada {
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
}
