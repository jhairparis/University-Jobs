package com.works.POO.interfaces;

import com.utils.Colors;
import com.utils.Tidbits;

public class Main {
	public static void main(String[] args) {
		Tidbits.ClearConsole();

		Circle circle = new Circle(2);
		Square square = new Square(4);

		circle.rotate();
		circle.drawable();
		circle.calculateArea();
		System.out.println(Colors.YELLOW_BACKGROUND("================================"));
		square.drawable();
		square.calculateArea();
	}
}
