package by.zheynov.socnet.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zheynovvv on 19.10.2016.
 */


@Entity
@Table(name = "profile")
public class ProfileEntity implements Serializable {

    public ProfileEntity() {
    }

    @OneToOne(mappedBy = "profileEntity") // OneToOne with UserEntity
    private UserEntity user;

    @Id
    @Column(name = "profileID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileID;

    @Column(name = "firstName", length = 64)
    private String firstName;

    @Column(name = "lastName", length = 64)
    private String lastName;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "birthDate", length = 64)
    private Date birthDate;

    @Column(name = "age", length = 64)
    private Integer age;

    @Column(name = "sex", length = 64)
    private String sex;

    @Column(name = "city", length = 64)
    private String city;

    @Column(name = "phoneNumber", length = 64)
    private String phoneNumber;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getProfileID() {
        return profileID;
    }

    public void setProfileID(Long profileID) {
        this.profileID = profileID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

