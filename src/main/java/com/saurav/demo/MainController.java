package com.saurav.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")  // starts with localhost:8080/
public class MainController {


	@Autowired
	public FoodRepository foodRepo;

	@GetMapping("/foodlist")
	public String mainPage(Model m){


		m.addAttribute("listfood", new FoodPotluck());


		return "mainpage";
	}


	@PostMapping("/foodlist")
	public String showList(@ModelAttribute FoodPotluck listfood, Model food  ){

		foodRepo.save(listfood);

		Iterable<FoodPotluck> a = foodRepo.findAll();

		food.addAttribute("list", a);
		return "result";
	}

	@GetMapping("/delete")
	public String deleteForm(Model m){

		FoodPotluck p= new FoodPotluck();
		m.addAttribute("deleteName", p);
		return "delete";


	}

	@PostMapping("/delete")
	public String deletePerson(@ModelAttribute FoodPotluck deleteName ,Model food  ){

		Iterable<FoodPotluck> aa = foodRepo.findByPersonName(deleteName.getPersonName());

		foodRepo.delete(aa);;



		Iterable<FoodPotluck> a = foodRepo.findAll();

		food.addAttribute("list", a);
		return "result";
	}




}
