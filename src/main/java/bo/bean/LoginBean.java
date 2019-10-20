package bo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import bo.handler.UserHandler;


@Named
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean loginAction() {
        return UserHandler.login(username, password);
    }
}
