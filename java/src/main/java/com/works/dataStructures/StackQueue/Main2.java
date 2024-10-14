package com.works.dataStructures.StackQueue;

import java.util.Stack;

public class Main2 {
	static Stack<Integer> operands = new Stack<Integer>();

	public static int postfixed(String eval) {
		eval = eval.replaceAll(" ", "");
		for (int i = 0; i < eval.length(); i++) {
			char item = eval.charAt(i);
			Boolean isDigit = Character.isDigit(item);
			if (isDigit)
				operands.push(Character.digit(item, 10));
			else {
				if (!(operands.size() >= 2))
					throw new Error("expression is incorrect");
				int a = operands.pop(),
						b = operands.pop();
				if (item == '+')
					operands.push(a + b);
				if (item == '*')
					operands.push(a * b);
			}
		}

		if (operands.size() != 1)
			throw new Error("Error");
		return operands.get(0);
	}

	public static void main(String[] args) {
		String expression = "3 5 + 1 4 + * 5 4 * +";
		System.out.println(postfixed(expression));
	}
}
