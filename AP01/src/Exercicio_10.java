import java.util.Scanner;
/**
 * @author Luciano Belo - 3897
*/
public class Exercicio_10 {
    public static int som(int num1, int num2) {
        return num1 + num2;
    }  
    public static int sub(int num1, int num2){
        return num1 - num2;
    }  
    public static int div(int num1,int num2){
        return num1 / num2;
    }  
    public static int mult(int num1, int num2){
        return num1 * num2;
    }  
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Digite a operação desejava : ");
        String op = scan.nextLine();

        op = op.toLowerCase();
        
        String[] currencies = op.split(" ");
        
        int result = 0;
        int fs = Integer.parseInt(currencies[1]);
        int sec = Integer.parseInt(currencies[3]);
        
        switch (currencies[0]){
            case "soma":
                result = som(fs,sec);
                break;
            case "multiplica":
                result = mult(fs,sec);
                break;
            case "divide":
                result = div(fs,sec);
                break;
            case "subtrai":
                result = sub(fs,sec);
                break;
        }
        
        System.out.println("RESULTADO: "+result);
        scan.close();
    }
}
