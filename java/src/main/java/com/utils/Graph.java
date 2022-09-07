package com.utils;

import javax.swing.JFrame;

import org.math.plot.*;

public class Graph {
	private Plot2DPanel plot = new Plot2DPanel();
	private JFrame frame = new JFrame("Graph");

	public Graph() {
		plot.addLegend("SOUTH");
		plot.removePlotToolBar();
		frame.setContentPane(plot);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void show() {
		frame.setVisible(true);
	}

	public void addLine(double[] X, double[] Y, String name) {
		plot.addLinePlot(name, X, Y);
	}

	public void setMinMaxAxis(double min, double max) {
		plot.setFixedBounds(0, min, max);
	}

	public void addPointLine(double[] X, double[] Y, String name) {
		plot.addBarPlot(name, X, Y);
	}
}
