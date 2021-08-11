package ca.sheridancollege.teixerya.bean;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dog {
	
	private int dogId;
	private String dogName;
	private String ownerName;
	private String breed;  
	private String gender;
	private String classSpecialty;
	

}