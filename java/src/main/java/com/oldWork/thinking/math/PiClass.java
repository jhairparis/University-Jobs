package com.oldWork.thinking.math;
import java.awt.AWTException;

import com.utils.Tidbits;

public class PiClass {
    public static void main(String args[]) throws AWTException {
        Tidbits.ClearConsole();
        second();
    }

    public static void second() {
        double pi = 0;
        double denominador = 1;
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
                pi += (1 / denominador);
            } else {
                pi -= (1 / denominador);
            }
            denominador = denominador + 2;
        }
        pi *= 4;
        System.out.println(pi);
    }
}
