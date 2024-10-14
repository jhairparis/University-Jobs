package com.works.dataStructures.grafito;

import java.util.HashMap;
import java.util.LinkedList;

public class Grafito {
	static HashMap<Node, LinkedList<Node>> listNodes = new HashMap<>();

	public static void main(String[] args) {
		Grafito x = new Grafito();
		Node one = new Node("Stop A", 100.0);
		Node two = new Node("Stop B", 40.0);
		Node tree = new Node("Stop C", 60.0);
		Node four = new Node("Stop D", 73.5);

		x.addNode(one);
		x.addNode(two);
		x.addNode(tree);
		x.addNode(four);

		x.addEdge(one, two);
		x.addEdge(four, tree);
		x.addEdge(four, one);
		x.addEdge(tree, one);

		System.out.println(x);

	}

	public void addNode(Node n) {
		listNodes.put(n, new LinkedList<Node>());
	}

	public void addEdge(Node origen, Node destino) {
		LinkedList<Node> nodes = listNodes.get(origen);
		nodes.add(destino);
	}

	@Override
	public String toString() {
		String result = "";
		for (Node key : listNodes.keySet())
			result += key.toString() + "-> " + listNodes.get(key) + "\n";
		return result;
	}
}
