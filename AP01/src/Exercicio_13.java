import java.util.Scanner;
/**
 * @author Luciano Belo - 3897
*/
public class Exercicio_13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String continueUse = "";
        String type = "";
        int time = 0;
        
        int balance = 100;
        int vaivai = 50;
        double other = 0.65;
        double otherVaivai = 0.20;
        double otherFixo = 0.325;
        
        double total = 50;
        
        do {
            System.out.print("Digite o tipo de ligação (‘o’ = outras operadoras, ‘v’ = a própria Vai-Vai, ou ‘f’ = telefone fixo): ");
            type = scan.next();
            
            System.out.print("Digite a quantidade de minutos: ");
            time = scan.nextInt();
           
            switch (type){
                case "o":
                    if(balance>0 && time<=balance){
                        balance -=time;
                    }else if(time>balance && balance>0){
                        total +=  ((time-balance) * other);
                        balance = 0;
                    }
                    else if(balance==0){
                        total += (time *other);
                    }
                    
                    break;
                case "v":
                    if(vaivai>0 && time<=vaivai){
                        vaivai -=time;
                    }else if(time>vaivai && vaivai>0){
                        total +=  ((time-vaivai) * otherVaivai);
                        vaivai = 0;
                    }
                    else if(vaivai==0){
                        total += (time *otherVaivai);
                    }
                    
                    break;
                case "f":
                    if(balance>0 && time<=balance){
                        balance -=time;
                    }else if(time>balance && balance>0){
                        total +=  ((time-balance) * otherFixo);
                        balance = 0;
                    }
                    else if(balance==0){
                        total += (time *otherFixo);
                    }
                    
                    break;
                default:
                    System.out.println("\nOpção Inválida\n");
            }
            
            System.out.println("Saldo Atual: " + balance + " minutos  para qualquer número e " + vaivai + " minutos para a Vai-vai");
            System.out.println("Valor a ser pago: R$" + total);
            
            System.out.println("\n");
            System.out.print("Deseja fazer mais uma ligação (s/n): ");
            continueUse = scan.next();
            System.out.println("\n");
        } while ((!continueUse.equals("n")));

        scan.close();
    }
}
