package ca.sheridancollege.teixerya.controller;

import ca.sheridancollege.teixerya.bean.Dog;
import ca.sheridancollege.teixerya.publicrepository.DogRepository;
import ca.sheridancollege.teixerya.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class DogController {

    @Autowired
    @Lazy
    private DogRepository dogRepo;

    @GetMapping("/viewDog")
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
        return "checkDogs.html";

    }
}
