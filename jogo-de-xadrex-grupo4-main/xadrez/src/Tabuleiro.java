public class Tabuleiro {

    private Casa[][] tabuleiro = new Casa[8][8];

    // construtor
    public Tabuleiro(Peca pecas[]) {
        inicializaTabuleiro(pecas);
    }

    // getter
    public Casa getCasa(int linha, char coluna) {
        return this.tabuleiro[8 - linha][coluna - 97];
    }

    // se estiver nos limites do tabuleiro retorna true
    public boolean noLimite(int linha, char coluna) {
        if (linha < 9 && linha > 0 && coluna < 'i' && coluna >= 'a') {
            return true;
        }
        return false;
    }

    // desenha o tabuleiro com suas peças
    public void desenho() {
        String[][] tabuleiro = new String[8][8];

        for (int i = 0; i < 8; i++) {
            System.out.printf("%d ", 8 - i);
            for (int j = 0; j < 8; j++) {
                if (this.tabuleiro[i][j].getPeca() != null) {
                    tabuleiro[i][j] = this.tabuleiro[i][j].getPeca().desenho();
                    System.out.printf(tabuleiro[i][j]);
                    if (j < 8)
                        System.out.printf("\t");
                } else {
                    tabuleiro[i][j] = " ";
                    System.out.printf(tabuleiro[i][j]);
                    System.out.printf("\t");
                }
            }
            System.out.printf("\n\n");
        }
        System.out.printf("  a\tb\tc\td\te\tf\tg\th\n");
    }

    // inicia o tabuleiro com suas casas e posiciona as peças nas posições corretas
    private void inicializaTabuleiro(Peca pecas[]) {
        char coluna;
        int linha, nPeca = 0;
        for (int i = 0; i < 8; i++) {
            linha = 8 - i;
            for (int j = 0; j < 8; j++) {
                coluna = (char) (j + 'a');
                this.tabuleiro[i][j] = new Casa(linha, coluna);
                this.tabuleiro[i][j].CorDaCasa();
                if (i == 0 || i == 1 || i == 6 || i == 7) {
                    this.tabuleiro[i][j].setPeca(pecas[nPeca++]);
                }
            }
        }
    }
}