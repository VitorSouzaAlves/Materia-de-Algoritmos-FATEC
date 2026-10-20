import java.util.Scanner;

static Scanner scanner = new Scanner(System.in);
public static void main() {
    byte x;

    do {
        System.out.print("""
                Digite o número indicado para realizar uma das opções a seguir:
                
                1 - Verificar idade para campeonato de atletismo
                2 - Cálculo de multa por excesso de velocidade
                3 - Simulador de caixa eletrônico
                0 - Sair
                """);
        x = scanner.nextByte();

        switch (x){
            case 0:
                System.out.println("Saindo...");
                break;
            case 1:
                ex01();
                break;
            case 2:
                ex02();
                break;
            case 3:
                ex03();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }while (x != 0);
}

private static void ex01(){
    System.out.print("Digite a idade: ");
    int idade = scanner.nextInt();

    if (idade >= 0 && idade <= 5){
        System.out.println("Não pode competir");
    } else if (idade >= 6 && idade <= 8) {
        System.out.println("Pré-Mirim");
    } else if (idade >= 9 && idade <= 11) {
        System.out.println("Mirim");
    } else if (idade >= 12 && idade <= 14) {
        System.out.println("Infantil");
    } else if (idade >= 15 && idade <= 17) {
        System.out.println("Juvenil");
    } else if (idade >= 18 && idade <= 39) {
        System.out.println("Adulto");
    } else if (idade >= 40 && idade <= 49) {
        System.out.println("Master 1");
    } else if (idade >= 50 && idade <= 59) {
        System.out.println("Master 2");
    }else if (idade >= 60){
        System.out.println("Master 3");
    }else {
        System.out.println("Idade inválida");
    }
}

private static void ex02(){
    int veloMax, veloRegistrada, valorMulta;
    float percentualAcima;

    System.out.print("Digite o valor da multa (R$): ");
    valorMulta = scanner.nextInt();
    System.out.print("Digite a velocidade máxima da via (km/h): ");
    veloMax = scanner.nextInt();
    System.out.print("Digite a velocidade registrada no radar (km/h): ");
    veloRegistrada = scanner.nextInt();

    percentualAcima = ((float)(veloRegistrada - veloMax)/veloMax)*100;

    if (veloRegistrada <= veloMax){
        System.out.println("Velocidade dentro do limite. Logo, não paga multa.");
        return;
    }
    else if (percentualAcima > 5 && percentualAcima <= 10) {
        valorMulta += 100;
    } else if (percentualAcima <= 20) {
        valorMulta += 200;
    } else if (percentualAcima <= 30) {
        valorMulta += 300;
    } else if (percentualAcima > 30) {
        valorMulta += 500;
    }

    System.out.printf("""
                A velocidade máxima da via é de: %dkm/h
                A velocidade registrada foi de: %dkm/h
                O excesso de velocidade foi de: %.2f%%
                Valor da multa a ser paga: R$ %d
           """, veloMax, veloRegistrada, percentualAcima, valorMulta);
}

private static void ex03(){
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

        switch (indice){
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

                if (valorOperacao > saldo){
                    System.out.println("Saldo insuficiente para realizar o saque.");
                }else {
                    saldo -= valorOperacao;
                    System.out.println("Saque realizado com sucesso!");
                }
                break;
            default:
                System.out.println("Opção inválida");
        }
    }while (indice != 4);
}