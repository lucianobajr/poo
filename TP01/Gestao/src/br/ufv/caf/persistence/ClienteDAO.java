package br.ufv.caf.persistence;

import br.ufv.caf.model.Cliente;
import java.util.ArrayList;

public class ClienteDAO {
    private static ArrayList<Cliente> clientes;

    public ClienteDAO() {
        clientes = new ArrayList<>();
    }

    public void inserirCliente(Cliente p) {
        clientes.add(p);
    }

    public Cliente pesquisa(String cpf, String email) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
            if (cliente.getEmail().equals(email)) {
                return cliente;
            }
        }
        return null;
    }

    public String pesquisaPorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente.toString();
            }
        }
        return null;
    }

    public Cliente pesquisaCodigo(int codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                return cliente;
            }

        }
        return null;
    }

    public ArrayList<Cliente> listarClientes() {
        return clientes;
    }

    public void editarNome(String nome, Cliente cliente) {
        cliente.setNome(nome);
    }

    public void editarCPF(String cpf, Cliente cliente) {
        cliente.setCpf(cpf);
    }

    public void editarSenha(String senha, Cliente cliente) {
        cliente.setSenha(senha);
    }

    public void editarEmail(String email, Cliente cliente) {
        cliente.setEmail(email);
    }

    public void adicionarEndereco(String email, Cliente cliente) {
        cliente.addEndereco(email);
    }

    public void removeEndereco(int posicaoEndereco, Cliente cliente) {
        cliente.removeEndereco(posicaoEndereco);
    }

    public int quantidadeClientes() {
        return clientes.size();
    }
}
