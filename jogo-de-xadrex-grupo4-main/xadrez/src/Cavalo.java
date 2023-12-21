public class Cavalo extends Peca {
    public Cavalo(String cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        if ("preto".equals(this.getCor())) {
            return "Cp";
        }
        return "Cb";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        int movColuna = colunaD - colunaO;
        int movLinha = linhaD - linhaO;
        if ((movLinha == 2 && movColuna == 1) || (movLinha == 2 && movColuna == -1)) {
            return true;
        }
        if ((movLinha == -2 && movColuna == 1) || (movLinha == -2 && movColuna == -1)) {
            return true;
        }
        if ((movLinha == 1 && movColuna == 2) || (movLinha == 1 && movColuna == -2)) {
            return true;
        }
        if ((movLinha == -1 && movColuna == 2) || (movLinha == -1 && movColuna == -2)) {
            return true;
        }
        return false;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        int movLinha = linhaD - linhaO;
        int movColuna = colunaD - colunaO;

        if (movimentoValido(linhaO, colunaO, linhaD, colunaD)) {

            if ((movLinha == 2 && movColuna == 1) || (movLinha == 2 && movColuna == -1)) {
                return String.valueOf(linhaO) + colunaO + String.valueOf(linhaO + 1) + colunaO
                        + String.valueOf(linhaO + 2) + colunaO + String.valueOf(linhaD) + colunaD;
            }
            if ((movLinha == -2 && movColuna == 1) || (movLinha == -2 && movColuna == -1)) {
                return String.valueOf(linhaO) + colunaO + String.valueOf(linhaO - 1) + colunaO
                        + String.valueOf(linhaO - 2) + colunaO + String.valueOf(linhaD) + colunaD;
            }
            if ((movLinha == 1 && movColuna == 2) || (movLinha == -1 && movColuna == 2)) {
                return String.valueOf(linhaO) + colunaO + String.valueOf(linhaO) + (char) (colunaO + 1)
                        + String.valueOf(linhaO) + (char) (colunaO + 2) + String.valueOf(linhaD) + colunaD;
            }
            if ((movLinha == 1 && movColuna == -2) || (movLinha == -1 && movColuna == -2)) {
                return String.valueOf(linhaO) + colunaO + String.valueOf(linhaO) + (char) (colunaO - 1)
                        + String.valueOf(linhaO) + (char) (colunaO - 2) + String.valueOf(linhaD) + colunaD;
            }
        }

        return "";

    }
}
