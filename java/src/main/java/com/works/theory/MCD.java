package com.works.theory;

import com.utils.Tidbits;

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
		System.out.println(Tidbits.COLOR_CYAN_BACKGROUND + "     MCD     " + Tidbits.COLOR_RESET);
		System.out.println(Tidbits.COLOR_RED + "recursion" + Tidbits.COLOR_RESET);
		System.out.println(recursion(24, 18));
		System.out.println(Tidbits.COLOR_YELLOW + "recursion" + Tidbits.COLOR_RESET);
		System.out.println(noRecursion(24, 18));
	}

}
