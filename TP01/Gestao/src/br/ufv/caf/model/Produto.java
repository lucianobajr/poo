package br.ufv.caf.model;

public class Produto {

    final private int codigo;
    private String nome;
    private String descricao;
    private int estoque;
    private String categoria;
    private double valor;

    public Produto(int codigo, String nome, String descricao, int estoque, String categoria, double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = estoque;
        this.categoria = categoria;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "---------------------------"
                + "\nCódigo " + this.codigo + "\n"
                + "Nome: " + this.nome + "\n"
                + "Descrição: " + this.descricao + "\n"
                + "Categoria: " + this.categoria + "\n"
                + "Valor: R$ " + this.valor + "\n"
                + "Quantidade em estoque: " + this.estoque
                + "\n---------------------------";
    }
}
