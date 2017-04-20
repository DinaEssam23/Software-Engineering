package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotEmpty
	private String Gname;

	@NotEmpty
	private String question;

	@NotEmpty
	private String choices;

	@NotEmpty
	private String answer;

	@NotEmpty
	private String Gcourse;

	public Questions(String gname, String question, String choices, String answer, String gcourse) {
		super();
		Gname = gname;
		this.question = question;
		this.choices = choices;
		this.answer = answer;
		Gcourse = gcourse;
	}

	public Questions() {
		super();
		Gname = "";
		question = "";
		choices = "";
		answer = "";
		Gcourse = "";
	}

	public String getGname() {
		return Gname;
	}

	public void setGname(String gname) {
		Gname = gname;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getChoices() {
		return choices;
	}

	public void setChoices(String choices) {
		this.choices = choices;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getGcourse() {
		return Gcourse;
	}

	public void setGcourse(String gcourse) {
		Gcourse = gcourse;
	}

}
