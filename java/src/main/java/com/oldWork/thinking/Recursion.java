package com.oldWork.thinking;

import com.utils.Tidbits;

/**
 * Recursion
 */
public class Recursion {

    public static int pop(int N) {
        if (N >= 1)
            return N + pop(N - 1);
        return N;
    }

    public static void main(String[] args) {
        Tidbits.Start();
        System.out.println(pop(5));
    }
}
