package com.works.POO.interfaces;

public class Square implements Figure, Drawable {
	int side;

	public Square(int side) {
		this.side = side;
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
