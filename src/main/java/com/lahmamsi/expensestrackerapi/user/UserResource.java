package com.lahmamsi.expensestrackerapi.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/auth/")
public class UserResource {
	
	@PostMapping("login")
	public ResponseEntity<User> authenticate(AuthRequest authReq){
		
		return null;
	}
	
	@PostMapping("register")
	public ResponseEntity<User> register(UserDto userDto){
		
		return null;
	}

}
