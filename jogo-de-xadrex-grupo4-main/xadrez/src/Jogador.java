import java.util.Scanner;

public class Jogador {
    Scanner scanner = new Scanner(System.in);
    private String nomeJogador;
    private Peca[] pecas = new Peca[16];

    // construtor
    public Jogador(String nomeJogador, Peca[] pecas) {
        this.nomeJogador = nomeJogador;
        this.pecas = pecas;
    }

    // a jogada de determinado jogador é digitada
    public String informaJogada() throws ArrayIndexOutOfBoundsException {
        String jogada = scanner.nextLine();
        return jogada;
    }

    // roda o vetor de peças do jogador e retorna as capturadas
    public String pecasCapturadas() {
        StringBuilder capturadas = new StringBuilder();
        for (Peca peca : pecas) {
            if (peca.getCapturada()) {
                capturadas.append(peca.desenho()).append(" ");
            }
        }
        return capturadas.toString().trim();
    }

    // getters
    public String getNome() {
        return this.nomeJogador;
    }

    public Peca[] getPeca() {
        return this.pecas;
    }
}
