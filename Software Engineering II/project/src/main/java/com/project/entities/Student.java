package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotEmpty
	private String email;

	@NotEmpty
	@Size(min = 8, max = 20)
	private String password;

	@NotEmpty
	private String name;

	@Min(6)
	private int age;

	@NotEmpty
	private String gender;

	@NotEmpty
	private String nationality;

	private int score;
	private String VerificationCode = ""; // 3shan f teacher not empty
	private String type = "student"; // 3shan a3rf hd5ol f anhy page fl login

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
