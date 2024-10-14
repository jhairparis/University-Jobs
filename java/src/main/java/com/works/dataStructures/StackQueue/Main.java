package com.works.dataStructures.StackQueue;

import java.util.Stack;

import com.utils.Colors;
import com.utils.Tidbits;

public class Main {
	static Stack<Integer> operands = new Stack<Integer>();
	static Stack<Character> operators = new Stack<Character>();

	public static int dijkstra(String expression) {
		for (int i = 0; i < expression.length(); i++) {
			char item = expression.charAt(i);

			Boolean isDigit = Character.isDigit(item);

			if (isDigit)
				operands.push(Character.digit(item, 10));

			if (item == '*' || item == '+')
				operators.push(item);

			if (item == ')') {
				int a = operands.pop(),
						b = operands.pop();

				char op = operators.pop();

				if (op == '+')
					operands.push(a + b);
				if (op == '*')
					operands.push(a * b);
			}

		}
		if (operators.size() != 0)
			return -1;
		else
			return operands.pop();
	}

	public static void main(String[] args) {
		Tidbits.Start();

		// String expression = "( ( 4 * 5 ) + ( 9 + ( 9 * ( 2 + 1 ) ) ) )";
		String expression = "( ( 4 * 5 ) + ( ( 9 + 1 ) + ( (9 + 2 ) * ( 2 + 1 ) ) ) )";
		String expressionBad = "( ( 4 * 5 ) + ( 9 + ( 9 * ( 2 + 1 ) ) )";

		int res = dijkstra(expression);
		int resBad = dijkstra(expressionBad);

		System.out.println(expression);
		System.out.println(Colors.COLOR_CYAN(res));

		System.out.println(expressionBad);
		System.out.println(Colors.COLOR_RED(resBad));
	}
}
