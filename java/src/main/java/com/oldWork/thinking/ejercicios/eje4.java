package com.oldWork.thinking.ejercicios;

import com.utils.*;

public class eje4 {
        public static void main(String[] args) {
                Tidbits.Start();

                float w;
                int i, j = 2, k = 4;

                i = j / k;
                System.out.println("valor de i: " + i + "            "
                                + Colors.CYAN_BACKGROUND("valor no almacenado 0.5"));

                w = i / j;
                System.out.println("valor de w: " + w + "            "
                                + Colors.CYAN_BACKGROUND("valor no almacenado 0.25"));

                k = i % j;
                System.out.println("valor de k: " + k + "            "
                                + Colors.CYAN_BACKGROUND("valor no almacenado 0.25"));

                w = (float) 8.0 / j;
                System.out.println("valor de w: " + w);
        }
}
