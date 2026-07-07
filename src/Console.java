import java.util.Scanner;

public class Console {
  public static void limparTela() {
      for (int i = 0; i < 40; i++) {
          System.out.println();
      }
  }

  public static void pausar(Scanner scanner) {
      System.out.println("\nPressione ENTER para continuar...");
      scanner.nextLine();
  }
}