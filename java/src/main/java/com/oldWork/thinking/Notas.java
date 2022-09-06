package com.oldWork.thinking;

import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {
        int contadorAes = 0;
        int contadorBes = 0;
        int contadorCes = 0;
        int contadorDes = 0;
        int contadorEes = 0;
        int contadorErrs = 0;
        int N = 5;

        int contador = 0;
        String notaletra = "";
        double Nota;

        Scanner entrada = new Scanner(System.in);
        boolean h = true;

        while (h) {
            if (contador >= N) {
                h = false;
            }
            Nota = entrada.nextDouble();

            if (Nota < 0.0 || Nota > 5.0) {
                System.out.println("Es un error");
                contadorErrs++;
            } else {
                if (Nota <= 1.0) {
                    notaletra = "E";
                    contadorEes++;
                } else {
                    if (Nota <= 2.0) {
                        notaletra = "D";
                        contadorDes++;
                    } else {
                        if (Nota <= 3.0) {
                            notaletra = "C";
                            contadorCes++;
                        } else {
                            if (Nota <= 4.0) {
                                notaletra = "B";
                                contadorBes++;
                            } else {
                                notaletra = "A";
                                contadorAes++;
                            }
                        }
                    }

                }

            }
            contador++;
            System.out.println("Nota Numerica= " + Nota);
            System.out.println("No en letras= " + notaletra);
        }
        System.out.println("Cantidad de As =" + contadorAes);
        System.out.println("Cantidad de Bs =" + contadorBes);
        System.out.println("Cantidad de Cs =" + contadorCes);
        System.out.println("Cantidad de Ds =" + contadorDes);
        System.out.println("Cantidad de Es =" + contadorEes);
        System.out.println("err =" + contadorErrs);
        entrada.close();
    }
}
