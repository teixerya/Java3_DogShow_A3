package ca.sheridancollege.teixerya.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import ca.sheridancollege.teixerya.repository.SecurityRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	@Lazy
	private SecurityRepository secRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//Find my User
		ca.sheridancollege.teixerya.bean.User user = secRepo.findUserAccount(username);
		
		
		//No User was found
		
		if(user == null) {
			throw new UsernameNotFoundException("User " + username + " was not found.");
		}
		
		//Get a list of roles
		List<String> roleNames = secRepo.getRolesById(user.getUserId());
		
		//Change the lit of role names into a list of GrantedAuthority
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if(roleNames != null) {
			for(String role: roleNames) {
				grantList.add(new SimpleGrantedAuthority(role));
			}
		}
		
		//import org.springframework.security.core.userdetails.User;
		User springUser = new User(user.getUserName(), user.getEncryptedPassword(), grantList);
		
		return (UserDetails)springUser;
	}

}

