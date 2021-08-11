package ca.sheridancollege.teixerya.bean;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contact {

	private int id;
	private String name;
	private String address;
	private String phoneNumber;
	private String email;
	private String role;
	
	

}
