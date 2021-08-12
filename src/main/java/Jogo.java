import java.util.Scanner;

public class Jogo {

  public static final String EXCEPTION_NUMERO_INVALIDO = "Digite um número menor que 10 ou maior que 0!";
  public static final String MSG_DERROTA = "Sinto muito, você perdeu.";
  public static final String MSG_VITORIA = "Parabéns, você ganhou!";
  public static final String STATUS_IMPAR = "ímpar";
  public static final String STATUS_PAR = "par";

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);

    System.out.printf("Digite 1 (%s) ou 2 (%s): ", STATUS_IMPAR, STATUS_PAR);
    int numeroSelecionado = in.nextInt();

    System.out.printf("%s", "\nDigite um número: ");
    int meuNumero = in.nextInt();

    if (meuNumero > 10 || meuNumero < 0)
      throw new Exception(EXCEPTION_NUMERO_INVALIDO);

    System.out.println("\nVocê jogou: " + meuNumero);

    int numeroOponente = (int) (Math.random() * 10);
    System.out.println("Computador jogou: " + numeroOponente + "\n");

    int somatorio = meuNumero + numeroOponente;
    System.out.printf("%s + %s = %s%n", meuNumero, numeroOponente, somatorio);

    var status = somatorio % 2 == 0 ? STATUS_PAR : STATUS_IMPAR;
    System.out.printf("%s é um número %s%n%n", somatorio, status);

    switch (numeroSelecionado) {
      case 1:
        if (status.equals(STATUS_IMPAR)) System.out.printf("%s", MSG_VITORIA);
        else System.out.printf("%s", MSG_DERROTA);
        break;

      case 2:
        if (status.equals(STATUS_PAR)) System.out.printf("%s", MSG_VITORIA);
        else System.out.printf("%s", MSG_DERROTA);
        break;

      default:
        System.err.printf("%s", "Sinto muito, mas você não escolheu nem par nem ímpar.");
    }
  }
}
