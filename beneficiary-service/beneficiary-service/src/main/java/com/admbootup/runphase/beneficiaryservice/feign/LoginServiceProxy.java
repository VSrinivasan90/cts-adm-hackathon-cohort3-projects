package com.admbootup.runphase.beneficiaryservice.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admbootup.runphase.beneficiaryservice.entity.User;

@FeignClient(name="login-service")
@RibbonClient(name="login-service")
public interface LoginServiceProxy {

	/*
	 * @GetMapping(path="/authorize-login") public ResponseEntity<Boolean>
	 * authorizeUserLoginToken(@RequestParam(name = "username") String username,
	 * 
	 * @RequestParam(name = "token") String token);
	 */
	
	/*
	 * @GetMapping(path="/authorize-login") public ResponseEntity<Object>
	 * authorizeUserLoginToken(@RequestParam(name = "username") String username,
	 * 
	 * @RequestParam(name = "token") String token);
	 */
	
	@GetMapping(path="/authorize-login")
	public User authorizeUserLoginToken(@RequestParam(name = "username") String username,
			@RequestParam(name = "token") String token);
}
