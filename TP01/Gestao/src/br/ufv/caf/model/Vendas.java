package br.ufv.caf.model;

import java.util.ArrayList;

public class Vendas {

    public enum Status {
        pendente, em_andamento, entregue
    }

    final private int codigo;
    private Status status;
    final private Cliente cliente;
    final private ArrayList<String> produtos;
    final private ArrayList<Integer> quantidades;
    final private String endereco;
    final private double total;
    final private String dataInicio;
    private String dataFinal;

    public Vendas(int codigo,
            Status status,
            Cliente cliente,
            String endereco,
            ArrayList<String> produtos,
            ArrayList<Integer> quantidades,
            double total,
            String dataInicio
    ) {
        this.codigo = codigo;
        this.status = status;
        this.cliente = cliente;
        this.endereco = endereco;
        this.produtos = produtos;
        this.quantidades = quantidades;
        this.total = total;
        this.dataInicio = dataInicio;
        this.dataFinal = " ";
    }

    public int getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status.toString();
    }

    public ArrayList<String> getProdutos() {
        return produtos;
    }

    public ArrayList<Integer> getQuantidades() {
        return quantidades;
    }

    public double getTotal() {
        return total;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCliente() {
        return cliente.toString();
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getDataInicio() {
        return this.dataInicio;
    }

    public String getDataFinal() {
        return this.dataFinal;
    }

    public void setDataFinal(String data) {
        this.dataFinal = data;
    }

    @Override
    public String toString() {
        if (this.status == Status.entregue) {
            return "---------------------------"
                    + "\nCódigo da Compra: " + this.codigo + "\n"
                    + "Data da Venda: " + this.dataInicio + "\n"
                    + "Data da Entrega: " + this.dataFinal + "\n"
                    + "Cliente: " + "Código: " + this.cliente.getCodigo() + "- Nome: " + this.cliente.getNome() + "\n"
                    + "Status: " + this.status + "\n"
                    + "Endereço: " + this.endereco + "\n"
                    + "Produtos: " + this.produtos + "\n"
                    + "Quantidades: " + this.quantidades.toString() + "\n"
                    + "Valor total: R$" + this.total + "\n"
                    + "\n---------------------------";
        } else {
            return "---------------------------"
                    + "\nCódigo da Compra: " + this.codigo + "\n"
                    + "Data da Venda: " + this.dataInicio + "\n"
                    + "Cliente: " + "Código: " + this.cliente.getCodigo() + "- Nome: " + this.cliente.getNome() + "\n"
                    + "Status: " + this.status + "\n"
                    + "Endereço: " + this.endereco + "\n"
                    + "Produtos: " + this.produtos + "\n"
                    + "Quantidades: " + this.quantidades.toString() + "\n"
                    + "Valor total: R$" + this.total + "\n"
                    + "\n---------------------------";
        }

    }
}
