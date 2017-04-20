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

import com.project.entities.Game;
import com.project.entities.Questions;
import com.project.repository.GameRepository;
import com.project.repository.QuestionRepository;

@Controller
public class GameController extends WebMvcConfigurerAdapter {

	@Autowired
	private GameRepository repo;

	@Autowired
	private QuestionRepository repos;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/Play").setViewName("Play");
		registry.addViewController("/ShowCoursesS").setViewName("ShowCoursesS");
		registry.addViewController("/ShowGamesS").setViewName("ShowGamesS");
		registry.addViewController("/CreatingGame").setViewName("CreatingGame");
		registry.addViewController("/QA").setViewName("QA");
		registry.addViewController("/ShowGamesS").setViewName("ShowGamesS");
		registry.addViewController("/ShowGamesT").setViewName("ShowGamesT");
		registry.addViewController("/More").setViewName("More");

	}

	@GetMapping("/QA")
	public String QA(Model model) {
		model.addAttribute("questions", new Questions());
		return "QA";
	}

	@GetMapping("/CreatingGame")
	public String ShowForm(Model model) {
		model.addAttribute("game", new Game());
		return "CreatingGame";
	}

	@PostMapping("/CreatingGame")
	public String addGame(Model model, @ModelAttribute @Valid Game game, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "CreatingGame";
		}

		System.out.println(game.getName());
		System.out.println(game.getDescription());
		repo.save(game);
		model.addAttribute("game", new Game());
		return "redirect:/QA";
	}

	@PostMapping("/QA")
	public String QAs(Model model, @ModelAttribute @Valid Questions questions, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "QA";
		}
		repos.save(questions);
		return "redirect:/More";

	}

}
