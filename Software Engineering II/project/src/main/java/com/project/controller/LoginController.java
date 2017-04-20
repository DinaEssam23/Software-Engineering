package com.project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class LoginController extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/WelcomeStudent").setViewName("WelcomeStudent");
		registry.addViewController("/WelcomeTeacher").setViewName("WelcomeTeacher");
		registry.addViewController("/Home").setViewName("Home");
		registry.addViewController("/").setViewName("Home");
		registry.addViewController("/Login").setViewName("Login");

	}

	@RequestMapping("/Login")
	public String Login() {
		return "Login";
	}

	@RequestMapping("/login")
	public String viewResult(@RequestParam("name") String name, @RequestParam("password") String password)
			throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/brightminds?useSSL=false", "nouran",
				"root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT name, password,type FROM users WHERE name = name and password = password");

		String type = "";
		String username = "";
		String pass = "";
		while (rs.next()) {
			type = rs.getString("type");
			username = rs.getString("name");
			pass = rs.getString("password");
			if (type.equals("student") && username.equals(name) && pass.equals(password)) {
				return "redirect:/WelcomeStudent";
			}
			if (type.equals("teacher") && username.equals(name) && pass.equals(password)) {

				return "redirect:/WelcomeTeacher";
			}
		}

		return "redirect:/Home";
	}

}
