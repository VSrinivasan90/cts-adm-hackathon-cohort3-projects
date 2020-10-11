package com.admbootup.runphase.beneficiaryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admbootup.runphase.beneficiaryservice.BeneficiaryData;
import com.admbootup.runphase.beneficiaryservice.entity.Beneficiary;
import com.admbootup.runphase.beneficiaryservice.entity.User;
import com.admbootup.runphase.beneficiaryservice.repository.BeneficiaryRepository;

@Service
public class BeneficiaryService {
	
	@Autowired
	BeneficiaryRepository beneficiaryRepository;
	
	public Beneficiary saveBeneficiary(Beneficiary beneficiary) {
		Beneficiary savedBeneficiary=beneficiaryRepository.save(beneficiary);
		System.out.println("savedBeneficiary..."+savedBeneficiary);
		return savedBeneficiary;
	}
	
	public List<BeneficiaryData> getAllBeneficiaries(User user) {
		//List<Beneficiary> beneficiariesList=beneficiaryRepository.findAll();
		//List<Beneficiary> beneficiariesList=beneficiaryRepository.findByUser(user);
		List<BeneficiaryData> beneficiariesList=beneficiaryRepository.findBeneficiariesByUser(user.getUsername());
		System.out.println("beneficiariesList..."+beneficiariesList);
		return beneficiariesList;
	}

}