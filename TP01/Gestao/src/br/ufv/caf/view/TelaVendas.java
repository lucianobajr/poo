package br.ufv.caf.view;

import br.ufv.caf.controller.ControleVendas;
import br.ufv.caf.controller.ControleCliente;
import br.ufv.caf.controller.ControleProduto;
import br.ufv.caf.model.Vendas;
import br.ufv.caf.model.Cliente;
import br.ufv.caf.model.Produto;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public class TelaVendas {

    final private Scanner scan;
    final private ControleVendas controleVendas;
    final private ControleCliente controleClientes;
    final private ControleProduto controleProdutos;

    public TelaVendas() {
        scan = new Scanner(System.in);
        controleVendas = new ControleVendas();
        controleClientes = new ControleCliente();
        controleProdutos = new ControleProduto();
    }

    public void telaInicial() {
        if (controleProdutos.listarProdutos().isEmpty()) {
            System.out.print("Nenhum produto cadastrado!");
        } else if (controleClientes.listarClientes().isEmpty()) {
            System.out.print("Nenhum cliente cadastrado!");
        } else {
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
                            telaAlterarStatus();
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
    }

    private void telaInserir() {
        int posicaoEndereco, codigoCliente, codigo;
        double total = 0;
        String endereco;
        ArrayList<String> produtos = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();

        System.out.print("Digite o código o Cliente: ");
        codigoCliente = scan.nextInt();

        Cliente cliente = controleClientes.listaClienteCodigo(codigoCliente);
        System.out.print("Digite o código do endereço do Cliente: ");
        posicaoEndereco = scan.nextInt();

        endereco = cliente.getEndereco(posicaoEndereco - 1);

        while (true) {

            System.out.print("Digite o código do produto ou zero para encerrar: ");
            codigo = scan.nextInt();
            System.out.println("\n");
            if (codigo != 0) {
                Produto produto = controleProdutos.pesquisa(codigo);
                System.out.println(produto.toString());

                if (produto.getEstoque() > 0) {
                    System.out.print("Quantidade do produto: ");
                    int quantidade = scan.nextInt();
                    if (produto.getEstoque() >= quantidade && quantidade != 0) {
                        produtos.add("Codigo: " + produto.getCodigo() + " - Nome: " + produto.getNome() + " - Valor: R$ " + produto.getValor());
                        quantidades.add(quantidade);
                        total = total + (quantidade * produto.getValor());
                        int novoEstoque = produto.getEstoque() - quantidade;
                        controleProdutos.alterarEstoque(codigo, novoEstoque);
                    } else if (quantidade == 0) {
                        System.err.println("Quantidade digitada é inválida!");
                        break;
                    } else if (produto.getEstoque() < quantidade) {
                        System.err.println("Quantidade maior do que disponível em estoque!");
                        break;
                    }

                } else {
                    System.err.println("Produto sem estoque!");
                    break;
                }
            } else {
                break;
            }
        }
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        String dataInicio = formatador.format(data);

        controleVendas.inserVenda(Vendas.Status.pendente, cliente, endereco, produtos, quantidades, total, dataInicio);

    }

    private void telaListarTodos() {
        ArrayList<String> vendas = controleVendas.listarVendas();
        System.out.println("\nTotal de vendas: " + vendas.size());

        vendas.forEach(v -> {
            System.out.println(v);
        });
    }

    private void telaListarDataInicio() {
        System.out.print("Digite a data de início (dd-MM-yyyy): ");
        String dataInicio = scan.next();
        ArrayList<String> vendas = controleVendas.listarVendaPorDataInicio(dataInicio);

        if (vendas == null) {
            System.err.println("Nenhuma venda encontrada!");
        } else {
            vendas.forEach(v -> {
                System.out.println(v);
            });
        }
    }

    private void telaListarDataFinal() {
        System.out.print("Digite a data de fim (dd-MM-yyyy): ");
        String dataFinal = scan.next();
        ArrayList<String> vendasFinal = controleVendas.listarVendaPorDataFinal(dataFinal);

        if (vendasFinal == null) {
            System.err.println("Nenhuma venda encontrada!");
        } else {
            vendasFinal.forEach(v -> {
                System.out.println(v);
            });
        }
    }

    private void telaAlterarStatus() {
        int codigo;
        System.out.print("Digite o código da Venda: ");
        codigo = scan.nextInt();

        Vendas venda = controleVendas.listarVendaPorCodigo(codigo);

        if (venda != null) {
            mostrarMenuStatus();
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    controleVendas.alteraStatusVenda(venda, Vendas.Status.em_andamento);
                    break;
                case 2:
                    controleVendas.alteraStatusVenda(venda, Vendas.Status.entregue);
                    break;
                default:
                    System.err.println("Opção Inválida");
            }
        } else {
            System.out.print("Venda não encontrada!");
        }
    }

    private void telaListar() {
        mostrarMenuListar();
        int option;

        option = scan.nextInt();
        switch (option) {
            case 1:
                telaListarTodos();
                break;
            case 2:
                telaListarDataInicio();
                break;
            case 3:
                telaListarDataFinal();
                break;
            default:
                System.err.println("Opção Inválida");
        }
    }

    public void mostrarMenu() {
        System.out.println("\n---------------------");
        System.out.println("      Digite:      ");
        System.out.println("  1: Inserir Venda ");
        System.out.println("  2: Listar Vendas ");
        System.out.println("  3: Alterar o status de Venda");
        System.out.println("---------------------\n");
    }

    public void mostrarMenuListar() {
        System.out.println("\n---------------------");
        System.out.println("      Digite:      ");
        System.out.println("  1: Listar todas as Vendas ");
        System.out.println("  2: Filtrar Venda por data de início ");
        System.out.println("  3: Filtrar Venda por data de fim");
        System.out.println("---------------------\n");
    }

    public void mostrarMenuStatus() {
        System.out.println("\n---------------------");
        System.out.println("Digite o novo código do status :   ");
        System.out.println("  1: Em andamento ");
        System.out.println("  2: Entregue");
        System.out.println("---------------------\n");
    }
}
