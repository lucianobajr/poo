package br.ufv.caf.controller;

import br.ufv.caf.persistence.BitsStringDAO;
import java.util.Arrays;

public class ControleBitsString {
    
    BitsStringDAO bits;
    
    public ControleBitsString(int size) {
        bits = new BitsStringDAO(size);
    }
    
    public void insereBit(int posicao, String valor) {
        bits.inserirBit(posicao, valor);
        System.out.println("\n");
        System.out.print("\u001B[" + "32" + "m");
        System.out.println("Bit inserido com sucesso!");
        System.out.println("\u001B[" + "m");
    }
    
    public String[] getArry() {
        return bits.getArray();
    }
    
    public String recuperarBit(int posicao) {
        return bits.recuperarBit(posicao);
    }
    
    public String listarBits() {
        return bits.listarBits();
    }
    
    public int tamanho() {
        return bits.tamanho();
    }
    
    public boolean equalsStrings(String[] arr) {
        return Arrays.equals(arr, bits.getArray());
    }
    
    public String[] and(String[] arr) {
        String[] arrResponse = new String[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            int aux = Integer.parseInt(bits.getArray()[i]) & Integer.parseInt(arr[i]);
            arrResponse[i] = String.valueOf(aux);
        }
        
        return arrResponse;
    }
    
    public String[] or(String[] arr) {
        String[] arrResponse = new String[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            int aux = Integer.parseInt(bits.getArray()[i]) | Integer.parseInt(arr[i]);
            arrResponse[i] = String.valueOf(aux);
        }
        
        return arrResponse;
    }
    
    public String[] not() {
        String[] arrResponse = new String[bits.tamanho()];
        
        for (int i = 0; i < bits.tamanho(); i++) {
            
            arrResponse[i] = Integer.parseInt(bits.getArray()[i]) == 1 ? "0" : "1";
        }
        
        return arrResponse;
    }
    
}
