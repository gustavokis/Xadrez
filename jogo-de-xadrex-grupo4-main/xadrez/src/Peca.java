public abstract class Peca {
    private String cor;
    private boolean capturada = false;

    // construtor
    public Peca(String cor) {
        this.cor = cor;
    }

    // getters e setters
    public boolean getCapturada() {
        return capturada;
    }

    public void setCapturada() {
        this.capturada = true;
    }

    public String getCor() {
        return this.cor;
    }

    // cria strings para aparecer no tabuleiro qual a peça
    public abstract String desenho();

    // verifica se o movimento de cada peça é permitido
    public abstract boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD);

    // printa todas as casas que a peça passou pelo caminho
    public abstract String caminho(int linhaO, char colunaO, int linhaD, char colunaD);
}
