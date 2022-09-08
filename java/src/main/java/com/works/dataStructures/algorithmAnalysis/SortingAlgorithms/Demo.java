package com.works.dataStructures.algorithmAnalysis.SortingAlgorithms;


public class Demo {

	public static void main(String[] args) {
		// Crea 10 arreglos aleatorios de tama�o 10000 e imprime el tiempo
		// promedio de ejecuci�n del ordenamiento de burbuja.
		Stopwatch sw = new Stopwatch();
		for (int i = 0; i < 10; i++) {
			int[] arr = DataGenerator.randomArray(10000);
			sw.start();
			SortingAlgorithms.bubbleSort(arr);
			sw.stop();
		}
		System.out.println("Tiempo promedio: " + (sw.totalTime() / 10) + " ns.");
	}

}
