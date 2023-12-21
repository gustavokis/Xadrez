public class Caminho {

    private Casa casaInicial;
    private Casa casaFinal;
    private Casa[] caminho;

    // construtor
    public Caminho(Casa[] caminho) {
        this.casaInicial = caminho[0];
        this.casaFinal = caminho[caminho.length - 1];
        this.caminho = caminho;
    }

    // anda pelas casas do caminho, se tiver peça retorna falso
    boolean estaLivre() {
        for (int i = 1; i < caminho.length - 1; i++) {
            Casa casa = caminho[i];
            if (casa.getPeca() != null) {
                return false;
            }
        }
        return true;
    }

    public Casa casaInicial() {
        return casaInicial;
    }

    public Casa casaFinal() {
        return casaFinal;
    }
}
