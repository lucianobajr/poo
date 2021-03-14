import java.util.Scanner;
/**
 * @author Luciano Belo - 3897
*/
public class Exercicio_6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("-------PRIMEIRO HORÁRIO-------");
        
        System.out.print("Digite o primeiro valor das horas: ");
        int firstHours = scan.nextInt();
        System.out.print("Digite o primeiro valor dos minutos: ");
        int firstMinutes = scan.nextInt();
        System.out.print("Digite o primeiro valor dos segundos: ");
        int firstSeconds = scan.nextInt();
        
        
        System.out.println("-------SEGUNDO HORÁRIO-------");
        
        System.out.print("Digite o segundo valor das horas: ");
        int secondHours = scan.nextInt();
        System.out.print("Digite o segundo valor das horas: ");
        int secondMinutes = scan.nextInt();
        System.out.print("Digite o segundo valor das horas: ");
        int secondSeconds = scan.nextInt();

        System.out.println("-------RESULTADO-------");
        
        int result = ((firstHours-secondHours)*3600)+((firstMinutes-secondMinutes)*60)+(firstSeconds-secondSeconds);
        System.out.println(result+" segundos");

        scan.close();
    }
}
