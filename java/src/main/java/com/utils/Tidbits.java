package com.utils;

import java.util.Scanner;

import java.io.*;

public class Tidbits {
    //  Letters colors
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_WHITE = "\u001B[37m";

    public static final String COLOR_RESET = "\u001B[0m";

    //  Background colors
    public static final String COLOR_BLACK_BACKGROUND = "\u001B[40m";
    public static final String COLOR_RED_BACKGROUND = "\u001B[41m";
    public static final String COLOR_GREEN_BACKGROUND = "\u001B[42m";
    public static final String COLOR_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String COLOR_BLUE_BACKGROUND = "\u001B[44m";
    public static final String COLOR_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String COLOR_CYAN_BACKGROUND = "\u001B[46m";
    public static final String COLOR_WHITE_BACKGROUND = "\u001B[47m";

    public static void ClearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
                System.out.println("windows");
            } else {
                System.out.print("\u001b[H\u001b[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            /* Nothing to do  */
        }
    }

    public static void imageInConsole(String command) {
        String string = "";
        try {
            final InputStream inputStream = Runtime.getRuntime().exec(command).getInputStream();
            final byte[] bytes = new byte[1024];
            int read;
            while ((read = inputStream.read(bytes)) >= 0) {
                System.err.write(bytes, 0, read);
                string += new String(bytes);
            }
        } catch (Exception ex) {
        }
    }

    public static double[] GeneratorOptions(String[][] options, boolean imagen, String comando) {
        Scanner input = new Scanner(System.in);

        int pag = 0;
        int pagT = options.length;
        boolean salir = false;

        double opcion = 0.0;// Guardamos opcion del usuarion

        while (!salir) {
            System.out.println(COLOR_BLUE_BACKGROUND + COLOR_WHITE
                    + "0) Salir         0.1)nextPag            0.2)prevPag               Pag-" + (pag + 1) + "-" + pagT
                    + COLOR_RESET);

            int fin = options[pag].length;

            for (int i = 0; i < fin; i++) {
                System.out.println(COLOR_GREEN + (i + 1) + ") " + COLOR_RESET + options[pag][i]);
                if (imagen) {
                    imageInConsole(comando + " ej" + (pag + 1) + "=" + i);
                }
            }

            System.out.println("\n");
            System.out.println("Escribe una de las opciones");
            opcion = input.nextDouble();

            if (opcion == 0.1) {
                ClearConsole();
                if ((pag + 1) < pagT) {
                    pag += 1;
                }
            } else if (opcion == 0.2) {
                ClearConsole();
                if (pag > 0) {
                    pag -= 1;
                } else {
                    ClearConsole();
                    System.out.println(COLOR_RED + "No hay mas paginas" + COLOR_RESET);
                }
            } else if (opcion == 0) {
                ClearConsole();
                salir = true;
            } else if (opcion <= options[pag].length) {
                ClearConsole();
                salir = true;
                double[] select = { pag, opcion };
                return select;
            } else {
                ClearConsole();
                System.out.println(COLOR_RED + "La opccion no existe" + COLOR_RESET);
            }
        }
        double[] select = { pag, opcion };

        return select;
    }

    public static void Start() {
        ClearConsole();
        String Logo = COLOR_RED + "                                  /   \\ \n " + COLOR_YELLOW + "_" + COLOR_RED
                + "                        )      ((   ))     ( \n" + COLOR_YELLOW + "(@)" + COLOR_RED
                + "                      /|\\      ))_((     /|\\ \n" + COLOR_YELLOW + "|-|" + COLOR_RED
                + "                     / | \\    (/\\|/\\)   / | \\                      " + COLOR_YELLOW + "(@)"
                + COLOR_RED + " \n" + COLOR_YELLOW + "| |" + COLOR_RED + " " + COLOR_YELLOW + "-------------------"
                + COLOR_RED + "/" + COLOR_YELLOW + "--" + COLOR_RED + "|" + COLOR_YELLOW + "-------" + COLOR_RED
                + "\\|/"
                + COLOR_YELLOW + "------" + COLOR_RED + "|" + COLOR_YELLOW + "--" + COLOR_RED + "\\" + COLOR_YELLOW
                + "---------------------" + COLOR_YELLOW + "|-|" + COLOR_RED + " \n" + COLOR_YELLOW + "|-|" + COLOR_RED
                + "                         '^`   (o o)  '^`                          " + COLOR_YELLOW + "| |"
                + COLOR_RED
                + " \n" + COLOR_YELLOW + "| |" + COLOR_RED
                + "                               `\\Y/'                               " + COLOR_YELLOW + "|-|"
                + COLOR_RED + " \n" + COLOR_YELLOW + "|-|" + COLOR_RED
                + "                                                                   " + COLOR_YELLOW + "| |"
                + COLOR_RED
                + " \n" + COLOR_YELLOW + "| | " + COLOR_RED + "                            " + COLOR_CYAN
                + "Jhair Paris"
                + COLOR_RED + "                           " + COLOR_YELLOW + "|-|" + COLOR_RED + " \n" + COLOR_YELLOW
                + "|-|" + COLOR_RED + "                          " + COLOR_PURPLE + "" + COLOR_GREEN
                + " @IllustriousLoop"
                + COLOR_RED + "                       " + COLOR_YELLOW + "| |" + COLOR_RED + " \n" + COLOR_YELLOW
                + "| |" + COLOR_RED + "                                                                   "
                + COLOR_YELLOW
                + "|-|" + COLOR_RED + " \n" + COLOR_YELLOW + "|_|"
                + "___________________________________________________________________" + COLOR_YELLOW + "| |"
                + COLOR_RED
                + " \n" + COLOR_YELLOW + "(@)" + COLOR_RED
                + "              l   /\\ /         ( (       \\ /\\   l                " + COLOR_YELLOW + "`\\"
                + COLOR_YELLOW + "|-|" + COLOR_RED
                + " \n                 l /   V           \\ \\       V   \\ l                  " + COLOR_YELLOW + "(@)"
                + COLOR_RED
                + " \n                 l/                _) )_          \\I \n                                   `\\ /'            "
                + COLOR_RESET;
        System.out.println(Logo);
        try {
            Thread.sleep(650);
        } catch (Exception e) {

        }
        ClearConsole();
    }
}
