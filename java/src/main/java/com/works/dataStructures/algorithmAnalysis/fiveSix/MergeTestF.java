package com.works.dataStructures.algorithmAnalysis.fiveSix;

import com.utils.Graph;
import com.works.dataStructures.algorithmAnalysis.SortingAlgorithms.DataGenerator;
import com.works.dataStructures.algorithmAnalysis.SortingAlgorithms.SortingAlgorithms;
import com.works.dataStructures.algorithmAnalysis.SortingAlgorithms.Stopwatch;

public class MergeTestF {
	public int min = 50;
	public int step = 50;
	public int max = 2000;
	public int arrayAverage = 20;

	public double[] timeDataRand = new double[max / step];
	public double[] valueK = new double[max / step];

	public void run() {
		Stopwatch sw = new Stopwatch();
		int i = 0;
		long time = 0;

		for (int k = min; k <= max; k += step) {
			for (int x = 0; x < arrayAverage; x++) {
				int[] arrRand = DataGenerator.randomArray(k);
				sw.reset();
				sw.start();
				SortingAlgorithms.mergeSort(arrRand);
				sw.stop();
				time += sw.totalTime();
			}

			timeDataRand[i] = time / arrayAverage;
			valueK[i] = k;
			i++;
		}

		Graph comparison = new Graph();
		comparison.addLine(valueK, timeDataRand, "mergeSort Random");
		comparison.setMinMaxAxis(min, max);
		comparison.show();
	}
}
