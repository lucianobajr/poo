import java.util.Scanner;
/**
 * @author Luciano Belo - 3897
*/
public class Exercicio_8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Digite o valor de N: ");
        int n = scan.nextInt();
        int total = 0;
        int odd = 0; 
        int even = 0;
        int bigger = 0;
        int smaller = 0;
        
        if(n>1000||n<0){
            while(n>1000||n<0){
                System.out.print("Digite o valor de N: ");
                n = scan.nextInt();
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print("Digite um valor: ");
            int value = scan.nextInt();
            total+=value;
            
            if(i==0){
                bigger = value;
                smaller = value;
            }
            
            if(n>bigger){
                bigger = value;
            }
            
            if(smaller<n){
                bigger = value;
            }
            
            if(value%2==1){
                //impar
                odd++;
            }else{
                //par
                even++;
            }
        }
        
        
        System.out.println("Menor valor: " + smaller);
        System.out.println("Media aritmética: " + (total/n));
        System.out.println("Maior valor : " + bigger);
        System.out.println("Quantidade de números pares: " + even);
        System.out.println("Quantidade de números ímpares: " + odd);
        
        scan.close();
    }
}
