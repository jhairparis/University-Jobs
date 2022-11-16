package com.utils;

import java.awt.Color;
import java.util.ArrayList;
// import java.awt.BasicStroke;
import java.awt.Dimension;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class Graph extends ApplicationFrame {
	private XYSeriesCollection dataset = new XYSeriesCollection();
	private String xAxisLabel = "Category";
	private String yAxisLabel = "Score";

	public Graph() {
		super("");
	}

	public void createDataset(ArrayList<Number> x, ArrayList<Number> y, String name) {
		final XYSeries search = new XYSeries(name);

		if (x.size() != y.size())
			return;

		for (int i = 0; i < x.size(); i++)
			search.add(x.get(i), y.get(i));

		dataset.addSeries(search);
	}

	public void show(String chartTitle) {
		JFreeChart xylineChart = ChartFactory.createXYLineChart(
				chartTitle,
				xAxisLabel,
				yAxisLabel,
				dataset,
				PlotOrientation.VERTICAL,
				true, true, false);

		ChartPanel chartPanel = new ChartPanel(xylineChart);
		chartPanel.setPreferredSize(new Dimension(560, 367));

		XYPlot plot = xylineChart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(1, Color.GREEN);
		// renderer.setSeriesStroke(0, new BasicStroke(4.0f));
		// renderer.setSeriesStroke(1, new BasicStroke(3.0f));
		// renderer.setSeriesStroke(2, new BasicStroke(2.0f));
		plot.setRenderer(renderer);

		this.setContentPane(chartPanel);
		this.pack();
		this.setVisible(true);
	}

	public void setxAxisLabel(String xAxisLabel) {
		this.xAxisLabel = xAxisLabel;
	}

	public void setyAxisLabel(String yAxisLabel) {
		this.yAxisLabel = yAxisLabel;
	}

}