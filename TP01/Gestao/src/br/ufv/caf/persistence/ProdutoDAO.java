package br.ufv.caf.persistence;

import br.ufv.caf.model.Produto;
import java.util.ArrayList;

public class ProdutoDAO {

    private static ArrayList<Produto> produtos;

    public ProdutoDAO() {
        produtos = new ArrayList<>();
    }

    public void inserirProduto(Produto p) {
        produtos.add(p);
    }

    public Produto pesquisa(int codigo) {
        for (Produto product : produtos) {
            if (product.getCodigo() == codigo) {
                return product;
            }
        }
        return null;
    }

    public Produto pesquisaNome(String nome) {
        for (Produto product : produtos) {
            if (product.getNome().contains(nome)) {
                return product;
            }
        }
        return null;
    }

    public ArrayList<Produto> listarProdutos() {
        return produtos;
    }

    public int quantidadeProdutos() {
        return produtos.size();
    }
}
