import java.util.Scanner;

static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
    byte escolha;

    do {
        System.out.print("""
                Digite o número indicado para realizar uma das opções a seguir:
                
                1 - Verificar o maior e menor valor, além da média de um vetor com 10 posições
                2 - Verificação de frequência em um vetor de 8 posições
                3 - Inversão da posição de valores em um vetor de 6 posições
                4 - Separação de valores pares e ímpares de um vetor de 10 posições
                0 - Sair
                """);
        System.out.print("\nDigite a opção: ");
        escolha = scanner.nextByte();
        System.out.println();

        switch (escolha){
            case 0:
                System.out.println("Saindo...");
                break;
            case 1:
                maiorMenorMedia();
                break;
            default:
                System.out.println("Opção inválida\n");
        }
    }while (escolha != 0);
}

private static void maiorMenorMedia(){
    int[] vetorNumeros = new int[10];
    int maiorNumero = vetorNumeros[0], menorNumero = vetorNumeros[0];
    double mediaVetor = 0;

    for (int i = 1; i <= 10; i++){
        System.out.printf("Digite o %d° número que irá no vetor (10 números no total): ", i);
        vetorNumeros[i-1] = scanner.nextInt();
    }

    for (int posicaoVetor : vetorNumeros){
        if (posicaoVetor > maiorNumero) maiorNumero = posicaoVetor;
        if (posicaoVetor < menorNumero) menorNumero = posicaoVetor;
        mediaVetor += posicaoVetor;
    }

    mediaVetor = mediaVetor / 10.0;

    System.out.printf("""
            
            Maior valor digitado: %d
            Menor valor digitado: %d
            Media dos valores digitados: %.2f
            """, maiorNumero, menorNumero, mediaVetor
    );
}