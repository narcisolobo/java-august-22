package com.nlobo.loginreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.nlobo.loginreg.models.User;
import com.nlobo.loginreg.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	// register method
	public User register(User user, BindingResult result) {
		
		Optional<User> potentialUser = userRepository.findByEmail(user.getEmail());
		
		// Does email already exist?
		if (potentialUser.isPresent()) {
			// oh no! the email exists! remind the user to log in.
			result.rejectValue("email", "emailExists", "A user has that email. Did you forget to login?");
		}
		
		// Does password match confirm password?
		if (!user.getPassword().equals(user.getConfirm())) {
			// they don't match! add an error message
			result.rejectValue("confirm", "noMatch", "Passwords must match.");
		}
		
		if (result.hasErrors()) return null;
		
		// hash the password, save the user
		else {
			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashed);
			return userRepository.save(user);
		}
	}
	
	// login method
	
	// 
}
