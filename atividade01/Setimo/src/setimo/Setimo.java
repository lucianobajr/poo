package setimo;
import java.util.Scanner;
/**
 * @author Luciano Belo - 3897
 */
public class Setimo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int sum = 0;
        int multiplication = 1;
        int currentValue;
        
        System.out.print("Digite o valor de N: ");
        int n = scan.nextInt();
        
        if(n>100 || n<0){
            System.out.print("Digite o valor de N: ");
            n = scan.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print("Digite um valor: ");
            currentValue = scan.nextInt();
            sum+=currentValue;
            multiplication*=currentValue;
        }
        
        System.out.println("Soma: "+sum);
        System.out.println("Produto: "+multiplication);
    }    
}
