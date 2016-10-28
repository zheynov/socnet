package by.zheynov.socnet.dto;

import java.io.Serializable;

/**
 * Created by zheynovvv on 19.10.2016.
 */

public class UserDTO implements Serializable {
    private Long   id;
    private String email;
    private String login;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof UserDTO))
        {
            return false;
        }

        UserDTO userDTO = (UserDTO) o;

        if (!getId().equals(userDTO.getId()))
        {
            return false;
        }
        if (!getEmail().equals(userDTO.getEmail()))
        {
            return false;
        }
        if (!getLogin().equals(userDTO.getLogin()))
        {
            return false;
        }
        return getPassword().equals(userDTO.getPassword());

    }

    @Override
    public int hashCode()
    {
        int result = getId().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}