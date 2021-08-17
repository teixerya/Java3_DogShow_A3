package ca.sheridancollege.teixerya.restrepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.teixerya.bean.Dog;



@Repository
public class RestDogRepository {


	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public void addDog(Dog dog) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();

		String query = " INSERT INTO DOG_REGISTRY_TABLE (dogName, ownerName, breed, gender, classSpecialty)"
				+ " VALUES "+
				"(:dogName, :ownerName, :breed, :gender, :classSpecialty)";
		parameters.addValue("dogName", dog.getDogName());
		parameters.addValue("ownerName", dog.getOwnerName());
		parameters.addValue("breed", dog.getBreed());
		parameters.addValue("gender", dog.getGender());
		parameters.addValue("classSpecialty", dog.getClassSpecialty());
		
//		String query = " INSERT INTO Dogs (name) VALUES (:name)";
//		parameters.addValue("name", Dog.getName());


		System.out.println("\naddDog method was called");
		jdbc.update(query, parameters);

	}


	
	public ArrayList<Dog> getDogs(){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM DOG_REGISTRY_TABLE ";

		ArrayList<Dog> Dogs = (ArrayList<Dog>)
				jdbc.query(query, new BeanPropertyRowMapper<Dog>(Dog.class));
//		jdbc.update(query, parameters);q
		System.out.println("\ngetDogs method was called");
		
		return Dogs;
		
		
	}
	
	
	public Dog getDogsById(int dogId){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM DOG_REGISTRY_TABLE WHERE dogId=:dogId";
		parameters.addValue("dogId", dogId);
		ArrayList<Dog> Dogs =  (ArrayList<Dog>)
				jdbc.query(query, parameters, new BeanPropertyRowMapper<Dog>(Dog.class));
		
		System.out.println("\ngetDogByID method was called");
		
		
		
//		if(Dogs != null) {
//			System.out.println(Dogs.get(0));
//			
//			return Dogs.get(0);
//		}else {
//		
//		return null;
//		}
		
		if(Dogs.isEmpty()) {
			return null;
		}else {
		
		return Dogs.get(0);
		}
		

	}
	
	
	public void deleteAllDogs() {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "delete FROM DOG_REGISTRY_TABLE";
		
		System.out.println("\ndeleteAllDogs method was called");
		jdbc.update(query, parameters);
	}
	
	public void deleteDogByID(int dogId) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "delete from DOG_REGISTRY_TABLE where dogId=:dogId";
		parameters.addValue("dogId", dogId);
		jdbc.update(query, parameters);
		System.out.println("\ndeleteDogByID method was called");
		
	}
	
	
	
	public void editDog(int id2, Dog dog) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "UPDATE DOG_REGISTRY_TABLE SET dogId=:dogId, dogName=:dogName, "
				+ "ownerName=:ownerName, breed=:breed, gender=:gender, "
				+ "classSpecialty=:classSpecialty"
				+ " WHERE dogId=:dogId";
		

		
		parameters.addValue("dogId", id2);
		parameters.addValue("dogName", dog.getDogName());
		parameters.addValue("ownerName", dog.getOwnerName());
		parameters.addValue("breed", dog.getBreed());
		parameters.addValue("gender", dog.getGender());
		parameters.addValue("classSpecialty", dog.getClassSpecialty());
		
		
		
		jdbc.update(query, parameters);
		System.out.println("\nRepo method editDog was called with ID# "+ id2);
		
		
	}
	
	

	
	public void resetCounter() {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "ALTER TABLE DOG_REGISTRY_TABLE ALTER COLUMN id RESTART WITH 1";
		jdbc.update(query, parameters);
	}
	
	public void resetCounter(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "ALTER TABLE DOG_REGISTRY_TABLE ALTER COLUMN id RESTART WITH 1";
		jdbc.update(query, parameters);
	}
	
	
	//Delete all
	//Delete by id
	// Edit all
	//Edit by id
	
	
}
