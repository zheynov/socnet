package by.zheynov.socnet.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zheynovvv on 19.10.2016.
 */

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    public UserEntity() {
    }

    @Id
    @Column(name = "userID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", length = 64)
    private String firstName;

    @Column(name = "lastName", length = 64)
    private String lastName;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "login", length = 64, unique = true)
    private String login;

    @Column(name = "password", length = 64)
    private String password;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "profileID")
    private ProfileEntity profileEntity;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public ProfileEntity getProfileEntity() {
        return profileEntity;
    }

    public void setProfileEntity(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }
}

