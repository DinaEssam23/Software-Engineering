package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class Teacher {

	@Id
	@GeneratedValue
	private Integer id;

	@NotEmpty
	private String email;

	@NotEmpty
	private String name;

	@Min(20)
	private int age;

	@NotEmpty
	private String gender;

	@NotEmpty
	private String nationality;

	@NotEmpty
	@Size(min = 4, max = 20)
	private String VerificationCode;

	@NotEmpty
	@Size(min = 8, max = 20)
	private String password;

	private String type = "teacher"; // 3shan a3rf hd5ol f anhy page fl login
	private int score = -1; // 3lshan mynf3sh fl db tkon b-null 3shan int fa
							// lazm
							// ay initial value

	public Teacher() {
		password = "";
		name = "";
		age = 20;
		gender = "";
		nationality = "";
		email = "";
		VerificationCode = "";
	}

	public Teacher(Integer id, String email, String name, int age, String gender, String nationality,
			String verificationCode, String password) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
		VerificationCode = verificationCode;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getVerificationCode() {
		return VerificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		VerificationCode = verificationCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
