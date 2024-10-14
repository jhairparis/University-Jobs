package com.works.dataStructures.grafito;

public class Node {
	private String name;
	private double value;

	public Node(String name, double value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		return name + ": " + value;
	}
}
