package view;

import java.util.Scanner;

import controller.Partida;


public class Main {
	private static boolean jogoIniciado = false;
	
	private static void limparTela() {
		for(int i = 0; i < 30; i++) {
			System.out.println();
		}
	}
	
	private static void opcoes() {
		if(jogoIniciado) {
			System.out.println("1 - Mover carta");
			System.out.println("2 - Exibir jogo");
			System.out.println("3 - Alterar nº de cartas a virar do estoque");
			System.out.println("4 - Reiniciar");
			System.out.println("5 - Finalizar");
		} else {
			System.out.println("4 - Iniciar jogo");
			System.out.println("5 - Finalizar");
		}
	}
	
	private static void menu() {
		String opcao;
		Scanner entrada = new Scanner(System.in);
		
		do{	
			if(jogoIniciado) limparTela();
			
			opcoes();
			
			System.out.print("Escolha uma opção: ");
            opcao = entrada.next();
            
            switch(opcao) {
	            case "1":
	                break;
	            case "2":
	                break;
	            case "3":
	                break;
	            case "4":
	            	if(jogoIniciado) {
	            		System.out.print("Você realmente quer reiniciar o jogo? (1 - sim, 2 - não): ");
	                    opcao = entrada.next();
	                    
	                    if(opcao.equals("1")) jogoIniciado = true;;
	            	} else {
	                	new Partida();
	                	jogoIniciado = true;
	            	}
	            	
	                break;
	            case "5":
	        		System.out.print("Você realmente quer finalizar o jogo? (1 - sim, 2 - não): ");
	                opcao = entrada.next();
	                
	                if(jogoIniciado) {
	                    if(opcao.equals("1")) jogoIniciado = false;
	                } else {
	                	opcao = "5";
	                }
                    
	                break;
	            default:
	            	if(!opcao.equals("0"))
	            		System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("5"));
		
		entrada.close();
	}
	
	public static void main(String[] args) {
		new Partida();
		menu();
	}

}