public class Peao extends Peca {

    public Peao(String cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        if ("preto".equals(this.getCor())) {
            return "Pp";
        }
        return "Pb";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        int movColuna = colunaD - colunaO;
        int movLinha = linhaD - linhaO;
        if (colunaD == colunaO) {
            if ("preto".equals(this.getCor())) {
                if ((movLinha == -1) || (movLinha == -2 && linhaO == 7))
                    return true;
            } else {
                if ((movLinha == 1) || (movLinha == 2 && linhaO == 2))
                    return true;
            }
        } else if (movColuna == 1 || movColuna == -1) {
            if ("preto".equals(this.getCor()) && movLinha == -1)
                return true;
            else if ("branco".equals(this.getCor()) && movLinha == 1)
                return true;
        }
        return false;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        int movLinha = linhaD - linhaO;

        if (movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            if (movLinha == -1 || movLinha == 1) {
                return String.valueOf(linhaO) + colunaO + String.valueOf(linhaD) + colunaD;
            } else {
                if ("preto".equals(this.getCor())) {
                    return String.valueOf(linhaO) + colunaO + String.valueOf(linhaO - 1) + colunaO
                            + String.valueOf(linhaD) + colunaD;
                }
                if ("branco".equals(this.getCor())) {
                    return String.valueOf(linhaO) + colunaO + String.valueOf(linhaO + 1) + colunaO
                            + String.valueOf(linhaD) + colunaD;
                }
            }
        }

        return "";

    }
}
