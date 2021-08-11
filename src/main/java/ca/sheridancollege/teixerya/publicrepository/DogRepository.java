package ca.sheridancollege.teixerya.publicrepository;


import ca.sheridancollege.teixerya.bean.Breed;
import ca.sheridancollege.teixerya.bean.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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


}











