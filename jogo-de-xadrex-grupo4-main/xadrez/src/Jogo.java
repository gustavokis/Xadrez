import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {

    private Jogador[] jogador = new Jogador[2];
    private Tabuleiro tabuleiro;
    private Peca[] pecas = new Peca[32];
    private List<Jogada> jogadas = new ArrayList<>();

    // construtor para novo jogo
    public Jogo() {
    }

    // construtor usado para realizar as jogadas já feitas ao carregar um jogo.
    public Jogo(String nomejogador1, String nomejogador2, List<String> jogadas) {
        inicializaJogo(nomejogador1, nomejogador2);
        int i = 0;
        for (String jogada : jogadas) {
            char[] posicoes = jogada.toCharArray();
            this.jogadaValida(Character.getNumericValue(posicoes[0]), posicoes[1],
                    Character.getNumericValue(posicoes[2]), posicoes[3], jogador[i]);
            i = 1 - i;
            this.realizarJogada(Character.getNumericValue(posicoes[0]), posicoes[1],
                    Character.getNumericValue(posicoes[2]), posicoes[3]);
        }
        jogando(nomejogador1, nomejogador2, i);
    }

    /*
     * se a jogada for válida, realiza a jogada e retorna true, caso a última
     * casa do caminho possua uma peça do adversário ela será capturada.
     */
    public boolean jogadaValida(int linhaO, char colunaO, int linhaD, char colunaD, Jogador jogador) {
        Jogada jogada = new Jogada(jogador, tabuleiro.getCasa(linhaO, colunaO), tabuleiro.getCasa(linhaD, colunaD));
        if (jogada.ehValida(tabuleiro)) {
            if (tabuleiro.getCasa(linhaD, colunaD).getPeca() != null
                    && !tabuleiro.getCasa(linhaD, colunaD).getPeca().getCor().equals(jogador.getPeca()[0].getCor())) {
                jogadas.add(jogada);
                capturar(linhaD, colunaD);
                return true;
            }
            jogadas.add(jogada);
            return true;
        }
        return false;
    }

    // adiciona a peça na casa final e deixa a casa inicial vazia.
    public void realizarJogada(int linhaO, char colunaO, int linhaD, char colunaD) {
        tabuleiro.getCasa(linhaD, colunaD).setPeca(tabuleiro.getCasa(linhaO, colunaO).getPeca());
        tabuleiro.getCasa(linhaO, colunaO).setPeca(null);
    }

    // captura a peça na casa final
    private void capturar(int linhaD, char colunaD) {
        tabuleiro.getCasa(linhaD, colunaD).getPeca().setCapturada();
    }

    // salva os jogadores com suas cores e as jogadas realizadas no jogo
    public String registroJogo() {
        String jogadasString = "";
        for (Jogada jogada : jogadas) {
            jogadasString += jogada.toString() + "\n";
        }
        return jogador[0].getNome() + " - pecas brancas\n" + jogador[1].getNome() + " - pecas pretas\n" + jogadasString;
    }

    // recebe o nome dos jogadores, inicializa as peças no tabuleiro e inicia o jogo
    public void comecarJogo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("digite o seu nome Jogador1:");
        String jogador1 = scan.nextLine();
        System.out.println("digite o seu nome Jogador2:");
        String jogador2 = scan.nextLine();
        inicializaJogo(jogador1, jogador2);
        jogando(jogador1, jogador2, 0);
    }

    // é o funcionamento do jogo
    public void jogando(String jogador1, String jogador2, int i) {
        while (true) {
            String jogada;
            char[] posicoes;
            // jogada das peças brancas
            if (i == 0) {
                // imprime as peças capturadas e o tabuleiro
                System.out.println("Pecas capturadas de " + jogador2 + ": " + jogador[1].pecasCapturadas());
                tabuleiro.desenho();
                System.out.println("Pecas capturadas de " + jogador1 + ": " + jogador[0].pecasCapturadas());
                System.out.printf("\n\n");
                System.out.println(jogador1 + ": Informe sua jogada com linha sendo de 1 a 8 e coluna de 'a' a 'h'\n");
                System.out.println("Escreva, por exemplo, '2a3a' para fazer a peca andar uma casa para frente\n ");
                System.out.println(
                        "Caso queira parar o jogo e salvar para continuar em outro momento, digite '0q0q' \n ");

                try {
                    // o jogador informa a jogada
                    jogada = jogador[0].informaJogada();

                    // se for digitado "0q0q" o jogo será salvo
                    if ("0q0q".equals(jogada)) {
                        break;
                    }
                    posicoes = jogada.toCharArray();

                    // se a jogada for inválida entra no loop e permanece até realizar uma válida
                    while (!this.jogadaValida(Character.getNumericValue(posicoes[0]), posicoes[1],
                            Character.getNumericValue(posicoes[2]), posicoes[3], jogador[0])) {
                        System.out.printf("Jogada invalida, informe outra jogada.\n");
                        System.out.println(
                                "Caso queira parar o jogo e salvar para continuar em outro momento, digite '0q0q' \n ");
                        jogada = jogador[0].informaJogada();
                        if ("0q0q".equals(jogada)) {
                            break;
                        }
                        posicoes = jogada.toCharArray();
                        System.out
                                .println(tabuleiro.getCasa(Character.getNumericValue(posicoes[0]), posicoes[1])
                                        .getLinha());
                    }
                    // realiza a jogada no tabuleiro
                    realizarJogada(Character.getNumericValue(posicoes[0]), posicoes[1],
                            Character.getNumericValue(posicoes[2]), posicoes[3]);
                    i = 1;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Jogada invalida, informe outra jogada.");
                } catch (NullPointerException e) {
                    System.out.println("Jogada invalida, informe outra jogada.");
                }
                // jogada das peças pretas
            } else {
                System.out.println("Pecas capturadas de " + jogador2 + ": " + jogador[1].pecasCapturadas());
                tabuleiro.desenho();
                System.out.println("Pecas capturadas de " + jogador1 + ": " + jogador[0].pecasCapturadas());
                System.out.printf("\n\n");
                System.out.println(jogador2 + ": Informe sua jogada com linha sendo de 1 a 8 e coluna de 'a' a 'h'\n");
                System.out.println("Escreva, por exemplo, '2a3a' para fazer a peca andar uma casa para frente\n ");
                System.out.println(
                        "Caso queira parar o jogo e salvar para continuar em outro momento, digite '0q0q' \n ");

                try {
                    jogada = jogador[1].informaJogada();
                    if ("0q0q".equals(jogada)) {
                        break;
                    }
                    posicoes = jogada.toCharArray();
                    while (!this.jogadaValida(Character.getNumericValue(posicoes[0]), posicoes[1],
                            Character.getNumericValue(posicoes[2]), posicoes[3], jogador[1])) {
                        System.out.printf("Jogada invalida, informe outra jogada.\n");
                        System.out.println(
                                "Caso queira parar o jogo e salvar para continuar em outro momento, digite '0q0q' \n ");
                        jogada = jogador[1].informaJogada();
                        if ("0q0q".equals(jogada)) {
                            break;
                        }
                        posicoes = jogada.toCharArray();
                    }
                    realizarJogada(Character.getNumericValue(posicoes[0]), posicoes[1],
                            Character.getNumericValue(posicoes[2]), posicoes[3]);
                    i = 0;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Jogada invalida, informe outra jogada.");
                } catch (NullPointerException e) {
                    System.out.println("Jogada invalida, informe outra jogada.");
                }
            }
        }
    }

    // cria as 32 peças e os 2 jogadores, com as cores definidas
    public void inicializaJogo(String nomePrimeiroJogador, String nomeSegundoJogador) {
        Peca brancas[] = new Peca[16];
        Peca pretas[] = new Peca[16];
        this.pecas[0] = new Torre("preto");
        this.pecas[1] = new Cavalo("preto");
        this.pecas[2] = new Bispo("preto");
        this.pecas[3] = new Dama("preto");
        this.pecas[4] = new Rei("preto");
        this.pecas[5] = new Bispo("preto");
        this.pecas[6] = new Cavalo("preto");
        this.pecas[7] = new Torre("preto");
        for (int i = 8; i < 16; i++) {
            this.pecas[i] = new Peao("preto");
        }
        for (int i = 16; i < 24; i++) {
            this.pecas[i] = new Peao("branco");
        }
        this.pecas[24] = new Torre("branco");
        this.pecas[25] = new Cavalo("branco");
        this.pecas[26] = new Bispo("branco");
        this.pecas[27] = new Dama("branco");
        this.pecas[28] = new Rei("branco");
        this.pecas[29] = new Bispo("branco");
        this.pecas[30] = new Cavalo("branco");
        this.pecas[31] = new Torre("branco");
        this.tabuleiro = new Tabuleiro(pecas);

        for (int i = 0; i < 16; i++)
            pretas[i] = this.pecas[i];
        this.jogador[1] = new Jogador(nomeSegundoJogador, pretas);

        for (int i = 16; i < 32; i++)
            brancas[i - 16] = this.pecas[i];
        this.jogador[0] = new Jogador(nomePrimeiroJogador, brancas);

    }
}