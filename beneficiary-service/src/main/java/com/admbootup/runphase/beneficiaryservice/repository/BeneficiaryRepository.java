package com.admbootup.runphase.beneficiaryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admbootup.runphase.beneficiaryservice.entity.Beneficiary;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary,Long> {

	
	
}
