package com.admbootup.runphase.beneficiaryservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.admbootup.runphase.beneficiaryservice.entity.Beneficiary;
import com.admbootup.runphase.beneficiaryservice.entity.User;
import com.admbootup.runphase.beneficiaryservice.service.BeneficiaryService;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BeneficiaryServiceApplicationTests {
	
	@Test
	public void saveBeneficiaryTest() {
		User user = new User("sriniv","1602416173174");
		Beneficiary addBene = new Beneficiary("NewBene A","nbenA","123123123");
		addBene.setUser(user);
		Beneficiary savedBeneficiary = beneficiaryService.saveBeneficiary(addBene);
		assertThat(savedBeneficiary).isNotNull();
		assertThat(savedBeneficiary.getBeneficiaryid()).isGreaterThan(0L);
	}
	
	@Autowired
	BeneficiaryService beneficiaryService;

}
