import java.util.Scanner;

static Scanner scanner = new Scanner(System.in);

public static void main() {
    byte escolha;

    do {
        System.out.print("""
                \nDigite o número indicado para realizar uma das opções a seguir:
                
                1 - Lista de Candidatos para Vestibular
                2 - Campeonato de Futebol
                0 - Sair
                """);
        System.out.print("\nDigite a opção: ");
        escolha = scanner.nextByte();
        scanner.nextLine();

        switch (escolha) {
            case 0:
                System.out.print("Saindo...");
                break;
            case 1:
                candidatosVestibular();
                break;
            case 2:
                campeoanatoFutebol();
                break;
            default:
                System.out.println("Opção inválida");
        }
    } while (escolha != 0);
}

private static void candidatosVestibular() {
    String[][] candidatos = new String[10][3];
    String[] cursos = {"ADS", "GECOM", "Eventos", "RH"};
    int[] qtdPorCurso = new int[4];

    String cpf;
    int idade;
    byte indiceCurso;

    int totalCandidatos = 0;
    int somaIdades = 0;

    System.out.println("\n-- Cadastro de Candidatos --");

    while (totalCandidatos < 10) {
        System.out.print("Digite o CPF do candidato: ");
        cpf = scanner.nextLine();

        boolean existe = false;
        for (String[] linha : candidatos) {
            if (linha[0] != null && linha[0].equals(cpf)) {
                existe = true;
                break;
            }
        }

        if (existe) {
            System.out.println("CPF já cadastrado, registro não inserido\n");
            continue;
        }

        System.out.print("Digite a idade do candidato: ");
        idade = Integer.parseInt(scanner.nextLine());

        System.out.print("""
                
                -- Índice do Curso  --
                
                1 - ADS
                2 - GECOM
                3 - Eventos
                4 - RH
                
                Digite o índice: """
        );
        indiceCurso = Byte.parseByte(scanner.nextLine());

        candidatos[totalCandidatos][0] = cpf;
        candidatos[totalCandidatos][1] = String.valueOf(idade);
        candidatos[totalCandidatos][2] = String.valueOf(indiceCurso);

        qtdPorCurso[indiceCurso - 1] ++;
        somaIdades += idade;
        totalCandidatos++;

        System.out.println("\nRegistro finalizado com sucesso!\n");
    }

    System.out.println("\n-- Inscritos por curso --");
    for (int i = 0; i < cursos.length; i++) {
        System.out.println(cursos[i] + ": " + qtdPorCurso[i]);
    }

    int mediaIdade = somaIdades/10;
    System.out.printf("\nA media de idade dos candidatos é %d anos.\n", mediaIdade);

    System.out.println("\nRetornando ao menu principal...");
}

private static void campeoanatoFutebol(){
    int[][] tabelaCampeonato = new int[10][4];
    int vitorias;
    int empates;
    int derrotas;

    System.out.println("\n-- Times do Campeonato --\n");

    for (int i = 0; i < 10; i++) {
        System.out.printf("Digite o total de vitórias do %dº time: ", i+1);
        vitorias = scanner.nextInt();
        tabelaCampeonato[i][0] = vitorias;

        System.out.print("Digite o total de empates do time: ");
        empates = scanner.nextInt();
        tabelaCampeonato[i][1] = empates;

        System.out.print("Digite o total de derrotas do time: ");
        derrotas = scanner.nextInt();
        tabelaCampeonato[i][2] = derrotas;

        tabelaCampeonato[i][3] = (vitorias * 3) + empates;
        System.out.println();
    }

    System.out.println("\n-- Tabelão --");
    System.out.printf("%-8s %-10s %-10s %-10s %-8s%n", "Time", "Vitórias", "Empates", "Derrotas", "Pontos");

    for (int i = 0; i < tabelaCampeonato.length; i++) {
        System.out.printf("%-8d %-10d %-10d %-10d %-8d%n",
                i + 1,
                tabelaCampeonato[i][0],
                tabelaCampeonato[i][1],
                tabelaCampeonato[i][2],
                tabelaCampeonato[i][3]
        );
    }

    System.out.println("\n-- Três primeiros colocados --");

    boolean[] jaEscolhido = new boolean[tabelaCampeonato.length];

    for (int posicao = 1; posicao <= 3; posicao++) {
        int melhor = -1;

        for (int i = 0; i < tabelaCampeonato.length; i++) {
            if (!jaEscolhido[i] && (melhor == -1 || tabelaCampeonato[i][3] > tabelaCampeonato[melhor][3])) {
                melhor = i;
            }
        }

        jaEscolhido[melhor] = true;

        System.out.printf("%dº lugar: Time %d - %d pontos%n", posicao, melhor + 1, tabelaCampeonato[melhor][3]);
    }
}