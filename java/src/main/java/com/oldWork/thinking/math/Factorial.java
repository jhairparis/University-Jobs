package com.oldWork.thinking.math;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int g = 0;
        int N = 5;

        String grade = "";

        System.out.println("Cuantas Notas:");
        N = keyboard.nextInt();

        for (int i = 1; i <= N; i++) {
            System.out.println("Nota N°" + i);
            g = keyboard.nextInt();
            if (g >= 90) {
                grade = "la nota es A";
            } else if (g >= 80) {
                grade = "la nota es B";
            } else if (g >= 70) {
                grade = "la nota es C";
            } else if (g >= 60) {
                grade = "la nota es D";
            } else {
                grade = "la nota es F";
            }
            System.out.println("La nota es" + grade);
        }
        keyboard.close();
    }
}
