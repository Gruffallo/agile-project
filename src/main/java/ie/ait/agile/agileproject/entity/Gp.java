package ie.ait.agile.agileproject.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Gp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String gpName;
    private String gpEmail;
    private String gpBadgeNo;
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
	public String getGpName() {
		return gpName;
	}
	public void setGpName(String gpName) {
		this.gpName = gpName;
	}
	public String getGpEmail() {
		return gpEmail;
	}
	public void setGpEmail(String gpEmail) {
		this.gpEmail = gpEmail;
	}
	public String getGpBadgeNo() {
		return gpBadgeNo;
	}
	public void setGpBadgeNo(String gpBadgeNo) {
		this.gpBadgeNo = gpBadgeNo;
	}
    
//    private boolean active;
    
    
}
