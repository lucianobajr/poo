package br.ufv.caf.view;

import br.ufv.caf.controller.ControleProduto;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaProduto {

    final private Scanner scan;
    final private ControleProduto controleProduto;

    public TelaProduto() {
        scan = new Scanner(System.in);
        controleProduto = new ControleProduto();
    }

    public void telaInicial() {
        mostrarMenu();
        int option;
        boolean continueLoop = true;
        do {
            try {
                option = scan.nextInt();
                switch (option) {
                    case 1:
                        telaInserir();
                        break;
                    case 2:
                        telaListar();
                        break;
                    case 3:
                        alterarEstoque();
                        break;
                    default:
                        System.err.println("Opção Inválida");
                }

                continueLoop = false;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Digite um inteiro!");
                scan.nextLine();
            }
        } while (continueLoop);
    }

    private void telaInserir() {
        boolean continueLoop = true;
        System.out.print("Digite o nome do produto: ");
        String nome = scan.next();
        System.out.print("Digite a descrição do produto: ");
        String descricao = scan.next();
        System.out.print("Digite categoria do produto: ");
        String categoria = scan.next();

        int estoque;
        double valor;

        do {
            try {
                System.out.print("Digite a quantidade em estoque do produto: ");
                estoque = scan.nextInt();

                System.out.print("Digite o valor do produto: ");
                valor = scan.nextDouble();
                continueLoop = false;
            } catch (InputMismatchException inputMismatchException) {
                System.out.print("Digite a quantidade em estoque do produto: ");
                estoque = scan.nextInt();

                System.out.print("Digite o valor do produto: ");
                valor = scan.nextDouble();
            }
        } while (continueLoop);

        controleProduto.inserirProduto(nome, descricao, estoque, categoria, valor);
    }

    private void telaListarTodos() {
        ArrayList<String> produtos = controleProduto.listarProdutos();
        System.out.println("Total de produtos: " + produtos.size());

        System.out.println("================PRODUTOS================");
        produtos.forEach(s -> {
            System.out.println(s);
        });
        System.out.println("========================================");
    }

    private void telaListarProduto() {
        System.out.print("Digite o nome do Produto: ");
        String nomeProduto = scan.next();
        String produto = controleProduto.listarProduto(nomeProduto);
        if (produto != null) {
            System.out.println(produto);
        }
    }

    private void telaListar() {
        mostrarMenuListagem();
        int option;
        boolean continueLoop = true;
        do {
            try {
                option = scan.nextInt();
                switch (option) {
                    case 1:
                        telaListarTodos();
                        break;
                    case 2:
                        telaListarProduto();
                        break;

                    default:
                        System.err.println("Opção Inválida");
                }
                continueLoop = false;
            } catch (InputMismatchException inputMismatchException) {
                System.out.print("\nDigite uma opção: ");
                scan.nextLine();
            }
        } while (continueLoop);

    }

    private void alterarEstoque() {
        telaListarTodos();
        boolean continueLoop = true;
        do {
            try {
                System.out.print("Digite código do produto a ser editado: ");
                int codigo = scan.nextInt();
                System.out.print("Digite a nova quantidade em estoque do produto: ");
                int estoque = scan.nextInt();

                controleProduto.alterarEstoque(codigo, estoque);
                continueLoop = false;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Digite um inteiro!");
                System.out.print("Digite uma opção: ");
                scan.nextLine();
            }
        } while (continueLoop);
    }

    public void mostrarMenu() {
        System.out.println("\n---------------------");
        System.out.println("      Digite:      ");
        System.out.println("  1: Inserir Produto ");
        System.out.println("  2: Listar Produtos ");
        System.out.println("  3: Alterar Estoque de Produto ");
        System.out.println("---------------------\n");
    }

    public void mostrarMenuListagem() {
        System.out.println("\n---------------------");
        System.out.println("      Digite:      ");
        System.out.println("  1: Listar todos os produtos ");
        System.out.println("  2: Filtrar Produto por Nome ");
        System.out.println("---------------------\n");
    }
}
