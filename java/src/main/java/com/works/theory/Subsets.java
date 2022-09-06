package com.works.theory;

import java.util.*;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Subsets {
	static ArrayList<String> list1 = new ArrayList<String>();
	static ArrayList<String> list2 = new ArrayList<String>();

	// GUI
	static JFrame frame = new JFrame("Set Theory");
	static JTextField setOne = new JTextField(20);
	static JTextField setTwo = new JTextField(20);

	private static boolean StringToArrayList(String a, String b) {
		a.trim();
		b.trim();

		if (a.length() == 0 || b.length() == 0) {
			showMessageDialog(null, "Please enter a set");
			return false;
		} else {
			String[] array = a.split(",");
			String[] array2 = b.split(",");

			for (String s : array)
				list1.add(s);
			for (String s : array2)
				list2.add(s);

			return true;
		}
	}

	private static void handlerOnClick() {
		if (StringToArrayList(setOne.getText(), setTwo.getText())) {
			System.out.println(list1.size());
			System.out.println(list2.size());

			if (list1.isEmpty() && list2.isEmpty())
				showMessageDialog(null, "set is empty or them equals", "Error", JOptionPane.ERROR_MESSAGE);

			if (list1.size() > list2.size() || list1.size() == list2.size()) {
				if (set(list1, list2))
					showMessageDialog(null, "B is a subset of A");
			}

			if (list2.size() > list1.size() || list1.size() == list2.size()) {
				if (set(list2, list1))
					showMessageDialog(null, "A is a subset of B");
			}
			frame.dispose();

			question();
		}
	}

	private static boolean set(ArrayList<String> arr1, ArrayList<String> arr2) {
		int counter = 0;

		for (String item : arr2)
			for (String item2 : arr1)
				if (item.equals(item2))
					counter++;

		if (counter == arr2.size()) {
			return true;
		} else {
			showMessageDialog(null, "Not subset", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public static void run() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLayout(new GridLayout(4, 1));

		JLabel textFieldInfo = new JLabel("Insert items separated by , without spaces");
		JButton button = new JButton("OK");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(new JLabel("Set A:"));
		panel.add(setOne);
		panel.add(new JLabel("Set B:"));
		panel.add(setTwo);

		// Add components to the frame
		frame.getContentPane().add(textFieldInfo);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(button);
		frame.pack();

		// Display the frame
		frame.setVisible(true);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handlerOnClick();
			}
		});
	}

	static void question() {
		Scanner sc = new Scanner(System.in);
		System.out.println("🪄  Do you want to more? (y/n)");
		String answerer = sc.nextLine();
		if (answerer.equals("y")) {
			frame.getContentPane().removeAll();
			list1.clear();
			list2.clear();
			run();
		} else {
			sc.close();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		run();
	}
}
