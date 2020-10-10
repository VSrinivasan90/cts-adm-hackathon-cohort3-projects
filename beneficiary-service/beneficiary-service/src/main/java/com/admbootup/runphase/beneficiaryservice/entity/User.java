package com.admbootup.runphase.beneficiaryservice.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="bank_user_details")
public class User {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.AUTO) private Long id;
	 */
	
	@Id
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	private String firstName;
    
    private String lastName;
    
    private String gender;
    
    private String mobileNumber;
    
    private String roles="";
    
    private String permissions="";
    
    private int active=1;
    
    private String loginToken;
    
    public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}
    
	
	  @OneToMany(fetch = FetchType.LAZY)	  
	  @JoinTable(name="user_beneficiary", joinColumns=
	  {@JoinColumn(name="username")}, inverseJoinColumns=
	  {@JoinColumn(name="beneficiaryid")} ) 
	  private List<Beneficiary> beneficiaries;
	 

		/*
		 * public Long getId() { return id; }
		 * 
		 * public void setId(Long id) { this.id = id; }
		 */

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	public void addPassenger(Beneficiary beneficiary) {
		this.beneficiaries.add(beneficiary);
	}
	
	public void setPassengers(List<Beneficiary> beneficiaries) {
		this.beneficiaries=beneficiaries;
	}

	protected User() {
		
	}
	
	public User(String username, String password, String firstName, String lastName, String gender, String mobileNumber,
			String roles, String permissions) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.roles = roles;
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		/*
		 * return "User [id=" + id + ", username=" + username + ", password=" + password
		 * + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" +
		 * gender + ", mobileNumber=" + mobileNumber + ", roles=" + roles +
		 * ", permissions=" + permissions + ", active=" + active + ", loginToken=" +
		 * loginToken + "]";
		 */
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", roles="
				+ roles + ", permissions=" + permissions + ", active=" + active + ", loginToken=" + loginToken + "]";
	}
	
	
    
}
