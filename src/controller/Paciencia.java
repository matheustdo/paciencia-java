package controller;

import java.util.ArrayList;

import model.Carta;
import model.MonteDeCartas;
import model.Fundacao;
import model.Fileira;
import model.Estoque;
import model.Descarte;

public class Paciencia {
	private static final int QUANTIDADE_FUNDACOES = 4;
	private static final int QUANTIDADE_FILEIRAS = 7;
	private int qtdCartasVirarEstoque = 1;
	private MonteDeCartas estoque = new Estoque();
	private MonteDeCartas descarte = new Descarte();
	private ArrayList<MonteDeCartas> montes = new ArrayList<MonteDeCartas>(2 + QUANTIDADE_FILEIRAS + QUANTIDADE_FUNDACOES);
	
	public Paciencia() {
		montes.add(estoque);
		montes.add(descarte);

		for(int i = 0; i < QUANTIDADE_FUNDACOES; i++) {
			Fundacao fundacao = new Fundacao();
			montes.add(fundacao);
		}
		
		for(int i = 0; i < QUANTIDADE_FILEIRAS; i++) {
			Fileira fileira = new Fileira();
			for(int j = 0; j <= i; j++) {
				Carta carta = estoque.retirarCartaDoTopo();
				fileira.preencher(carta);
			}
			fileira.virarCartaDoTopo();
			montes.add(fileira);
		}
	}
	
	
	public void definirQtdDeCartasVirarEstoque (int n) {
		qtdCartasVirarEstoque = n;
	}
	
	/*
	public void virarCartaEstoque() {
		for (int n = 0; n < qtdCartasVirarEstoque; n++) {
			moverCartaEstoque();
		}
	}
	
	public void moverCartaEstoque() {
		Carta c = estoque.retirarCartaDoTopo();
		if (c != null) {
			descarte.receberCarta(c);
			return;
		}
		while (!descarte.estaVazio()) { 
			Carta c2 = descarte.retirarCartaDoTopo();
			estoque.receberCarta(c2);
		}
		
	}*/
	
	public boolean moverCarta(int idOrigem, int idDestino) {
		MonteDeCartas origem = montes.get(idOrigem - 1);
		MonteDeCartas destino = montes.get(idDestino - 1);
		
		Carta c = origem.visualizarCartaDoTopo();
		if (c == null) {
			if (origem instanceof Estoque) { // o estoque está vazio, é necessário reestabelece-lo
				while (!descarte.estaVazio()) { 
					Carta c2 = descarte.retirarCartaDoTopo();
					Estoque est = (Estoque) estoque;
					est.restabelecer(c2, (MonteDeCartas) descarte);
				}
			}
			return false; // a origem não possui carta, logo não é possível realizar o movimento.
		}
		
		if (!(origem instanceof Estoque)) { // se a origem não é o estoque
			if (destino.receberCarta(c, origem)) {
				origem.retirarCartaDoTopo();
				return true;
			}
			return false;
		}else { // a origem é o estoque, logo há possibilidade de fornecer mais de uma carta
			for (int n = 0; n < qtdCartasVirarEstoque; n++) {
				if (destino.receberCarta(c, origem)) {
					origem.retirarCartaDoTopo();
				}else {
					return false;
				}
			}
			return true;
		}	
	}
	
	public boolean verificarVitoria() {
		int qtdFundacoesCompletas = 0;
		for(MonteDeCartas monte : montes) {
			if(monte instanceof Fundacao) {
				Fundacao f = (Fundacao) monte;
				if(f.estaCompleta()) {
					qtdFundacoesCompletas++;
					if (qtdFundacoesCompletas == 4) {
						return true;
					}
				}
			}
		}
		return false;
	}
	

	@Override
	public String toString() {
		String opcoes = "";
		int idMonte = 1;
		
		for(MonteDeCartas monte : montes) {
			if (monte instanceof Estoque) {
				opcoes += idMonte++ + " - Estoque: ";
				opcoes += monte + "\n";
			}
			else if (monte instanceof Descarte) {
				opcoes += idMonte++ + " - Descarte: ";
				opcoes += monte + "\n";
			}
			else if(monte instanceof Fundacao) {
				opcoes += idMonte++ + " - Fundação" + String.valueOf(idMonte - 3) + ": ";
				opcoes += monte + "\n";
			}else if(monte instanceof Fileira) {
				opcoes += idMonte++ + " - Fileira" + String.valueOf(idMonte - 7) + ": ";
				opcoes += monte + "\n";
			}
		}

		return opcoes;
	}
	
}
