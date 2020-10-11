package com.admbootup.runphase.loginservice;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.admbootup.runphase.loginservice.entity.User;
import com.admbootup.runphase.loginservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	/*
	 * public String getLoginToken(String username) {
	 * 
	 * }
	 */
	
	public String authenticateUser(User user) {
		User dbUser=userRepository.findByUsername(user.getUsername());
		System.out.println("dbUser.."+dbUser);
		//System.out.println("matches..."+passwordEncoder.matches(user.getPassword(), dbUser.getPassword()));
		if(dbUser!=null) {
			if(passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
				String loginToken=Long.toString(System.currentTimeMillis());
				dbUser.setLoginToken(loginToken);
				userRepository.save(dbUser);
				return loginToken;
			}
			else {
				return "invalidcredentials";
			}
		}
		else {
			//return "invaliduser";
			return "invalidcredentials";
		}
	}
	
	/*
	 * public boolean authorizeUser(String username, String token) { User
	 * dbUser=userRepository.findByUsername(username);
	 * System.out.println("dbUser.."+dbUser);
	 * System.out.println("token equalization..."+token.equals(dbUser.getLoginToken(
	 * ))); if(dbUser!=null) { if(token.equals(dbUser.getLoginToken())) { return
	 * true; } else { return false; } } return false; }
	 */
	
	public User authorizeUser(String username, String token) {
		User dbUser=userRepository.findByUsername(username);
		System.out.println("dbUser.."+dbUser);
		System.out.println("token equalization..."+token.equals(dbUser.getLoginToken()));
		if(dbUser!=null) {
			if(token.equals(dbUser.getLoginToken())) {
				return dbUser;
			}
			else {
				return null;
			}
		}
		return null;
	}
	
}
