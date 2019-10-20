package bo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import bo.handler.UserHandler;
import bo.model.User;


@Named
@ManagedBean
@SessionScoped
public class RegisterBean implements Serializable {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
    private Date userCreated;;

    public RegisterBean() {
        this.userCreated = new Date();
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Date userCreated) {
        this.userCreated = userCreated;
    }

    public boolean register() {
        User user = new User(username, password, firstname, lastname, age, userCreated);
        return UserHandler.createUser(user);
    }
}
