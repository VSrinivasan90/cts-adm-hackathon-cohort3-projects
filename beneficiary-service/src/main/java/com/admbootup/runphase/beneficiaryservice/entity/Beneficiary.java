package com.admbootup.runphase.beneficiaryservice.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="beneficiary")
public class Beneficiary {
	
	@Id
	@GeneratedValue
	private long beneficiaryid;
	private String name;
	private String nickname;
	private String beneaccountnumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name="user_beneficiary", 
		joinColumns={@JoinColumn(name="beneficiaryid")},
		inverseJoinColumns={@JoinColumn(name="username")}) 
	private User user;
	 

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

	public void setBeneaccountnumber(String beneaccountnumber) {
		this.beneaccountnumber = beneaccountnumber;
	}

	
	  public User getUser() { return user; }
	  
	  public void setUser(User user) { this.user = user; }
	 

	public Beneficiary() {
		
	}
	
	public Beneficiary(String name, String nickname, String beneaccountnumber) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.beneaccountnumber = beneaccountnumber;
	}

	@Override
	public String toString() {
		return "Beneficiary [beneficiaryid=" + beneficiaryid + ", name=" + name + ", nickname=" + nickname
				+ ", beneaccountnumber=" + beneaccountnumber; //+ ", user=" + user + "]";
	}
	
}