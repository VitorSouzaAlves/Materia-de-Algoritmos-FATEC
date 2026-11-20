import java.util.Scanner;

static Scanner scanner = new Scanner(System.in);

public static void main() {
    byte escolha;

    do {
        System.out.print("""
                \nDigite o número indicado para realizar uma das opções a seguir:
                
                1 - Rede de lojas
                2 - Estacionamento
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