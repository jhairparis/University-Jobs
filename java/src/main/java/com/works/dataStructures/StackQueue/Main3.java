package com.works.dataStructures.StackQueue;

import java.util.ArrayList;
import java.util.Stack;

import com.utils.*;

public class Main3 {
	static Stack<ArrayList<Integer>> callStack = new Stack<ArrayList<Integer>>();
	static Stack<Integer> results = new Stack<Integer>();

	public static int StackFibonacci(int n) {
		boolean finish = false;
		while (!finish) {
			if (callStack.size() == 0) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(n);
				temp.add(0);
				callStack.push(temp);
			}

			if (callStack.size() > 0) {
				ArrayList<Integer> current = callStack.pop();

				if (current.get(0) <= 1)
					results.push(current.get(0));
				else if (current.get(1) == 1) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(current.get(0));
					if (current.get(1) == 1)
						temp.add(2);

					callStack.push(temp);

					// llamado n-2
					ArrayList<Integer> temp2 = new ArrayList<Integer>();
					temp2.add(current.get(0) - 2);
					if (current.get(1) == 1)
						temp2.add(0);

					callStack.push(temp2);
				} else if (current.get(1) == 2) {
					int a = results.pop();
					int b = results.pop();
					results.push(a + b);
					if (callStack.size() == 0 && results.size() == 1)
						finish = true;
				} else if (current.get(1) == 0) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(current.get(0));
					if (current.get(1) == 0)
						temp.add(1);

					callStack.push(temp);

					ArrayList<Integer> temp2 = new ArrayList<Integer>();
					temp2.add(current.get(0) - 1);
					if (temp.get(1) == 1)
						temp2.add(0);

					callStack.push(temp2);
					n--;
				}
			}

		}
		return results.pop();
	}

	public static void main(String[] args) {
		Tidbits.Start();
		System.out.println(Colors.YELLOW_BACKGROUND(" CallStack of fibonacci "));
		String r = Colors.COLOR_GREEN(StackFibonacci(4));
		System.out.println(r);
	}
}
