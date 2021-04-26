package br.ufv.caf.controller;

import br.ufv.caf.persistence.BitsDAO;
import java.util.Arrays;

public class ControleBits {

    BitsDAO bits;

    public ControleBits(int size) {
        bits = new BitsDAO(size);
    }

    public void insereBit(int posicao, int valor) {
        bits.inserirBit(posicao, valor);
        System.out.println("\n");
        System.out.print("\u001B[" + "32" + "m");
        System.out.println("Bit inserido com sucesso!");
        System.out.println("\u001B[" + "m");
    }

    public int[] getArry() {
        return bits.getArray();
    }

    public int recuperarBit(int posicao) {
        return bits.recuperarBit(posicao);
    }

    public String listarBits() {
        return bits.listarBits();
    }

    public int tamanho() {
        return bits.tamanho();
    }

    public boolean equals(int[] arr) {
        return Arrays.equals(arr, bits.getArray());
    }

    public int[] and(int[] arr) {
        int[] arrResponse = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arrResponse[i] = bits.getArray()[i] & arr[i];
        }

        return arrResponse;
    }

    public int[] or(int[] arr) {
        int[] arrResponse = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arrResponse[i] = bits.getArray()[i] | arr[i];
        }

        return arrResponse;
    }

    public int[] not() {
        int[] arrResponse = new int[bits.tamanho()];

        for (int i = 0; i < bits.tamanho(); i++) {
            arrResponse[i] = bits.getArray()[i] == 1 ? 0 : 1;
        }

        return arrResponse;
    }
}
