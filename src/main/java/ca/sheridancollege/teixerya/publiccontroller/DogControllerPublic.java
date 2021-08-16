package ca.sheridancollege.teixerya.publiccontroller;

import ca.sheridancollege.teixerya.bean.Breed;
import ca.sheridancollege.teixerya.bean.Dog;
import ca.sheridancollege.teixerya.publicrepository.BreedRepository;
import ca.sheridancollege.teixerya.publicrepository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class DogControllerPublic {

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



    @GetMapping("/editDog/{dogId}")
    public String editDog(@PathVariable int dogId, Model model) {
        Dog dog = dogRepo.getDogById(dogId);
        model.addAttribute("dog", dog);
        model.addAttribute("breedList", breedRepo.getBreed());

        System.out.println("\n/editDog/{dogId} value dog" + dog);
        System.out.println("@GetMapping /editDog/{dogId} value dog" + dog + "\n");

        return "editDog.html";
    }

    @PostMapping("/editDog")
    public String editDogFromDataBase(@ModelAttribute Dog dog, Model model) {
        dogRepo.editDog(dog);
        System.out.println("\n/editDog value dog" + dog);
        System.out.println("@PostMapping /editDog value dog" + dog + "\n");
        return "redirect:/viewDogs";
    }


}
