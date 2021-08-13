package ca.sheridancollege.teixerya.publicrepository;


import ca.sheridancollege.teixerya.bean.Breed;
import ca.sheridancollege.teixerya.bean.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DogRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    public void addDogAtRepo(Dog dog) {
    	
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        String query = " INSERT INTO DOG_REGISTRY_TABLE"
                + " (dogName, ownerName, breed, gender, classSpecialty)VALUES "
        		+"(:dogName, :ownerName, :breed, :gender, :classSpecialty)";

        System.out.println("DogRepository breed is" + dog.getBreed());

        parameters.addValue("dogName", dog.getDogName());
        parameters.addValue("ownerName", dog.getOwnerName());
        parameters.addValue("breed", dog.getBreed());
        parameters.addValue("gender",dog.getGender());
        parameters.addValue("classSpecialty",dog.getClassSpecialty());

        jdbc.update(query, parameters);

    }

    public ArrayList<Dog> getDogs() {
        String query = "SELECT * FROM DOG_REGISTRY_TABLE";
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        List<Map<String, Object>> rows = jdbc.queryForList(query, new HashMap<String, Object>());

        for (Map<String, Object> row : rows) {
            Dog dogList = new Dog();

            dogList.setDogId((int) row.get("dogId"));
            dogList.setDogName((String) row.get("dogName"));
            dogList.setOwnerName((String) row.get("ownerName"));
            dogList.setBreed((String) row.get("breed"));
            dogList.setGender((String) row.get("gender"));
            dogList.setClassSpecialty((String) row.get("classSpecialty"));
            dogs.add(dogList);

        }

        return dogs;
    }

    public Dog getDogById(int dogId) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM DOG_REGISTRY_TABLE WHERE dogId=:dogId";
        parameters.addValue("dogId", dogId);
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);

        for (Map<String, Object> row : rows) {
            Dog dogList = new Dog();

            dogList.setDogId((int) row.get("dogId"));
            dogList.setDogName((String) row.get("dogName"));
            dogList.setOwnerName((String) row.get("ownerName"));
            dogList.setBreed((String) row.get("breed"));
            dogList.setGender((String) row.get("gender"));
            dogList.setClassSpecialty((String) row.get("classSpecialty"));
            dogs.add(dogList);

        }
        if (dogs.isEmpty()) {
            return null;
        } else {
            return dogs.get(0);
        }
    }

    public void editDog(Dog dog) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "UPDATE DOG_REGISTRY_TABLE set dogName=:name, userName=:user, breed=:breed, "
                + "gender=:gender, classSpecialty=:classSpecialty, role=:role WHERE dogId=:id";
        parameters.addValue("id", dog.getDogId());
        parameters.addValue("name", dog.getDogName());

        parameters.addValue("user", dog.getOwnerName());
        parameters.addValue("breed", dog.getBreed());

        parameters.addValue("gender", dog.getGender());
        parameters.addValue("classSpecialty", dog.getClassSpecialty());
        jdbc.update(query, parameters);

    }

}//Closing brace











