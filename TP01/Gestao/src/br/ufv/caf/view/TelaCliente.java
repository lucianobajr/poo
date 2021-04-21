package br.ufv.caf.view;

import br.ufv.caf.controller.ControleCliente;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaCliente {

    final private Scanner scan;
    final private ControleCliente controleCliente;

    public TelaCliente() {
        scan = new Scanner(System.in);
        controleCliente = new ControleCliente();
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
                        telaAlterarDados();
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

        try {
            System.out.print("Digite o CPF: ");
            String cpf = scan.next();

            System.out.print("Digite o nome: ");
            String nome = scan.next();

            System.out.print("Digite o email: ");
            String email = scan.next();

            System.out.print("Digite o senha: ");
            String senha = scan.next();

            ArrayList<String> enderecosCliente = new ArrayList<>();
            System.out.print("Digite a quantidade de endereços a ser cadastrado: ");
            int quantidadeEnderecos = scan.nextInt();
            for (int i = 0; i < quantidadeEnderecos; i++) {
                System.out.print("Digite um endereço: ");
                String endereco = scan.next();
                enderecosCliente.add(endereco);
            }
            controleCliente.inserirCliente(cpf, nome, email, senha, enderecosCliente);
        } catch (Exception e) {
            System.err.println("Erro ao cadastrar cliente!");
        }

    }

    private void telaListar() {
        mostrarMenuListagem();
        int option;

        option = scan.nextInt();
        switch (option) {
            case 1:
                telaListarClientes();
                break;
            case 2:
                telaListarCliente();
                break;

            default:
                System.err.println("Opção Inválida");
        }

    }

    private void telaListarClientes() {
        ArrayList<String> clientes = controleCliente.listarClientes();
        System.out.println("Total de clientes: " + clientes.size());

        System.out.println("================CLIENTES================");
        clientes.forEach(s -> {
            System.out.println(s);
        });
        System.out.println("========================================");
    }

    private void telaListarCliente() {
        System.out.print("Digite o nome Cliente: ");
        String nomeCliente = scan.next();
        String cliente = controleCliente.listaCliente(nomeCliente);

        if (cliente != null) {
            System.out.println(cliente);
        }
    }

    private void telaAlterarDados() {
        telaListarClientes();
        int codigo;
        System.out.print("Digite o código do cliente: ");
        codigo = scan.nextInt();
        mostrarMenuDados();

        int optionDados;
        optionDados = scan.nextInt();

        switch (optionDados) {
            case 1:
                // editar o nome
                System.out.print("Digite o novo nome:");
                String nome = scan.next();
                controleCliente.editarNome(nome, codigo);

                break;
            case 2:
                // editar o email
                System.out.print("Digite o novo email:");
                String email = scan.next();
                controleCliente.editarNome(email, codigo);
                break;
            case 3:
                // editar o CPF
                System.out.print("Digite o novo CPF:");
                String CPF = scan.next();
                controleCliente.editarCPF(CPF, codigo);
                break;
            case 4:
                // editar senha
                System.out.print("Digite a nova Senha:");
                String senha = scan.next();
                controleCliente.editarSenha(senha, codigo);
                break;
            case 5:
                // Adicionar novo endereço
                System.out.print("Digite o novo Endereço:");
                String endereco = scan.next();
                controleCliente.adicionarEndereco(endereco, codigo);
                break;
            case 6:
                // Excluir endereço
                ListarEnderecosCliente(codigo);
                System.out.print("Digite o código do endereço: ");
                int posicaoEndereco = scan.nextInt();
                controleCliente.removerEndereco(posicaoEndereco, codigo);
                break;
            default:
                System.err.println("Opção Inválida");
        }
    }

    public void ListarEnderecosCliente(int codigo) {
        ArrayList<String> enderecos = controleCliente.enderecosCliente(codigo);

        enderecos.forEach((endereco) -> {
            System.out.println(enderecos.indexOf(endereco) + " - " + endereco);
        });
    }

    public void mostrarMenu() {
        System.out.println("\n---------------------");
        System.out.println("      Digite:      ");
        System.out.println(" 1: Inserir cliente");
        System.out.println(" 2: Listar clientes");
        System.out.println(" 3: Alterar dados de cliente");
        System.out.println("---------------------\n");
    }

    public void mostrarMenuDados() {
        System.out.println("\n---------------------");
        System.out.println("      Digite para:      ");
        System.out.println(" 1: Editar  o nome: ");
        System.out.println(" 2: Editar o email: ");
        System.out.println(" 3: Editar o CPF: ");
        System.out.println(" 4: Editar o senha: ");
        System.out.println(" 5: Adicionar um endereço: ");
        System.out.println(" 6: Remover um endereço: ");
        System.out.println("---------------------\n");
    }

    public void mostrarMenuListagem() {
        System.out.println("\n---------------------");
        System.out.println("      Digite:      ");
        System.out.println("  1: Listar todos os Clientes ");
        System.out.println("  2: Filtrar Cliente por Nome ");
        System.out.println("---------------------\n");
    }
}
