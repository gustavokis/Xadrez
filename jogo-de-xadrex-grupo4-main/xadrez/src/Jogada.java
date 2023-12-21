public class Jogada {

    private Jogador jogador;
    private Casa posicaoInicial;
    private Casa posicaoFinal;
    private Caminho caminho;
    private Peca[] pecasjogador;

    public Jogada(Jogador jogador, Casa posicaoInicial, Casa posicaoFinal) {
        this.jogador = jogador;
        this.posicaoInicial = posicaoInicial;
        this.posicaoFinal = posicaoFinal;
    }

    @Override
    public String toString() {
        return String.valueOf(posicaoInicial.getLinha()) + posicaoInicial.getColuna()
                + String.valueOf(posicaoFinal.getLinha()) + posicaoFinal.getColuna();
    }

    public boolean ehValida(Tabuleiro tabuleiro) {

        // verificar se a peça pertence ao jogador
        if (!pecaJogador(posicaoInicial.getPeca())) {
            return false;
        }
        // verificar se as posições inicial e final estão dentro dos limites do
        // tabuleiro
        if (!tabuleiro.noLimite(posicaoInicial.getLinha(), posicaoInicial.getColuna())
                || !tabuleiro.noLimite(posicaoFinal.getLinha(), posicaoFinal.getColuna())) {
            return false;
        }
        String caminhos = posicaoInicial.getPeca().caminho(posicaoInicial.getLinha(), posicaoInicial.getColuna(),
                posicaoFinal.getLinha(), posicaoFinal.getColuna());

        char[] posicoes = caminhos.toCharArray();
        Casa[] casas = new Casa[posicoes.length / 2];
        int j = 0;
        for (int i = 0; i < posicoes.length; i += 2) {
            casas[j] = tabuleiro.getCasa(Character.getNumericValue(posicoes[i]), posicoes[i + 1]);
            j++;
        }
        this.caminho = new Caminho(casas);
        // verificar se a casa final está livre ou ocupada por uma peça do oponente, se
        // estiver ocupada e a peça pertencer ao jogador, retorna falso
        if (caminho.casaFinal().getPeca() != null && pecaJogador(caminho.casaFinal().getPeca())) {
            return false;
        }
        // verificar se o movimento é válido para a peça inicial
        if (!caminho.casaInicial().getPeca().movimentoValido(caminho.casaInicial().getLinha(),
                posicaoInicial.getColuna(),
                posicaoFinal.getLinha(), posicaoFinal.getColuna())) {
            return false;
        }

        // checagem para movimentação do peão, se o movimento é válido e o movimento é
        // na diagonal, a checagem da casa final já foi feita
        if ("Pp".equals(caminho.casaInicial().getPeca().desenho())
                || "Pb".equals(caminho.casaInicial().getPeca().desenho())) {
            if (caminho.casaInicial().getPeca().movimentoValido(posicaoInicial.getLinha(), posicaoInicial.getColuna(),
                    posicaoFinal.getLinha(), posicaoFinal.getColuna())) {
                if (posicaoInicial.getColuna() != posicaoFinal.getColuna()) {
                    if (caminho.casaFinal().getPeca() != null && !pecaJogador(caminho.casaFinal().getPeca())) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        // verificar se o caminho está livre,
        // se a peca for cavalo retorna true mesmo se não estiver
        if (!caminho.estaLivre()) {
            if ("Cp".equals(caminho.casaInicial().getPeca().desenho())
                    || "Cb".equals(caminho.casaInicial().getPeca().desenho())) {
                return true;
            }
            return false;
        }

        return true;
    }

    // verifica se a peça na casa final pertence ao jogador
    public boolean pecaJogador(Peca peca) {
        pecasjogador = jogador.getPeca();
        if (!peca.getCor().equals(pecasjogador[1].getCor())) {
            return false;
        } else {
            return true;
        }
    }
}