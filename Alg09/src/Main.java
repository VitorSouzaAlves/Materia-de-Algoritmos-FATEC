import java.util.Scanner;

static Scanner scanner = new Scanner(System.in);

public static void main(){
    byte escolha;

    do {
        System.out.print("""
                \nDigite o número indicado para realizar uma das opções a seguir:
                
                1 - Matriz de temperaturas
                2 - Percentuais dos tipos de triãngulos em uma matriz
                0 - Sair
                """);
        System.out.print("\nDigite a opção: ");
        escolha = scanner.nextByte();
        System.out.println();

        switch (escolha){
            case 0:
                System.out.print("Saindo...");
                break;
            case 1:
                matrizTemperatura();
                break;
            case 2:
                verificarTipoTriangulo();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }while (escolha != 0);
}

private static void matrizTemperatura(){
    float[][] tempDia = new float[10][3];

    System.out.println("-- Digite os valores de temperatura para alimentar a matriz --");

    for (int i = 0; i < 10; i++){
        System.out.printf("\nDigite a temperatura mínima do %dº dia: ", i+1);
        tempDia[i][0] = scanner.nextFloat();

        System.out.print("Digite a temperatura máxima: ");
        tempDia[i][1] = scanner.nextFloat();

        tempDia[i][2] = tempDia[i][1] - tempDia[i][0];
    }

    byte escolha;

    do {
        System.out.print("""
                \nDigite o número indicado para realizar uma das opções a seguir:
                
                1 - Verificar a temperatura mínima de cada dias
                2 - Verificar a temperatura máxima de cada dias
                3 - Verificar a maior variação de temperatura entre os dias
                0 - Sair
                """);
        System.out.print("\nDigite a opção: ");
        escolha = scanner.nextByte();
        System.out.println();

        switch (escolha){
            case 0:
                System.out.println("Voltando ao menu inicial...");
                break;
            case 1:
                System.out.println("Valores dos dias 1 a 10 (Esquerda para direita)");
                for (int i = 0; i < 10 ; i++) {
                    System.out.printf("[%.1f°]", tempDia[i][0]);
                }
                System.out.println();
                break;
            case 2:
                System.out.println("Valores dos dias 1 a 10 (Esquerda para direita)\n");
                for (int i = 0; i < 10 ; i++) {
                    System.out.printf("[%.1f°]", tempDia[i][1]);
                }
                System.out.println();
                break;
            case 3:
                int dia = 0;
                float maiorVariacao = 0;

                for (int i = 0; i < 10; i++) {
                    if (tempDia[i][2] > maiorVariacao){
                        maiorVariacao = tempDia[i][2];
                        dia = i+1;
                    }
                }
                System.out.printf("A maior variação de temperatura foi no %dº dia: %.1f°\n", dia, maiorVariacao);
                break;
            default:
                System.out.println("Opção inválida\n");
        }
    }while (escolha != 0);
}

private static void verificarTipoTriangulo(){
    float[][] triangulos = new float[10][3];
    int qtdIsosceles = 0, qtdEquilatero = 0, qtdEscaleno = 0;
    float pIsosceles = 0, pEquilatero = 0, pEscaleno = 0;

    System.out.println("-- Digite os valores dos lados do triângulo para alimentar a matriz --");

    for (int i = 0; i < 10; i++){
        System.out.printf("\n-- %dº triângulo da Matriz --\n", i + 1);
        System.out.print("\nDigite o valor do 1º lado do triângulo: ");
        triangulos[i][0] = scanner.nextFloat();

        System.out.print("Digite o valor do 2º lado do triângulo: ");
        triangulos[i][1] = scanner.nextFloat();

        System.out.print("Digite o valor do 3º lado do triângulo: ");
        triangulos[i][2] = scanner.nextFloat();
    }

    for (int i = 0; i < 10; i++) {
        if (triangulos[i][0] != triangulos[i][1] && triangulos[i][0] != triangulos[i][2] && triangulos[i][1] != triangulos[i][2]){
            qtdEscaleno++;
        } else if (triangulos[i][0] == triangulos[i][1] && triangulos[i][0] == triangulos[i][2]) {
            qtdEquilatero++;
        } else {
            qtdIsosceles++;
        }
    }

    pIsosceles = ((float) qtdIsosceles/10 * 100);
    pEquilatero = ((float) qtdEquilatero/10 * 100);
    pEscaleno = ((float) qtdEscaleno/10 * 100);

    System.out.printf("""
            
            Percentuais de incidência de cada tipo de triângulo:
            
            Isósceles: %.2f%%
            Equilátero: %.2f%%
            Escaleno: %.2f%%
            
            """, pIsosceles, pEquilatero, pEscaleno
    );
}