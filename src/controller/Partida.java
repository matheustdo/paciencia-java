package controller;

/*
* Essa classe representa um Facade.
*/
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
	
	public boolean temSequenciaNaFileira(int idMonte) {
		return paciencia.temSequenciaNaFileira(idMonte);
	}

	public boolean moverSequencia(int idOrigem, int idDestino, int quantidadeCartas) {
		return paciencia.moverSequencia(idOrigem, idDestino, quantidadeCartas);
	}
}
