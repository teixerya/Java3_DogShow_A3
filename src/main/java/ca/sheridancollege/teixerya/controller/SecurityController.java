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
			@RequestParam Optional<String> role,
			@RequestParam Optional<String> role2,
			@RequestParam Optional<String> role3
			
			) {
		
		if(secRepo.findUserAccount(username) != null) {
			//The username already exists.
		} else {

			secRepo.addUser(username,password);

			User user = secRepo.findUserAccount(username);
			

			String opt = role.toString();
			String opt2 = role2.toString();
			String opt3 = role3.toString();
			
			if (opt.equals("Optional[admin]")) {
				System.out.println("\nUser ID" + user.getUserId());
				System.out.println("opt sout "+ opt);
				System.out.println("printed role if statement ");

			secRepo.addRole(user.getUserId(), 1);//User
			} 
			
			if (opt2.equals("Optional[member]")) {
				System.out.println("\nUser ID" + user.getUserId());
				System.out.println("opt2 sout "+ opt2);
				System.out.println("printed role2 if statement");

			secRepo.addRole(user.getUserId(), 2);//User
			} 
			
			if (opt3.equals("Optional[guest]")) {
				System.out.println("\nUser ID" + user.getUserId());
				System.out.println("opt3 sout "+ opt3);
				System.out.println("printed role3 if statement");
				
				secRepo.addRole(user.getUserId(), 3);//User
			} 
					
			
		}
		
		return "redirect:/";
	}

	

}


