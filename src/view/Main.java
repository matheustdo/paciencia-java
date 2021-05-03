package view;

import java.util.Scanner;

import controller.Partida;


public class Main {
	private static Partida partida = new Partida();
	private static String mensagemInformacao = "";
	private static String mensagemSolicitacao = "> Escolha uma opção: ";
	
	/**
	 * Limpa a tela para melhorar a visualização do jogo.
	 */
	private static void limparTela() {
		for(int i = 0; i < 30; i++) {
			System.out.println();
		}
	}
	
	/**
	 * Imprime as opções de acordo com cada estado do jogo.
	 */
	private static void opcoes() {
		if(partida.temPartidaAtiva()) {
			if(partida.verificarVitoria()) {
				System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗");
				System.out.println("║  1 - Iniciar nova partida                                                       ║");
				System.out.println("║  2 - Voltar ao menu principal                                                   ║");
				System.out.println("╚═════════════════════════════════════════════════════════════════════════════════╝");
				System.out.println();
			} else {
				System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗");
				System.out.println("║  1 - Mover carta                                                                ║");
				System.out.println("║  2 - Exibir carta                                                               ║");
				System.out.println("║  3 - Alterar nº de cartas a virar do estoque                                    ║");
				System.out.println("║  4 - Reiniciar                                                                  ║");
				System.out.println("║  5 - Finalizar                                                                  ║");
				System.out.println("╚═════════════════════════════════════════════════════════════════════════════════╝");
				System.out.println();
			}
		} else {
			System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("║  1 - Iniciar jogo                                                               ║");
			System.out.println("║  2 - Finalizar                                                                  ║");
			System.out.println("╚═════════════════════════════════════════════════════════════════════════════════╝");
			System.out.println();
		}
	}
	
	/**
	 * Pede pro usuário inserir uma nova opção no próximo estado.
	 */
	private static void pedirInserirNovamente() {
		mensagemSolicitacao = "> Opção inválida. Insira novamente: ";
	}
	
	/**
	 * Limpa a mensagem de solicitação.
	 */
	private static void resetarMensagens() {
		mensagemSolicitacao = "> Escolha uma opção: ";
		mensagemInformacao = "";
	}
	
	/**
	 * Imprime o cabeçalho exibido na tela inicial.
	 */
	private static void imprimirTituloInicio() {
		System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║   _______                      __                                __             ║");
		System.out.println("║  |       \\                    |  \\                              |  \\            ║");
		System.out.println("║  | $$$$$$$\\ ______    _______  \\$$  ______   _______    _______  \\$$  ______    ║");
		System.out.println("║  | $$__/ $$|      \\  /       \\|  \\ /      \\ |       \\  /       \\|  \\ |      \\   ║");
		System.out.println("║  | $$    $$ \\$$$$$$\\|  $$$$$$$| $$|  $$$$$$\\| $$$$$$$\\|  $$$$$$$| $$  \\$$$$$$\\  ║");
		System.out.println("║  | $$$$$$$ /      $$| $$      | $$| $$    $$| $$  | $$| $$      | $$ /      $$  ║");
		System.out.println("║  | $$     |  $$$$$$$| $$_____ | $$| $$$$$$$$| $$  | $$| $$_____ | $$|  $$$$$$$  ║");
		System.out.println("║  | $$      \\$$    $$ \\$$     \\| $$ \\$$     \\| $$  | $$ \\$$     \\| $$ \\$$    $$  ║");
		System.out.println("║   \\$$       \\$$$$$$$  \\$$$$$$$ \\$$  \\$$$$$$$ \\$$   \\$$  \\$$$$$$$ \\$$  \\$$$$$$$  ║");
		System.out.println("║                                                                                 ║");
		System.out.println("║                           Desenvolvido por Matheus Teles e Rafael Azevedo. v1.0 ║");
		System.out.println("╚═════════════════════════════════════════════════════════════════════════════════╝");
	}
	
