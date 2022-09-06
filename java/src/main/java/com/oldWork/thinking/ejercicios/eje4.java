package com.oldWork.thinking.ejercicios;

import com.utils.Tidbits;

public class eje4 {
        public static void main(String[] args) {
                Tidbits.Start();

                float w;
                int i, j = 2, k = 4;

                i = j / k;
                System.out.println("valor de i: " + i + "            " + Tidbits.COLOR_CYAN_BACKGROUND
                                + "valor no almacenado 0.5" + Tidbits.COLOR_RESET);

                w = i / j;
                System.out.println("valor de w: " + w + "            " + Tidbits.COLOR_CYAN_BACKGROUND
                                + "valor no almacenado 0.25" + Tidbits.COLOR_RESET);

                k = i % j;
                System.out.println("valor de k: " + k + "            " + Tidbits.COLOR_CYAN_BACKGROUND
                                + "valor no almacenado 0.25" + Tidbits.COLOR_RESET);

                w = (float) 8.0 / j;
                System.out.println("valor de w: " + w);
        }
}
