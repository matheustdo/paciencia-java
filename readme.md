# Paciência
Esse jogo representa a primeira parte de um projeto que foi desenvolvido para a disciplina de Padrões e Frameworks (UEFS, 2021), que foi realizado a partir da linguagem de programação Java por Matheus Teles e Rafael Azevedo.

## Como o projeto implementa o Paciência

## Como jogar
Ao iniciar o jogo, a tela inicial é exibida, onde o jogador pode selecionar se irá iniciar uma partida (digitando *1*), ou se vai finalizar a aplicação (digitando *2*), como mostrado na imagem abaixo:

![Menu inicial](docs/inicio.png)

Agora, dentro da partida, o jogador tem a visão da mesa do jogo.
Aqui, ele pode visualizar treze pilhas, que são identificadas por números ao lado esquerdo.

![Tela da partida](docs/partida.png)

As cartas pretas são identificadas pelos parênteses em volta, exemplo:
- (A P)

As cartas vermelhas são identificadas pelos colchetes em volta, exemplo:
- [5 C]

Cada naipe é representado por uma letra, onde:	
- E => Espadas
- C => Copas
- P => Paus
- O => Ouros

Para vencer uma partida, o jogador deve preencher todas as _fundações_ seguindo as regras conhecidas do ***Paciência***, que serão melhor explicadas na respectiva seção.

As cinco opções de controle são descritas a seguir.

### Mover carta
O jogador pode mover carta ao digitar *1*.
Ao selecionar essa opção, ele deve escolher um número que identifique a pilha de origem da carta, e posteriormente, um número que identifique a pilha com o destino da carta.

As regras são:

- Do estoque (pilha *1*) a carta só pode ir para o descarte (pilha *2*);
- Do descarte (pilha *2*) a carta só pode ir para qualquer uma das pilhas de fundação (pilhas *3*-*6*) ou pilhas de fileiras (pilhas *7*-*13*);
- As cartas não podem ir de nenhuma pilha para o estoque. As únicas formas das cartas voltarem pro estoque é se ele estiver vazio e for solicitado que se mova cartas do estoque para o descarte ou se ele estiver vazio e for solicitado para exibir alguma carta (caso existam cartas no descarte).
- As cartas não podem voltar de uma fundação ou fileira para o descarte.
- As cartas das _fundações_ começam com um *Ás* e precisam seguir uma ordem ascendente do mesmo naipe.
- As cartas das _fundações_ podem ir para as _fileiras_, e o contrário também.
- As cartas das _fileiras_ precisam ser encaixadas seguindo uma ordem decrescente, alternando-se as cores dos naipes.
- Caso uma _fileira_ contenha uma pilha de cartas ordenadas viradas para cima, o jogador é perguntado se é desejado mover mais de uma carta de vez.
- Se uma _fileira_ estiver vazia, só é possível inserir uma carta nela se for um rei (carta *K*)

### Exibir carta
O jogador pode exibir cartas ao digitar *2*.
Ao selecionar essa opção, uma ou três cartas saem do _estoque_ e vão para o _descarte_.
Se o _estoque_ estiver vazio, o _descarte_ é esvaziado e todas as cartas vão para o _estoque_.

### Alterar o número de cartas a virar do estoque
O jogador pode configurar a quantidade de cartas a virar do estoque ao digitar *3*.
É possível selecionar se será desejado virar uma ou três cartas por vez.

### Reiniciar
O jogador pode reiniciar a partida ao inserir *4*.

### Finalizar
O jogador pode finalizar a partida e retornar ao menu principal ao digitar *5*.

## Modelo conceitual em UML

## Modelo de baixo nível em UML

## Padrões utilizados e padrões que poderiam ser utilizados

## Pontos fortes e fracos do projeto


## Créditos
Desenvolvido por Matheus Teles [@matheustdo](https://github.com/matheustdo) e Rafael Azevedo [@rrazvd](https://github.com/rrazvd).
