package ca.sheridancollege.teixerya.publiccontroller;

import ca.sheridancollege.teixerya.bean.Breed;
import ca.sheridancollege.teixerya.bean.Dog;
import ca.sheridancollege.teixerya.publicrepository.BreedRepository;
import ca.sheridancollege.teixerya.publicrepository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class DogController {

    @Autowired
    @Lazy
    private DogRepository dogRepo;
    
    @Autowired
    @Lazy
    private BreedRepository breedRepo;

    
	@GetMapping("/addDogLink")
	public String goToAddDog(Model model) {
		model.addAttribute("dog", new Dog());
		model.addAttribute("breedList", breedRepo.getBreed());
		return "dogRegistration.html";
	}

	@PostMapping("/addDogLink")
	public String newDogToDatabase(@ModelAttribute Dog dog, Model model) {

		dogRepo.addDogAtRepo(dog);

		return "redirect:/addDogLink";
	}
    
    
    
//    @GetMapping("/addDogLink")
//    public String goToAddBreedPage(Model model) {
//        model.addAttribute("dog", new Dog());
//        model.addAttribute("breedList", breedRepo.getBreed());
//        return "dogRegistration.html";
//    }
//
//    @PostMapping("/addDogLink")
//    public String addBreedToDatabase(@ModelAttribute Dog dog, Model model) {
//
//        System.out.println("\nSecurity Controller @PostMapping addDogToController breed is "+ dog+ "\n");
//
//        dogRepo.addDogAtRepo(dog);
//
//
////		return "redirect:/addBreed";
//        return "dogRegistration.html";
//    }

}
