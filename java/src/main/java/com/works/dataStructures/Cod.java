package com.works.dataStructures;

import java.util.LinkedList;

import com.utils.Tidbits;

/**
 * Cod
 *
 */
public class Cod {

	public static LinkedList<String> unionX(LinkedList<String> A, LinkedList<String> B) {
		LinkedList<String> C = new LinkedList<String>();
		C.addAll(A);

		for (int i = 0; i < C.size(); i++)
			for (int j = 0; j < B.size(); j++)
				if (B.get(j) == C.get(i))
					B.remove(j);

		C.addAll(B);
		return C;
	}

	public static void main(String[] args) {
		Tidbits.ClearConsole();
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