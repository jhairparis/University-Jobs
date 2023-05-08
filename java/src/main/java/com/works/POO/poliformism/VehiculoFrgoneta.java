package com.works.POO.poliformism;

/**
 * VehiculoFrgoneta
 */
public class VehiculoFrgoneta extends Vehiculo {
	public int carga;

	public VehiculoFrgoneta(String matricula, String marca, String modelo, int carga) {
		super(matricula, marca, modelo);
		this.carga = carga;
	}

	public String toString() {
		return super.toString() + "carga: " + this.carga;
	}

	public String mostrar() {
		return getMatricula() + "gho" + carga;
	}
}