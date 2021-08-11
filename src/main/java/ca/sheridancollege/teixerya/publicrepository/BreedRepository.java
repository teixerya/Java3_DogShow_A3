package ca.sheridancollege.teixerya.publicrepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.teixerya.bean.Breed;







@Repository
public class BreedRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
		public void addBreedAtRepo(Breed breed) {
			MapSqlParameterSource parameters = new MapSqlParameterSource();
	
			String query = " INSERT INTO breed_table"
					+ " (breedName) VALUES (:breedName)";

			System.out.println("Breed Repository breed is" + breed.getBreedName());
	
			parameters.addValue("breedName", breed.getBreedName());
	
			jdbc.update(query, parameters);
	
		}
		
		
		public ArrayList<Breed> getBreed(){
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			String query = "SELECT * FROM breed_table ";
			List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
			ArrayList<Breed> breeds = new ArrayList<Breed>();
			
		for(Map<String, Object> row : rows) {
			Breed d = new Breed();
			d.setBreedId((int)row.get("breedId"));
			d.setBreedName((String)row.get("breedName"));
	
	
			breeds.add(d);
		}
		return breeds;
		}
		


}





