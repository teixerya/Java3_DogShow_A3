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
    public String goToDogPage(Model model, Authentication authentication){

        System.out.println("\n\n /viewDogs " );

        ArrayList<Dog> dogs = new ArrayList<Dog>();
        String name=authentication.getName();
        List<String> roles = new ArrayList<String>();

        for(GrantedAuthority ga: authentication.getAuthorities()) {
            roles.add(ga.getAuthority());
        }

        System.out.println("\nroles /viewDogs " + roles);


        System.out.println("\n@GetMapping /viewDogs dogs before" + dogs);
        dogs.addAll((dogRepo.getDogs()));


        System.out.println("\n@GetMapping /viewDogs dogs after .getDogs()" + dogs);

        model.addAttribute("dogs", dogs);
        return "viewDogs.html";


    }



    @GetMapping("/deleteDog/{dogId}")
    public String deleteDog(@PathVariable int dogId, Model model) {
        dogRepo.deleteDog(dogId);
        return "redirect:/viewDogs";
    }



}














