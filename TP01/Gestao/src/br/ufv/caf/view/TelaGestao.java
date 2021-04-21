package br.ufv.caf.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaGestao {

    final private TelaProduto telaProduto;
    final private TelaCliente telaCliente;
    final private TelaVendas telaVendas;
    final private Scanner scan;

    public TelaGestao() {
        scan = new Scanner(System.in);
        telaProduto = new TelaProduto();
        telaCliente = new TelaCliente();
        telaVendas = new TelaVendas();
    }

    public void telaInicial() {
        mostrarMenu();
        int option;
        boolean continueLoop = true;
        while (true) {
            do {
                try {
                    option = scan.nextInt();
                    switch (option) {
                        case 1:
                            telaProduto.telaInicial();
                            break;
                        case 2:
                            telaCliente.telaInicial();
                            break;
                        case 3:
                           
                            telaVendas.telaInicial();
                            break;
                        case 4:
                            System.exit(0);
                            break;
                        default:
                            System.err.println("Opção Inválida");
                    }
                    mostrarMenu();
                    continueLoop = false;
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Digite um inteiro!");
                    System.out.print("Digite uma opção: ");
                    scan.nextLine();
                }
            } while (continueLoop);
        }
    }

    public void mostrarMenu() {
        System.out.println("\n---------------------");
        System.out.println("      Digite:      ");
        System.out.println("     1: Produto    ");
        System.out.println("     2: Cliente    ");
        System.out.println("     3: Vendas     ");
        System.out.println("      4: Sair      ");
        System.out.println("---------------------\n");

    }
}
