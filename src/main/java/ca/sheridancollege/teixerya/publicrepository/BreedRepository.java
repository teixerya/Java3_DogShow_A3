package ca.sheridancollege.teixerya.publicrepository;

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
		

		parameters.addValue("breedName", breed.getBreedName());

		jdbc.update(query, parameters);

	}
	
}






