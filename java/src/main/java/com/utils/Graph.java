package com.utils;

import java.awt.Color;
import java.util.ArrayList;
// import java.awt.BasicStroke;
import java.awt.Dimension;
import java.text.DecimalFormat;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SymbolAxis;
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
	private SymbolAxis sa;

	public Graph() {
		super("");
	}

	public void createDataset(ArrayList<Double> x, ArrayList<Double> y, String name) {
		XYSeries search = new XYSeries(name);
		String[] xAxis = new String[x.size()];

		if (x.size() != y.size())
			return;

		for (int i = 0; i < x.size(); i++) {
			search.add(i, y.get(i));
			DecimalFormat df = new DecimalFormat("0.#E0");
			df.setMaximumFractionDigits(3);
			xAxis[i] = df.format(x.get(i));
		}

		sa = new SymbolAxis(xAxisLabel, xAxis);
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
		if (sa != null)
			plot.setDomainAxis(sa);
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