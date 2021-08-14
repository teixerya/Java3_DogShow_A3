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

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM DOG_REGISTRY_TABLE";

        List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
        ArrayList<Dog> dogs = new ArrayList<Dog>();

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
        String query = "UPDATE DOG_REGISTRY_TABLE SET dogId=:dogId, dogName=:dogName," +
                " ownerName=:ownerName, breed=:breed, "+
                 "gender=:gender, classSpecialty=:classSpecialty " +
                "WHERE dogId=:dogId";
        System.out.println("editDog at the Repo" + dog);



        parameters.addValue("dogId", dog.getDogId());
        parameters.addValue("dogName", dog.getDogName());

        parameters.addValue("ownerName", dog.getOwnerName());
        parameters.addValue("breed", dog.getBreed());

        parameters.addValue("gender", dog.getGender());
        parameters.addValue("classSpecialty", dog.getClassSpecialty());

        jdbc.update(query, parameters);

    }

    public void deleteDog(int dogId){
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "DELETE FROM DOG_REGISTRY_TABLE WHERE dogId=:dogId";
        parameters.addValue("dogId", dogId);
        jdbc.update(query, parameters);

    }

    public ArrayList<Dog> getOwnerDogs(String ownerName) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM DOG_REGISTRY_TABLE WHERE ownerName=:ownerName";
        parameters.addValue("ownerName", ownerName);

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

        return dogs;
    }

//    public ArrayList<Dog> getDogAdminContacts(){ //Connection code here
//
//        MapSqlParameterSource parameters = new MapSqlParameterSource();
//        String query = "SELECT * FROM contact_info WHERE role = 'ROLE_ADMIN'";
////		parameters.addValue("role", role);
//
//        List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
//        ArrayList<Dog> dogs = new ArrayList<Dog>();
//
//        for(Map<String, Object> row : rows) {
//            Dog d = new Dog();
//            d.setDogId((int)row.get("dogId"));
//            d.setDogName((String)row.get("DogName"));
//            d.setOwnerName((String)row.get("OwnerName"));
//            d.setBreed((String)row.get("breed"));
//            d.setGender((String)row.get("gender"));
//            d.setClassSpecialty((String)row.get("classSpecialty"));
//
//            dogs.add(d);
//        }
//        return dogs;
//    }








//    public ArrayList<Dog> getShowList() {
//        String query = "select count (breed)", breed, count (gender = 'Male'), "
//                + "count(gender='Female'), count(classSpecialty='Class'), "
//                + "count(classSpecialty='Specialty') "
//                + "from DOG_REGISTRY_TABLE group by breed, gender, classSpecialty";
//
//        ArrayList<Dog> dogs = new ArrayList<Dog>();
//        List<Map<String, Object>> rows = jdbc.queryForList(query, new HashMap<String, Object>());
//
//        for (Map<String, Object> row : rows) {
//            Dog dogList = new Dog();
//
//            dogList.setBreed((String) row.get("breed"));
//            dogList.setGender((String) row.get("gender"));
//            dogList.setClassSpecialty((String) row.get("classSpecialty"));
//            dogs.add(dogList);
//
//        }
//
//        return dogs;
//    }


}//Closing brace











