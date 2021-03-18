package ap02;

import ap02.Funcionario.TipoContrato;
/**
 *
 * @author Luciano Belo - 3897
 */
public class Main {
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
                "Laura",
                "23/09/2000"
        );
        novoFuncionarioEfetivo.contratar(TipoContrato.Efetivo, 4000, 1, "10/12/2016");

        novoFuncionarioEfetivo.folhaPagamento(novoFuncionarioEfetivo.calculaSalarioBruto(240));
        /*FUNCIONARIO EFETIVO*/

        /*FUNCIONARIO HORISTA*/
        System.out.println("\nFUNCIONARIO HORISTA\n");
        Funcionario novoFuncionarioHoristaDois = new Funcionario(
                "Guilherme Henrique",
                "17/03/2000"
        );
        novoFuncionarioHoristaDois.contratar(TipoContrato.Horista, 60, 1, "25/06/2012");

        novoFuncionarioHoristaDois.folhaPagamento(novoFuncionarioHoristaDois.calculaSalarioBruto(240));
        /*FUNCIONARIO HORISTA*/

        /*FUNCIONARIO EFETIVO*/
        System.out.println("\nFUNCIONARIO EFETIVO\n");
        Funcionario novoFuncionarioEfetivoDois = new Funcionario(
                "Jorge",
                "09/09/2000"
        );
        novoFuncionarioEfetivoDois.contratar(TipoContrato.Efetivo, 1800, 1, "8/12/2020");

        novoFuncionarioEfetivoDois.folhaPagamento(novoFuncionarioEfetivoDois.calculaSalarioBruto(240));
        /*FUNCIONARIO EFETIVO*/
    }
}
