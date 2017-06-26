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
		
		Food f= new Food();
		
		m.addAttribute("listfood", f);
		
		
		return "mainpage";
	}
	
	
	@PostMapping("/foodlist")
	public String showList(@ModelAttribute Food f, Model food  ){
		
		foodRepo.save(f);
		
		Iterable<Food> a = foodRepo.findAll();
		
		food.addAttribute("list", a);
		return "result";
	}
	
	
	
	
	

}
