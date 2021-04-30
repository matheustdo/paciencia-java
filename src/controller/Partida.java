package controller;

import java.util.Collections;
import java.util.Stack;
import java.util.ArrayList;

import model.MonteDeCartas;
import model.Fundacao;
import model.Pilha;
import model.Carta;
import model.Naipe;
import model.Numeracao;

/**
 * Essa classe funciona como o controlador da partida de paciência.
 * @author Matheus Teles e Rafael Azevedo
 */
public class Partida {
	private static final int QUANTIDADE_FUNDACOES = 4;
	private static final int QUANTIDADE_FILEIRAS = 7;
	private int qtdCartasVirarEstoque = 1;
	private Stack<Carta> estoque = new Stack<>();
	private ArrayList<Pilha> fundacoes = new ArrayList<Pilha>(QUANTIDADE_FUNDACOES);
	private ArrayList<Pilha> fileiras = new ArrayList<Pilha>(QUANTIDADE_FILEIRAS);
	private Pilha descarte = new Pilha();
	
	/**
	 * O construtor de Partida() preenche todas as estruturas de dados necessárias.
	 * para o funcionamento da partida.
	 */
	public Partida() {
		/* Preenche o estoque com todas as 52 cartas disponíveis no jogo. */
		for (Naipe naipe : Naipe.values()) {
			for (Numeracao valor : Numeracao.values()) {
				Carta carta = new Carta(naipe, valor);
				estoque.push(carta);
			}
		}

		/* Embaralha as cartas no estoque. */
		Collections.shuffle(estoque);

		/* Instancia e adiciona pilhas na estrutura das fundações. */
		for(int i = 0; i < QUANTIDADE_FUNDACOES; i++) {
			Pilha fundacao = new Pilha();
			fundacoes.add(fundacao);
		}

		/* Instancia e adiciona pilhas na estrutura das fileiras. */
		for(int i = 0; i < QUANTIDADE_FILEIRAS; i++) {
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
		for (int i = 0; i < 23; i++) {
			virarCartaEstoque();
		}
		log();
		virarCartaEstoque();
		log();
		virarCartaEstoque();
		log();
		virarCartaEstoque();
		log();
		moverDoDescarteParaFileira(1);
		moverDoDescarteParaFileira(2);
		moverDoDescarteParaFileira(3);
		moverDoDescarteParaFileira(4);
		moverDoDescarteParaFileira(5);
		moverDoDescarteParaFileira(6);
		moverDoDescarteParaFileira(7);
		log();
		
		MonteDeCartas mdc = new MonteDeCartas();
		mdc.receberCarta(new Carta(Naipe.COPAS, Numeracao.AS));
		
		MonteDeCartas fnd = new Fundacao();
		fnd.receberCarta(new Carta(Naipe.COPAS, Numeracao.AS));
		fnd.retirarCarta();
		
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
		for(Pilha fundacao : fundacoes) {
			System.out.print(idFundacao++ + " - Fundacao:  ");
			System.out.println(fundacao);
		}

		System.out.println();
		
		int idFileira = 1;
		for(Pilha fileira : fileiras) {
			System.out.print(idFileira++ +" - Tableau:   ");
			System.out.println(fileira);
		}
		
		System.out.println();
	}
	
	public void definirQtdDeCartasVirarEstoque (int n) {
		qtdCartasVirarEstoque = n;
	}
	
	public void virarCartaEstoque() {
		for (int n = 0; n < qtdCartasVirarEstoque; n++) {
			moverCartaEstoque();
		}
	}
	
	/**
	 * Movimenta uma carta do estoque para o descarte. Caso o descarte esvazie, as cartas do estoque retornam para o descarte.
	 */
	private void moverCartaEstoque() {
		if(!estoque.isEmpty()) { // estoque não está vazio
			Carta carta = estoque.pop(); // pega a carta
			carta.mostrar(); // vira a carta para cima
			descarte.colocarCarta(carta); // coloca a carta no descarte
		}else { // estoque está vazio
			while (!descarte.isEmpty()) { // enquanto descarte não estiver vazio
				Carta c = descarte.retirarCarta(); // retira a carta do estoque
				c.esconder(); // vira a carta para baixo
				estoque.push(c); // coloca a carta de volta ao estoque
			}
			if(!estoque.isEmpty()) { 
				Carta carta = estoque.pop(); 
				carta.mostrar(); 
				descarte.colocarCarta(carta);
			}
		}
	}
	
	/**
	 * Movimenta uma carta do descarte para uma fileira.
	 * @param idFileiraDestino identificador da fileira de destino.
	 */
	public void moverDoDescarteParaFileira(int idFileiraDestino) {
		if(!descarte.isEmpty()) {
			Pilha fileiraDestino = fileiras.get(idFileiraDestino - 1);
			Carta cartaOrigem = descarte.virarCartaDoTopo();
			
			if(fileiraDestino.isEmpty()) {
				descarte.retirarCarta();
				fileiraDestino.colocarCarta(cartaOrigem);
			} else {
				Carta cartaDestino = fileiraDestino.virarCartaDoTopo();
				
				if(verificarJogada(cartaOrigem, cartaDestino)) {
					descarte.retirarCarta();
					fileiraDestino.colocarCarta(cartaOrigem);
				}
			}
		}
	}
	
	/**
	 * Movimenta uma carta de uma fileira para outra fileira.
	 * @param idFileiraOrigem identificador da fileira de origem.
	 * @param idFileiraDestino identificador da fileira de destino.
	 */
	public void moverDeFileiraParaFileira(int idFileiraOrigem, int idFileiraDestino) {
		Pilha fileiraOrigem = fileiras.get(idFileiraOrigem - 1);
		
		if(!fileiraOrigem.isEmpty()) {
			Pilha fileiraDestino = fileiras.get(idFileiraDestino - 1);
			Carta cartaOrigem = fileiraOrigem.virarCartaDoTopo();
			
			if(fileiraDestino.isEmpty()) {
				fileiraOrigem.retirarCarta();
				fileiraDestino.colocarCarta(cartaOrigem);
			} else {
				Carta cartaDestino = fileiraDestino.virarCartaDoTopo();
				
				if(verificarJogada(cartaOrigem, cartaDestino)) {
					fileiraOrigem.retirarCarta();
					fileiraDestino.colocarCarta(cartaOrigem);
				}
			}
		}
	}
	
	/**
	 * Verifica se uma jogada é permitida analisando a descendência e distinção de cores.
	 * @param cartaOrigem carta a ser movimentada.
	 * @param cartaDestino carta a ser sobreposta.
	 * @return booleano indicando se a jogada é permitida ou não.
	 */
	public boolean verificarJogada(Carta cartaOrigem, Carta cartaDestino) {
		if (cartaOrigem.getNumeracao().getValor() - cartaDestino.getNumeracao().getValor() == -1) {
			if(!cartaOrigem.getNaipe().getCor().equals(cartaDestino.getNaipe().getCor())) {
				return true;
			}
		}
		
		return false;
	}
	
}
