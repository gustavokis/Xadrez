public class Rei extends Peca {
    public Rei(String cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        if ("preto".equals(this.getCor())) {
            return "Rp";
        }
        return "Rb";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        int movColuna = colunaD - colunaO;
        int movLinha = linhaD - linhaO;
        if ((movColuna >= -1 && movColuna < 2) && (movLinha >= -1 && movLinha < 2)) {
            return true;
        }
        return false;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {

        if (movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            return String.valueOf(linhaO) + colunaO + String.valueOf(linhaD) + colunaD;
        }
        return "";
    }
}
