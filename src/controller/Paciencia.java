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
	private MonteDeCartas estoque = new Estoque();
	private MonteDeCartas descarte = new Descarte();
	private ArrayList<Fundacao> fundacoes = new ArrayList<Fundacao>(QUANTIDADE_FUNDACOES);
	private ArrayList<Fileira> fileiras = new ArrayList<Fileira>(QUANTIDADE_FILEIRAS);
	
	public Paciencia() {
		
		/* Instancia e adiciona pilhas na estrutura das fundações. */
		for(int i = 0; i < QUANTIDADE_FUNDACOES; i++) {
			Fundacao fundacao = new Fundacao();
			fundacoes.add(fundacao);
		}
		
		/* Instancia e adiciona pilhas na estrutura das fileiras. */
		for(int i = 0; i < QUANTIDADE_FILEIRAS; i++) {
			Fileira fileira = new Fileira();
			fileiras.add(fileira);
		}
		
		/* Distribui as cartas do estoque nas fileiras disponíveis, onde cada fileira
		 * recebe uma quantidade de cartas igual ao número da fileira. */
		for(int i = 0; i < fileiras.size(); i++) {
			Fileira fileira = fileiras.get(i);
			
			for(int j = 0; j <= i; j++) {
				Carta carta = estoque.retirarCarta();
				fileira.preencher(carta);
			}
			
			fileira.virarCartaDoTopo();
		}
		
		log();
	}
	
	public void log() {
		String visualizacaoEstoque = estoque.toString();
		System.out.print("Estoque:   ");
		
		if(visualizacaoEstoque.length() > 2)
			System.out.print(visualizacaoEstoque.substring(1, visualizacaoEstoque.length() - 1));
		
		System.out.println();

		System.out.print("Descarte:  ");
		System.out.print(descarte);
		
		System.out.println();
		System.out.println();
		
		int idFundacao = 1;
		for(Fundacao fundacao : fundacoes) {
			System.out.print(idFundacao++ + " - Fundacao:  ");
			System.out.println(fundacao);
		}

		System.out.println();
		
		int idFileira = 1;
		for(Fileira fileira : fileiras) {
			System.out.print(idFileira++ +" - Tableau:   ");
			System.out.println(fileira);
		}
		
		System.out.println();
	}
	
}
