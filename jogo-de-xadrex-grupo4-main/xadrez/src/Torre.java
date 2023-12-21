public class Torre extends Peca {
    public Torre(String cor) {
        super(cor);
    }

    @Override
    public String desenho() {
        if ("preto".equals(this.getCor())) {
            return "Tp";
        }
        return "Tb";
    }

    @Override
    public boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
        int movColuna = colunaD - colunaO;
        int movLinha = linhaD - linhaO;
        if (movColuna != 0 && movLinha == 0) {
            return true;
        }
        if (movColuna == 0 && movLinha != 0) {
            return true;
        }
        return false;
    }

    @Override
    public String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
        int movLinha = linhaD - linhaO;
        int movColuna = colunaD - colunaO;
        if (movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            if (movColuna != 0 && movLinha == 0) {
                if (movColuna < 0) {
                    movColuna = movColuna * (-1);
                    String caminho1 = String.valueOf(linhaO) + colunaO;
                    for (int i = 0; i < movColuna; i++) {
                        colunaO = (char) (colunaO - 1);
                        caminho1 = caminho1 + String.valueOf(linhaO) + colunaO;
                    }
                    return caminho1;
                }
                String caminho1 = String.valueOf(linhaO) + colunaO;
                for (int i = 0; i < movColuna; i++) {
                    colunaO = (char) (colunaO + 1);
                    caminho1 = caminho1 + String.valueOf(linhaO) + colunaO;
                }
                return caminho1;
            }
            if (movColuna == 0 && movLinha != 0) {
                if (movLinha < 0) {
                    movLinha = movLinha * (-1);
                    String caminho2 = "";
                    for (int i = 0; i < movLinha; i++) {
                        caminho2 = caminho2 + String.valueOf(linhaO - i) + (colunaO);
                    }
                    return caminho2;
                }
                String caminho2 = "";
                for (int i = 0; i < movLinha; i++) {
                    caminho2 = caminho2 + String.valueOf(linhaO + i) + (colunaO);
                }
                return caminho2;
            }
        }

        return "";

    }
}