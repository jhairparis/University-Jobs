package com.utils;

import java.util.Scanner;

import java.io.*;

public class Tidbits {

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
            String menuTop = "0) Salir         0.1)nextPag            0.2)prevPag               Pag-"
                    + (pag + 1) + "-" + pagT;
            System.out.println(Colors.BLUE_BACKGROUND(Colors.COLOR_WHITE(menuTop)));

            int fin = options[pag].length;

            for (int i = 0; i < fin; i++) {
                System.out.println(Colors.COLOR_GREEN((i + 1) + ") ") + options[pag][i]);
                if (imagen)
                    imageInConsole(comando + " ej" + (pag + 1) + "=" + i);
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
                    System.out.println(Colors.COLOR_RED("No hay mas paginas"));
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
                System.out.println(Colors.COLOR_RED("La opccion no existe"));
            }
        }
        double[] select = { pag, opcion };

        return select;
    }

    public static void Start() {
        ClearConsole();
        String Logo = Colors.COLOR_RED("                                  /   \\ \n ")
                + Colors.COLOR_YELLOW("_")
                + Colors.COLOR_RED("                        )      ((   ))     ( \n")
                + Colors.COLOR_YELLOW("(@)")
                + Colors.COLOR_RED("                      /|\\      ))_((     /|\\ \n")
                + Colors.COLOR_YELLOW("|-|")
                + Colors.COLOR_RED("                     / | \\    (/\\|/\\)   / | \\                      ")
                + Colors.COLOR_YELLOW("(@)")
                + Colors.COLOR_RED(" \n")
                + Colors.COLOR_YELLOW("| |")
                + Colors.COLOR_RED(" ")
                + Colors.COLOR_YELLOW("-------------------")
                + Colors.COLOR_RED("/")
                + Colors.COLOR_YELLOW("--")
                + Colors.COLOR_RED("|")
                + Colors.COLOR_YELLOW("-------")
                + Colors.COLOR_RED("\\|/")
                + Colors.COLOR_YELLOW("------")
                + Colors.COLOR_RED("|")
                + Colors.COLOR_YELLOW("--")
                + Colors.COLOR_RED("\\")
                + Colors.COLOR_YELLOW("---------------------")
                + Colors.COLOR_YELLOW("|-|")
                + Colors.COLOR_RED(" \n")
                + Colors.COLOR_YELLOW("|-|")
                + Colors.COLOR_RED("                         '^`   (o o)  '^`                          ")
                + Colors.COLOR_YELLOW("| |")
                + Colors.COLOR_RED(" \n")
                + Colors.COLOR_YELLOW("| |")
                + Colors.COLOR_RED("                               `\\Y/'                               ")
                + Colors.COLOR_YELLOW("|-|")
                + Colors.COLOR_RED(" \n")
                + Colors.COLOR_YELLOW("|-|")
                + Colors.COLOR_RED("                                                                   ")
                + Colors.COLOR_YELLOW("| |")
                + Colors.COLOR_RED(" \n")
                + Colors.COLOR_YELLOW("| | ")
                + Colors.COLOR_RED("                            ")
                + Colors.COLOR_CYAN("Jhair Paris")
                + Colors.COLOR_RED("                           ")
                + Colors.COLOR_YELLOW("|-|")
                + Colors.COLOR_RED(" \n")
                + Colors.COLOR_YELLOW("|-|")
                + Colors.COLOR_RED("                          ")
                + Colors.COLOR_PURPLE("")
                + Colors.COLOR_GREEN(" @IllustriousLoop")
                + Colors.COLOR_RED("                       ")
                + Colors.COLOR_YELLOW("| |")
                + Colors.COLOR_RED(" \n")
                + Colors.COLOR_YELLOW("| |")
                + Colors.COLOR_RED("                                                                   ")
                + Colors.COLOR_YELLOW("|-|")
                + Colors.COLOR_RED(" \n")
                + Colors.COLOR_YELLOW("|_|" + "___________________________________________________________________")
                + Colors.COLOR_YELLOW("| |")
                + Colors.COLOR_RED(" \n")
                + Colors.COLOR_YELLOW("(@)")
                + Colors.COLOR_RED("              l   /\\ /         ( (       \\ /\\   l                ")
                + Colors.COLOR_YELLOW("`\\")
                + Colors.COLOR_YELLOW("|-|")
                + Colors.COLOR_RED(" \n                 l /   V           \\ \\       V   \\ l                  ")
                + Colors.COLOR_YELLOW("(@)")
                + Colors.COLOR_RED(
                        " \n                 l/                _) )_          \\I \n                                   `\\ /'            ");
        System.out.println(Logo);
        try {
            Thread.sleep(850);
        } catch (Exception e) {

        }
        ClearConsole();
    }
}
