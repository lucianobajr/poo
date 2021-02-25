package segundo;
import java.util.Scanner;
/**
 * @author Luciano Belo - 3897
 */
public class Segundo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        System.out.print("Digite o valor do numerador: ");
        float numerator = scan.nextFloat();
        System.out.print("Digite o valor do denominador: ");
        float denominator = scan.nextFloat();
        
        if(denominator==0){
           while(denominator==0){
                System.out.println("O denominador deve ser diferente de 0 (zero)!");
                System.out.print("Digite novamente o valor do denominador: ");
                denominator = scan.nextFloat();
           }
        }
        
        float result = numerator / denominator;
        System.out.println("Resultado: "+ result);
    }
    
}
