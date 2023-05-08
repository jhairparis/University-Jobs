package com.works.POO.inherence;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student extends Person {
	private int code;
	private float grade;

	public Student(String name, String lastName, String country, char gender, int id, int ageBirth, int code,
			float grade) {
		super(name, lastName, country, gender, id, ageBirth);
		this.code = code;
		this.grade = grade;
	}
}