	/**
	 * Imprime o cabeçalho exibido na tela de partida
	 */
	private static void imprimirTituloPartida() {
		System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║  ╔═╗╔═╗╔═╗╦╔═╗╔╗╔╔═╗╦╔═╗                                         Olá, jogador.  ║");
		System.out.println("║  ╠═╝╠═╣║  ║╠╣ ║║║║  ║╠═╣                                      Essa é sua mesa.  ║");
		System.out.println("║  ╩  ╩ ╩╚═╝╩╚═╝╝╚╝╚═╝╩╩ ╩                                         Vá com calma!  ║");
		System.out.println("╚═════════════════════════════════════════════════════════════════════════════════╝");
		System.out.println();
	}

	/**
	 * Imprime o cabeçalho exibido na tela de partida
	 */
	private static void imprimirVitoria() {
		System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║  ╔═╗╔═╗╔═╗╦╔═╗╔╗╔╔═╗╦╔═╗                                            Oooooopaa.  ║");
		System.out.println("║  ╠═╝╠═╣║  ║╠╣ ║║║║  ║╠═╣                                        E aí, jogador.  ║");
		System.out.println("║  ╩  ╩ ╩╚═╝╩╚═╝╝╚╝╚═╝╩╩ ╩                Parece que temos um vencedor por aqui!  ║");
		System.out.println("╚═════════════════════════════════════════════════════════════════════════════════╝");
		System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║                                                                                 ║");
		System.out.println("║                              Aeeeeeeeeeeeeeeeeeeeee!!!                          ║");
		System.out.println("║                                                                                 ║");
		System.out.println("║        .------..------..------..------..------..------..------..------.         ║");
		System.out.println("║        |P.--. ||A.--. ||R.--. ||A.--. ||B.--. ||É.--. ||N.--. ||S.--. |         ║");
		System.out.println("║        | :/\\: || (\\/) || :(): || (\\/) || :(): || (\\/) || :(): || :/\\: |         ║");
		System.out.println("║        | (__) || :\\/: || ()() || :\\/: || ()() || :\\/: || ()() || :\\/: |         ║");
		System.out.println("║        | '--'P|| '--'A|| '--'R|| '--'A|| '--'B|| '--'É|| '--'N|| '--'S|         ║");
		System.out.println("║        `------'`------'`------'`------'`------'`------'`------'`------'         ║");
		System.out.println("║                                                                                 ║");
		System.out.println("║                          Você acaba de vencer a partida!!!                      ║");
		System.out.println("║                              Parabéns pela paciência!!!                         ║");
		System.out.println("║                                                                                 ║");
		System.out.println("╚═════════════════════════════════════════════════════════════════════════════════╝");
	}
	
