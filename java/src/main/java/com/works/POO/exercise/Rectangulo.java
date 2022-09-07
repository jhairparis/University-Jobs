package com.works.POO.exercise;

public class Rectangulo {
	int A, B;

	Rectangulo(int a, int b) {
		this.A = a;
		this.B = b;
	}

	public int area() {
		return A * B;
	}

	public int perimetro() {
		return (2 * A) + (2 * B);
	}
}
