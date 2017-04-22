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
	public static String loggedname;
	public static String loggedpassword;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/WelcomeStudent").setViewName("WelcomeStudent");
		registry.addViewController("/WelcomeTeacher").setViewName("WelcomeTeacher");
		registry.addViewController("/Home").setViewName("Home");
		registry.addViewController("/").setViewName("Home");
		registry.addViewController("/Login").setViewName("Login");

	}

	@RequestMapping("/login")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password)
			throws SQLException {
		loggedname = name;
		loggedpassword = password;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/brightminds?useSSL=false", "nouran",
				"root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT name, password,type FROM users");

		while (rs.next()) {
			String type = rs.getString("type");
			String username = rs.getString("name");
			String pass = rs.getString("password");
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
