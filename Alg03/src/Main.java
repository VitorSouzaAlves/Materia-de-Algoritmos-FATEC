public static Scanner scanner = new Scanner(System.in);

public static void main() {
  byte id = 0;

  do {
    System.out.print("\nDigite um número de 1 a 3. Caso queira finalizar o sistema, digite 0: ");
    id = scanner.nextByte();

    switch (id) {
      case 1:
        ex03();
        break;

      case 2:
        ex04();
        break;

      case 3:
        ex05();
        break;

        default:
          System.out.println("Opção inválida!");
    }
  } while (id != 0);

  System.out.print("Finalizando sistema...");
}

private static void ex03(){
  byte a = 6, b = 3, c = 9, somaProduto, somaPeso;
  float media;

  somaProduto = (byte) ((a*2) + (b*3) + (c*2));
  somaPeso = (2+3+2);
  media = (float) somaProduto/somaPeso;

  System.out.printf("\nCom as notas: %d, %d e %d. Sua nota final é: %.2f\n", a, b, c, media);
}

private static void ex04(){
  float distKm, tempoViagem, litroCombustivel;
  short velMediaKm, consCombustivel;

  System.out.print("\nDigite a distância da viagem em Km: ");
  distKm = scanner.nextFloat();

  System.out.print("\nAgora digite a velocidade media do veiculo em Km/h: ");
  velMediaKm = scanner.nextShort();

  System.out.print("\nPor fim, digite o consumo em Km/L de combustível do veiculo: ");
  consCombustivel = scanner.nextShort();

  tempoViagem = distKm / velMediaKm;
  litroCombustivel = distKm / consCombustivel;

  System.out.printf("\nO tempo de viagem estimado é de: %.2fh, " +
          "e a quantia necessária de combustível é de: %.2fL\n", tempoViagem, litroCombustivel);
}

private static void ex05(){
  final float milha = 1.60934F;
  float km, kmEmMilha;

  System.out.print("\nDigite a quantia de quilômetros, para realizar a conversão em milhas: ");
  km = scanner.nextFloat();

  kmEmMilha = km / milha;

  System.out.printf("\nO valor da conversão é de: %.2fmi\n", kmEmMilha);
}