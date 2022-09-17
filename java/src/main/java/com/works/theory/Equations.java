package com.works.theory;

import com.utils.*;

public class Equations {
	public static double recursion(double A, int n, double d) {
		if (n > 0)
			return recursion(d * A, n - 1, d);
		else
			return A;
	}

	public double iterative(double A, int n, double d) {
		double x = 0;
		while (n > 0) {
			x = A * Math.pow(d, n);
			n -= 1;
		}
		return x;
	}

	public static void main(String[] args) {
		Tidbits.Start();
		// System.out.println(Colors.BLUE_BACKGROUND(recursion(7, 5, 0.2)));
	}
}
