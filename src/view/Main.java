package view;

import java.util.Scanner;

import controller.Partida;


public class Main {
	private static Partida partida = new Partida();
	private static String mensagemInformacao = "";
	private static String mensagemSolicitacao = "▶ Escolha uma opção: ";
	
	private static void limparTela() {
		for(int i = 0; i < 30; i++) {
			System.out.println();
		}
	}
	
	private static void opcoes() {
		if(partida.temPartidaAtiva()) {
			if(partida.verificarVitoria()) {
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.println("┃  1 - Iniciar nova partida                                                       ┃");
				System.out.println("┃  2 - Voltar ao menu principal                                                   ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				System.out.println();
			} else {
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.println("┃  1 - Mover carta                                                                ┃");
				System.out.println("┃  2 - Exibir carta                                                               ┃");
				System.out.println("┃  3 - Alterar nº de cartas a virar do estoque                                    ┃");
				System.out.println("┃  4 - Reiniciar                                                                  ┃");
				System.out.println("┃  5 - Finalizar                                                                  ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				System.out.println();
			}
		} else {
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("┃  1 - Iniciar jogo                                                               ┃");
			System.out.println("┃  2 - Finalizar                                                                  ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.println();
		}
	}
	
	private static void pedirInserirNovamente() {
		mensagemSolicitacao = "▶ Opção inválida. Insira novamente: ";
	}
	
	private static void resetarMensagens() {
		mensagemSolicitacao = "▶ Escolha uma opção: ";
		mensagemInformacao = "";
	}
	
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
	
	private static void imprimirTituloPartida() {
		System.out.println("╔═════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║  ╔═╗╔═╗╔═╗╦╔═╗╔╗╔╔═╗╦╔═╗                                         Olá, jogador.  ║");
		System.out.println("║  ╠═╝╠═╣║  ║╠╣ ║║║║  ║╠═╣                                      Essa é sua mesa.  ║");
		System.out.println("║  ╩  ╩ ╩╚═╝╩╚═╝╝╚╝╚═╝╩╩ ╩                                         Vá com calma!  ║");
		System.out.println("╚═════════════════════════════════════════════════════════════════════════════════╝");
		System.out.println();
	}

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
	
	private static void menu() {
		String opcao;
		Scanner entrada = new Scanner(System.in);
		
		do {
        	limparTela();
        	
            if(partida.temPartidaAtiva()) {
            	if(partida.verificarVitoria()) {
            		imprimirVitoria();
        			opcoes();
        			System.out.print(mensagemSolicitacao);
        			resetarMensagens();
                    opcao = entrada.next();

                    if (opcao.equals("1")) {
                    	partida.iniciarPartida();
                    } else if(opcao.equals("2")) {
                    	partida.encerrarPartida();
                    } else {
                        opcao = "0";
                        pedirInserirNovamente();
                    }
            	} else {
            		imprimirTituloPartida();
                	System.out.println(partida.visualizarMesa());
        			opcoes();
        			System.out.print(mensagemInformacao);
        			System.out.print(mensagemSolicitacao);
        			resetarMensagens();
                    opcao = entrada.next();
                    
                    if(opcao.equals("1")) {
                		System.out.print("▷ Informe o monte no qual carta se encontra: ");
                		String idOrigemString = entrada.next();
                        
                        try {
                            int idOrigem = Integer.parseInt(idOrigemString);

                    		System.out.print("▷ Informe o monte de destino da carta: ");
                    		String idDestinoString = entrada.next();
                            int idDestino = Integer.parseInt(idDestinoString);

                    		if (partida.temPilha(idOrigem)) {
                        		System.out.print("▷ Informe a quantidade de cartas que deseja mover: ");
                        		String quantidadeCartasString = entrada.next();
                                int quantidadeCartas = Integer.parseInt(quantidadeCartasString);

                                if (partida.moverPilha(idOrigem, idDestino, quantidadeCartas)) {
                                	mensagemInformacao = "✔ Pilha movida com sucesso! \n";
                                } else {
                                	mensagemInformacao = "✖ Movimento inválido! \n";
                                }
                    		} else {
                                if (partida.moverCarta(idOrigem, idDestino)) {
                                	mensagemInformacao = "✔ Carta movida com sucesso! \n";
                                } else {
                                	mensagemInformacao = "✖ Movimento inválido! \n";
                                }
                    		}
                        } catch (NumberFormatException e) {
                        	mensagemInformacao = "✖ Você digirou um caractere inválido! \n";
                        }
                    } else if(opcao.equals("2")) {
                    	partida.exibirCarta();
                    } else if(opcao.equals("3")) {
                		System.out.print("▷ Você deseja virar uma ou três cartas por vez? ");
                		opcao = entrada.next();
                        
                        try {
                        	int qtd = Integer.parseInt(opcao);
                            
                            if (qtd == 1 || qtd == 3) {
                                partida.definirQtdVirarEstoque(qtd);
                            	mensagemInformacao = "✔ Quantidade de cartas por vez alterada! \n";
                            } else {
                            	mensagemInformacao = "✖ Quantidade inválida! \n";
                            }
                        } catch (NumberFormatException e) {
                        	mensagemInformacao = "✖ Você digirou um caractere inválido! \n";
                        }
                    } else if(opcao.equals("4")) {
                		System.out.print("▷ Você realmente quer reiniciar o jogo? (1 - sim, `Qualquer coisa` - não): ");
                        opcao = entrada.next();
                        
                        if(opcao.equals("1")) partida.iniciarPartida();
                    } else if(opcao.equals("5")) {
                		System.out.print("▷ Você realmente quer finalizar a partida? (1 - sim, `Qualquer coisa` - não): ");
                        opcao = entrada.next();

                        if(opcao.equals("1")) partida.encerrarPartida();
                    } else {
                        opcao = "0";
                        pedirInserirNovamente();
                    }
            	}
            } else {
            	imprimirTituloInicio();
    			opcoes();
    			System.out.print(mensagemSolicitacao);
    			resetarMensagens();
                opcao = entrada.next();
                
                if(opcao.equals("1")) {
                	partida.iniciarPartida();
                } else if(opcao.equals("2")) {
            		System.out.print("▷ Você realmente quer finalizar o jogo? (1 - sim, `Qualquer coisa` - não): ");
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
		menu();
	}

}