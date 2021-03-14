import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Exercicio_12 {
    public static void main(String[] args) {
        File objFile = new File("file.txt");
        
        DecimalFormat formatador = new DecimalFormat("0.00");
        
        int numberOfPatients= 0;
        int mans = 0;
        int women = 0;
        int ageBetween=0;
        int olderMan = 0;
        
        double ageMan = 0;
        double heightWoman=0;
        
        String nameOlderMan = "";
        String nameShorterWoman = "";

        
        try (Scanner myReader = new Scanner(objFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(" ");

                if(heightWoman==0&&"feminino".equals(line[1])){
                    heightWoman = Double.parseDouble(line[4]);
                    nameShorterWoman=line[0];
                }

                if("feminino".equals(line[1])&&Double.parseDouble(line[4])<heightWoman){
                    heightWoman = Double.parseDouble(line[4]);
                    nameShorterWoman = line[0];
                }

                if("masculino".equals(line[1])){
                    mans++;
                    ageMan+= Double.parseDouble(line[3]);
                }

                if("feminino".equals(line[1]) && ( Double.parseDouble(line[4])<1.70 && Double.parseDouble(line[4])>1.60 ) && Double.parseDouble(line[2])>70){
                    women++;
                }

                if(Integer.parseInt(line[3])>=18&&Integer.parseInt(line[3])<=25){
                    ageBetween++;
                }

                if(Integer.parseInt(line[3])>olderMan&&"masculino".equals(line[1])){
                    olderMan = Integer.parseInt(line[3]);
                    nameOlderMan = line[0];
                }

                numberOfPatients++;
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo!");
        }    
        
        double media = ageMan / mans;
        
        System.out.println("Quantidade de pacientes: " + numberOfPatients);
        System.out.println("Média de idade dos homens: " + formatador.format(media));
        System.out.println("Número de mulheres com altura entre 1,60 e 1,70 e peso acima de 70kg: " + women);
        System.out.println("Quantidade de pessoas com idade entre 18 e 25: " + ageBetween);
        System.out.println("Nome do Paciente mais velho: " + nameOlderMan);
        System.out.println("Nome da mulher mais baixa: " + nameShorterWoman );
        
        System.out.println("\nObs:  O arquivo deve estar na raiz do exercício\n");
    }
}
