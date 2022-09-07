package com.works.POO.exercise;

public class Book {
	String title, author;
	int numberOfCopies, loans;

	Book(String title, String author, int numberOfCopies) {
		this.title = title;
		this.author = author;
		this.numberOfCopies = numberOfCopies;
	}

	public String toString() {
		return "title: " + this.title +
				"\nauthor: " + this.author +
				"\nNumber Of Copies: " + this.numberOfCopies +
				"\nLoans Book: " + this.loans;
	}
}
