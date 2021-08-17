package ca.sheridancollege.teixerya.restcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.teixerya.bean.Dog;
import ca.sheridancollege.teixerya.restrepository.RestDogRepository;



@RestController
public class RestDogController {

	@Autowired
    @Lazy
	private RestDogRepository restDogRepo;
	
//	@GetMapping("/")
//	public Dog root() {
//		Dog s = new Dog (1, "Sully", "Bobby", "American Bully", "Male", "Specialty");
//		return s;
//	}
	
	@GetMapping("/restdogs")
	public List<Dog> getDogs(){
		return restDogRepo.getDogs();
	}
	
	@GetMapping("/restdogs/{dogId}")
	public Dog getDogsById(@PathVariable int dogId){

		System.out.println(restDogRepo.getDogsById(dogId));
		return restDogRepo.getDogsById(dogId);
	}
	

	
	@PostMapping(value="/restdogs", headers = {"Content-type=application/json"})
	public String poststudent(@RequestBody Dog student) {
		restDogRepo.addDog(student);
		return "student was added";
	}
	
	@PutMapping(value="/restdogs", headers = {"Content-type=application/json"})
	public String putDogList(@RequestBody List<Dog> students) {
		restDogRepo.deleteAllDogs();
		restDogRepo.resetCounter();
		for(Dog s: students) {
			restDogRepo.addDog(s);
		}
		return "Records Added: " + restDogRepo.getDogs().size();
		
	}
	
	
	//PUT-ELEMENT edit element
	@PutMapping(value="/restdogs/{dogId}", headers = {"Content-type=application/json"})
	public String putDogsById(@PathVariable int dogId, @RequestBody Dog student) {
//		restDogRepo.updateDogs(dogId,student);
//		restDogRepo.deleteDogByID(dogId);
//		restDogRepo.addDog(student);
		System.out.println("Path variable ID# " + dogId);
		System.out.println("student from JSON " + student);

		restDogRepo.editDog(dogId, student);
		
		return "Record Edited";
	}
	
	
	//DELETE-COLLECTION
	@DeleteMapping(value="/restdogs", headers= {"Content-type=application/json"})
	public String deleteDogList() {
		restDogRepo.deleteAllDogs();
		return "Records deleted";
	}
	
	//DELETE-ELEMENT
	@DeleteMapping(value="/restdogs/{dogId}",headers = {"Content-type=application/json"})
	public String deleteDogsById(@PathVariable int dogId) {
		restDogRepo.deleteDogByID(dogId);
		return "Dog " + dogId + " deleted";
	}
	
	
	// HTTP methods - Collection
	//GET - return entire collection 				localhost:8080/students
	//POST - add new element into the collection	localhost:8080/students
	//PUT - edit the entire collection				localhost:8080/students
	
	//**DELETE - delete the entire collection			localhost:8080/students
	
	// HTTP methods - Element
	//GET - return a single element by dogId			localhost:8080/students/dogId
	//POST - Do nothing 
	
	//**PUT - edit a single element by dogId				localhost:8080/students/dogId
	//**DELETE - delete a single element by dogId 		localhost:8080/students/dogId
	
	// All URL's should not be a plural noun based on the data
	// the URL should not have descriptive text
	
	

	
}

