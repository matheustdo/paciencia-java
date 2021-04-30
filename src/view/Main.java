package view;

import java.util.Scanner;

import controller.Fachada;
import controller.Partida;
import controller.Paciencia;


public class Main {
	private static Fachada fachada = new Fachada();
	private static String mensagemSolicitacao = "";
	
	private static void limparTela() {
		for(int i = 0; i < 30; i++) {
			System.out.println();
		}
	}
	
	private static void opcoes() {
		if(fachada.temPartidaAtiva()) {
			System.out.println("1 - Mover carta");
			System.out.println("2 - Exibir jogo");
			System.out.println("3 - Alterar nº de cartas a virar do estoque");
			System.out.println("4 - Reiniciar");
			System.out.println("5 - Finalizar");
		} else {
			System.out.println("1 - Iniciar jogo");
			System.out.println("2 - Finalizar");
		}
	}
	
	private static void pedirInserirNovamente() {
		mensagemSolicitacao = "Opção inválida. Insira novamente: ";
	}
	
	private static void resetarSolicitacao() {
		mensagemSolicitacao = "Escolha uma opção: ";
	}
	
	private static void menu() {
		String opcao;
		Scanner entrada = new Scanner(System.in);
		
		do {	
			if(fachada.temPartidaAtiva()) limparTela();
			
			opcoes();
			
			System.out.print(mensagemSolicitacao);
			resetarSolicitacao();
            opcao = entrada.next();
            
            if(fachada.temPartidaAtiva()) {
                if(opcao.equals("1")) {
                	
                } else if(opcao.equals("2")) {
                    
                } else if(opcao.equals("3")) {
             
                } else if(opcao.equals("4")) {
            		System.out.print("Você realmente quer reiniciar o jogo? (1 - sim, `Qualquer coisa` - não): ");
                    opcao = entrada.next();
                    
                    if(opcao.equals("1")) fachada.iniciarPartida();
                } else if(opcao.equals("5")) {
            		System.out.print("Você realmente quer finalizar a partida? (1 - sim, `Qualquer coisa` - não): ");
                    opcao = entrada.next();

                    if(opcao.equals("1")) fachada.encerrarPartida();
                } else {
                    opcao = "0";
                    pedirInserirNovamente();
                }
            } else {
                if(opcao.equals("1")) {
                	fachada.iniciarPartida();
                } else if(opcao.equals("2")) {
            		System.out.print("Você realmente quer finalizar o jogo? (1 - sim, `Qualquer coisa` - não): ");
                    opcao = entrada.next();
                    
                    if(opcao.equals("1")) opcao = "-1";
                } else {
                    opcao = "0";
                    pedirInserirNovamente();
                }
            }
        } while (!opcao.equals("-1"));
		
		entrada.close();
	}
	
	public static void main(String[] args) {
		/*new Partida();
		menu();*/
		new Paciencia();
	}

}