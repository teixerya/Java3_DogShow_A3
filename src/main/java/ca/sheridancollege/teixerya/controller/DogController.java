package ca.sheridancollege.teixerya.controller;

import ca.sheridancollege.teixerya.bean.Contact;
import ca.sheridancollege.teixerya.bean.Dog;
import ca.sheridancollege.teixerya.publicrepository.BreedRepository;
import ca.sheridancollege.teixerya.publicrepository.DogRepository;
import ca.sheridancollege.teixerya.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DogController {

    @Autowired
    @Lazy
    private DogRepository dogRepo;

    @Autowired
    @Lazy
    private BreedRepository breedRepo;

    @GetMapping("/viewDogs")
    public String goToDogPage(Model model, Authentication authentication, Dog dog){

        ArrayList<Dog> dogs = new ArrayList<Dog>();
        String name=authentication.getName();
        List<String> roles = new ArrayList<String>();

        for(GrantedAuthority ga: authentication.getAuthorities()) {
            roles.add(ga.getAuthority());
        }

        System.out.println("\n@GetMapping /viewDogs " + roles);

//        if(roles.contains("ROLE_OWNER")) {
////            dogs.addAll((dogRepo.getDogAdminContacts()));
////            String oName = authentication.getName();
//            dogs= dogRepo.getDogs();
//            System.out.println("\n@GetMapping /viewDogs if ROLE_OWNER" + dogs);
//
//        }
//
//        if(roles.contains("ROLE_ADMIN")) {
//            dogs = dogRepo.getDogs();
//        }
        System.out.println("\n@GetMapping /viewDogs dogs before" + dogs);
        dogs= dogRepo.getDogs();
        System.out.println("\n@GetMapping /viewDogs dogs after .getDogs()" + dogs);

        model.addAttribute("dogs", dogs);
        return "viewDogs.html";
//        return "redirect:/viewDogs";

    }

    @GetMapping("/editDog/{dogId}")
    public String editDog(@PathVariable int dogId, Model model) {
        Dog dog = dogRepo.getDogById(dogId);
        model.addAttribute("dog", dog);
        model.addAttribute("breedList", breedRepo.getBreed());

        System.out.println("\n@GetMapping /editDog/{dogId} value dog" + dog);

        return "editDog.html";
    }

    @PostMapping("/editDog")
    public String editDog(@ModelAttribute Dog dog) {
        dogRepo.editDog(dog);
        System.out.println("\n@PostMapping /editDog value dog" + dog);
        return "redirect:/viewDogs";
    }

    @GetMapping("/deleteDog/{dogId}")
    public String deleteDog(@PathVariable int dogId, Model model) {
        dogRepo.deleteDog(dogId);
        return "redirect:/viewDogs";
    }



}














