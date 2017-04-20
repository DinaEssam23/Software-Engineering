package com.project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class ViewGamesController {

	@RequestMapping("/ShowGamesT")
	public String T() {
		return "ShowGamesT";
	}

	@RequestMapping("/ShowGamesS")
	public String S() {
		return "ShowGamesS";
	}

	@RequestMapping("/Play")
	public String plaay() {
		return "Play";
	}

	@RequestMapping("/games")
	public List<String> viewResult(@RequestParam("course") String course) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/brightminds?useSSL=false", "nouran",
				"root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT *  FROM game ");

		List<String> games = new ArrayList<String>();
		while (rs.next()) {
			String n = rs.getString("name");
			String c = rs.getString("course");

			if (c.equals(course)) {
				games.add(n);
			}
		}
		return games;
	}

	@RequestMapping("/play")
	public List<String> play(@RequestParam("course") String course) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/brightminds?useSSL=false", "nouran",
				"root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT *  FROM game ");

		List<String> games = new ArrayList<String>();
		while (rs.next()) {
			String n = rs.getString("name");
			String c = rs.getString("course");

			if (c.equals(course)) {
				games.add(n);
			}
		}
		return games;
	}

}
