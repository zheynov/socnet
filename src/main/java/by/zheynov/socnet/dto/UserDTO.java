package by.zheynov.socnet.dto;

/**
 *  Created by zheynovvv on 19.10.2016.
 */

public class UserDTO {

    private String login;
    private String password;

    public UserDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}