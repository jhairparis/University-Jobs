package com.works.POO.exercise;

public class Automovil {
	String Marca;
	String Color;
	String Modelo;
	int arranque;

	Automovil(String marca, String color, String Modelo) {
		this.Marca = marca;
		this.Color = color;
		this.Modelo = Modelo;
		this.arranque = 0;
	}

	public void acelear() {
		this.arranque += 1;
	}

	public void frenar() {
		this.arranque -= 1;
	}

	public void arrancar() {
		acelear();
	}
}