package com.works.POO.poliformism;

/**
 * VehiculoTurismo
 */
public class VehiculoTurismo extends Vehiculo {
	public int numeroPuertas;
	

	public VehiculoTurismo(String matricula, String marca, String modelo, int numeroPuertas) {
		super(matricula, marca, modelo);
		this.numeroPuertas = numeroPuertas;
	}


	public String toString() {
		return super.toString() + "numeroPuertas" + this.numeroPuertas;
	}

}