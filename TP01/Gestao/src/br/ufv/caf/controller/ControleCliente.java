package br.ufv.caf.controller;

import br.ufv.caf.model.Cliente;
import br.ufv.caf.persistence.ClienteDAO;
import java.util.ArrayList;

public class ControleCliente {

    ClienteDAO clienteDAO;

    public ControleCliente() {
        clienteDAO = new ClienteDAO();
    }

    public void inserirCliente(String cpf, String nome, String email, String senha, ArrayList<String> enderecos) {
        Cliente novoCliente = new Cliente(geraCodigoCliente(), cpf, nome, email, senha, enderecos);

        Cliente cExiste = clienteDAO.pesquisa(cpf, email);

        if (cExiste != null) {
            System.err.println("Erro ao cadastrar Cliente! CPF ou E-mail já estão cadastrados.");

        } else {
            clienteDAO.inserirCliente(novoCliente);
            System.out.println("\n");
            System.out.print("\u001B[" + "32" + "m");
            System.out.println("Cliente castrado com sucesso!");
            System.out.println("\u001B[" + "m");
        }
    }

    public ArrayList<String> listarClientes() {
        ArrayList<String> clientesStr = new ArrayList<>();
        ArrayList<Cliente> clientes = clienteDAO.listarClientes();

        clientes.forEach((var p) -> {
            clientesStr.add(p.toString());
        });

        return clientesStr;
    }

    public String listaCliente(String nome) {
        String cliente = clienteDAO.pesquisaPorNome(nome);
        return cliente;
    }

    public Cliente listaClienteCodigo(int codigo) {
        Cliente cliente = clienteDAO.pesquisaCodigo(codigo);
        return cliente;
    }

    public ArrayList<String> enderecosCliente(int codigo) {
        Cliente cliente = clienteDAO.pesquisaCodigo(codigo);
        if (cliente != null) {
            ArrayList<String> enderecos = cliente.getEnderecos();
            return enderecos;
        } else {
            System.err.println("Cliente não encontrado!");
        }
        return null;
    }

    public int geraCodigoCliente() {
        return clienteDAO.quantidadeClientes() + 1;
    }

    public void editarNome(String nome, int codigo) {
        Cliente cliente = clienteDAO.pesquisaCodigo(codigo);
        if (cliente != null) {
            clienteDAO.editarNome(nome, cliente);
        } else {
            System.err.println("Cliente não encontrado!");
        }

    }

    public void editarCPF(String cpf, int codigo) {
        Cliente cliente = clienteDAO.pesquisaCodigo(codigo);
        if (cliente != null) {
            clienteDAO.editarCPF(cpf, cliente);
        } else {
            System.err.println("Cliente não encontrado!");
        }
    }

    public void editarSenha(String senha, int codigo) {
        Cliente cliente = clienteDAO.pesquisaCodigo(codigo);
        if (cliente != null) {
            clienteDAO.editarSenha(senha, cliente);
        } else {
            System.err.println("Cliente não encontrado!");
        }
    }

    public void editarEmail(String email, int codigo) {
        Cliente cliente = clienteDAO.pesquisaCodigo(codigo);
        if (cliente != null) {
            clienteDAO.editarEmail(email, cliente);
        } else {
            System.err.println("Cliente não encontrado!");
        }
    }

    public void adicionarEndereco(String endereco, int codigo) {
        Cliente cliente = clienteDAO.pesquisaCodigo(codigo);
        if (cliente != null) {
            clienteDAO.adicionarEndereco(endereco, cliente);
        } else {
            System.err.println("Cliente não encontrado!");
        }
    }

    public void removerEndereco(int posicaoEndereco, int codigo) {
        Cliente cliente = clienteDAO.pesquisaCodigo(codigo);
        if (cliente != null) {
            clienteDAO.removeEndereco(posicaoEndereco, cliente);
        } else {
            System.err.println("Cliente não encontrado!");
        }
    }
}