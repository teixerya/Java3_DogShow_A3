package ca.sheridancollege.teixerya.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.teixerya.bean.Contact;


@Repository
public class ContactRepo {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public void newContact(Contact contact) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();

		String query = " INSERT INTO contact_info"
				+ " (name, address, phoneNumber, email, role)VALUES "+
				"(:name, :address, :phoneNumber, :email, :role)";
		parameters.addValue("name", contact.getName());
		parameters.addValue("address", contact.getAddress());
		parameters.addValue("phoneNumber", contact.getPhoneNumber());
		parameters.addValue("email",contact.getEmail());
		parameters.addValue("role",contact.getRole());

		
		jdbc.update(query, parameters);

	}

	public ArrayList<Contact> getContacts(){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM contact_info ";
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
	for(Map<String, Object> row : rows) {
		Contact d = new Contact();
		d.setId((int)row.get("id"));
		d.setName((String)row.get("name"));
		d.setAddress((String)row.get("address"));
		d.setPhoneNumber((String)row.get("phoneNumber"));
		d.setEmail((String)row.get("email"));

		contacts.add(d);
	}
		return contacts;
	}
	

	
	public Contact getContactById(int id){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM contact_info WHERE id=:id";
		parameters.addValue("id", id);
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
	for(Map<String, Object> row : rows) {
		Contact d = new Contact();

		d.setId((int)row.get("id"));
		d.setName((String)row.get("name"));
		d.setAddress((String)row.get("address"));
		d.setPhoneNumber((String)row.get("phoneNumber"));
		d.setEmail((String)row.get("email"));

		contacts.add(d);
	}
		if(contacts.isEmpty()) {
			return null;
		}else {
		
		return contacts.get(0);
		}
	}
	

	
	
	public void editContact(Contact contact) {
		String query = "UPDATE contact_info SET name=:name, address=:address,"+
				"phoneNumber=:phoneNumber, email=:email, role=:role WHERE id=:id";
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		
		parameters.addValue("id",contact.getId());
		parameters.addValue("name", contact.getName());
		parameters.addValue("address", contact.getAddress());
		parameters.addValue("phoneNumber",contact.getPhoneNumber());
		parameters.addValue("email",contact.getEmail());
		parameters.addValue("role",contact.getRole());

		jdbc.update(query, parameters);
		
	}
	
	public void deleteById(int id) {
		String query = "DELETE FROM contact_info WHERE id=:id";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		
		parameters.addValue("id",id);
		jdbc.update(query,  parameters);
	}
	
	
	public ArrayList<Contact> getGuestContacts(){ //Connection code here 

		MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM contact_info WHERE role = 'ROLE_GUEST'";
//		parameters.addValue("role", role);
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		for(Map<String, Object> row : rows) {
			Contact d = new Contact();
			d.setId((int)row.get("id"));
			d.setName((String)row.get("name"));
			d.setAddress((String)row.get("address"));
			d.setPhoneNumber((String)row.get("phoneNumber"));
			d.setEmail((String)row.get("email"));
			d.setRole((String)row.get("role"));
			

			contacts.add(d);
		}
			return contacts;
		}
	
	public ArrayList<Contact> getMembersContacts(){ //Connection code here 

		MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM contact_info WHERE role = 'ROLE_MEMBER'";
//		parameters.addValue("role", role);
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		for(Map<String, Object> row : rows) {
			Contact d = new Contact();
			d.setId((int)row.get("id"));
			d.setName((String)row.get("name"));
			d.setAddress((String)row.get("address"));
			d.setPhoneNumber((String)row.get("phoneNumber"));
			d.setEmail((String)row.get("email"));
			d.setRole((String)row.get("role"));

			contacts.add(d);
		}
			return contacts;
		}
	
	public ArrayList<Contact> getAdminContacts(){ //Connection code here 

		MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM contact_info WHERE role = 'ROLE_ADMIN'";
//		parameters.addValue("role", role);
		
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		for(Map<String, Object> row : rows) {
			Contact d = new Contact();
			d.setId((int)row.get("id"));
			d.setName((String)row.get("name"));
			d.setAddress((String)row.get("address"));
			d.setPhoneNumber((String)row.get("phoneNumber"));
			d.setEmail((String)row.get("email"));
			d.setRole((String)row.get("role"));

			contacts.add(d);
		}
			return contacts;
		}


	
	
}

