package ie.ait.agile.agileproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	
	private String username;
	
	private String password;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="patient_email")
	private String patientEmail;
	
	@Column(name="emergency_id")
	private Long emergencyId;
	
	
	
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
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Long getEmergencyId() {
		return emergencyId;
	}
	public void setEmergencyId(Long emergencyId) {
		this.emergencyId = emergencyId;
	}
	
	
	

}
