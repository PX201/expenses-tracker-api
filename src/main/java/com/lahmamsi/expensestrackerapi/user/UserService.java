package com.lahmamsi.expensestrackerapi.user;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	
	public User newUser(UserDto userDto) {
		try {
			
			User user = 
					new User(userDto.getUsername(), userDto.getEmail(), userDto.getPassword(), Set.of(Role.USER));
			
			return userRepo.save(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void setAsAdmin(User user) {
		var roles = user.getRole();
		roles.add(Role.ADMIN);
		user.setRole(roles);
		
		userRepo.save(user);
	}
	
	public void updateUser(User user){
		userRepo.save(user);
	}
	
	

}
