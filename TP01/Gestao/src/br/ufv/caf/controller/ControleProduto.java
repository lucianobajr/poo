package br.ufv.caf.controller;

import br.ufv.caf.model.Produto;
import br.ufv.caf.persistence.ProdutoDAO;
import java.util.ArrayList;

public class ControleProduto {

    ProdutoDAO produtoDAO;

    public ControleProduto() {
        produtoDAO = new ProdutoDAO();
    }

    public void inserirProduto(String nome, String descricao, int estoque, String categoria, double valor) {
        Produto novoProduto = new Produto(geraCodigo(), nome, descricao, estoque, categoria, valor);
        produtoDAO.inserirProduto(novoProduto);
        System.out.println("\n");
        System.out.print("\u001B[" + "32" + "m");
        System.out.println("Produto castrado com sucesso!");
        System.out.println("\u001B[" + "m");
    }

    public ArrayList<String> listarProdutos() {
        ArrayList<String> produtosStr = new ArrayList<>();
        ArrayList<Produto> produtos = produtoDAO.listarProdutos();

        produtos.forEach((var p) -> {
            produtosStr.add(p.toString());
        });

        return produtosStr;
    }

    public String listarProduto(String nome) {
        Produto produto = produtoDAO.pesquisaNome(nome);

        if (produto == null) {
            System.err.println("Produto não encontrado!");
            return null;

        } else {
            return produto.toString();
        }

    }
    
    public Produto pesquisa(int codigo){
        Produto produto = produtoDAO.pesquisa(codigo);
        return produto;
    }

    public int geraCodigo() {
        return produtoDAO.quantidadeProdutos() + 1;
    }

    public void alterarEstoque(int codigo, int estoque) {
        Produto produto = produtoDAO.pesquisa(codigo);
        if (produto == null) {
            System.err.println("Produto não encontrado!");
        } else {
            produto.setEstoque(estoque);
            System.out.println("\n");
            System.out.print("\u001B[" + "32" + "m");
            System.out.println("Estoque alterado com sucesso!");
            System.out.println("\u001B[" + "m");
        }
    }

}
