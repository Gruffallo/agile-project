package ie.ait.agile.agileproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pharmacist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	
	@Column(name="pharmacist_name")
	private String pharmacistName;
	
	@Column(name="pharmacist_email")
	private String pharmacistEmail;
	
	@Column(name="badge_no")
	private String badgeNo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getPharmacistName() {
		return pharmacistName;
	}
	public void setPharmacistName(String pharmacistName) {
		this.pharmacistName = pharmacistName;
	}
	public String getBadgeNo() {
		return badgeNo;
	}
	public void setBadgeNo(String badgeNo) {
		this.badgeNo = badgeNo;
	}
	
	
}
