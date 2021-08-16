package ca.sheridancollege.teixerya.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		//*************************************
		//Allow us to use the h2 console GUI
		//Must be removed on production level code
		http.csrf().disable();
		http.headers().frameOptions().disable();
		 
		//*************************************
		
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/img/**").permitAll();
		
		http.authorizeRequests()
		
		//Define what URL are restricted to specific roles
		//We Restrict URL not HTML Pages
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/owner").hasRole("OWNER")
		.antMatchers("/guest").hasRole("GUEST")

		.antMatchers("/edit/**").hasRole("ADMIN")
		.antMatchers("/edit").hasRole("ADMIN")
		.antMatchers("/delete/**").hasRole("ADMIN")
		
		.antMatchers("/editDog/**").hasRole("ADMIN")
		.antMatchers("/editDog").hasRole("ADMIN")
		.antMatchers("/deleteDog/**").hasRole("ADMIN")

		.antMatchers("/addDogLink/**").hasRole("ADMIN")

		.antMatchers("/guest").hasRole("GUEST")  


		.antMatchers(HttpMethod.GET,"/register").permitAll()
		.antMatchers(HttpMethod.POST,"/register").permitAll()

		
		.antMatchers(HttpMethod.GET,"/addBreedLink").permitAll()
//		.antMatchers(HttpMethod.POST,"/addBreedLink").permitAll()
				.antMatchers(HttpMethod.POST,"/addBreedLink").hasRole("ADMIN")

//		.antMatchers(HttpMethod.GET,"/addDogLink").permitAll()
//		.antMatchers(HttpMethod.POST,"/addDogLink").permitAll()
		
		.antMatchers(HttpMethod.GET,"/editDog/{dogId}").permitAll()
		.antMatchers(HttpMethod.POST,"/editDog").permitAll()
		
		.antMatchers(HttpMethod.GET,"/viewDogs").permitAll()
		.antMatchers(HttpMethod.POST,"/viewDogs").permitAll()

		.antMatchers("/publiccontroller/**").permitAll()
		.antMatchers("/publicrepository/**").permitAll()

		.antMatchers("/").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/")//Choose controller mapping for root directory
		.permitAll()
		.and()
		.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/?logout")//go here at logout
			.permitAll()
		.and()
		.exceptionHandling()
			.accessDeniedHandler(accessDeniedHandler);
		
	}
	
	@Autowired
	private LoginAccessDeniedHandler accessDeniedHandler;
	
	@Autowired 
	private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

		
		
	}
	
}


