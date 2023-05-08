package com.works.POO.poliformism;

import lombok.Getter;
import lombok.ToString;

/**
 * Vehiculo
 */

@ToString
@Getter
public class Vehiculo {
	private String matricula;
	private String marca;
	private String modelo;

	public Vehiculo(String matricula, String marca, String modelo) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}
}