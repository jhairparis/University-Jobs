package com.works.dataStructures.algorithmAnalysis.SortingAlgorithms;

public class Stopwatch {

	private long elapsedTime;
	private long initTime;
		
	public Stopwatch() {
		reset();
	}
	
	public void start() {
		if (initTime >= 0) return;
		initTime = System.nanoTime();
	}
	
	public void stop() {
		if (initTime < 0) return;
		elapsedTime += System.nanoTime() - initTime;
		initTime = -1;
	}	
	
	public long totalTime() {
		return elapsedTime;
	}
	
	public void reset() {
		elapsedTime = 0;
		initTime = -1;
	}
}
