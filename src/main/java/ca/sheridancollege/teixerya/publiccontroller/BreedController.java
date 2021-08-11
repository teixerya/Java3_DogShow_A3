package ca.sheridancollege.teixerya.publiccontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.teixerya.bean.Breed;
import ca.sheridancollege.teixerya.publicrepository.BreedRepository;


@Controller
public class BreedController {

	@Autowired
	private BreedRepository breedRepo;
	
	
	@GetMapping("/addBreedLink")
	public String goToAddBreedPage(Model model) {
		model.addAttribute("breed", new Breed());
		return "addBreedPage.html";
	}

	@PostMapping("/addBreedLink")
	public String addBreedToDatabase(@ModelAttribute Breed breed, Model model) {

		System.out.println("\nSecurity Controller @PostMapping addBreedToController breed is "+ breed+ "\n"); 
		
		breedRepo.addBreedAtRepo(breed);


		return "addBreedPage.html";
	}
	
}