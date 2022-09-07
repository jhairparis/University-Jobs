package com.works.POO.exercise;

enum typeAccount {
	saving, checking
};

public class BankAccount {
	String name, lastName;
	long numberAccount;
	typeAccount typeAccount;
	long balance;

	BankAccount(String name, String lasName, typeAccount typeAccount) {
		this.name = name;
		this.lastName = lasName;
		this.numberAccount = (long) (Math.random() * (999999 - 1 + 1) + 1);
		this.typeAccount = typeAccount;
	}

	public String toString() {
		return "Name: " + this.name +
				"\nLast Name: " + this.lastName +
				"\nTypeAccount: " + this.typeAccount +
				"\nNumber of Account: " + this.numberAccount +
				"\nBalance: " + this.balance;
	}
}
