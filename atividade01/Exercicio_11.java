import java.util.Scanner;
import java.util.Random;
/**
 * @author Luciano Belo - 3897
*/
public class Exercicio_11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        
        int sorted = random.nextInt(100);
        int tried = 0;
        
        Boolean hit=false;
                
        do {            
            System.out.print("Digite um valor: ");
            int value = scan.nextInt();
            
            if(value==sorted){
                hit = true;   
            }
            else{
                if(sorted>value){
                    System.out.println("O número sorteado é maior do que o digitado");
                }else{
                     System.out.println("O número sorteado é menor do que o digitado");
                }
            }
            tried++;

        } while (hit==false);
       
        
        System.out.println("Parabens!! você acertou após "+tried+" tentativas");
        scan.close();
    }
}
