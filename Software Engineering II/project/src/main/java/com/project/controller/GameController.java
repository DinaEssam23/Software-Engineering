package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		registry.addViewController("/QA").setViewName("QA");
	}

	// @GetMapping("/QA")
	// public String ShowFormQA(Model model) {
	// model.addAttribute("questions", new Questions());
	// return "QA";
	// }

	// lw atktb mn awel mra
	@GetMapping("/CreatingGame")
	public String ShowFormGames(Model model) {
		model.addAttribute("game", new Game());
		return "CreatingGame";
	}

	// lw atb3tt mn b-data in post method
	@PostMapping("/CreatingGame")
	public String addGame(Model model, @ModelAttribute @Valid Game game, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "CreatingGame";
		}

		repo.save(game);
		model.addAttribute("game", new Game());
		return "redirect:/QA";
	}

	@RequestMapping("/add")
	public String QAs(@RequestParam("Gname") String Gname, @RequestParam("question1") String question1,
			@RequestParam("choices1") String choices1, @RequestParam("answer1") String answer1,
			@RequestParam("question2") String question2, @RequestParam("choices2") String choices2,
			@RequestParam("answer2") String answer2, @RequestParam("question3") String question3,
			@RequestParam("choices3") String choices3, @RequestParam("answer3") String answer3,
			@RequestParam("Gcourse") String Gcourse) {
		Questions questions1 = new Questions();
		Questions questions2 = new Questions();
		Questions questions3 = new Questions();

		questions1.setGname(Gname);
		questions1.setQuestion(question1);
		questions1.setChoices(choices1);
		questions1.setAnswer(answer1);
		questions1.setGcourse(Gcourse);
		repos.save(questions1);

		questions2.setGname(Gname);
		questions2.setQuestion(question2);
		questions2.setChoices(choices2);
		questions2.setAnswer(answer2);
		questions2.setGcourse(Gcourse);
		repos.save(questions2);

		questions3.setGname(Gname);
		questions3.setQuestion(question3);
		questions3.setChoices(choices3);
		questions3.setAnswer(answer3);
		questions3.setGcourse(Gcourse);
		repos.save(questions3);

		return "redirect:/ShowCoursesT";

	}

	@GetMapping("/gamesT")
	public String showGamesT(Model model, @RequestParam("course") String course) {
		Iterable<Game> gamesIT = repo.findAll();
		List<Game> gamesList = new ArrayList<Game>();
		for (Game game : gamesIT) {
			if (game.getCourse().equals(course)) {
				gamesList.add(game);
			}
		}
		model.addAttribute("games", gamesList);
		return "ShowCoursesT";
	}

	@GetMapping("/gamesS")
	public String showGamesS(Model model, @RequestParam("course") String course) {
		Iterable<Game> gamesIT = repo.findAll();
		List<Game> gamesList = new ArrayList<Game>();
		for (Game game : gamesIT) {
			if (game.getCourse().equals(course)) {
				gamesList.add(game);
			}
		}
		model.addAttribute("games", gamesList);
		return "ShowCoursesS";
	}

	@GetMapping("/show")
	public String showQuestions(Model model, @RequestParam("game") String game, @RequestParam("course") String course) {
		Iterable<Questions> questionsIT = repos.findAll();
		List<Questions> questionsList = new ArrayList<Questions>();
		for (Questions question : questionsIT) {
			if (question.getGname().equals(game) && question.getGcourse().equals(course)) {
				questionsList.add(question);
			}
		}
		model.addAttribute("questions", questionsList);
		return "Play";
	}

}
