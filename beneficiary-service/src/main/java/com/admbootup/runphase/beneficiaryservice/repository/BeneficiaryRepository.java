package com.admbootup.runphase.beneficiaryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.admbootup.runphase.beneficiaryservice.BeneficiaryData;
import com.admbootup.runphase.beneficiaryservice.entity.Beneficiary;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary,Long> {

	//@Query("SELECT beneficiaryid, name, nickname, beneaccountnumber"
			//+ " FROM Beneficiary b WHERE user in ( SELECT u from User u WHERE u.username=:username )")
	//@Query("SELECT new BeneficiaryData(beneficiaryid, name, nickname, beneaccountnumber)"
			//+ " FROM Beneficiary b WHERE user in ( SELECT u from User u WHERE u.username=:username )")
	@Query("SELECT new com.admbootup.runphase.beneficiaryservice.BeneficiaryData(beneficiaryid, name, nickname, beneaccountnumber)"
			+ " FROM Beneficiary b WHERE user in ( SELECT u from User u WHERE u.username=:username )")
	public List<BeneficiaryData> findBeneficiariesByUser(@Param("username") String username);
	
}
