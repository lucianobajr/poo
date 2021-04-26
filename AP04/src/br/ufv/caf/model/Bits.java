package br.ufv.caf.model;

import java.util.Arrays;

public class Bits implements BitsInterface{

    final private int[] array;

    public Bits(int size) {
        this.array = new int[size];
    }
    
    @Override
    public int[] getArray() {
        return array;
    }

    public void setArray(int posicao, int valor) {
        this.array[posicao] = valor;
    }
    @Override
    public int size(){
        return array.length;
    }
    
    public int getBit(int posicao){
        return array[posicao];
    }
    
    @Override
    public String toString(){
        return Arrays.toString(this.array);
    }
}
