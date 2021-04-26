package br.ufv.caf.model;

import java.util.Arrays;

public class BitsString implements BitsInterface {

    final private String array[];

    public BitsString(int size) {
        this.array = new String[size];
    }

    @Override
    public String[] getArray() {
        return array;
    }

    public void setArray(int posicao, String valor) {
        this.array[posicao] = valor;
    }

    @Override
    public int size() {
        return array.length;
    }

    public String getBit(int posicao) {
        return array[posicao];
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
}
