package com.oldWork.thinking.ejercicios;

public class ej3 {
    public static void ejercioA(int A, int B, int C) {
        double ecuacion;
        ecuacion = B * A - B * B / 4 * C;
        System.out.println(ecuacion);
    }

    public static void ejercioB(int A, int B, int C) {
        double ecuacion;
        ecuacion = (A * B) / 3 * 3;
        System.out.println(ecuacion);
    }

    public static void ejercioC(int A, int B, int C) {
        double ecuacion;
        ecuacion = (((B + C) / 2 * A + 10) * 3 * B) - 6;
        System.out.println(ecuacion);
    }

    public static void ejercioU(int A, int B) {
        double ecuacion;
        ecuacion = 3 * A - 4 * B / A % 2;
        System.out.println(ecuacion);
    }
}
