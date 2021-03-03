import java.util.Scanner;

/**
 * @author Luciano Belo - 3897
 */
public class Exercicio_14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite a quantidade de linhas: ");
        int x = scan.nextInt();
        String aux = "";

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j < i; j++) {
                aux += "*";

            }
            System.out.println(aux);
            aux = "";
        }
        scan.close();
    }
}
