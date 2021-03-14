import java.util.Scanner;
/**
 * @author Luciano Belo - 3897
 */
public class Exercicio_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Digite o ano atual: ");
        var currentYear = scan.nextInt();
        
        System.out.print("Digite o ano do seu Nascimento: ");
        var bithYear = scan.nextInt();
        
        var age = currentYear - bithYear;
        
        System.out.println("Você faz " + age + " anos neste ano.");

        scan.close();
    }
}
