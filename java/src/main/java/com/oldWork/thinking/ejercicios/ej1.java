package com.oldWork.thinking.ejercicios;

public class ej1 {
    public static void ejercioA(int A, int B, int C, int D) {
        double x;
        x = (double) A % B + C / D - 6;
        System.out.println(x);
    }

    public static void ejercioB(int A, int B) {
        double x;
        x = A + 2 * (3 + B);
        System.out.println(x);
    }

    public static void ejercioC(int A, int B, int C) {
        double x;
        x = (double) 3 * (A % (B / C)) + 5;
        System.out.println(x);
    }

    public static void ejercioD() {
        double x;
        x = (double) 6 * 5 / 10 * 2 + 10;
        System.out.println(x);
    }

    public static void ejercioE() {
        double x;
        x = (double) (6 * 5) / (10 * 2) + 10;
        System.out.println(x);
    }

    public static void ejercioF() {
        double x;
        x = (double) (6 * 5) / (10 * 2 + 10);
        System.out.println(x);
    }

    public static void ejercioG() {
        double x;
        x = (double) (6 * 5) / (10 * (2 + 10));
        System.out.println(x);
    }

    public static void ejercioH(int A, int B, int C, int D) {
        double x;
        x = (double) A * B / C * D;
        System.out.println(x);
    }
}
