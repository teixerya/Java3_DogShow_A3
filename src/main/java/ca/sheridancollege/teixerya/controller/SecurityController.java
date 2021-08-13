package ca.sheridancollege.teixerya.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.teixerya.bean.Breed;
import ca.sheridancollege.teixerya.bean.User;
import ca.sheridancollege.teixerya.publicrepository.BreedRepository;
import ca.sheridancollege.teixerya.repository.SecurityRepository;

@Controller
public class SecurityController {
	
	
	@Autowired
	@Lazy
	private SecurityRepository secRepo;
	

	
	@GetMapping("/login")
	public String goLogin() {
		return "login.html";
	}
	
	@GetMapping("/access-denied")
	public String goAccessDenied() {
		return "access-denied.html";
	}


	@GetMapping("/register")
	public String goToRegistration() {
		return "registration.html";
	}

	@PostMapping("/register")
	public String registerNewUser(@RequestParam String username,
								  @RequestParam String password,
								  @RequestParam String[] user_sec) {

		if (secRepo.findUserAccount(username) != null) {
			//The username already exists.
		} else {

			secRepo.addUser(username, password);
			User user = secRepo.findUserAccount(username);


			for (int i = 0; i < user_sec.length; i++) {
				String[] storeSecUserTemp = user_sec;
				if (storeSecUserTemp[i].contains("admin")) {
					secRepo.addRole(user.getUserId(), 1);
				} else {
					secRepo.addRole(user.getUserId(), 2);
				}
			}

		}
		
		return "redirect:/login";
	}

	

}


