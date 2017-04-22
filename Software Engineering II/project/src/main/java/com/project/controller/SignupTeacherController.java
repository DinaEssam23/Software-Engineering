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

import com.project.entities.Teacher;
import com.project.repository.TeacherRepository;

@Controller
public class SignupTeacherController extends WebMvcConfigurerAdapter {

	@Autowired
	private TeacherRepository repo;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/WelcomeTeacher").setViewName("WelcomeTeacher");
	}

	@GetMapping("/SignupTeacher")
	public String ShowSignupForm(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "SignupTeacher";
	}

	@PostMapping("/SignupTeacher")
	public String SignupTeacher(Model model, @ModelAttribute @Valid Teacher teacher, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "SignupTeacher";
		} else {

			repo.save(teacher);
			model.addAttribute("teacher", new Teacher());
			return "redirect:/Login";
		}
	}
}
