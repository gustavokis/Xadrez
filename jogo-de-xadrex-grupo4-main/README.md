# Projetos de POO - 2023 - Jogo de xadrez

Os 2 projetos de POO se referem à implementação de um jogo de xadrez para dois jogadores humanos. Cada projeto se refere ao desenvolvimento de um conjunto de características do jogo. As regras básicas do jogo de xadrez podem ser obtidas em: https://pt.wikibooks.org/wiki/Xadrez/Regras. O diagrama de classes simplificado a seguir representa um conjunto mínimo de classes e relacionamentos entre classes que devem ser considerados ao implementar o jogo.

![image](https://github.com/UFSCar-Ciencia-da-Computacao/ProjetoPratico-Xadrez/assets/70561321/fb8c2beb-9517-4e82-bbd7-56f7b88d82c9)


A versão final dos dois projetos será entregue no dia 25/08, até as 13:00, com tolerância de 10 minutos. A partir das 13:00 serão feitas entrevistas em que cada grupo deverá estar pronto para mostrar o funcionamento do projeto, bem como os códigos e relatórios.  Horários serão agendados pelos grupos oportunamente. P1 terá um ponto de checagem entre 21/07 e 02/08, em que as tarefas do P1 já devem estar em grande parte concluídas. Cada grupo deve agendar um horário com a professora, presencialmente, para mostrar o andamento do projeto (sem isso o grupo não terá a nota de P1). Deverá também ser elaborado um relatório contemplando elementos dos dois projetos.

## Instruções gerais:

  - Desenvolvimento: deve ser feito em grupos de 4 alunos. Um ou dois grupos com pequenas variações são admissíveis, mas não serão permitidos mais do que 12 grupos.
  - Os grupos devem ser anotados na planilha disponibilizada imediatamente.
    - https://docs.google.com/spreadsheets/d/1jWRiRLbzO6hpa5IGphy6ZwAYwcbRD2uw7mGK1b8pRi0/edit#gid=632488861 
  - A entrega será feita pelo Google Classroom por apenas um dos integrantes do grupo e pelo gitHub Classroom. 
  - Todos os componentes do projeto devem ser feitos em conjunto pelos membros do grupo.
  - O que e como entregar: o relatório (em formato .pdf) e os códigos-fontes (todos os arquivos .java das classe do jogo e da classe Teste) devem ser compactados em um arquivo .zip, nomeado com o nome completo dos integrantes do grupo na forma 
    - <nome1><nome2><nome3><nome4>.zip. O projeto deverá também ser submetido no gitHub Classrom, cujo link será divulgado oportunamente.
  - **Lembrete:** Cópia ou implementação por terceiros implica em 0 de nota final da disciplina. Cuidado ao compartilhar códigos com os colegas. A colaboração e ajuda entre todos é muito importante, mas não compartilhem código. 

## Relatório

O relatório deve ser elaborado desde o P1. Para avaliação serão consideradas a organização, completude e qualidade das informações. Deve conter os seguintes elementos, organizados da forma que o grupo achar mais apropriada:
  - descrição e resultados dos testes exaustivos;
  - descrição da forma de trabalho adotada pelo grupo; 
  - descrição clara dos pontos do programa que não foram resolvidos e de pontos que poderiam ser melhorados; 
  - descrição das condições que podem causar erro, que foram ou deveriam ter sido tratadas e evitadas com tratamento de exceção (incluir o que efetivamente tratou e o que identificou que deveria tratar mas não tratou);
  - uma nova versão do diagrama de classes contendo todos os atributos e métodos implementados no projeto (o detalhamento de cada classe pode ser fornecido separadamente do diagrama criado). Também deve conter pequenas modificações nos relacionamentos, se houver;
  - descrição detalhada de cada classe, considerando seus atributos e métodos, bem como a sua interface, exceções que lançam, etc; 
  - instruções para a compilação e uso do programa (como se fosse para um usuário leigo que fosse jogar); 
  - descrição do funcionamento da interface do programa (interface do jogo em si);
  - dificuldades do grupo e avaliação do que foi solicitado e não foi feito. Discutir também as limitações do programa. 

## Descrição e exigências para as classes

Nas descrições a seguir, considerar: 
  - **linhaO** e **linhaD** são as linhas de origem e destino de um movimento, podendo ter apenas valores entre 1 e 8
  - **colunaO** e **colunaD** são as colunas de origem e destino de um movimento, podendo ter apenas valores entre a e h

### Gerenciador
Classe que vai criar e disparar o jogo, permitindo ao usuário a escolha de iniciar um jogo do zero, carregar um jogo a partir de um arquivo texto, cujo nome seja fornecido pelo usuário e salvar um jogo após o encerramento ou interrupção de uma partida. Nenhum controle do jogo em si deve ser feito nessa classe. Essa classe é a que contém o main, mas estejam atentos para separar as funcionalidades da classe em métodos para uma melhor organização. O main deve ser o mais enxuto possível.

Os arquivos para registro dos jogos devem ter o seguinte formato:
```
<Nome do Jogador 1 - peças brancas>
<Nome do Jogador 2 - peças pretas>
<Jogada 1>
<Jogada 2>
<Jogada 3>
…
```

Cada jogada tem a linha e coluna da casa inicial da jogada e a linha e coluna da casa final, sem qualquer separação. Por exemplo:
```
1a3b
4c2h
3g7g
```

### Jogo

Essa classe é responsável pelo gerenciamento do jogo, controlando tudo o que acontece. Essa classe contém um tabuleiro, 2 jogadores e o conjunto de 32 peças disponíveis. O jogo sabe o estado em que se encontra a cada momento (por exemplo: início do jogo, xeque, xeque-mate). Sabe também de que jogador é a vez, controlando as jogadas, de quem é a vez, as checagens, etc, sendo a classe responsável por manter as informações na tela e solicitar ao jogador da vez as informações necessárias para a jogada ou interrupção do jogo. No início do jogo, também solicita a cada jogador o seu nome. Na tela, além do tabuleiro, o Jogo deve manter visível as peças de cada jogador que já foram capturadas, desenhadas do lado do tabuleiro correspondente ao jogador.

A cada jogada solicitada por um jogador, o Jogo é a classe que dispara a jogada checando se ela é válida,  atualizando o tabuleiro, a situação, o histórico de jogadas, a tela, a situação do jogo, das peças, etc, usando sempre as chamadas de métodos das outras classes que forem apropriadas.

Todas as jogadas efetivamente realizadas devem ser registradas em um histórico de jogadas que pode ser solicitado pelo Gerenciador para armazenamento em arquivo ou visualização das jogadas.

A classe Jogo deve ter ao menos os métodos:
  - ```boolean jogadaValida(linhaO, colunaO, linhaD, colunaD)```: verifica se a jogada é válida ou não
  - ```void realizarJogada(linhaO, colunaO, linhaD, colunaD)```: se a jogada é válida, atualiza o posicionamento das peças no tabuleiro, a situação do jogo, etc, e mostra na tela as informações apropriadas.
  - ```String registroJogo()```: deve retornar uma string com todos os dados relevantes do jogo para que ele possa ser retomado posteriormente (ver arquivo do Gerenciador).

### Jogador

Cada jogador tem um nome, um conjunto de peças de uma das cores possíveis e sabe quais peças suas ainda estão ativas no jogo. Essa classe é onde é feita a entrada de dados para o jogo em si.

Deve ter no mínimo os métodos:

  - ```String informaJogada()```: Solicita que o jogador digite a jogada que ele deseja (ou o código ‘parar” para interromper o jogo e retorna uma string com o que foi informado pelo usuário.
  - ```String pecasCapturadas()```: Retorna uma string com os desenhos das suas peças que foram capturadas (não estão mais ativas no jogo), separadas por espaço em branco. Por exemplo, se suas peças forem representadas por letras minúsculas, e um bispo e dois peões foram capturados, a string ficaria assim: “b p p”.

### Jogada
Uma jogada é criada a partir das informações do jogador que a está realizando, a posição inicial e posição final da jogada, mas deve manter o caminho com base nessas informações iniciais (veja o diagrama). Lembrar que cada peça é quem deve fornecer seu caminho (na forma de uma string) e identificar se o movimento é válido de acordo com sua forma de se movimentar. Uma vez criada, uma jogada não pode ser alterada.

Tem ao menos os seguintes métodos:
  - boolean ehValida(): checa se uma jogada é válida. Uma jogada ser válida depende do caminho, do jogador, do tabuleiroé válida se:
    - tem uma posição inicial e uma posição final dentro dos limites do tabuleiro
    - a peça que está na posição inicial é do jogador que está realizando o movimento
    - se a posição final está livre ou está ocupada por peça do oponente
    - se o caminho está livre, caso a peça não puder pular sobre as outras
    - se o movimento é válido para a peça que está na casa inicial
  - ```boolean ehXeque()```: verifica se a jogada levou a uma situação de xeque
  - ```boolean ehXequeMate()```: verifica se a jogada levou a uma situação de xeque mate

### Caminho
O caminho tem a sequência das casas e informa sobre a posição inicial, a posição final e a situação do caminho.

Tem ao menos os métodos:
  - ```boolean estaLivre()```: indica se todas as casas do caminho estão livres, exceto a inicial e a final.
  - ```Casa casaInicial()```: retorna a casa inicial do caminho
  - ```Casa casaFinal()```: retorna a casa final do caminho
    
### Casa

Cada casa tem uma cor (branco ou preto), uma linha (de 1 a 8) e uma coluna (de a a h). Cada casa pode estar livre ou ocupada por uma peça e deve saber que peça a ocupa. 

### Tabuleiro

Um tabuleiro contém 64 casas organizadas em 8 linhas e 8 colunas. Essa classe é responsável pela configuração inicial do tabuleiro, manutenção da configuração do tabuleiro a cada jogada,  pelas informações dos limites do tabuleiro, bem como pelo desenho do tabuleiro (com as peças nas posições ocupadas) na tela.

Deve ter ao menos os métodos:
  - ```boolean noLimite(linha, coluna)```: verifica se uma determinada posição está no limite do tabuleiro. Observação: dependendo dos tipos usados para linha e coluna, esse método pode ser dispensado.
  - ```String desenho()```: que vai retornar uma string que representa o desenho de todo o tabuleiro na tela, com as casas e as peças nos seus devidos lugares.

### Peças específicas
Cada tipo de peça específica tem uma classe própria: Rei, Dama, Cavalo, Bispo, Torre, Peão. Cada peça tem uma cor e é responsável pela representação que a peça terá na tela, pela checagem da adequação do movimento que o usuário deseja fazer em relação ao tipo específico de peça e pelo fornecimento do caminho que a peça realizaria. Cada peça também é responsável por manter a sua situação (se está capturada ou em jogo). Deve ter no mínimo os métodos:
  - ```String desenho()```: que vai retornar o elemento que representa a peça específica, que será desenhado na tela. 
  - boolean movimentoValido(linhaO, colunaO, linhaD, colunaD):   que vai verificar se o movimento que o usuário deseja fazer é adequado para aquele tipo específico de peça. Este método se preocupa apenas com a parte do movimento que se refere à peça, não se preocupando com seu posicionamento do tabuleiro ou se o caminho está livre para a peça se movimentar
  - ```String caminho(linhaO, colunaO, linhaD, colunaD)```: se o movimento for válido para a peça, retorna uma String que representa a sequência de casas pela qual a peça irá se mover ou “” (string vazia) caso contrário. Por exemplo, se a peça for o cavalo, a posição inicial for 4b e a final for 5d, o movimento é válido e o método retorna a string “4b5b5c5d”.

### Peça
Classe que representa as funcionalidades gerais comuns a todas as peças, e serve de base para todas as outras. A classe Peça deverá ser uma classe abstrata, contendo a interface para os métodos  desenho, movimentoValido e caminho., cuja implementação já deve constar nas classes específicas. Atributos e outros métodos que são comuns a todas as peças específicas devem ser transferidos para a classe base.  
Essa classe não deve ser implementada no P1. Mas após sua implementação, as demais classes devem lidar com as peças polimorficamente a partir de referências para a classe Peça.

## Observações e dicas:

Materiais úteis
  - Para strings:
    - https://www.devmedia.com.br/string-em-java-entendendo-e-utilizando-essa-classe/25503
    - https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
      
  - Para arquivos:
    - https://wiki.sj.ifsc.edu.br/index.php/Trabalhando_com_arquivos_texto_em_Java — exemplo simples de uso de arquivo texto, que reabre um arquivo para continuar escrevendo (observe que aqui não faremos isso, cada jogo deve estar em um arquivo separado, nomeado pelo usuário).


## Sobre o que será avaliado

  - Escolha dos construtores e métodos get e set apropriados (não incluir gets e sets desnecessários e, principalmente indevidos). 
  - Todas as checagens necessárias para garantir que somente valores válidos sejam armazenados nos atributos devem ser feitas, lembrando que a escolha dos tipos mais apropriados para representar cada atributo, parâmetro, retorno, etc é importante e pode ajudar. Para o P1, pode mostrar mensagem na tela ao identificar valor inválido, mas no final, o uso correto de exceções deve ser feito.
  - As classes e cada método devem ter suas responsabilidades bem delimitadas, evitando a presença de métodos que façam “tudo”.
  - Atenção ao correto encapsulamento 
    - uso dos especificadores de acesso adequados - deixar sem especificador  significa liberar acesso no pacote todo e isso não reflete o encapsulamento correto
    - o que retorna dos métodos ou passa como parâmetro
    - boa escolha da interface
  - O código deve estar bem documentado e seguir boas práticas de programação.
  - Acrescentar os atributos e métodos que forem necessários. O diagrama completo deve ser apresentado no relatório.
  - O trabalho pode ser feito considerando a interface mais simples que envolve o desenho do tabuleiro e das peças com caracteres simples.
    - Sugestão:
      - Peças: caracter inicial do nome da peça
      - Cores das peças diferenciadas por letras maiúsculas ou minúsculas
      - Posições vazias representadas por dois caracteres distintos
  - O grupo pode escolher investigar formas mais elaboradas para a interface, mas o funcionamento e o correto uso dos conceitos de orientação a objetos são os elementos relevantes para a nota.
  - Não é necessária a implementação dos movimentos especiais (roque, captura en passant ou promoção).

## Separação dos projetos e itens de avaliação

### Projeto 1

Para o P1, devem ser implementadas as classes destacadas no diagrama a seguir, substituindo a classe Peça pela classe Peão. Algumas funcionalidades que dependem da existência de todas as peças (por exemplo, checagem de xeque ou xeque mate) ou que serão usadas no Gerenciador não precisam ser implementadas ainda.

Implementar também uma classe Teste para criar objetos das classes implementadas e testar exaustivamente todas as funcionalidades já implementadas até o momento. Essa classe não precisa ter atributos e métodos além do main. Todos os métodos devem ser testados. Para os métodos privados, liberar temporariamente o acesso público para teste e imediatamente após garantir seu funcionamento, já retornar ao especificador correto, mantendo as chamadas comentadas na classe Teste. Todos os testes devem ser descritos no relatório. Para isso, descrever:
  - Objetivo do teste: descrever o que se pretende verificar com esse teste 
  - Objeto/classe: nome do objeto ou da classe para o qual o método foi chamado 
  - Método testado: classe e nome do método que o teste se refere: 
  - Valores dos parâmetros: valor que foi fornecido para cada parâmetro neste teste 
  - Valores de retorno: caso o método retorne um valor 
  - Tela: o que foi mostrado na tela, caso o método tenha saída de dados na tela 
  - Anotar se com o teste foi identificado algum erro e corrigido 

![image](https://github.com/UFSCar-Ciencia-da-Computacao/ProjetoPratico-Xadrez/assets/70561321/f4d3cefe-d211-4aa0-aa14-e2fb8804c274)

Componentes de avaliação do projeto 1 (P1), em que a marcação C significa parte de código e R de relatório: 
  - C: Implementação correta dos componentes básicos das classes, com uso adequado dos atributos e métodos; 
  - C: Implementação dos relacionamentos de composição, agregação e associação; 
  - C: Correto encapsulamento; 
  - C: Correto uso de construtores, gets, sets, atributos, métodos e sobrecarga; 
  - C: Testes exaustivos das classes básicas implementadas (classe Teste); 
  - C: Documentação e boas práticas. 
  - R: Descrição e resultados dos testes exaustivos; 
  - R: descrição da forma de trabalho adotada pelo grupo; 

### Projeto 2

Para o P2, o jogo  completo deve ser implementado e testado. Agora, a classe Peça deve ser utilizada e todos os métodos que interagem com ela devem ser modificados/complementados, incluindo a criação das outras classes específicas além do Peão. 

Por meio da classe Gerenciador, deve-se permitir a interrupção de uma partida e sua retomada em uma execução posterior. Para isso, ao iniciar e finalizar a execução, o sistema deve recuperar e armazenar em arquivo as configurações do jogo no momento da interrupção. 

Além das funcionalidades já destacadas, o programa deve ser robusto, não permitindo que erros e exceções tratáveis interrompam sua execução. Assim, para o P2, o máximo possível das potenciais situações em que o jogo de xadrez pode produzir um erro em tempo de execução devem ser identificadas, relatadas e tratadas adequadamente. Todas as condições que podem causar erro no programa devem ser identificadas, descritas no relatório e tratadas no seu programa utilizando o mecanismo de tratamento de exceções com os elementos apropriados em cada classe. Garanta que cada classe tenha muito bem definida sua responsabilidade na captura, no lançamento e no tratamento da exceção. Por exemplo, uma Casa não deve se comunicar com o usuário para solicitar nova entrada caso tenha recebido como parâmetro uma cor inválida, mas deve lançar a exceção para ser tratada no lugar apropriado. Estejam atentos para só utilizar tratamento de exceção quando apropriado. Por exemplo, checagem de movimento válido/inválido é processamento normal do programa e os métodos normais das classes devem ser utilizados apropriadamente para isso. Reveja as dicas para utilizar exceções estudadas no roteiro. Usar a hierarquia de exceções apropriadamente, também criando suas classes de exceção para especificar melhor os detalhes da exceção se apropriado.



Componentes de avaliação do projeto 2 (P2), em que a marcação C significa parte de código e R de relatório: 
  - C: uso correto dos conceitos de OO; 
  - C: separação correta das responsabilidades das classes e dos métodos em uma classe; 
  - C: Implementação dos relacionamentos de herança; 
  - C: Polimorfismo e classes abstratas; 
  - C: Uso apropriado de tratamento de exceções ; 
  - C: Entrada e saída em arquivos
  - C: completude e corretude das funcionalidades do jogo; 
  - C: qualidade da comunicação com o usuário (considerando interface mais simples). 
  - R: descrição clara dos pontos do programa que não foram resolvidos e de pontos que poderiam ser melhorados; 
  - R: descrição das condições de erro; 
  - R: versão completa do diagrama de classes;
  - R: descrição de todas as classes; 
  - R: instruções de compilação e uso do programa; 
  - R: Descrição da interface do programa (não das classes); 
  - R: Dificuldades do grupo e discussões

## Mais algumas dicas

  - Comecem pelas classes, atributos e métodos mais simples, testando-os e garantindo seu funcionamento antes de partir para as mais complexas
  - planejem e se organizem, estabelecendo a forma de trabalho antes de começar; 
  - Façam a documentação (interna e relatório) paralelamente à implementação, e sigam um padrão escolhido pelo grupo desde o início. Mas lembrem-se de checar tudo no final! 
  - Perguntem sempre 
