package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String email;

	private String password;

	private String name;

	// @Min(6)
	private int age;

	private String gender;

	private String nationality;

	private int score;
	private String type = "student";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Student(Integer id, String password, String name, int age, String gender, String nationality, String email,
			int score) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
		this.email = email;
		this.score = score;
	}

	public Student() {
		password = "";
		name = "";
		age = 6;
		gender = "";
		nationality = "";
		email = "";
		score = 0;
	}

}
