package controller;

import java.util.Collections;
import java.util.Stack;
import java.util.ArrayList;

import model.Pilha;
import model.Carta;
import model.Naipe;
import model.Valor;

/**
 * Essa classe funciona como o controlador da partida de paciência.
 * @author Matheus Teles e Rafael Azevedo
 */
public class Partida {
	private static final int QUANTIDADE_FUNDACOES = 4;
	private static final int QUANTIDADE_FILEIRAS = 7;
	private Stack<Carta> estoque = new Stack<>();
	private ArrayList<Pilha> fundacoes = new ArrayList<Pilha>(QUANTIDADE_FUNDACOES);
	private ArrayList<Pilha> fileiras = new ArrayList<Pilha>(QUANTIDADE_FILEIRAS);
	private Pilha descarte = new Pilha();
	
	/**
	 * O construtor de Partida() preenche todas as estruturas de dados necessárias
	 * para o funcionamento da partida.
	 */
	public Partida() {
		/* Preenche o estoque com todas as 52 cartas disponíveis no jogo. */
		for (Naipe naipe : Naipe.values()) {
			for (Valor valor : Valor.values()) {
				Carta carta = new Carta(naipe, valor);
				estoque.push(carta);
			}
		}

		/* Embaralha as cartas no estoque. */
		Collections.shuffle(estoque);

		/* Instancia e adiciona pilhas na estrutura das fundações. */
		for (int i = 0; i < QUANTIDADE_FUNDACOES; i++) {
			Pilha fundacao = new Pilha();
			fundacoes.add(fundacao);
		}

		/* Instancia e adiciona pilhas na estrutura das fileiras. */
		for (int i = 0; i < QUANTIDADE_FILEIRAS; i++) {
			Pilha fileira = new Pilha();
			fileiras.add(fileira);
		}

		/* Distribui as cartas do estoque nas fileiras disponíveis, onde cada fileira
		 * recebe uma quantidade de cartas igual ao número da fileira. */
		for(int i = 0; i < fileiras.size(); i++) {
			Pilha fileira = fileiras.get(i);
			
			for(int j = 0; j <= i; j++) {
				Carta carta = estoque.pop();
				fileira.colocarCarta(carta);
			}
			
			fileira.virarCartaDoTopo();
		}
		
		log();
		pegarCartaEstoque();
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
		
		for(Pilha fundacao : fundacoes) {
			System.out.print("Fundacao:  ");
			System.out.println(fundacao);
		}

		System.out.println();
		
		for(Pilha fileira : fileiras) {
			System.out.print("Tableau:   ");
			System.out.println(fileira);
		}
		
		System.out.println();
	}
	
	public void pegarCartaEstoque() {
		if(!estoque.isEmpty()) {
			Carta carta = estoque.pop();
			carta.mostrar();
			descarte.colocarCarta(carta);
		}
	}
}
