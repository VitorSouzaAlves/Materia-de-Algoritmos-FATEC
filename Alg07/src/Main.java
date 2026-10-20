import java.util.Scanner;

public static Scanner scanner = new Scanner(System.in);
public static void main() {
    byte escolha;

    do {
        System.out.print("""
                Digite o número indicado para realizar uma das opções a seguir:
                
                1 - Verificar valores da taboada de um número até 10
                2 - Chute de número gerado aleatoriamente
                3 - Simulador caixa eletrônico
                4 - Cálculo de exponencial
                5 - Cálculo de fatorial
                0 - Sair
                """);
        System.out.print("\nDigite a opção: ");
        escolha = scanner.nextByte();

        switch (escolha){
            case 0:
                System.out.println("Saindo...");
                break;
            case 1:
                verificarTaboada();
                break;
            case 2:
                chuteAteIgualdade();
                break;
            case 3:
                caixaEletronico();
                break;
            case 4:
                calculoExponencial();
                break;
            case 5:
                calculoFatorial();
                break;
            default:
                System.out.println("Opção inválida\n");
        }
    }while (escolha != 0);
}

private static void verificarTaboada (){
    int n1, i, resultado;

    System.out.print("\nDigite o número que deseja ver a taboada: ");
    n1 = scanner.nextInt();

    for (i = 1; i <= 10; i++){
        resultado = n1 * i;
        System.out.println("Multiplicado por " + i + ": " + resultado);
    }
    System.out.println();
}

private static void chuteAteIgualdade(){
    int numero = (int) (Math.random() * 101), chute;
    System.out.println("\nNúmero aleatório gerado!");
    System.out.print("Digite um número de 0 a 100: ");

    do {
        chute = scanner.nextInt();
        if (chute < numero){
            System.out.println("O chute é menor!");
        }else if (chute > numero){
            System.out.println("O chute é maior!");
        }
    }while (chute != numero);

    System.out.printf("Parabéns, você acertou o número sorteado: %d\n", numero);
}

private static void caixaEletronico() {
    byte indice;
    double saldo, valorOperacao;

    System.out.print("Digite o valor do primeiro depósito: ");
    valorOperacao = scanner.nextDouble();
    saldo = valorOperacao;

    do {
        System.out.print("""
                Digite o número indicado para realizar uma das ações a seguir:
                
                1 - Consultar saldo
                2 - Depositar
                3 - Sacar
                4 - Sair
                """);
        indice = scanner.nextByte();

        switch (indice) {
            case 1:
                System.out.printf("Saldo atual: R$ %.2f\n", saldo);
                break;
            case 2:
                System.out.print("Digite o valor a ser depositado: ");
                valorOperacao = scanner.nextDouble();
                saldo += valorOperacao;
                System.out.println("Depósito realizado com sucesso!");
                break;
            case 3:
                System.out.print("Digite o valor do saque: ");
                valorOperacao = scanner.nextDouble();

                if (valorOperacao > saldo) {
                    System.out.println("Saldo insuficiente para realizar o saque.");
                } else {
                    saldo -= valorOperacao;
                    System.out.println("Saque realizado com sucesso!");
                }
                break;
            default:
                System.out.println("Opção inválida");
        }
    } while (indice != 4);
}

private static void calculoExponencial(){
    int numero, expoente, resultado = 1;
    System.out.print("\nDigite o número que será a base: ");
    numero = scanner.nextInt();

    System.out.print("Agora digite o número que será o expoente: ");
    expoente = scanner.nextInt();

    for (int i = 0; i < expoente; i++){
        resultado = resultado * numero;
    }
    System.out.printf("O valor do exponencial é: %d\n\n", resultado);
}

private static void calculoFatorial(){
    int numero, resultado = 1;
    System.out.print("\nDigite o número que deseja saber o fatorial: ");
    numero = scanner.nextInt();

    for (int i = 1; i <= numero; i++){
        resultado = resultado * i;
    }

    System.out.printf("O fatorial de %d é %d\n\n", numero, resultado);
}