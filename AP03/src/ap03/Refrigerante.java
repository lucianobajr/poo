package ap03;
/**
 * @author Luciano - 3897
 */
public class Refrigerante {
    private String nome;
    private double valor;

    public String getNome(){
        return this.nome;
    }

    public double getValor(){
        return this.valor;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setValor(double valor){
        this.valor = valor;
    }
    
    Refrigerante(double valor,String nome){
        this.nome = nome;
        this.valor = valor;
    }
}
