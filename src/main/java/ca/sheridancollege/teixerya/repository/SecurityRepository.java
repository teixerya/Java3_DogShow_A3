package ca.sheridancollege.teixerya.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.teixerya.bean.Contact;
import ca.sheridancollege.teixerya.bean.User;

@Repository
public class SecurityRepository {


	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public User findUserAccount(String userName){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM SEC_USER WHERE userName=:user";
		parameters.addValue("user", userName);
		ArrayList<User> users = (ArrayList<User>)
				jdbc.query(query, parameters, new BeanPropertyRowMapper<User>(User.class));
		
		if(!users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}
	}
	
	//Will return a list of strings which are the role names assigned to a specific userId
	public List<String> getRolesById(long userId){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT user_role.userId, sec_role.roleName FROM " 
				+ "user_role, sec_role WHERE user_role.roleid=sec_role.roleId"
				+ " and userId=:id";
		parameters.addValue("id", userId);
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		ArrayList<String> roles = new ArrayList<String>();
		
	for(Map<String, Object> row : rows) {
		String role = (String)row.get("roleName");
		roles.add(role);
	}
	return roles;
	}		

	//required for Registration
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void addUser(String userName, String password) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "insert into SEC_User(userName, encryptedPassword, ENABLED)"
				+ " values(:name, :pass, 1)";
		parameters.addValue("name",userName);
		parameters.addValue("pass", encoder.encode(password));
		jdbc.update(query, parameters);
		
	}
	
	//required for Registration
	public void addRole(long userId, long roleId) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query ="insert into user_role (userId, roleId) values ( :uid, :rid)";
		parameters.addValue("uid", userId);
		
		parameters.addValue("rid", roleId);
		
		
		jdbc.update(query, parameters);
		
	}
	

	
}

