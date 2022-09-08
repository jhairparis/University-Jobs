package com.works.dataStructures.algorithmAnalysis.SortingAlgorithms;
import java.util.Random;

public class DataGenerator {

	public static int[] increasingArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = i+1;
		return arr;
	}
	
	public static int[] decreasingArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = n-i;
		return arr;
	}
	
	public static int[] randomArray(int n) {
		Random gen = new Random();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = i+1;
		for (int i = n-1; i >= 0; i--) {
			int pos = gen.nextInt(i+1);
			int aux = arr[i];
			arr[i] = arr[pos];
			arr[pos] = aux;
		}
		return arr;
	}
}
