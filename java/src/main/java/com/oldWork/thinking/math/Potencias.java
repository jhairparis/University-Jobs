package com.oldWork.thinking.math;

import com.utils.Tidbits;

public class Potencias {
    static int x = 2;

    public static int miPow(int exponente) {
        int resultado = 1;
        for (int f = 1; f <= exponente; f++) {
            resultado = resultado * x;
        }
        return resultado;
    }

    public static void main(String[] args) {
        Tidbits.ClearConsole();

        int exponente = 2;
        int serie = 1;

        for (int i = 1; i <= 4; i++) {
            if (i % 2 == 0) {
                serie += miPow(exponente);
            } else {
                serie -= miPow(exponente);
            }
            System.out.println("Valor de serie: "+serie);
            exponente += 2;
        }
        System.out.println("\n");
        System.out.println(serie);
    }
}
