package com.works.dataStructures.sets;

import java.util.ArrayList;

public class Set {
	public ArrayList<Integer> union(ArrayList<Integer> A, ArrayList<Integer> B) {
		// Recibe dos listas A y B, y retorna una lista conteniendo A ∪ B.
		ArrayList<Integer> r = new ArrayList<Integer>();
		r.addAll(A);
		r.addAll(B);
		return r;
	}

	public ArrayList<Integer> interseccion(ArrayList<Integer> A, ArrayList<Integer> B) {
		// Recibe dos listas A y B, y retorna una lista conteniendo A ∩ B
		ArrayList<Integer> r = new ArrayList<Integer>();
		if (A.size() > B.size()) {
			A.retainAll(B);
			r.addAll(A);
		} else {
			B.retainAll(A);
			r.addAll(B);
		}

		return r;
	}

	public ArrayList<Integer> diferencia_simetrica(ArrayList<Integer> A, ArrayList<Integer> B) {
		// Recibe dos listas A y B, y retorna una lista conteniendo A △ B.
		ArrayList<Integer> r = interseccion(A, B);
		for (int i = 0; i < r.size(); i++) {
			if (A.indexOf(r.get(i)) > 0)
				A.remove(A.indexOf(r.get(i)));
			if (B.indexOf(r.get(i)) > 0)
				B.remove(B.indexOf(r.get(i)));
		}
		r.clear();
		r.addAll(A);
		r.addAll(B);
		return r;
	}

	public ArrayList<Integer> diferencia(ArrayList<Integer> A, ArrayList<Integer> B) {
		// Recibe dos listas A y B, y retorna una lista conteniendo A - B.
		ArrayList<Integer> r = interseccion(A, B);
		for (int i = 0; i < r.size(); i++) {
			if (A.indexOf(r.get(i)) > 0)
				A.remove(A.indexOf(r.get(i)));
			if (B.indexOf(r.get(i)) > 0)
				B.remove(B.indexOf(r.get(i)));
		}

		r.clear();
		r.addAll(A);
		return r;
	}

}
