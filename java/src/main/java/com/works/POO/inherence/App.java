package com.works.POO.inherence;

import com.utils.Tidbits;

public class App {
	public static void main(String[] args) {
		Tidbits.Start();
		Student person = new Student("Juan", "Gonzales", "VE", 'h', 20, 0440, 11002,
		5);
		Student person2 = new Student("Juan", "Gonzales", "VE", 'h', 20, 0400, 11002,
				5);

		System.out.println(person);
		System.out.println(person2);
	}
}
