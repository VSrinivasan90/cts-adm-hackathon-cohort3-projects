package com.admbootup.runphase.beneficiaryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.admbootup.runphase.beneficiaryservice.BeneficiaryData;
import com.admbootup.runphase.beneficiaryservice.entity.Beneficiary;
import com.admbootup.runphase.beneficiaryservice.entity.User;
import com.admbootup.runphase.beneficiaryservice.feign.LoginServiceProxy;
import com.admbootup.runphase.beneficiaryservice.service.BeneficiaryService;

@Controller
@CrossOrigin(origins = "*")
public class BeneficiaryController {
	
	@Autowired
	BeneficiaryService beneficiaryService;
	
	@Autowired
	LoginServiceProxy loginServiceProxy;

	@GetMapping(path="/beneficiary")
	public String showAddBeneficiaryPage(ModelMap model) {
		model.addAttribute("beneficiary", new Beneficiary());
		System.out.println("inside show add bene...");
		return "addbeneficiary";
	}
	
	@PostMapping(path="/beneficiary")
	public ResponseEntity<Object> addNewBeneficiary(@RequestBody Beneficiary beneficiary, @RequestHeader HttpHeaders headers) {
		/*
		 * Beneficiary savedBeneficiary =
		 * beneficiaryService.saveBeneficiary(beneficiary);
		 * System.out.println("addnew bene.."+savedBeneficiary); return new
		 * ResponseEntity(savedBeneficiary,HttpStatus.CREATED);
		 */
		System.out.println("header user.."+headers.get("user").get(0));
		System.out.println("header token.."+headers.get("token").get(0));
		String username=headers.get("user").get(0);
		String loginToken=headers.get("token").get(0);
		//boolean validUserSession=
		/*
		 * ResponseEntity<Boolean> responseEntity=
		 * loginServiceProxy.authorizeUserLoginToken(username, loginToken); boolean
		 * validUserSession = responseEntity.getBody(); if(validUserSession) {
		 * System.out.println("Valid token and Session and hence creating beneficiary.."
		 * ); Beneficiary savedBeneficiary =
		 * beneficiaryService.saveBeneficiary(beneficiary);
		 * System.out.println("addnew bene.."+savedBeneficiary); return new
		 * ResponseEntity(beneficiary,HttpStatus.CREATED); } else {
		 * System.out.println("INValid token and Session.."); return new
		 * ResponseEntity("Invalid Session",HttpStatus.UNAUTHORIZED); }
		 */
		/*
		 * ResponseEntity<Object> responseEntity=
		 * loginServiceProxy.authorizeUserLoginToken(username, loginToken); Object
		 * responseObj = responseEntity.getBody(); if(responseObj.getClass() ==
		 * Boolean.class) { return new
		 * ResponseEntity("Invalid Session",HttpStatus.UNAUTHORIZED); } else { User
		 * user=(User)responseObj;
		 * System.out.println("Valid token and Session and hence creating beneficiary.."
		 * ); beneficiary.setUser(user);
		 * System.out.println("beneficiary to save.."+beneficiary); Beneficiary
		 * savedBeneficiary = beneficiaryService.saveBeneficiary(beneficiary);
		 * System.out.println("addnew bene.."+savedBeneficiary); return new
		 * ResponseEntity(beneficiary,HttpStatus.CREATED); }
		 */
		User authorizedUser=loginServiceProxy.authorizeUserLoginToken(username, loginToken);
		if(authorizedUser!=null) {
			System.out.println("Valid token and Session and hence creating beneficiary.."+authorizedUser);
			beneficiary.setUser(authorizedUser);
			System.out.println("beneficiary to save.."+beneficiary);
			Beneficiary savedBeneficiary = beneficiaryService.saveBeneficiary(beneficiary);
			System.out.println("addnew bene.."+savedBeneficiary);
			BeneficiaryData beneData=new BeneficiaryData(savedBeneficiary.getBeneficiaryid(),
														savedBeneficiary.getName(),
														savedBeneficiary.getNickname(),
														savedBeneficiary.getBeneaccountnumber());
			return new ResponseEntity(beneData,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity("Invalid Session",HttpStatus.UNAUTHORIZED);
		}	
	}
	
	/*
	 * @GetMapping(path="/beneficiary/all") public ResponseEntity<Object>
	 * getAllBeneficiaries() { List<Beneficiary> beneficiariesList =
	 * beneficiaryService.getAllBeneficiaries();
	 * System.out.println("beneficiariesList.."+beneficiariesList); return new
	 * ResponseEntity(beneficiariesList,HttpStatus.OK); }
	 */
	
	@GetMapping(path="/beneficiary/all")
	public ResponseEntity<Object> getAllBeneficiaries(@RequestHeader HttpHeaders headers) {
		
		System.out.println("header user getAllBeneficiaries.."+headers.get("user").get(0));
		System.out.println("header token getAllBeneficiaries.."+headers.get("token").get(0));
		String username=headers.get("user").get(0);
		String loginToken=headers.get("token").get(0);
		
		User authorizedUser=loginServiceProxy.authorizeUserLoginToken(username, loginToken);
		if(authorizedUser!=null) {
			System.out.println("Valid token and Session and hence fetching beneficiaries a.."+authorizedUser);
			List<BeneficiaryData> beneficiariesList = beneficiaryService.getAllBeneficiaries(authorizedUser);
			System.out.println("beneficiariesList.."+beneficiariesList);
			return new ResponseEntity(beneficiariesList,HttpStatus.OK);
		}
		else { 
			return new ResponseEntity("Invalid Session",HttpStatus.UNAUTHORIZED);
		}
		
		
	}
}
