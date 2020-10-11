package com.admbootup.runphase.beneficiaryservice;

public class BeneficiaryData {

	private long beneficiaryid;
	private String name;
	private String nickname;
	private String beneaccountnumber;
	
	public long getBeneficiaryid() {
		return beneficiaryid;
	}
	public void setBeneficiaryid(long beneficiaryid) {
		this.beneficiaryid = beneficiaryid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getBeneaccountnumber() {
		return beneaccountnumber;
	}
	
	public BeneficiaryData() {
		
	}
	
	public BeneficiaryData(long beneficiaryid, String name, String nickname, String beneaccountnumber) {
		super();
		this.beneficiaryid = beneficiaryid;
		this.name = name;
		this.nickname = nickname;
		this.beneaccountnumber = beneaccountnumber;
	}
	public void setBeneaccountnumber(String beneaccountnumber) {
		this.beneaccountnumber = beneaccountnumber;
	}
	
	@Override
	public String toString() {
		return "BeneficiaryData [beneficiaryid=" + beneficiaryid + ", name=" + name + ", nickname=" + nickname
				+ ", beneaccountnumber=" + beneaccountnumber + "]";
	}
	
	
	
}
