package com.admbootup.runphase.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admbootup.runphase.loginservice.UserService;
import com.admbootup.runphase.loginservice.entity.User;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	/*
	 * public String getLoginToken() {
	 * 
	 * return }
	 */
	
	
	@PostMapping(path="/authenticate-login")
	public ResponseEntity<String> authenticateUserAndSendToken(@RequestBody User user) {
		System.out.println("user..."+user);
		if(user!=null) {
			String authenticationResponse=userService.authenticateUser(user);
			if(authenticationResponse=="invalidcredentials" || authenticationResponse=="invaliduser") {
				return new ResponseEntity(authenticationResponse,HttpStatus.BAD_REQUEST);
			}
			else {
				return new ResponseEntity(authenticationResponse,HttpStatus.OK);
			}			
		}
		else {
			return new ResponseEntity("Invalid Username/Password",HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	 * @GetMapping(path="/authorize-login") public ResponseEntity<Boolean>
	 * authorizeUserLoginToken(@RequestParam(name = "username") String
	 * username,@RequestParam(name = "token") String token) { boolean
	 * validUserToken=userService.authorizeUser(username,token); if(validUserToken)
	 * { return new ResponseEntity(validUserToken,HttpStatus.OK); } else { return
	 * new ResponseEntity(validUserToken,HttpStatus.UNAUTHORIZED); } }
	 */
	
	/*
	 * @GetMapping(path="/authorize-login") public ResponseEntity<Object>
	 * authorizeUserLoginToken(@RequestParam(name = "username") String
	 * username,@RequestParam(name = "token") String token) { User
	 * user=userService.authorizeUser(username,token); if(user!=null) { return new
	 * ResponseEntity(user,HttpStatus.OK); } else { return new
	 * ResponseEntity(false,HttpStatus.OK); } }
	 */
	
	@GetMapping(path="/authorize-login")
	public User authorizeUserLoginToken(@RequestParam(name = "username") String username,@RequestParam(name = "token") String token) {
		User user=userService.authorizeUser(username,token);
		return user;
	}
	
}
