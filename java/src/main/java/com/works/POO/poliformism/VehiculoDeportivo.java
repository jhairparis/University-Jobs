package com.works.POO.poliformism;

/**
 * VehiculoDeportivo
 */

public class VehiculoDeportivo extends Vehiculo {
	public int cilindraje;
	
	public VehiculoDeportivo(String matricula, String marca, String modelo, int cilindraje) {
		super(matricula, marca, modelo);
		this.cilindraje = cilindraje;
	}

	public String toString() {
		return super.toString() + "cilindraje: " + this.cilindraje;
	}
}