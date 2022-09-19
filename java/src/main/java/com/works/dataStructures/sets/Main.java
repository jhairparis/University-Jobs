package com.works.dataStructures.sets;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Set conjunto = new Set();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		list2.add(10);
		list2.add(3);
		list2.add(4);
		list2.add(5);

		ArrayList<Integer> union = conjunto.union(list, list2);
		ArrayList<Integer> interseccion = conjunto.interseccion(list, list2);
		ArrayList<Integer> diferencia_simetrica = conjunto.diferencia_simetrica(list, list2);
		ArrayList<Integer> diferencia = conjunto.diferencia(list, list2);

		System.out.println(union.toString());
		System.out.println(interseccion.toString());
		System.out.println(diferencia.toString());
		System.out.println(diferencia_simetrica.toString());
	}
}
