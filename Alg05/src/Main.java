import java.util.Scanner;

static Scanner scanner = new Scanner(System.in);

public static void main() {
    byte x;
    System.out.print("Digite um número de 1 a 3 para realizar o exercício: ");
    x = scanner.nextByte();

    switch (x) {
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
            System.out.println("De 1 a 3 bobão!");
    }
}

private static void ex01() {
    float p1, p2, p3, media;
    short qtdFaltas;

    System.out.print("Digite a quantidade de faltas do aluno: ");
    qtdFaltas = scanner.nextShort();

    if (qtdFaltas > 20) {
        System.out.println("Aluno reprovado por estourar o limite de faltas.");
        return;
    } else {
        System.out.print("Digite a nota da p1: ");
        p1 = scanner.nextFloat();
        System.out.print("Agora, digite a nota da p2: ");
        p2 = scanner.nextFloat();

        media = (p1 + p2) / 2;
    }
    if (media > 6) {
        System.out.println("Aluno Aprovado! Média: " + media);
    } else {
        System.out.print("Digite a nota da p3: ");
        p3 = scanner.nextFloat();

        media = (p1 + p2 + p3) / 3;

        System.out.println(
                media > 6 ? "Aluno aprovado! Média: " + media
                        : "Aluno reprovado. Média: " + media + " nota necessária no exame > 6"
        );
    }
}

private static void ex02() {
    float valorTotalOrcamento, aporteFinanceiro;
    byte qtdErrosCrit;

    System.out.print("Digite o valor do orçamento: ");
    valorTotalOrcamento = scanner.nextFloat();
    System.out.print("Digite o quantidade de erros críticos (se > 5, o projeto será rejeitado): ");
    qtdErrosCrit = scanner.nextByte();

    if (qtdErrosCrit > 5){
        System.out.println("Projeto rejeitado pela auditoria!");
        return;
    } else if (valorTotalOrcamento/2 < 50000) {
        System.out.println("Projeto aprovado!");
        return;
    } else {
        System.out.print("Digite o valor do aporte financeiro: ");
        aporteFinanceiro = scanner.nextFloat();
    }

    System.out.println(
            (valorTotalOrcamento+aporteFinanceiro)/3 < 50000?
                    "Projeto aprovado com recursos extras!" : "Projeto rejeitado por estourar o orçamento"
    );
}

private static void ex03(){
    float pressArtSistolica, temp1, temp2, mediaTemp, freqCardiaca, mediaTotal;

    System.out.print("Digite a pressão arterial sistólica do paciente: ");
    pressArtSistolica = scanner.nextFloat();

    if (pressArtSistolica > 180){
        System.out.println("Encaminhamento imediato para emergência");
        return;
    }
    System.out.print("Digite o primeiro valor de temperatura: ");
    temp1 = scanner.nextFloat();
    System.out.print("Digite o segundo valor de temperatura: ");
    temp2 = scanner.nextFloat();
    mediaTemp = (temp1+temp2)/2;

    if (mediaTemp < 37.5){
        System.out.println("Paciente liberado / Triagem verde");
        return;
    }
    System.out.print("Digite a frequência cardíaca do paciente: ");
    freqCardiaca = scanner.nextFloat();
    mediaTotal = (pressArtSistolica + mediaTemp + freqCardiaca)/3;

    if (mediaTotal > 100){
        System.out.println("Paciente em observação...");
    }else {
        System.out.println("Paciente medicado e liberado!");
    }
}