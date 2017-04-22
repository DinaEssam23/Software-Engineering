package com.project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Controller
public class PlayController {

	@RequestMapping("/answers")
	public ModelAndView Play(@RequestParam("game") String game, @RequestParam("course") String course,
			@RequestParam("answer1") String answer1, @RequestParam("answer2") String answer2,
			@RequestParam("answer3") String answer3) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/brightminds?useSSL=false", "nouran",
				"root");
		ArrayList<String> answers = new ArrayList<String>();
		ModelAndView mv = new ModelAndView();
		int score = 0;
		try {
			Statement stmt = conn.createStatement();
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM questions");
				try {
					while (rs.next()) {
						String g = rs.getString("gname");
						String c = rs.getString("gcourse");
						String a = rs.getString("answer");
						if (g.equals(game) && c.equals(course)) {
							answers.add(a);
						}
					}
				} finally {
					rs.close();
				}
			} finally {
				stmt.close();
			}
		} finally {
			conn.close();
		}

		if (answer1.equals(answers.get(0))) {
			score++;

		}
		if (answer2.equals(answers.get(1))) {
			score++;
		}
		if (answer3.equals(answers.get(2))) {
			score++;
		}
		updateScore(score);

		mv.setViewName("Play");
		mv.addObject("answers", score);
		return mv;

	}

	private void updateScore(int s) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/brightminds?useSSL=false", "nouran",
				"root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM users");
		while (rs.next()) {
			String name = rs.getString("name");
			String password = rs.getString("password");
			Integer id = rs.getInt("id");
			if (name.equals(LoginController.loggedname) && password.equals(LoginController.loggedpassword)) {
				stmt = conn.createStatement();
				String sql = "UPDATE users " + "SET score = " + s + " Where id = " + id;
				stmt.executeUpdate(sql);
			}
		}
	}

}
