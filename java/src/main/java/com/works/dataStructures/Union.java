package com.works.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;

public class Union {

	public static LinkedList<String> unionX(LinkedList<String> A, LinkedList<String> B) {
		LinkedList<String> C = new LinkedList<String>();
		ArrayList<String> repetidos = new ArrayList<String>();
		C.addAll(A);
		C.addAll(B);

		for (int i = 0; i <= C.size(); i++) {
			int contador = 0;
			for (int j = 0; j <= C.size(); j++)
				if (C.get(i) == C.get(j))
					contador++;
			if (contador > 1)
				if (!repetidos.contains(C.get(i)))
					repetidos.add(C.get(i));
		}

		for (String R : repetidos) {
			int eli = C.indexOf(R);
			C.remove(eli);
		}
		return C;
	}

	public static void main(String[] args) {
		LinkedList<String> a = new LinkedList<String>();
		a.add("1");
		a.add("2");
		a.add("3");
		a.add("4");
		LinkedList<String> b = new LinkedList<String>();
		b.add("2");
		b.add("6");
		b.add("3");
		b.add("4");

		LinkedList<String> val = unionX(a, b);
		System.out.println(val);
	}
}
