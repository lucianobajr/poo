package br.ufv.caf.persistence;

import br.ufv.caf.model.Vendas;
import java.util.ArrayList;

public class VendasDAO {

    private static ArrayList<Vendas> vendas;

    public VendasDAO() {
        vendas = new ArrayList<>();
    }

    public void inserirVenda(Vendas p) {
        vendas.add(p);
    }

    public ArrayList<Vendas> listarVendas() {
        return vendas;
    }
    
    public Vendas listarPorCodigo(int codigo){
        for (Vendas venda : vendas) {
            if (venda.getCodigo()==codigo) {
                return venda;
            }
        }
        return null;
    }

    public ArrayList<Vendas> listarPorDataInicio(String data){
        ArrayList<Vendas> lista= new ArrayList<>();
        
        vendas.stream().filter(venda -> (venda.getDataInicio().equals(data))).forEachOrdered(venda -> {
            lista.add(venda);
        });
        return lista;
    }
    
    public ArrayList<Vendas> listarPorDataFinal(String data){
        ArrayList<Vendas> lista= new ArrayList<>();
        
        vendas.stream().filter(venda -> (venda.getDataFinal().equals(data))).forEachOrdered(venda -> {
            lista.add(venda);
        });
        return lista;
    }
    
    public int quantidadeVendas(){
        return vendas.size();
    }
}
