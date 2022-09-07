package com.works.POO.exercise;

/**
 * App
 */
public class App {

	public static void main(String[] args) {
		BankAccount account = new BankAccount("Jhair", "Paris", typeAccount.saving);
		Book book = new Book("My Book", "Jhair", 10);
		Automovil automovil = new Automovil("Renault", "Gris", "Stepway");
		Operaciones operaciones = new Operaciones(1, 2);
		Rectangulo rectangulo = new Rectangulo(4, 4);

		System.out.println(account);
		System.out.println(book);
		System.out.println(operaciones.dividir());
		System.out.println(rectangulo.area());
		automovil.acelear();
	}

}