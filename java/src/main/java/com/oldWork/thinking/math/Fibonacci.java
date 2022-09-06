package com.oldWork.thinking.math;

import com.utils.Tidbits;

public class Fibonacci {
    public static void main(String[] args) {
        Tidbits.ClearConsole();

        int penultimo = 0, ultimo = 1;

        int suma = 0;

        boolean parar = true;

        while (parar) {
            suma = ultimo + penultimo;

            if (suma > 1000)
                parar = false;


            penultimo = ultimo;
            ultimo = suma;
        }

        System.out.println("el valor de la suma es " + suma);
    }

}
