package ie.ait.agile.agileproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class OSM {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String username;
    private String password;

    @Column(name = "osm_name")
    private String osmName;

    @Column(name = "osm_email")
    private String osmEmail;

    @Column(name = "badge_no")
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

    public String getOsmName() {
        return osmName;
    }

    public void setOsmName(String osmName) {
        this.osmName = osmName;
    }

    public String getBadgeNo() {
        return badgeNo;
    }

    public void setBadgeNo(String badgeNo) {
        this.badgeNo = badgeNo;
    }


}
