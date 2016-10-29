package by.zheynov.socnet.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    public UserEntity() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "login", length = 64, unique = true)
    private String login;

    @Column(name = "password", length = 64)
    private String password;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "profileID")
    private ProfileEntity profileEntity;

/*    @OneToOne(mappedBy = "userEntity") // OneToOne with RoleEntity
    private RoleEntity roleEntity;*/


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

    public ProfileEntity getProfileEntity() {
        return profileEntity;
    }

    public void setProfileEntity(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }

}

