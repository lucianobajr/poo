package ap03;
/**
 * @author Luciano - 3897
 */
public class MaquinaRefrigerante {
    private double saldo;
    private Estoque estoque;
    private double credito;

    public double getSaldo(){
        return this.saldo;
    }

    public double getCredito(){
        return this.credito;
    }
    
    public Estoque getEstoque(){
        return this.estoque;
    }

    public void receveCredito(double valor){
        this.credito+=valor;
    }

    public MaquinaRefrigerante(double valor1,double valor2,double valor3,double valor4,double valor5,String nome1,String nome2,String nome3,String nome4,String nome5) {
        this.saldo = 10.00;
        this.credito = this.saldo;
        this.estoque = new Estoque(valor1,valor2,valor3,valor4,valor5,nome1,nome2,nome3,nome4,nome5);
    }
    
    public boolean verificarNoEstoque(int codigoRefrigerante){
        int aux = this.estoque.estoqueX(codigoRefrigerante);
        
        return aux>0;
    }
    
    public void creditar (double valor){
        this.saldo +=valor;
    }
    
    public boolean podeComprar(int codigoRefrigerante,double credito){
       boolean comprar = false;
       
        switch (codigoRefrigerante) {
            case 1:
                comprar = credito>=this.estoque.getRefrigerante1().getValor();
                break;
            case 2:
                comprar = credito>=this.estoque.getRefrigerante2().getValor();
                break;
            case 3:
                comprar = credito>=this.estoque.getRefrigerante3().getValor();
                break;
            case 4:
                comprar = credito>=this.estoque.getRefrigerante4().getValor();
                break;
            case 5:
                comprar = credito>=this.estoque.getRefrigerante5().getValor();
                break;
            default:
                break;
        }
       
       return comprar;
    }
    
    public void comprar(int codigoRefrigerante,double credito){
        Refrigerante comprado = this.estoque.refrigeranteX(codigoRefrigerante);
        double troco = credito-comprado.getValor();
       
        System.out.println("SEU TROCO SERÁ DE: R$"+troco);
        this.estoque.alteraEstoqueX(codigoRefrigerante,(this.estoque.estoqueX(codigoRefrigerante) - 1));
        this.creditar(comprado.getValor());
    }
   
    @Override
    public String toString(){
        return "\n ______________________________________\n"+
               "\n         INFORMAÇÕES DA MÁQUINA         \n"+
               " ______________________________________"+
               "\n\n          SALDO ATUAL: R$"+this.saldo+
               "\n ______________________________________\n"+
               "\n                ESTOQUE                \n"+
               " ______________________________________\n\n"+
               "            " +this.estoque.getRefrigerante1().getNome()+": "+this.estoque.getQuantidade1()+"\n"+
               "            " +this.estoque.getRefrigerante2().getNome()+": "+this.estoque.getQuantidade2()+"\n"+
               "            " +this.estoque.getRefrigerante3().getNome()+": "+this.estoque.getQuantidade3()+"\n"+
               "            " +this.estoque.getRefrigerante4().getNome()+": "+this.estoque.getQuantidade4()+"\n"+
               "            " +this.estoque.getRefrigerante5().getNome()+": "+this.estoque.getQuantidade5()+"\n"
        ;
    }
}
