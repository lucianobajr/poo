import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * @author Luciano Belo - 3897
 */
public class Exercicio_9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String value = "";
            
        List<Integer> numbers = new ArrayList<>();

        do {            
            System.out.print("Digite um valor: ");
            value = scan.next();
            
            if(value.equals("fim")){
                break;
            }
            else{
                numbers.add(Integer.parseInt(value));
            }
            
        } while ((!value.equals("fim")));
        
        int[] myNum;
        
        myNum = new int[numbers.size()];
        
        for (int i = 0; i < numbers.size(); i++) {
            myNum[i] =   numbers.get(i);
        }
     
        for (int i = 0; i < myNum.length; i++) {  
            for (int j = i + 1; j < myNum.length; j++) {  
                int tmp = 0;

                if (myNum[i] > myNum[j])   {  
                    tmp = myNum[i];  
                    myNum[i] = myNum[j];  
                    myNum[j] = tmp;  
                }
            }
        }  
        
        System.out.println("Números ordenados: "+Arrays.toString(myNum));
        scan.close();
    }
}
