package br.ufv.caf.model;

import java.util.ArrayList;

public class Cliente {
    final private int codigo;
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    final private ArrayList<String> enderecos;

    public Cliente(int codigo, String cpf, String nome, String email, String senha, ArrayList<String> enderecos) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.enderecos = enderecos;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco(int posicao) {
        return enderecos.get(posicao);
    }

    public void addEndereco(String novoEndereco) {
        this.enderecos.add(novoEndereco);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void removeEndereco(int posicao) {
        this.enderecos.remove(posicao);
    }

    public ArrayList<String> getEnderecos() {
        return enderecos;
    }

    @Override
    public String toString() {
        return "---------------------------"
                + "\nCódigo: " + this.codigo + "\n"
                + "CPF: " + this.cpf + "\n"
                + "Nome: " + this.nome + "\n"
                + "Email: " + this.email + "\n"
                + "Endereços: " + this.enderecos
                + "\n---------------------------";
    }
}