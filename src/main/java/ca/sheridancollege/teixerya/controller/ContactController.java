package ca.sheridancollege.teixerya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.teixerya.bean.Contact;
import ca.sheridancollege.teixerya.repository.ContactRepo;

@Controller
public class ContactController {

	@Autowired
	private ContactRepo  da;
	
	
	@GetMapping("/newContact")
	public String goToNewContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "newContact.html";
	}

	@PostMapping("/newContact")
	public String newContactToDatabase(@ModelAttribute Contact contact, Model model) {

		da.newContact(contact);

		return "redirect:/newContact";
	}


	@GetMapping("/edit/{id}")
	public String editContact(@PathVariable int id, Model model) {
		Contact contact = da.getContactById(id);
		model.addAttribute("contact", contact);
		return "editContact.html";
	}
	
	@PostMapping("/editContact")
	public String modifyContact(@ModelAttribute Contact contact) {
		da.editContact(contact);
		return "redirect:/viewContact";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteContact(@PathVariable int id, Model model) {
		da.deleteById(id);
		return "redirect:/viewContact";
	}
	
}

