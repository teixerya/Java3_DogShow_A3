package ca.sheridancollege.teixerya.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.teixerya.bean.Breed;
import ca.sheridancollege.teixerya.guestrepository.BreedRepository;


@Controller
public class BreedController {

	@Autowired
	private BreedRepository breedRepo;
	
	
//	@GetMapping("/newContact")
//	public String goToNewContact(Model model) {
//		model.addAttribute("breed", new Breed());
//		return "newContact.html";
//	}
//
//	@PostMapping("/newContact")
//	public String newContactToDatabase(@ModelAttribute Breed breed, Model model) {
//
//		breedRepo.addBreedAtRepo(breed.getBreedName());
//
//		return "redirect:/addBreed";
//	}
	
	
	
//	@GetMapping(value= {"/addBreed"})
//	public String goToNewBreed(Model model) {
//		model.addAttribute("breed", new Breed());
//		return "addBreeds.html";
//	}
	
//	@PostMapping("/addBreedToController")
//	public String addBreedToDatabase(@RequestParam String breedName) {
//		breedRepo.addBreedAtRepo(breedName);
//		return "redirect:/addBreed";
//	}
}