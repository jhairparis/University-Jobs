package com.oldWork.thinking.ejercicios;

public class ej2 {
    public static void evaluarAA() {
        double x;
        x = (double) 4 / 2 * 3 / 6 + 6 / 2 / 1 / 5 % 2 / 4 * 2;
        System.out.println(x);
    }

    public static void ejercioA(int A, int B) {
        double ecuacion;
        ecuacion = (4 * A) - (2 * B) + 7;
        System.out.println(ecuacion);
    }

    public static void ejercioB(int A, int B, int C, int D) {
        double ecuacion;
        ecuacion = (A + B) / (C - D);
        System.out.println(ecuacion);
    }

    public static void ejercioC(int A, int B, int C) {
        double ecuacion;
        ecuacion = ((3 * A) + (2 * B)) / (2 * C);
        System.out.println(ecuacion);
    }

    public static void ejercioD(int A, int B) {
        double ecuacion;
        ecuacion = ((A + B) / A) - ((3 * A) / 5);
        System.out.println(ecuacion);
    }

    public static void ejercioE(int A, int B, int C, int D) {
        double ecuacion;
        // a es ysub1 y b es ysub2 c es xsub1 y d es xsub2
        ecuacion = (A - B) / (C - D);
        System.out.println(ecuacion);
    }
}
