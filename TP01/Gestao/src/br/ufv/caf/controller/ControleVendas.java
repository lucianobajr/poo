package br.ufv.caf.controller;

import br.ufv.caf.model.Vendas;
import br.ufv.caf.model.Cliente;
import br.ufv.caf.model.Vendas.Status;
import br.ufv.caf.persistence.VendasDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ControleVendas {

    VendasDAO vendasDAO;

    public ControleVendas() {
        vendasDAO = new VendasDAO();
    }

    public void inserVenda(
            Vendas.Status status,
            Cliente cliente,
            String endereco,
            ArrayList<String> produtos,
            ArrayList<Integer> quantidades,
            double total,
            String dataInicio
    ) {
        Vendas novaVenda = new Vendas(geraCodigo(), status, cliente, endereco, produtos, quantidades, total, dataInicio);
        vendasDAO.inserirVenda(novaVenda);
        System.out.print("\u001B[" + "32" + "m");
        System.out.println("Nova venda realizada com sucesso!");
        System.out.println("\u001B[" + "m");
    }

    public ArrayList<String> listarVendas() {
        ArrayList<String> vendasStr = new ArrayList<>();
        ArrayList<Vendas> vendas = vendasDAO.listarVendas();

        vendas.forEach((var v) -> {
            vendasStr.add(v.toString());
        });

        return vendasStr;
    }

    public Vendas listarVendaPorCodigo(int codigo) {
        Vendas venda = vendasDAO.listarPorCodigo(codigo);
        return venda;
    }

    public ArrayList<String> listarVendaPorDataInicio(String data) {
        ArrayList<Vendas> vendas = vendasDAO.listarPorDataInicio(data);

        if (vendas.isEmpty()) {
            return null;
        } else {
            ArrayList<String> lista = new ArrayList<>();
            vendas.forEach((var v) -> {
                lista.add(v.toString());
            });
            return lista;
        }

    }

    public ArrayList<String> listarVendaPorDataFinal(String dataFinal) {
        ArrayList<Vendas> vendas = vendasDAO.listarPorDataFinal(dataFinal);
        
        if (vendas.isEmpty()) {
            return null;
        } else {
            ArrayList<String> lista = new ArrayList<>();
            vendas.forEach((var v) -> {
                lista.add(v.toString());
            });
            return lista;
        }
    }

    public void alteraStatusVenda(Vendas venda, Status status) {
        venda.setStatus(status);
        if (status == Status.entregue) {
            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
            String dataFinal = formatador.format(data);

            venda.setDataFinal(dataFinal);
        }

        System.out.print("\u001B[" + "32" + "m");
        System.out.println("Status atualizado com sucesso!");
        System.out.println("\u001B[" + "m");
    }

    public int geraCodigo() {
        return vendasDAO.quantidadeVendas() + 1;
    }
}
