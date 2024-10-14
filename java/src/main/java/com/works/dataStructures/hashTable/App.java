package com.works.dataStructures.hashTable;

import com.utils.Graph;
import com.utils.Tidbits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import com.works.dataStructures.algorithmAnalysis.SortingAlgorithms.Stopwatch;

public class App {
	private static Random random = new Random();
	private static double init = 100000;
	private static int Averaging = 20;
	private static ArrayList<Double> time = new ArrayList<>();
	private static ArrayList<Double> factor = new ArrayList<>();
	private static Graph chart = new Graph();

	public static final Random gen = new Random();

	public static void shuffle(Object[] array) {
		int n = array.length;
		while (n > 1) {
			int k = gen.nextInt(n--); // decrements after using the value
			Object temp = array[n];
			array[n] = array[k];
			array[k] = temp;
		}
	}

	private static Set<Double> generated = new LinkedHashSet<>();

	public static void randomNum(double size, double max) {
		while (generated.size() < size) {
			double next = random.nextDouble(max);
			generated.add(next);
		}
	}

	public static void main(String[] args) {
		randomNum(init, init);
		chart.setxAxisLabel("factor");
		chart.setyAxisLabel("time");
/* 
		for (float i = 0.1f; i < 1000; i *= 1.2f) {
			HashSet<Double> hey = new HashSet<Double>(16, i);
			for (double val : generated)
				hey.add(val);

			double p[] = new double[Averaging];
			for (int j = 0; j < Averaging; j++) {
				Stopwatch time = new Stopwatch();
				time.start();
				for (double val : generated)
					hey.contains(val);
				time.stop();
				p[j] = time.totalTime();
			}

			Arrays.sort(p);

			double median;
			int mid = p.length / 2;
			if (p.length % 2 == 0)
				median = (p[mid - 1] + p[mid]) / 2;
			else
				median = p[mid];

			double x = i;
			factor.add(x);
			time.add(median);
		}*/

		// chart.createDataset(factor, time, "Search");

		// factor.clear();
		// time.clear();

		
		  for (float i = 0.1f; i < 1000; i *= 1.2f) {
		  HashSet<Double> hey = new HashSet<Double>(16, i);
		  for (double val : generated)
		  hey.add(val);
		  
		  Object[] x = generated.toArray();
		  shuffle(x);
		  
		  double p[] = new double[Averaging];
		  for (int j = 0; j < Averaging; j++) {
		  Stopwatch time = new Stopwatch();
		  time.start();
		  for (int k = 0; k < p.length; k++)
		  hey.remove(x[k]);
		  time.stop();
		  
		  p[j] = time.totalTime();
		  }
		  
		  Arrays.sort(p);
		  
		  double median;
		  int mid = p.length / 2;
		  
		  if (p.length % 2 == 0) {
		  median = (p[mid - 1] + p[mid]) / 2;
		  } else {
		  median = p[mid];
		  }
		  
		  double y = i;
		  factor.add(y);
		  
		  System.out.println("Este es el tiempo de eliminacion: " + median);
		  time.add(median);
		  }
		 

		chart.createDataset(factor, time, "Delete");
		chart.show("DataStructures testing");
	}
}
