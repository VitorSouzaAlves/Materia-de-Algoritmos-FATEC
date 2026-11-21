import java.util.Scanner;

static Scanner scanner = new Scanner(System.in);

public static void main() {
    byte escolha;

    do {
        System.out.print("""
                \nDigite o número indicado para realizar uma das opções a seguir:
                
                1 - Rede de lojas
                2 - Mapa de vagas
                3 - Empresa
                4 - Competição
                5 - Cinema
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
                redeLojas();
                break;
            case 2:
                estacionamento();
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                System.out.println("Opção inválida");
        }
    } while (escolha != 0);
}

private static void redeLojas() {
    int[][] vendas = new int[7][3];
    int[] totalVendasDia = new int[7];
    int[] totalProduto = new int[3];

    int totalVendasGeral;

    System.out.println("\n-- Rede de Lojas --\n");

    for (int i = 0; i < 7; i++) {
        for (int j = 0; j < 3; j++) {
            System.out.printf("Dia %d - vendas do produto %d: ", (i + 1), (j + 1));
            vendas[i][j] = scanner.nextInt();

            totalProduto[j] += vendas[i][j];
            totalVendasDia[i] += vendas[i][j];
        }
        System.out.println();
    }

    System.out.println("\n== Vendas da Semana ==");
    System.out.printf("| %-5s | %-9s | %-9s | %-9s | %-11s |%n",
            "Dia", "Produto 1", "Produto 2", "Produto 3", "Total Dia"
    );

    for (int i = 0; i < 7; i++) {
        System.out.printf("| %-5d | %-9d | %-9d | %-9d | %-11d |%n",
                i + 1, vendas[i][0], vendas[i][1], vendas[i][2], totalVendasDia[i]
        );
    }

    totalVendasGeral = totalProduto[0] + totalProduto[1] + totalProduto[2];

    System.out.println();
    System.out.printf("| %-5s | %-9d | %-9d | %-9d | %-11d |%n",
            "Total", totalProduto[0], totalProduto[1], totalProduto[2], totalVendasGeral
    );

    int indiceProduto = 0;
    for (int j = 1; j < 3; j++) {
        if (totalProduto[j] > totalProduto[indiceProduto]) {
            indiceProduto = j;
        }
    }

    int indiceDia = 0;
    for (int i = 1; i < 7; i++) {
        if (totalVendasDia[i] > totalVendasDia[indiceDia]) {
            indiceDia = i;
        }
    }

    System.out.printf("%nProduto com maior volume de vendas: Produto %d (%d unidades)%n",
            indiceProduto + 1, totalProduto[indiceProduto]
    );

    System.out.printf("Dia com maior volume de vendas: Dia %d (%d unidades)%n",
            indiceDia + 1, totalVendasDia[indiceDia]
    );
}

private static void estacionamento() {
    int[][] vagas = new int[5][10];
    Random random = new Random();

    byte vagasLivres = 0;
    byte vagasOcupadas = 0;

    System.out.println("\n-- Estacionamento --");

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 10; j++) {
            vagas[i][j] = random.nextInt(2);

            if (vagas[i][j] == 1){
                vagasOcupadas++;
            } else {
                vagasLivres++;
            }
        }
    }

    byte opcao;
    do {
        System.out.print("""
                \nDigite o número indicado para realizar uma das opções a seguir:
                
                1 - Exibir mapa de vagas
                2 - Ver total de vagas livres
                3 - Ver total de vagas ocupadas
                4 - Alterar o estado de uma vaga
                0 - Sair
                """);
        System.out.print("\nDigite a opção: ");
        opcao = scanner.nextByte();
        scanner.nextLine();

        switch (opcao) {
            case 0:
                System.out.print("Saindo...");
                break;
            case 1:
                int vagasOcupadasFileira = 0;
                int indiceFileira = 0;

                System.out.println("\nX = Ocupada; _ = Livre\n");
                System.out.println("    1 2 3 4 5 6 7 8 9 10");

                for (int i = 0; i < 5; i++) {
                    int soma = 0;
                    System.out.printf("F%d  ", i + 1);

                    for (int j = 0; j < 10; j++) {
                        System.out.print(vagas[i][j] == 1 ? "X " : "_ ");
                        soma += vagas[i][j];
                    }
                    if (soma > vagasOcupadasFileira){
                        vagasOcupadasFileira = soma;
                        indiceFileira = i+1;
                    }
                    System.out.println();
                }

                System.out.printf("\nFileira mais ocupada: %dª (%d vagas ocupadas\n)", indiceFileira, vagasOcupadasFileira);
                break;
            case 2:
                System.out.printf("Existem ao todo %d vagas livres.\n", vagasLivres);
                break;
            case 3:
                System.out.printf("Existem ao todo %d vagas ocupadas.\n", vagasOcupadas);
                break;
            case 4:
                System.out.print("Digite a fileira (1 a 5): ");
                byte fileira = (byte) (scanner.nextByte() - 1);
                System.out.print("Digite a vaga (1 a 10): ");
                byte vaga = (byte) (scanner.nextByte() - 1);

                if (fileira < 0 || fileira > 4 || vaga < 0 || vaga > 9) {
                    System.out.println("Posição inválida!");
                    return;
                }

                vagas[fileira][vaga] = 1 - vagas[fileira][vaga];
                System.out.println("Estado da vaga alterado.");
                break;
            default:
                System.out.println("Opção inválida");
        }
    } while (opcao != 0);
}