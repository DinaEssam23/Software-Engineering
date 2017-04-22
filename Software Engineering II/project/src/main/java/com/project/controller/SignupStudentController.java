package com.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.project.entities.Student;
import com.project.repository.StudentRepository;

@Controller
public class SignupStudentController extends WebMvcConfigurerAdapter {

	@Autowired
	private StudentRepository repo;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/WelcomeStudent").setViewName("WelcomeStudent");

	}

	@GetMapping("/SignupStudent")
	public String ShowSignupForm(Model model) {
		model.addAttribute("student", new Student());
		return "SignupStudent";
	}

	@PostMapping("/SignupStudent")
	public String SignupStudent(Model model, @ModelAttribute @Valid Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "SignupStudent";
		}

		repo.save(student);
		model.addAttribute("student", new Student());
		return "redirect:/Login";
	}
}
