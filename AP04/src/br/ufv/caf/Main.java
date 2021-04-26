package br.ufv.caf;

import br.ufv.caf.view.TelaBits;
import br.ufv.caf.view.TelaBitsString;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Luciano- 3897
 */
public class Main {

    public static void main(String[] args) {
        int size = 0;
        int option;
        Scanner scan = new Scanner(System.in);

        boolean continueLoop = true;

        do {
            try {
                System.out.print("Digite o tamanho do array de bits: ");
                size = scan.nextInt();
                continueLoop = false;

            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Digite um inteiro!");
                scan.nextLine();
            }
        } while (continueLoop);

        continueLoop = true;

        while (true) {
            mostrarMenu();
            do {
                try {
                    option = scan.nextInt();
                    switch (option) {
                        case 1:
                            TelaBits tela = new TelaBits(size);
                            tela.telaInicial();
                            break;
                        case 2:
                            TelaBitsString telaString = new TelaBitsString(size);
                            telaString.telaInicial();
                            break;
                        default:
                            System.err.println("Opção Inválida");
                    }
                    continueLoop = false;

                } catch (InputMismatchException inputMismatchException) {
                    System.err.println("Digite um inteiro!");
                    scan.nextLine();
                }
            } while (continueLoop);
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n----------------------------");
        System.out.println("       Digite para Usar:     ");
        System.out.println("          1: Inteiro       ");
        System.out.println("          2: String        ");
        System.out.println("----------------------------\n");
    }
}
