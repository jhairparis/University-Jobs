package com.works.theory;

import java.util.Scanner;

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

		Scanner in = new Scanner(System.in);

		System.out.println("Equation: A * dⁿ");
		System.out.println("Please enter value for A: ");
		double A = in.nextDouble();
		System.out.println("Please enter value for d: ");
		double d = in.nextDouble();
		System.out.println("Please enter value for n: ");
		int n = in.nextInt();

		System.out.println(A + " * " + Tidbits.exponentText(d, n));

		System.out.println("Is correct the equation? y/n");
		String q = in.next();

		if (q.equals("y"))
			System.out.println(recursion(A, n, d));
		else
			System.out.println("ok");

		in.close();
	}
}
