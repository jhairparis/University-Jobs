package com.works.dataStructures.algorithmAnalysis.SortingAlgorithms;

import java.util.Arrays;

public class SortingAlgorithms {

	// n^2
	public static void bubbleSort(int[] arr) {
		int last = arr.length - 1;
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int o = 0; o < last; o++)
				if (arr[o] > arr[o + 1]) {
					int aux = arr[o];
					arr[o] = arr[o + 1];
					arr[o + 1] = aux;
					sorted = false;
				}
			last--;
		}
	}

	// n log n
	public static void mergeSort(int[] arr) {
		if (arr.length <= 1)
			return;
		int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
		int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
		mergeSort(left);
		mergeSort(right);
		merge(left, right, arr);
	}

	private static void merge(int[] a, int[] b, int[] c) {
		int i = 0, j = 0;
		for (int k = 0; k < c.length; k++)
			if (i < a.length && (j >= b.length || a[i] < b[j]))
				c[k] = a[i++];
			else
				c[k] = b[j++];
	}

	// n^2
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (arr[i] > arr[j]) {
					int aux = arr[i];
					arr[i] = arr[j];
					arr[j] = aux;
				}
	}
}
