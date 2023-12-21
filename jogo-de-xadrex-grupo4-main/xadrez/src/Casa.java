public class Casa {
    private int linha;
    private char coluna;
    private String cor;
    private Peca peca;

    // construtor
    public Casa(int linha, char coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.CorDaCasa();
        this.peca = null;
    }

    // getters e setter
    public String getCor() {
        return cor;
    }

    public int getLinha() {
        return linha;
    }

    public char getColuna() {
        return coluna;
    }

    public Peca getPeca() {
        return this.peca;
    }

    public void setPeca(Peca p) {
        this.peca = p;
    }

    // linhas ímpares: casas pares são brancas e ímpares pretas
    // linhas pares: casas pares são pretas e ímpares brancas
    public void CorDaCasa() {
        if (this.getLinha() % 2 == 1 && this.getColuna() % 2 == 1) {
            this.cor = "preto";
        } else if (this.getLinha() % 2 == 1 && this.getColuna() % 2 == 0) {
            this.cor = "branco";
        } else if (this.getLinha() % 2 == 0 && this.getColuna() % 2 == 0) {
            this.cor = "preto";
        } else if (this.getLinha() % 2 == 0 && this.getColuna() % 2 == 1) {
            this.cor = "branco";
        }
    }
}
