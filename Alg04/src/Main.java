import java.util.Scanner;

static Scanner scanner = new Scanner(System.in);

public static void main() {
    byte x;
    do {
        System.out.println("""
                    Digite uma opção:
                    1 - Exercício 03
                    2 - Exercício 04
                    0 - Finalizar sistema
                """);
        x = scanner.nextByte();
        switch (x) {
            case 0:
                System.out.println("Finalizando o sistema...");
                break;

            case 1:
                ex03();
                break;

            case 2:
                ex04();
                break;

            default:
                System.out.println("Opção inválida, digite novamente\n");
        }
    } while (x != 0);
}

private static void ex03() {
    float p1, p2, media;
    short qtdFaltas;

    System.out.print("Digite a quantidade de faltas do aluno: ");
    qtdFaltas = scanner.nextShort();

    if (qtdFaltas <= 20) {
        System.out.print("Digite a nota da p1: ");
        p1 = scanner.nextFloat();
        System.out.print("Agora, digite a nota da p2: ");
        p2 = scanner.nextFloat();

        media = (p1 + p2) / 2;

        System.out.println(
                media >= 6 ? "Aluno aprovado! Média: " + media
                        : "Aluno reprovado. Média: " + media + " nota necessária no exame >= 6"
        );
    } else {
        System.out.println("Aluno reprovado por estourar o limite de faltas.");
    }
}

private static void ex04(){
    float salario, margem;
    int emprestimo;

    System.out.print("Digite o seu salário: ");
    salario = scanner.nextFloat();
    System.out.print("Digite o valor da parcela do empréstimo:");
    emprestimo = scanner.nextInt();

    margem = (salario*30)/100;

    if (margem > emprestimo){
        System.out.println("O empréstimo foi concedido com sucesso!");
    }else {
        System.out.printf("A margem atual: R$ %.2f é menor que o valor da parcela solicitada." +
                "Portanto, o empréstimo não foi concedido.\n", margem);
    }
}