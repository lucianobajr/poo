package ap02;

import java.text.DecimalFormat;

/**
 *
 * @author Luciano Belo - 3897
 */
public class AP02 {

    public enum TipoContrato {
        Efetivo, Horista
    }

    private static class Funcionario {

        private final String nome;
        private final String dataNascimento;
        private TipoContrato tipoContratoFuncionario;
        private double salario;
        private int numFilhosMenores;
        private String dataAdmissao;

        public Funcionario(String nome, String dataNascimento) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
        }

        public void contratar(
                TipoContrato tipoContratoFuncionario,
                double salario,
                int numFilhosMenores,
                String dataAdmissao
        ) {
            this.tipoContratoFuncionario = tipoContratoFuncionario;
            this.salario = salario;
            this.numFilhosMenores = numFilhosMenores;
            this.dataAdmissao = dataAdmissao;
        }

        public String getNome() {
            return nome;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public TipoContrato getTipoContrato() {
            return tipoContratoFuncionario;
        }

        public double getSalario() {
            return salario;
        }

        public int getNumFilhosMenores() {
            return numFilhosMenores;
        }

        public String getDataAdmissao() {
            return dataAdmissao;
        }

        public void setTipoContrato(TipoContrato contrato) {
            this.tipoContratoFuncionario = contrato;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public void setNumFilhosMenores(int numFilhosMenores) {
            this.numFilhosMenores = numFilhosMenores;
        }

        public void setDataAdmissao(String dataAdmissao) {
            this.dataAdmissao = dataAdmissao;
        }

        public double calculaSalarioBruto(int horas) {
            double finalSalario = 0;
            if (this.tipoContratoFuncionario == TipoContrato.Efetivo) {
                finalSalario = this.salario;
            } else {
                finalSalario = horas * this.salario;
            }

            return finalSalario;
        }

        public double descontoInss(double salarioBruto) {
            double desconto = 0;
            if (salarioBruto <= 1659.38) {
                desconto = (salarioBruto * 8) / 100;
            } else if (salarioBruto > 1659.38 && salarioBruto <= 2765.66) {
                desconto = (salarioBruto * 9) / 100;
            } else if (salarioBruto > 2765.66 && salarioBruto <= 5531.31) {
                desconto = (salarioBruto * 11) / 100;
            } else if (salarioBruto > 5531.31) {
                desconto = (5531.31 * 11) / 100;
            }

            return desconto;
        }

        public double descontoImpostoRenda(double salarioBruto) {
            double desconto = 0;
            double inss = this.descontoInss(salarioBruto);

            if (salarioBruto <= 1903.98) {
                desconto = 0;
            } else if (salarioBruto > 1903.98 && salarioBruto <= 2826.65) {
                desconto = (((salarioBruto - inss) * 7.5) / 100) - 142.80;
            } else if (salarioBruto > 2826.65 && salarioBruto <= 3751.05) {
                desconto = (((salarioBruto - inss) * 15) / 100) - 354.80;
            } else if (salarioBruto > 3751.05 && salarioBruto <= 4664.68) {
                desconto = (((salarioBruto - inss) * 22.5) / 100) - 636.13;
            } else if (salarioBruto > 4664.68) {
                desconto = (((salarioBruto - inss) * 27.5) / 100) - 869.36;
            }

            return desconto;
        }

        public double salarioLiquido(double salarioBruto) {
            double inss = this.descontoInss(salarioBruto);
            double impostoRenda = this.descontoImpostoRenda(salarioBruto);
            double salarioLiquido = salarioBruto - (inss + impostoRenda);
            return salarioLiquido;
        }

        public void folhaPagamento(double salarioBruto) {
            DecimalFormat formatador = new DecimalFormat("0.00");
            double inss = this.descontoInss(salarioBruto);
            double impostoRenda = this.descontoImpostoRenda(salarioBruto);
            double salarioLiquido = this.salarioLiquido(salarioBruto);

            System.out.println("SALÁRIO BRUTO: " + formatador.format(salarioBruto));
            System.out.println("DESCONTO INSS: " + formatador.format(inss));
            System.out.println("DESCONTO IMPOSTO DE RENDA: " + formatador.format(impostoRenda));
            System.out.println("SALÁRIO LÍQUIDO: " + formatador.format(salarioLiquido));
        }
    }

    public static void main(String[] args) {
        /*FUNCIONARIO HORISTA*/
        System.out.println("\nFUNCIONARIO HORISTA\n");
        Funcionario novoFuncionarioHorista = new Funcionario(
                "Luciano",
                "28/12/99"
        );
        novoFuncionarioHorista.contratar(TipoContrato.Horista, 15, 1, "10/03/2019");

        novoFuncionarioHorista.folhaPagamento(novoFuncionarioHorista.calculaSalarioBruto(240));
        /*FUNCIONARIO HORISTA*/
        
        /*FUNCIONARIO EFETIVO*/    
        System.out.println("\nFUNCIONARIO EFETIVO\n");
        Funcionario novoFuncionarioEfetivo = new Funcionario(
                "Jorge",
                "09/09/2000"
        );
        novoFuncionarioEfetivo.contratar(TipoContrato.Efetivo, 4000, 1, "10/12/2016");

        novoFuncionarioEfetivo.folhaPagamento(novoFuncionarioEfetivo.calculaSalarioBruto(240));
        /*FUNCIONARIO EFETIVO*/

    }

}
