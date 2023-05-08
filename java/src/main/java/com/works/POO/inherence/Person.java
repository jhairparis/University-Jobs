package com.works.POO.inherence;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
	private String name, lastName, country;
	private char gender;
	private int id, ageBirth;

	public Person(String name, String lastName, String country, char gender, int id, int ageBirth) {
		this.name = name;
		this.lastName = lastName;
		this.country = country;
		this.gender = gender;
		this.id = id;
		this.ageBirth = ageBirth;
	}
}
