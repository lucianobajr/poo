package ap03;
import java.util.Scanner;
/**
 * @author Luciano Belo - 3897
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int continuar;
        int refrigerante;
        float credito;
        int confirmarComprar;
        MaquinaRefrigerante maquina = new MaquinaRefrigerante(
                4.50,5.00,3.60,4.00,6.20,
                "Pepsi","Fanta","Doli","Guarapam","Coca Cola"
        );
       
        
        do {           
            System.out.print("INFORME O VALOR A SER INSERIDO: ");
            credito = scan.nextFloat();
           
            do {                
                System.out.print("Digite o código do refrigerante (de 1 a 5): ");
                refrigerante = scan.nextInt();
            } while (refrigerante<1||refrigerante>5);
            
            if(!maquina.verificarNoEstoque(refrigerante)||!maquina.podeComprar(refrigerante,credito)){
                System.out.println("Não é possível comprar o item escolhido!");
                System.out.println("Seu troco será de: R$"+credito);
            }else{
                System.out.println("DIGITE (1) PARA CONFIRMAR COMPRA E (2) PARA CANCELAR");
                confirmarComprar = scan.nextInt();
                
                if(confirmarComprar==1){
                    maquina.comprar(refrigerante, credito);
                }else{
                    break;
                }
            }
     
                       
                        
            System.out.println("\n-----------------------------------------------\n");
            System.out.print("DIGITE (1) PARA FAZER UMA COMPRA NOVAMENTE: ");
            continuar = scan.nextInt();
            System.out.println("\n-----------------------------------------------\n");
        } while (continuar==1);
        
        
        System.out.println("\n-----------------------------------------------");
        System.out.print  ("                 VOLTE SEMPRE!                     ");
        System.out.println("\n-----------------------------------------------\n");
        System.out.println(maquina.toString());
    }
}
