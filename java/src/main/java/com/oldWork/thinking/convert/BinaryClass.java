package com.oldWork.thinking.convert;

import java.util.*;
import java.util.regex.Pattern;

import com.utils.*;

import java.util.regex.Matcher;

public class BinaryClass {
    public static int[] reverse(int x[], int num) {
        int a, b, c;
        for (a = 0; a < num / 2; a++) {
            c = x[a];
            x[a] = x[num - a - 1];
            x[num - a - 1] = c;
        }
        for (b = 0; b < num; b++) {
        }
        return x;
    }

    public static int[] toArray(String input) {
        int array[] = new int[input.length()];
        int indice = 0;
        for (char valor : input.toCharArray()) {
            array[indice] = Integer.valueOf(valor) - 48;
            indice++;
        }
        int[] reverse = reverse(array, array.length);

        return reverse;
    }

    public static int convert(String toConvert) {
        ArrayList<Integer> arrList = new ArrayList<>();

        int[] binarioArray = toArray(toConvert);

        Integer add = 0;
        int potencia = 1;

        for (int x : binarioArray) {
            arrList.add(x * potencia);
            potencia *= 2;
        }
        for (Integer num : arrList) {
            add += num;
        }
        return add;
    }

    public static String Input(boolean type) {
        Tidbits.ClearConsole();
        Scanner inputKeyboard = new Scanner(System.in);
        String exit = "null";

        if (type) {
            System.out.println(
                    Colors.COLOR_GREEN("Por favor introduzca un ")
                            + Colors.CYAN_BACKGROUND(Colors.COLOR_BLACK("  decimal  ")));

            exit = inputKeyboard.nextLine().toString();

            Pattern pat = Pattern.compile("[0-9]*");
            Matcher mat = pat.matcher(exit);

            if (mat.matches()) {
            } else {
                exit = "error";
            }
        } else {
            System.out.println(
                    Colors.COLOR_GREEN("Por favor introduzca un ")
                            + Colors.CYAN_BACKGROUND(Colors.COLOR_BLACK("  binario  ")));

            exit = inputKeyboard.nextLine().toString();

            Pattern pat = Pattern.compile("[0-1]*");
            Matcher mat = pat.matcher(exit);

            if (mat.matches()) {
            } else {
                exit = "error";
            }
        }
        inputKeyboard.close();
        return exit;
    }

    public static void main(String args[]) {
        //  Start Program 
        String binario = Input(false);

        if (binario == "error") {
            System.out.println(Colors.COLOR_RED("Not input valid"));
        } else {
            int solved = convert(binario);
            System.out.println(" resultado");
            System.out.println(solved);
        }
    }

}
