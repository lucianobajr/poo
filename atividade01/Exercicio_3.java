import java.util.Scanner;
/**
 * @author Luciano Belo - 3897
 */
public class Exercicio_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Informe seu salário bruto: ");
        double grossSalary = scan.nextDouble();
        System.out.print("Informe os descontos do seu salário: ");
        double discount = scan.nextDouble();
        System.out.print("Informe o valor desejado de empréstimo: ");
        double loan = scan.nextDouble();
        
        double salary = grossSalary - discount; 
        
        boolean canLoad = (loan <= (salary*0.3)?true:false);
        
        if(canLoad){
            System.out.println("Você pode fazer o empréstimo!");

        }else{
            System.out.println("Você não pode fazer o empréstimo");
        }

        scan.close();
    }
}
