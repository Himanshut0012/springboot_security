package com.demo.emp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.emp.model.User;
import com.demo.emp.repo.UserRepository;

@SpringBootApplication
public class EmpApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(EmpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user= new User();
		user.setEmail("ram@bhagwan.com");
		user.setUsername("ram");
		user.setPassword(this.bCryptPasswordEncoder.encode("ram"));
		user.setRole("ROLE_NORMAL");
		this.userRepository.save(user);
		
		User user1= new User();
		user1.setEmail("mahadev@bhagwan.com");
		user1.setUsername("mahadev");
		user1.setPassword(this.bCryptPasswordEncoder.encode("mahadev"));
		user1.setRole("ROLE_ADMIN");
		this.userRepository.save(user1);
		
		User user2= new User();
		user2.setEmail("shubh@bhagwan.com");
		user2.setUsername("shubh");
		user2.setPassword(this.bCryptPasswordEncoder.encode("shubh"));
		user2.setRole("ROLE_ADMIN");
		this.userRepository.save(user2);
		
	}

	

	
	

}
