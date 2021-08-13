package ca.sheridancollege.teixerya.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.teixerya.bean.Contact;
import ca.sheridancollege.teixerya.repository.ContactRepo;

@Controller
public class HomeController {

	
	@Autowired
	@Lazy
	private ContactRepo da;
	
	
	@GetMapping("/")
	public String goHome() {
		return "index.html";
	}
	
	@GetMapping("/viewContact")
	public String goToUserPage(Model model, Authentication authentication) {
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		String name=authentication.getName();
		List<String> roles = new ArrayList<String>();
		
		for(GrantedAuthority ga: authentication.getAuthorities()) {
			roles.add(ga.getAuthority());
		}
		
		if(roles.contains("ROLE_ADMIN")) {
			contacts.addAll((da.getAdminContacts()));
		}

		
		if(roles.contains("ROLE_MEMBER")) {
			contacts.addAll((da.getMembersContacts()));
		}
		
		if(roles.contains("ROLE_GUEST")) {
			contacts.addAll((da.getGuestContacts()));
		}
		
		model.addAttribute("contacts", contacts);
		return "/viewContact.html";

	}
	
	@GetMapping("/adminView") public String goToUserPage() {
		return "redirect:/viewContact"; } 
	
	@GetMapping("/ownerView")
	public String goToPicklePage() { 
	return "redirect:/viewContact"; } 
	
	@GetMapping("/guestView")
	public String goToEmployeePage() { 
		return "redirect:/viewContact"; } 
	

	
}
