package com.works.dataStructures.algorithmAnalysis;

import com.utils.Graph;
import com.works.dataStructures.algorithmAnalysis.fiveSix.BubbleTestF;
import com.works.dataStructures.algorithmAnalysis.fiveSix.MergeTestF;
import com.works.dataStructures.algorithmAnalysis.fiveSix.SelectionTestF;
import com.works.dataStructures.algorithmAnalysis.twoFour.BubbleTest;
import com.works.dataStructures.algorithmAnalysis.twoFour.MergeTest;
import com.works.dataStructures.algorithmAnalysis.twoFour.SelectionTest;

public class App {
	public static void second() {
		BubbleTest bT = new BubbleTest();
		MergeTest mT = new MergeTest();
		SelectionTest sT = new SelectionTest();

		bT.run();
		mT.run();
		sT.run();

		Graph three = new Graph();
		three.addLine(bT.valueK, bT.timeDataOrd, "bubbleSort Order");
		three.addLine(mT.valueK, mT.timeDataOrd, "mergeSort Order");
		three.addLine(sT.valueK, sT.timeDataOrd, "selectionSort Order");
		three.setMinMaxAxis(50, 2000);

		Graph four = new Graph();
		four.addLine(bT.valueK, bT.timeDataNoOrd, "bubbleSort No order");
		four.addLine(mT.valueK, mT.timeDataNoOrd, "mergeSort No order");
		four.addLine(sT.valueK, sT.timeDataNoOrd, "selectionSort No order");
		four.setMinMaxAxis(50, 2000);

		three.show();
		four.show();
	}

	public static void fiveSix() {
		BubbleTestF bT = new BubbleTestF();
		MergeTestF mT = new MergeTestF();
		SelectionTestF sT = new SelectionTestF();

		bT.run();
		mT.run();
		sT.run();

		Graph five = new Graph();
		five.addLine(bT.valueK, bT.timeDataRand, "bubbleSort Random");
		five.addLine(mT.valueK, mT.timeDataRand, "mergeSort Random");
		five.addLine(sT.valueK, sT.timeDataRand, "selectionSort Random");
		five.setMinMaxAxis(50, 2000);

		five.show();
	}

	public static void main(String[] args) {
		// second();
		fiveSix();
	}
}
