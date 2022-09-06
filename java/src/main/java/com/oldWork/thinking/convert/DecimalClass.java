package com.oldWork.thinking.convert;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.utils.Tidbits;

import java.util.Scanner;

public class DecimalClass {

    public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> alist) {
        ArrayList<Integer> revArrayList = new ArrayList<Integer>();
        for (int i = alist.size() - 1; i >= 0; i--) {
            // Append the elements in reverse order
            revArrayList.add(alist.get(i));
        }
        return revArrayList;
    }

    public static String generatorSpace(int num) {
        String xxx = "";
        for (int i = 0; i < num; i++) {
            xxx = xxx + " ";
        }
        return xxx;
    }

    public static int contador(int tyope) {
        int space = 0;
        while (tyope != 0) { // mientras a n le queden cifras
            tyope = tyope / 10; // le quitamos el último dígito
            space = space + 1;
        }

        return space;
    }

    public static String tabx(int n) {
        return generatorSpace(n * 5);
    }

    public static void illustration(ArrayList<Integer> Q, ArrayList<Integer> R, int start) {
        String line, line1, line2, line3, line4;

        boolean first = true;
        int v = 0;

        int tab = 0;

        for (int i = 0; i < Q.size(); i++) {
            if (first) {
                v = start;
                first = false;
            } else {
                v = Q.get(i - 1);
            }

            line = tabx(tab) + generatorSpace(contador(v) + 1) + "▌\n";
            line1 = tabx(tab) + v + " ▌ 2\n";
            line2 = tabx(tab) + generatorSpace(contador(v) + 1) + "▌\n";
            line3 = tabx(tab) + generatorSpace(contador(v) + 1) + "▀▀▀▀▀▀\n";
            line4 = tabx(tab) + generatorSpace(contador(R.get(i))) + Tidbits.COLOR_RED + R.get(i)
                    + Tidbits.COLOR_RESET + " ▌ " + Tidbits.COLOR_GREEN + Q.get(i);

            String Templete = line + line1 + line2 + line3 + line4;

            System.out.println(Tidbits.COLOR_BLUE + Templete + "\n" + Tidbits.COLOR_RESET);
            tab++;
        }

    }

    public static void main(String[] args) {
        String decimalString = BinaryClass.Input(true);

        Scanner lector = new Scanner(System.in); // Creación de un objeto Scanner

        if (decimalString == "error") {
            System.out.println(Tidbits.COLOR_RED + "Not input valid" + Tidbits.COLOR_RESET);
        } else {

            ArrayList<Integer> quotient = new ArrayList<>();
            ArrayList<Integer> remainder = new ArrayList<>();

            boolean loop = true;

            int state = Integer.parseInt(decimalString);

            while (loop) {
                quotient.add(state / 2);
                remainder.add(state % 2);

                if (state == 1) {
                    loop = false;
                }

                state = state / 2;
            }

            remainder = reverseArrayList(remainder);

            String listString = remainder.stream().map(Object::toString).collect(Collectors.joining(" "));

            System.out.println(
                    Tidbits.COLOR_CYAN + "Answer  " + Tidbits.COLOR_GREEN + listString + Tidbits.COLOR_RESET);

            System.out.println(Tidbits.COLOR_RED + "Ver proceso?" + Tidbits.COLOR_RESET + "  presiona Enter|n");

            String enterkey = lector.nextLine();

            if (enterkey.isEmpty()) {
                illustration(quotient, remainder, Integer.parseInt(decimalString));
            }

            System.out.println("Adios 襤");
            lector.close();
        }
    }
}
