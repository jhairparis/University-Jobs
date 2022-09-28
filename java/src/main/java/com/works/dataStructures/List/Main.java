package com.works.dataStructures.List;

import java.util.Iterator;

import com.utils.Tidbits;

public class Main {
	public static void main(String[] args) {
		Tidbits.Start();
		ArrayList<String> list = new ArrayList<String>();
		list.add(0, "juan");
		list.add(1, "pepe");
		// System.out.println(list);
		list.addLast("juan");
		System.out.println(list);

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add(0, "don");
		list2.add(1, "pepe");
		list2.add(2, "gonzales");
		list2.add(3, "gonzales");
		list2.add(4, "luna");
		list2.add(5, "pepe");
		list.addAll(list2);
		System.out.println(list);

		list.remove("don");
		System.out.println(list);

		list.removeAll("juan");
		System.out.println(list);

		int last = list.findLast("gonzales");
		System.out.println(last);

		ArrayList<Integer> lastAll = list.findAll("pepe");
		System.out.println(lastAll);

		list.sort();

		ArrayList<Integer> test = new ArrayList<Integer>();
		test.addLast(8);
		test.addLast(6);
		test.addLast(1);

		System.out.println(test);
		test.sort();
		System.out.println(test);
	}

	public void test(String[] args) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		for (int i = 1; i <= 10000; i++)
			lista.add(i - 1, i);

		long inicio = System.currentTimeMillis();

		int s = 0;
		Iterator<Integer> it = lista.iterator();
		while (it.hasNext())
			s += it.next();

		long fin = System.currentTimeMillis();
		System.out.println("Tiempo: " + (fin - inicio));
	}
}
