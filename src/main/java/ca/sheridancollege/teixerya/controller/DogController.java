package ca.sheridancollege.teixerya.controller;

import ca.sheridancollege.teixerya.bean.Contact;
import ca.sheridancollege.teixerya.bean.Dog;
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

    @GetMapping("/viewDogs")
    public String goToDogPage(Model model, Authentication authentication){

        ArrayList<Dog> dogs = new ArrayList<Dog>();

        List<String> roles = new ArrayList<String>();

        for(GrantedAuthority ga: authentication.getAuthorities()) {
            roles.add(ga.getAuthority());
        }

        if(roles.contains("ROLE_OWNER")) {

            String name = authentication.getName();
            dogs= dogRepo.getOwnerDogs(name);

        }

        if(roles.contains("ROLE_ADMIN")) {
            dogs = dogRepo.getDogs();
        }

        model.addAttribute("dogs", dogs);
        return "viewDogs.html";

    }

    @GetMapping("/edit/{dogId}")
    public String editDog(@PathVariable int dogId, Model model) {
        Dog dog = dogRepo.getDogById(dogId);
        model.addAttribute("dog", dog);
        return "editDog.html";
    }

    @PostMapping("/editDog")
    public String updateDog(@ModelAttribute Dog dog) {
        dogRepo.editDog(dog);
        return "viewDogs.html";
    }

    @GetMapping("/delete/{dogId}")
    public String deleteDog(@PathVariable int dogId, Model model) {
        dogRepo.deleteDog(dogId);
        return "redirect:/viewContact";
    }



}














