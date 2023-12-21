public class Bispo extends Peca {
    public Bispo(String cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        if ("preto".equals(this.getCor())) {
            return "Bp";
        }
        return "Bb";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        int movColuna = colunaD - colunaO;
        int movLinha = linhaD - linhaO;
        if (movLinha == movColuna) {
            return true;
        }
        if ((movColuna + movLinha) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        int movLinha = linhaD - linhaO;
        int movColuna = colunaD - colunaO;
        if (movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            if (movLinha == movColuna) {
                if (movColuna < 0) {
                    movColuna = movColuna * (-1);
                    String bispocam1 = String.valueOf(linhaO) + colunaO;
                    for (int i = 0; i < movColuna; i++) {
                        linhaO--;
                        colunaO = (char) (colunaO - 1);
                        bispocam1 = bispocam1 + String.valueOf(linhaO) + colunaO;
                    }
                    return bispocam1;
                }
                String bispocam2 = String.valueOf(linhaO) + colunaO;
                for (int i = 0; i < movColuna; i++) {
                    linhaO++;
                    colunaO = (char) (colunaO + 1);
                    bispocam2 = bispocam2 + String.valueOf(linhaO) + colunaO;
                }
                return bispocam2;
            }
            if ((movColuna + movLinha) == 0) {
                if (movColuna < 0) {
                    String bispocam3 = String.valueOf(linhaO) + colunaO;
                    for (int i = 0; i < movLinha; i++) {
                        linhaO++;
                        colunaO = (char) (colunaO - 1);
                        bispocam3 = bispocam3 + String.valueOf(linhaO) + colunaO;
                    }
                    return bispocam3;
                }
                String bispocam4 = String.valueOf(linhaO) + colunaO;
                for (int i = 0; i < movColuna; i++) {
                    linhaO--;
                    colunaO = (char) (colunaO + 1);
                    bispocam4 = bispocam4 + String.valueOf(linhaO) + (colunaO);
                }
                return bispocam4;
            }
        }

        return "";

    }
}