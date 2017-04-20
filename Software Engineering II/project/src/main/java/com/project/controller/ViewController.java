// package com.project.controller;
//
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
//
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
//
// import com.project.entities.Course;
//
// @RestController
// public class ViewController {
//
// @RequestMapping("/result")
// public ArrayList<Course> viewResult() throws SQLException {
// Connection conn =
// DriverManager.getConnection("jdbc:mysql://localhost:3306/brightminds?useSSL=false",
// "nouran",
// "root");
// Statement stmt = conn.createStatement();
// ResultSet rs = stmt.executeQuery("SELECT * FROM course");
// String name = "";
// int age;
// String bio = "";
// ArrayList<Course> courses = new ArrayList<Course>();
// while (rs.next()) {
// Course add = new Course();
// name = rs.getString("name");
// age = rs.getInt("age");
// bio = rs.getString("bio");
// add.setName(name);
// add.setAge(age);
// add.setBio(bio);
// courses.add(add);
// }
//
// return courses;
// }
//
// }
