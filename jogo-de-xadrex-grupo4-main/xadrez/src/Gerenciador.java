import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerenciador {
    // inicia novo jogo ou carrega jogo antigo
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Jogo jogo;
        System.out.println(
                "Se quiser carregar uma partida em andamento digite 0 ou digite 1 para iniciar uma nova partida.");
        String num = scanner.nextLine();
        while (!"0".equals(num) && !"1".equals(num)) {
            System.out.println(
                    "Opcao invalida. Digite 0 para carregar uma partida em andamento ou 1 para iniciar uma nova partida.");
            num = scanner.nextLine();
        }
        if ("0".equals(num)) {
            jogo = carregarJogo();
        } else {
            jogo = new Jogo();
            jogo.comecarJogo();
        }
        salvarJogo(jogo);
    }

    // escolhe nome para o arquivo, salva nome dos jogadores e jogadas realizadas.
    public static void salvarJogo(Jogo jogo) {
        Scanner s = new Scanner(System.in);
        String nomePartida;
        while (true) {
            System.out.printf("Para salvar a partida, digite um nome para o arquivo sem a extensao.\n");
            System.out.printf("Lembre-se que este sera o nome para voltar nessa partida, entao anote-o.\n");
            nomePartida = s.nextLine();
            try {
                File partida = new File(nomePartida + ".txt");
                if (!partida.exists()) { // se o nome de arquivo estiver livre
                    partida.createNewFile(); // cria o arquivo com esse nome
                    FileWriter fw = new FileWriter(partida);
                    fw.write(jogo.registroJogo());
                    fw.close();
                    break;
                } else {
                    System.out.println("Esse nome ja existe.");
                }
            } catch (IOException e) { // trata possíveis erros de arquivo, pedindo por outro nome
                System.out.println("Ocorreu um erro. Tente novamente com outro nome");
            }
        }
    }

    // se o nome para carregar for válido inicia o jogo de onde parou
    // caso contrário precisa digitar outro nome
    public static Jogo carregarJogo() throws FileNotFoundException, IOException {
        Scanner s = new Scanner(System.in);
        String nomePartida;
        System.out.println("Digite o nome da partida que deseja carregar.");
        nomePartida = s.nextLine();
        File partida = new File(nomePartida + ".txt");
        while (!partida.exists()) {
            System.out.println("Nome invalido. Digite novamente.");
            nomePartida = s.nextLine();
            partida = new File(nomePartida + ".txt");
        }
        if (partida.exists()) { // se o arquivo existe
            // cria o leitor
            FileReader fr = new FileReader(partida);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine(); // lê a próxima linha
            String[] nome = linha.split("-");
            String jogador1 = nome[0];
            linha = br.readLine(); // lê a próxima linha
            nome = linha.split("-");
            String jogador2 = nome[0];
            List<String> todasJogadas = new ArrayList<>();
            while (br.ready()) { // até acabar o arquivo
                todasJogadas.add(br.readLine()); // lê a próxima linha
            }
            Jogo jogo = new Jogo(jogador1, jogador2, todasJogadas);
            return jogo;
        }
        return null;
    }
}