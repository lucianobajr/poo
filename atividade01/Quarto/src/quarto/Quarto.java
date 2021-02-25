package quarto;
import java.util.Scanner;
/**
 * @author Luciano Belo - 3897
 */
public class Quarto {
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
        
        System.out.print("Digite um nome de mês: ");
        String mounth = scan.next();
        
        switch (mounth) {
            case "Janeiro":
              System.out.println(1);
              break;
            case "Fevereiro":
              System.out.println(2);
              break;
            case "Março":
              System.out.println(3);
              break;
            case "Abril":
              System.out.println(4);
              break;
            case "Maio":
              System.out.println(5);
              break;
            case "Junho":
              System.out.println(6);
              break;
            case "Julho":
              System.out.println(7);
              break;
            case "Agosto":
              System.out.println(8);
              break;
            case "Setembro":
              System.out.println(9);
              break;
            case "Outubro":
              System.out.println(10);
              break;
            case "Novembro":
              System.out.println(11);
              break;
            case "Dezembro":
              System.out.println(12);
              break;
        default:
          System.out.print(0);
        }
    }
}
