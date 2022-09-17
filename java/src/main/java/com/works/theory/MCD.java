package com.works.theory;

import com.utils.*;

public class MCD {
	public static int recursion(int a, int b) {
		if (b == 0)
			return a;
		else if (a == 0)
			return b;
		else if (a >= b)
			return recursion(a - b, b);
		else
			return recursion(a, b - a);
	}

	public static int noRecursion(int a, int b) {
		int temp;
		while (a != 0) {
			temp = a;
			a = b % a;
			b = temp;
		}
		return b;
	}

	public static void main(String[] args) {
		Tidbits.ClearConsole();
		System.out.println(Colors.CYAN_BACKGROUND("     MCD     "));
		System.out.println(Colors.COLOR_RED("recursion"));
		System.out.println(recursion(24, 18));
		System.out.println(Colors.COLOR_YELLOW("recursion"));
		System.out.println(noRecursion(24, 18));
	}

}
