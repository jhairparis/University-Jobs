package com.works.POO.exercise;

public class Operaciones {
	double A, B;

	Operaciones(double a, double b) {
		this.A = a;
		this.B = b;
	}

	public double sumar() {
		return A + B;
	}

	public double restar() {
		return A - B;
	}

	public double multiplicar() {
		return A * B;
	}

	public double dividir() {
		return A / B;
	}
}
