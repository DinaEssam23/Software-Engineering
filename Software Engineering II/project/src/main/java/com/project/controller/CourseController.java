package com.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.project.entities.Course;
import com.project.repository.CourseRepository;

@Controller
public class CourseController extends WebMvcConfigurerAdapter {

	@Autowired
	private CourseRepository repo;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/AddCourse").setViewName("AddCourse");
		registry.addViewController("/ShowCoursesS").setViewName("ShowCoursesS");
		registry.addViewController("/ShowCoursesT").setViewName("ShowCoursesT");

	}

	@GetMapping("/AddCourse")
	public String ShowForm(Model model) {
		model.addAttribute("course", new Course());
		return "AddCourse";
	}

	@PostMapping("/AddCourse")
	public String addCourse(Model model, @ModelAttribute @Valid Course course, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "AddCourse";
		}

		System.out.println(course.getName());
		System.out.println(course.getAge());
		System.out.println(course.getBio());
		repo.save(course);
		model.addAttribute("course", new Course());
		return "redirect:/ShowCoursesT";
	}

	@GetMapping("/result")
	public @ResponseBody Iterable<Course> showAllCoures() {
		return repo.findAll();
	}
}
