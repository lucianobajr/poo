package quinta;
import java.util.Scanner;
/**
 * @author Luciano Belo - 3897
 */
public class Quinta {
    public static boolean checkIfExists(int day,int mounth){
        boolean verify = false;
        
        if(day>31 || day <=0){
            verify = false;
        }
        else if(mounth>12 || mounth <=0){
            verify = false;
        }
        else if(mounth==2&&day>28){
            verify = false;
        }
        else if((mounth==4 || mounth==6 || mounth==9 || mounth==11)&&day>30){
            verify = false;
        }
        else {
            verify = true;
        }
        
        return verify;
    }
    
    public static String mounthInString(int value){
        String response;
        switch (value) {
            case 1:
                response = "Janeiro";
                break;
            case 2 :
                response ="Fevereiro";
                break;
            case 3:
              response = "Março";
              break;
            case 4:
              response = "Abril";
              break;
            case 5:
              response = "Maio";
              break;
            case 6:
              response = "Junho";
              break;
            case 7:
              response = "Julho";
              break;
            case 8:
              response = "Agosto";
              break;
            case 9:
              response = "Setembro";
              break;
            case 10:
              response = "Outubro";
              break;
            case 11:
              response = "Novembro";
              break;
            case 12:
              response = "Dezembro";
              break;
        default:
          response= "";
        }
        
        return response;
    }
    
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       
       System.out.print("Informe o dia do seu aniversário: ");
       int dayBirth = scan.nextInt();
       System.out.print("Informe o mês do seu aniversário: ");
       int mounthBirth = scan.nextInt();
       
       if(checkIfExists(dayBirth, mounthBirth)){
           System.out.println("Data válida e o mes é "+mounthInString(mounthBirth)+".");
       }else{
           System.out.println("Data inválida!");
       }
    }
    
}
