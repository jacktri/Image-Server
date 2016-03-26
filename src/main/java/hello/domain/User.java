package hello.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "users")
public class User {


    @Id
    private String username;
    private String password;
    private boolean enabled;

    public User() {
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }


    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAccess() {
        return enabled;
    }

    public void setAccess(boolean enabled) {
        this.enabled = enabled;
    }
}