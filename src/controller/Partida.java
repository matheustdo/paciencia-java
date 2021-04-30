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
		return paciencia.moverCarta(idOrigem, idDestino);
	}
	
	public void definirQtdVirarEstoque(int qtd) {
		paciencia.definirQtdVirarEstoque(qtd);
	}
	
	public boolean exibirCarta() {
		return paciencia.exibirCarta();
	}
	
	public boolean verificarVitoria() {
		return paciencia.verificarVitoria();
	}
	
	public boolean temPilha(int idMonte) {
		return false;
	}

	public boolean moverPilha(int idOrigem, int idDestino, int quantidadeCartas) {
		return false;
	}
}
