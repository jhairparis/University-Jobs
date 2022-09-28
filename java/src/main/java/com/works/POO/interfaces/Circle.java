package com.works.POO.interfaces;

public class Circle implements Rotate, Figure, Drawable {
	int radius;

	public Circle(int r) {
		this.radius = r;
	}

	@Override
	public void rotate() {
		System.out.println("ratando");
	}

	@Override
	public void calculateArea() {
		System.out.println("CalcularArea");
	}

	@Override
	public void drawable() {
		System.out.println("Dibujable");
	}

}
