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
            case 2:
                modaOuFrequencia();
                break;
            case 3:
                inversaoDeVetor();
                break;
            case 4:
                separaParEImpar();
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

private static void modaOuFrequencia(){
    int numero, ocorrencia = 0, valorVetor;
    String posicaoVetor = "";
    int[] vetorAleatorio = new int[8];
    Random geradorAleatorio = new Random();

    for (int i = 1; i <= 8; i++){
        vetorAleatorio[i-1] = geradorAleatorio.nextInt(11);
    }

    System.out.print("Digite um número de 0 a 10 para verificar a ocorrência dele no vetor: ");
    numero = scanner.nextInt();

    for (int i = 1; i <= 8; i++){
        valorVetor = vetorAleatorio[i-1];
        
        if (numero == valorVetor){
            ocorrencia++;
            posicaoVetor += i + " ";
        }
    }

    if (ocorrencia == 0){
        System.out.printf("O número digitado (%d) não apareceu nenhuma vez no vetor.\n", numero);
        System.out.print("Valores do vetor: ");
        for (int i = 1; i <= 8; i++){
            System.out.print(vetorAleatorio[i-1] + " ");
        }
        System.out.println("\n");
        return;
    }

    System.out.printf("""
            Número digitado: %d
            Ocorrências dentro do vetor: %d
            Posições em que apareceu no vetor: %s
            
            """, numero, ocorrencia, posicaoVetor
    );

    System.out.print("Valores do vetor: ");
    for (int i = 1; i <= 8; i++){
        System.out.print(vetorAleatorio[i-1] + " ");
    }
    System.out.println("\n");
}

private static void inversaoDeVetor(){
    int valorUm, valorDois;
    int[] vetorNumero = new int[6];

    for (int i = 1;  i <= 6; i++){
        System.out.printf("Digite o número que irá na %d° posição: ", i);
        vetorNumero[i-1] = scanner.nextInt();
    }

    for (int i = 1; i <= 3; i++){
        valorUm = vetorNumero[i-1];
        valorDois = vetorNumero[6-i];

        vetorNumero[6-i] = valorUm;
        vetorNumero[i-1] = valorDois;
    }

    System.out.print("\nVetor invertido: ");
    for (int i = 1; i <= 6; i++){
        System.out.printf("[%d]", vetorNumero[i-1]);
    }
    System.out.println("\n");
}

private static void separaParEImpar(){
    int[] vetorPrincipal = new int[10], vetorPar = new int[10], vetorImpar = new int[10];
    int contPar = 0, contImpar = 0;

    for (int i = 1; i <= 10; i++) {
        System.out.printf("Digite o %d° valor do vetor: ", i);
        vetorPrincipal[i-1] = scanner.nextInt();
    }

    for (int valorVetor : vetorPrincipal) {
        if (valorVetor % 2 == 0) {
            vetorPar[contPar] = valorVetor;
            contPar++;
        }else {
            vetorImpar[contImpar] = valorVetor;
            contImpar++;
        }
    }

    System.out.println("\nVetor par:");
    for (int i = 1; i <= contPar; i++) {
        System.out.printf("[%d]", vetorPar[i-1]);
    }

    System.out.println("\n\nVetor ímpar:");
    for (int i = 1; i <= contImpar; i++) {
        System.out.printf("[%d]", vetorImpar[i-1]);
    }

    System.out.println("\n");
}