	/**
	 * Exibe todo o jogo.
	 */
	private static void menu() {
		String opcao;
		Scanner entrada = new Scanner(System.in);
		
		/**
		 * Esse é o loop principal, onde cada ciclo é chamado de "estado" do game.
		 */
		do {
        	limparTela();
        	
        	// Se tiver partida ativa
            if(partida.temPartidaAtiva()) {

            	// Se o jogador tiver ganhado o jogo
            	if(partida.verificarVitoria()) {
            		imprimirVitoria();
        			opcoes();
        			System.out.print(mensagemSolicitacao);
        			resetarMensagens();
                    opcao = entrada.next();

                    // Se ele deseja iniciar uma nova partida
                    if (opcao.equals("1")) {
                    	partida.iniciarPartida();
                    } else if(opcao.equals("2")) {
                        // Se ele deseja voltar ao menu principal
                    	partida.encerrarPartida();
                    } else {
                        // Reseta as variáveis se uma opção indisponível for selecionada
                        opcao = "0";
                        pedirInserirNovamente();
                    }
            	} else {
                	// Se a partida ainda estiver ativa.
            		imprimirTituloPartida();
                	System.out.println(partida.visualizarMesa());
        			opcoes();
        			System.out.print(mensagemInformacao);
        			System.out.print(mensagemSolicitacao);
        			resetarMensagens();
                    opcao = entrada.next();

                    // Opção de mover a carta.
                    if(opcao.equals("1")) {
                		System.out.print("> Informe o monte no qual carta se encontra: ");
                		String idOrigemString = entrada.next(); // Pega a posição de origem das cartas ou pilha a ser movida
                        
                        try {
                            int idOrigem = Integer.parseInt(idOrigemString);

                    		System.out.print("> Informe o monte de destino da carta: ");
                    		String idDestinoString = entrada.next(); // Pega a posição de destino das cartas ou pilha a ser movida
                            int idDestino = Integer.parseInt(idDestinoString);
                            
                            // Verifica se é uma pilha ou carta que será movida
                    		if (partida.temSequenciaNaFileira(idOrigem)) {
                    			// Se for uma pilha, solicita ao jogador o tamanho da pilha
                        		System.out.print("> Informe a quantidade de cartas que deseja mover: ");
                        		String quantidadeCartasString = entrada.next();
                                int quantidadeCartas = Integer.parseInt(quantidadeCartasString);

                    			// Verifica se o movimento é válido ou não, e faz a ação
                                if (partida.moverSequencia(idOrigem, idDestino, quantidadeCartas)) {
                                	mensagemInformacao = "- Pilha movida com sucesso! \n";
                                } else {
                                	mensagemInformacao = "X Movimento inválido! \n";
                                }
                    		} else {
                    			// Se não for uma pilha, verifica se o movimento é válido ou não, e faz a ação
                                if (partida.moverCarta(idOrigem, idDestino)) {
                                	mensagemInformacao = "- Carta movida com sucesso! \n";
                                } else {
                                	mensagemInformacao = "X Movimento inválido! \n";
                                }
                    		}
                        } catch (NumberFormatException e) {
                        	mensagemInformacao = "X Você digirou um caractere inválido! \n";
                        }
                    } else if(opcao.equals("2")) {
                        // Opção de tirar a carta do estoque e mover para o descarte.
                    	partida.exibirCarta();
                    } else if(opcao.equals("3")) {
                        // Opção de configurar a quantidade de cartas a serem exibidas de vez.
                		System.out.print("> Você deseja virar uma ou três cartas por vez? ");
                		opcao = entrada.next();
                        
                        try {
                        	int qtd = Integer.parseInt(opcao);
                            
                        	// Muda a quantidade de cartas a serem exibidas para um ou três por vez
                            if (qtd == 1 || qtd == 3) {
                                partida.definirQtdVirarEstoque(qtd);
                            	mensagemInformacao = "- Quantidade de cartas por vez alterada! \n";
                            } else {
                            	// Se o jogador inserir uma quantidade de cartas inválida
                            	mensagemInformacao = "X Quantidade inválida! \n";
                            }
                        } catch (NumberFormatException e) {
                        	mensagemInformacao = "X Você digitou um caractere inválido! \n";
                        }
                    } else if(opcao.equals("4")) {
                        // Opção de reiniciar a partida.
                		System.out.print("> Você realmente quer reiniciar o jogo? (1 - sim, `Qualquer coisa` - não): ");
                        opcao = entrada.next();
                        
                        if(opcao.equals("1")) partida.iniciarPartida();
                    } else if(opcao.equals("5")) {
                        // Opção de sair da partida e voltar ao menu principal.
                		System.out.print("> Você realmente quer finalizar a partida? (1 - sim, `Qualquer coisa` - não): ");
                        opcao = entrada.next();

                        if(opcao.equals("1")) partida.encerrarPartida();
                    } else {
                        // Reseta as variáveis se uma opção indisponível for selecionada
                        opcao = "0";
                        pedirInserirNovamente();
                    }
            	}
            } else {
            	// Se não tiver partida ativa imprime as opções do menu principal.
            	imprimirTituloInicio();
    			opcoes();
    			System.out.print(mensagemSolicitacao);
    			resetarMensagens();
                opcao = entrada.next();
                
                if(opcao.equals("1")) {
                    // Inicia uma nova partida
                	partida.iniciarPartida();
                } else if(opcao.equals("2")) {
                    // Finaliza o jogo
            		System.out.print("> Você realmente quer finalizar o jogo? (1 - sim, `Qualquer coisa` - não): ");
                    opcao = entrada.next();
                    
                    if(opcao.equals("1")) opcao = "-1";
                } else {
                    // Reseta as variáveis se uma opção indisponível for selecionada
                    opcao = "0";
                    pedirInserirNovamente();
                }
            }
        } while (!opcao.equals("-1"));
		
		entrada.close();
	}
	
	public static void main(String[] args) {
		menu();
	}

}