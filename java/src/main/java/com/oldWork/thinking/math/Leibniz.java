package com.oldWork.thinking.math;

import com.utils.Tidbits;

public class Leibniz {
    public static void main(String[] args) {
        Tidbits.Start();

        double serie = 0;
        int N = 6;
        double denominador = 1;

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                serie -= (1 / denominador);
            } else {
                serie += (1 / denominador);
            }
            denominador = denominador + 2;

            System.out.println("valor de i: " + i + " serie" + serie);
        }
        System.out.println(serie);

    }
}
