package ap03;
/**
 * @author Luciano Belo - 3897
 */
public class Estoque {
    final private Refrigerante refrigerante1;
    final private Refrigerante refrigerante2;
    final private Refrigerante refrigerante3;
    final private Refrigerante refrigerante4;
    final private Refrigerante refrigerante5;
    
    private int quantidade1;
    private int quantidade2;
    private int quantidade3;
    private int quantidade4;
    private int quantidade5;
    
    
    public int getQuantidade1(){
        return this.quantidade1;
    }
    
    public int getQuantidade2(){
        return this.quantidade2;
    }
    
    public int getQuantidade3(){
        return this.quantidade3;
    }
    
    public int getQuantidade4(){
        return this.quantidade4;
    }
    
    public int getQuantidade5(){
        return this.quantidade5;
    }
    
    public Refrigerante getRefrigerante1(){
        return this.refrigerante1;
    }
    
    public Refrigerante getRefrigerante2(){
        return this.refrigerante2;
    }
    
    public Refrigerante getRefrigerante3(){
        return this.refrigerante3;
    }
    
    public Refrigerante getRefrigerante4(){
        return this.refrigerante4;
    }
    
    public Refrigerante getRefrigerante5(){
        return this.refrigerante5;
    }
    
    public void setQuantidade1(int quantidade){
        this.quantidade1 = quantidade;
    }
    
    public void setQuantidade2(int quantidade){
        this.quantidade2 = quantidade;
    }
    
    public void setQuantidade3(int quantidade){
        this.quantidade3 = quantidade;
    }
    
    public void setQuantidade4(int quantidade){
        this.quantidade4 = quantidade;
    }
    
    public void setQuantidade5(int quantidade){
        this.quantidade5 = quantidade;
    }
    
    public void alteraValor1(double valor){
        this.refrigerante1.setValor(valor);
    }
    public void alteraValor2(double valor){
        this.refrigerante2.setValor(valor);
    }
    public void alteraValor3(double valor){
        this.refrigerante3.setValor(valor);
    }
    public void alteraValor4(double valor){
        this.refrigerante4.setValor(valor);
    }
    public void alteraValor5(double valor){
        this.refrigerante5.setValor(valor);
    }
    
    public void alteraNome1(String nome){
        this.refrigerante1.setNome(nome);
    }
    public void alteraNome2(String nome){
        this.refrigerante2.setNome(nome);
    }
    public void alteraNome3(String nome){
        this.refrigerante3.setNome(nome);
    }
    public void alteraNome4(String nome){
        this.refrigerante4.setNome(nome);
    }
    public void alteraNome5(String nome){
        this.refrigerante5.setNome(nome);
    }
    
    public int estoqueX(int codigo){
        int value = 0;
        switch (codigo) {
            case 1:
                value = this.getQuantidade1();
                break;
            case 2:
                value = this.getQuantidade2();
                break;
            case 3:
                value = this.getQuantidade3();
                break;
            case 4:
                value = this.getQuantidade4();
                break;
            case 5:
                value = this.getQuantidade5();
                break;
            default:
                break;
        }
        
        return value;
    }
  
    
    public Refrigerante refrigeranteX(int codigo){
        Refrigerante value = null;
        switch (codigo) {
            case 1:
                value = this.refrigerante1;
                break;
            case 2:
                value = this.refrigerante2;
                break;
            case 3:
                value = this.refrigerante3;
                break;
            case 4:
                value = this.refrigerante4;
                break;
            case 5:
                value = this.refrigerante5;
                break;
            default:
                break;
        }
        
        return value;
    }
    
    public void alteraEstoqueX(int codigo,int novaQuantidade){
        
        switch (codigo) {
            case 1:
                this.quantidade1 = novaQuantidade;
                break;
            case 2:
               this.quantidade2 = novaQuantidade;
                break;
            case 3:
                this.quantidade3 = novaQuantidade;
                break;
            case 4:
                this.quantidade4 = novaQuantidade;
                break;
            case 5:
               this.quantidade5 = novaQuantidade;
                break;
            default:
                break;
        }
        
       
    }
    
    Estoque(double valor1,double valor2,double valor3,double valor4,double valor5,String nome1,String nome2,String nome3,String nome4,String nome5){
        this.quantidade1 = 20;
        this.quantidade2 = 20;
        this.quantidade3 = 20;
        this.quantidade4 = 20;
        this.quantidade5 = 20;
        
        this.refrigerante1  = new Refrigerante(valor1,nome1);
        this.refrigerante2 = new Refrigerante(valor2,nome2);
        this.refrigerante3 = new Refrigerante(valor3,nome3);
        this.refrigerante4 = new Refrigerante(valor4,nome4);
        this.refrigerante5 = new Refrigerante(valor5,nome5);
    }
}
