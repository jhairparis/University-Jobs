package com.oldWork.thinking.ejercicios;

import java.util.*;

import com.utils.*;

public class Main {
    private static int A = 0, B = 0, C = 0, D = 0;
    private static boolean loop = false;

    private static void defaultx() {
        loop = true;
        System.out.println(
                Colors.COLOR_RED(" ")
                        + "Has salido o seleccion algo que no existe " + Colors.COLOR_RED(""));
    }

    public static void seleccion() {
        System.out.println("Que expresion aritmetica desea ver?");
        String comando = "node ../../Javascript/render_Img/index.js";

        String[] ejerciosde1 = { "A % B + C / D - 6", "A + 2 * (3 + B)", "3 *(A % ( B / C )) + 5", "6 * 5 / 10 *2 + 10",
                "(6 * 5) / (10 * 2) + 10", "(6 * 5) / (10 * 2 + 10)", "(6 * 5) / (10 * (2 + 10))", "A * B / C * D" };
        String[] ejerciosde2 = { "4 / 2 * 3 / 6 + 6 / 2 / 1 / 5 % 2 /4 * 2", "4x - 2y +7", " ", " ", " ", " " };

        String[] ejerciosde3 = { "B * A - B * B / 4 * C", "(A*B)/3*3", "(((B+C) / 2 * A + 10)* 3 * B)- 6" };

        String[] ejerciosde31 = { "3 * A - 4 * B / A % 2" };

        String[][] options = { ejerciosde1, ejerciosde2, ejerciosde3, ejerciosde31 };

        System.out.println(
                Colors.RED_BACKGROUND("Recuerda los valores A: " + A + " B: " + B + " C:" + C + " D:" + D));

        double[] seleccion = Tidbits.GeneratorOptions(options, true, comando);

        int ejercio = (int) (seleccion[0] + 1);
        int num = (int) seleccion[1];

        switch (ejercio) {
            case 1:
                switch (num) {
                    case 1:
                        ej1.ejercioA(A, B, C, D);
                        break;
                    case 2:
                        ej1.ejercioB(A, B);
                        break;
                    case 3:
                        ej1.ejercioC(A, B, C);
                        break;
                    case 4:
                        ej1.ejercioD();
                        break;
                    case 5:
                        ej1.ejercioE();
                        break;
                    case 6:
                        ej1.ejercioF();
                        break;
                    case 7:
                        ej1.ejercioG();
                        break;
                    case 8:
                        ej1.ejercioH(A, B, C, D);
                        break;
                    default:
                        defaultx();
                }
                break;
            case 2:
                switch (num) {
                    case 1:
                        ej2.evaluarAA();
                        break;
                    case 2:
                        ej2.ejercioA(A, B);
                        break;
                    case 3:
                        ej2.ejercioB(A, B, C, D);
                        break;
                    case 4:
                        ej2.ejercioC(A, B, C);
                        break;
                    case 5:
                        ej2.ejercioD(A, B);
                        break;
                    case 6:
                        ej2.ejercioE(A, B, C, D);
                        break;
                    default:
                        defaultx();
                        break;
                }
                break;
            case 3:
                switch (num) {
                    case 1:
                        ej3.ejercioA(4, 5, 1);
                        break;
                    case 2:
                        ej3.ejercioB(4, 5, 1);
                        break;
                    case 3:
                        ej3.ejercioC(4, 5, 1);
                        break;
                    default:
                        defaultx();
                        break;
                }
                break;
            case 4:
                switch (num) {
                    case 1:
                        ej3.ejercioU(2, 5);
                        break;
                    default:
                        defaultx();
                        break;
                }
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        Tidbits.Start();
        System.out.println("Bienvenido a este programa");

        Scanner input = new Scanner(System.in);

        System.out.println("Por favor ingrese el valor de A:\n");
        A = input.nextInt();
        System.out.println("Por favor ingrese el valor de B:\n");
        B = input.nextInt();
        System.out.println("Por favor ingrese el valor de C:\n");
        C = input.nextInt();
        System.out.println("Por favor ingrese el valor de D:\n");
        D = input.nextInt();

        Tidbits.ClearConsole();

        while (!loop) {
            seleccion();
        }
        input.close();
    }
}
