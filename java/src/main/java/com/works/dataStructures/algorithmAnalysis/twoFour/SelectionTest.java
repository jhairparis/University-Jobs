package com.works.dataStructures.algorithmAnalysis.twoFour;

import com.utils.Graph;
import com.works.dataStructures.algorithmAnalysis.SortingAlgorithms.DataGenerator;
import com.works.dataStructures.algorithmAnalysis.SortingAlgorithms.SortingAlgorithms;
import com.works.dataStructures.algorithmAnalysis.SortingAlgorithms.Stopwatch;

public class SelectionTest {
	public int min = 50;
	public int step = 50;
	public int max = 2000;
	public int arrayAverage = 20;

	public double[] timeDataOrd = new double[max / step];
	public double[] timeDataNoOrd = new double[max / step];
	public double[] valueK = new double[max / step];

	public void run() {
		Stopwatch sw = new Stopwatch();
		int i = 0;
		long time = 0;

		for (int k = min; k <= max; k += step) {
			int[] arrIncr = DataGenerator.increasingArray(k);

			for (int x = 0; x < arrayAverage; x++) {
				sw.reset();
				sw.start();
				SortingAlgorithms.selectionSort(arrIncr);
				sw.stop();
				time += sw.totalTime();
			}

			timeDataOrd[i] = time / arrayAverage;
			valueK[i] = k;
			i++;
		}

		// ----------------------------------------------------------------
		i = 0;
		for (int k = min; k <= max; k += step) {
			int[] arrDec = DataGenerator.decreasingArray(k);

			for (int x = 0; x < arrayAverage; x++) {
				sw.reset();
				sw.start();
				SortingAlgorithms.selectionSort(arrDec);
				sw.stop();
				time += sw.totalTime();
			}

			timeDataNoOrd[i] = time / arrayAverage;
			i++;
		}

		Graph comparison = new Graph();
		comparison.addLine(valueK, timeDataOrd, "selectionSort Order");
		comparison.addLine(valueK, timeDataNoOrd, "selectionSort No Order");
		comparison.setMinMaxAxis(min, max);
		comparison.show();
	}
}
