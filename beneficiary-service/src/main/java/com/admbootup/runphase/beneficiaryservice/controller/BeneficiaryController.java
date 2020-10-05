package com.admbootup.runphase.beneficiaryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.admbootup.runphase.beneficiaryservice.entity.Beneficiary;
import com.admbootup.runphase.beneficiaryservice.service.BeneficiaryService;

@Controller
public class BeneficiaryController {
	
	@Autowired
	BeneficiaryService beneficiaryService;

	@GetMapping(path="/beneficiary")
	public String showAddBeneficiaryPage(ModelMap model) {
		model.addAttribute("beneficiary", new Beneficiary());
		System.out.println("inside show add bene...");
		return "addbeneficiary";
	}
	
	@PostMapping(path="/beneficiary")
	public ResponseEntity<Object> addNewBeneficiary(Beneficiary beneficiary) {
		Beneficiary savedBeneficiary = beneficiaryService.saveBeneficiary(beneficiary);
		System.out.println("addnew bene.."+savedBeneficiary);
		return new ResponseEntity(savedBeneficiary,HttpStatus.CREATED);
	}
	
	@GetMapping(path="/beneficiary/all")
	public ResponseEntity<Object> getAllBeneficiaries() {
		List<Beneficiary> beneficiariesList = beneficiaryService.getAllBeneficiaries();
		System.out.println("beneficiariesList.."+beneficiariesList);
		return new ResponseEntity(beneficiariesList,HttpStatus.OK);
	}
}
