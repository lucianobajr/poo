package br.ufv.caf.view;

import br.ufv.caf.controller.ControleBitsString;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaBitsString {

    final Scanner scan;
    final private ControleBitsString bits;

    public TelaBitsString(int size) {
        this.scan = new Scanner(System.in);
        this.bits = new ControleBitsString(size);
    }

    public void telaInicial() {
        int option;
        boolean continueLoop = true;

        while (true) {
            mostrarMenu();

            do {
                try {
                    option = scan.nextInt();
                    switch (option) {
                        case 1:
                            telaInserirBit();
                            break;
                        case 2:
                            telaListarBits();
                            break;
                        case 3:
                            telaAcessarBit();
                            break;
                        case 4:
                            telaArrayIgual();
                            break;
                        case 5:
                            telaOperaçãoAND();
                            break;
                        case 6:
                            telaOperaçãoOR();
                            break;
                        case 7:
                            telaOperaçãoNOT();
                            break;
                        case 8:
                            System.exit(0);
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

    public void telaInserirBit() {
        int posicao;
        String valor;

        boolean continueLoop = true;

        do {
            try {
                System.out.print("Digite a posição: ");
                posicao = scan.nextInt();
                System.out.print("Digite a valor: ");
                valor = scan.next();

                try {
                    if ("0".equals(valor) || "1".equals(valor)) {
                        bits.insereBit(posicao, valor);
                    } else {
                        System.err.println("Digite 0 ou 1!");
                    }
                } catch (ArrayIndexOutOfBoundsException exception) {
                    System.err.println("Digite uma posição válida!");
                }

                continueLoop = false;

            } catch (InputMismatchException inputMismatchException) {
                System.err.println("\nDigite um inteiro! \n");
                scan.nextLine();
            }
        } while (continueLoop);
    }

    public void telaListarBits() {
        System.out.println(bits.listarBits());
    }

    public void telaAcessarBit() {
        boolean continueLoop = true;
        int posicao;

        do {
            try {
                System.out.print("Digite a posição: ");
                posicao = scan.nextInt();

                if (posicao < 0 || posicao > bits.tamanho()) {
                    System.err.println("Posição inválida!");

                } else {
                    System.out.println(
                            "\nO bit na posição "
                            + posicao + " é: "
                            + bits.recuperarBit(posicao));
                }

                continueLoop = false;

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Digite um inteiro!");
                scan.nextLine();
            }
        } while (continueLoop);
    }

    public void telaArrayIgual() {
        String[] arr = new String[bits.tamanho()];
        boolean continueLoop = true;
        String valor;

        for (int i = 0; i < bits.tamanho(); i++) {

            do {
                try {
                    System.out.print("Posição " + i + ": ");
                    valor = scan.next();

                    if ("0".equals(valor) || "1".equals(valor)) {
                        arr[i] = valor;

                    } else {
                        System.err.println("Digite 0 ou 1!");
                    }

                    continueLoop = false;

                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Digite um inteiro!");
                    scan.nextLine();
                }
            } while (continueLoop);
            continueLoop = true;
        }

        System.out.println("\nArray de bits :  " + Arrays.toString(bits.getArry()));
        System.out.println("\nArray informado: " + Arrays.toString(arr));

        if (bits.equalsStrings(arr)) {
            System.out.println("\n");
            System.out.print("\u001B[" + "32" + "m");
            System.out.println("Os Arrays são iguais!");
            System.out.println("\u001B[" + "m");
        } else {
            System.err.println("\nOs Arrays são diferentes!\n");
        }
    }

    public void telaOperaçãoAND() {
        String valor;
        boolean continueLoop1 = true;
        String[] arr = new String[bits.tamanho()];
        String[] res;

        System.out.println("\nEntre com o Array\n");
        for (int i = 0; i < bits.tamanho(); i++) {
            do {
                try {
                    System.out.print("Posição " + i + ": ");
                    valor = scan.next();

                    if ("0".equals(valor) || "1".equals(valor)) {
                        arr[i] = valor;

                    } else {
                        System.err.println("Digite 0 ou 1!");
                    }

                    continueLoop1 = false;

                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Digite um inteiro!");
                    scan.nextLine();
                }
            } while (continueLoop1);
            continueLoop1 = true;
        }

        res = bits.and(arr);

        System.out.println("\nRESULTADO OPERAÇÃO AND\n");
        System.out.println("\nArray de bits :  " + Arrays.toString(bits.getArry()));
        System.out.println("\nArray informado: " + Arrays.toString(arr));
        System.out.println("\nArray Resultado: " + Arrays.toString(res));
    }

    public void telaOperaçãoOR() {
        String valor;
        boolean continueLoop1 = true;
        String[] arr = new String[bits.tamanho()];
        String[] res;

        System.out.println("\nEntre com o Array\n");
        for (int i = 0; i < bits.tamanho(); i++) {
            do {
                try {
                    System.out.print("Posição " + i + ": ");
                    valor = scan.next();

                    if ("0".equals(valor) || "1".equals(valor)) {
                        arr[i] = valor;

                    } else {
                        System.err.println("Digite 0 ou 1!");
                    }

                    continueLoop1 = false;

                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Digite um inteiro!");
                    scan.nextLine();
                }
            } while (continueLoop1);
            continueLoop1 = true;
        }

        res = bits.or(arr);

        System.out.println("\nRESULTADO OPERAÇÃO OR\n");
        System.out.println("\nArray de bits :  " + Arrays.toString(bits.getArry()));
        System.out.println("\nArray informado: " + Arrays.toString(arr));
        System.out.println("\nArray Resultado: " + Arrays.toString(res));
    }

    public void telaOperaçãoNOT() {
        String[] res = bits.not();

        System.out.println("\nRESULTADO OPERAÇÃO NOT\n");
        System.out.println("\nArray de bits :  " + Arrays.toString(bits.getArry()));
        System.out.println("\nArray Resultado: " + Arrays.toString(res));

    }

    public void mostrarMenu() {
        System.out.println("\n----------------------------");
        System.out.println("           Digite:            ");
        System.out.println("       1: Inserir Bit         ");
        System.out.println("       2: Mostrar Bits        ");
        System.out.println("       3: Acessar Bit         ");
        System.out.println("       4: Comparar Arrays     ");
        System.out.println("       5: Operação AND        ");
        System.out.println("       6: Operação OR         ");
        System.out.println("       7: Operação NOT        ");
        System.out.println("            8: Sair           ");
        System.out.println("----------------------------\n");
    }
}
