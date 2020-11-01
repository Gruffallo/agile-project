package ie.ait.agile.agileproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity


public class Hse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	public String username;

	public String password;


//public Hse(int i, String username, String p){
//	this.id=id;
//	this.username=username;
//	this.password=p;
//
//}

//	public Hse() {
//
//	}


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


	public String usernameLessThan5(){
		return "username less than 5";
	}
    public String passwordLessThan5(){
        return "password less than 5";
    }
    public String usernameGreaterThan15(){
        return "username greater than 15";
    }
    public String passwordGreaterThan15(){
        return "password greater than 15";
    }




}
