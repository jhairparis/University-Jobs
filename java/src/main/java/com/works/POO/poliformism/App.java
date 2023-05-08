package com.works.POO.poliformism;

public class App {
	public static void main(String[] args) {
		VehiculoDeportivo vD = new VehiculoDeportivo("UVD908", "Renault", "Bonito", 388);
		VehiculoFrgoneta vF = new VehiculoFrgoneta("CVT789", "Chevron", "Bon", 332);
		VehiculoTurismo vT = new VehiculoTurismo("CVC786", "Renault", "Cix", 789);
		System.out.println(vD);
		System.out.println(vF);
		System.out.println(vT);

	}
}
