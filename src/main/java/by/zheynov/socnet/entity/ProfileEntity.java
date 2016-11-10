package by.zheynov.socnet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Profile Entity class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.entity
 */

@Entity
@Table(name = "profile")
public class ProfileEntity implements Serializable
{
	private static final int TABLE_COLUMN_MAX_LENGTH = 64;

	@OneToOne(mappedBy = "profileEntity", fetch = FetchType.EAGER) // OneToOne with UserEntity
	private UserEntity userEntity;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "profile_profile", joinColumns = {@JoinColumn(name = "main_profile_id")}, inverseJoinColumns = {
					@JoinColumn(name = "friends_profile_id")
	})
	private Set<ProfileEntity> userFriends = new HashSet<ProfileEntity>();

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstname", length = TABLE_COLUMN_MAX_LENGTH)
	private String firstname;

	@Column(name = "lastname", length = TABLE_COLUMN_MAX_LENGTH)
	private String lastname;

	@Column(name = "email", length = TABLE_COLUMN_MAX_LENGTH)
	private String email;

	@Column(name = "birthDate", length = TABLE_COLUMN_MAX_LENGTH)
	private Date birthDate;

	@Column(name = "age", length = TABLE_COLUMN_MAX_LENGTH)
	private Integer age;

	@Column(name = "sex", length = TABLE_COLUMN_MAX_LENGTH)
	private String sex;

	@Column(name = "city", length = TABLE_COLUMN_MAX_LENGTH)
	private String city;

	@Column(name = "phoneNumber", length = TABLE_COLUMN_MAX_LENGTH)
	private String phoneNumber;

	/**
	 * Constructor for ProfileEntity.
	 */
	public ProfileEntity()
	{
	}

	/**
	 * Gets sex.
	 *
	 * @return Value of sex.
	 */
	public String getSex()
	{
		return sex;
	}

	/**
	 * Sets new sex.
	 *
	 * @param sex New value of sex.
	 */
	public void setSex(final String sex)
	{
		this.sex = sex;
	}

	/**
	 * Gets firstname.
	 *
	 * @return Value of firstname.
	 */
	public String getFirstname()
	{
		return firstname;
	}

	/**
	 * Sets new age.
	 *
	 * @param age New value of age.
	 */
	public void setAge(final Integer age)
	{
		this.age = age;
	}

	/**
	 * Sets new phoneNumber.
	 *
	 * @param phoneNumber New value of phoneNumber.
	 */
	public void setPhoneNumber(final String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets phoneNumber.
	 *
	 * @return Value of phoneNumber.
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * Sets new email.
	 *
	 * @param email New value of email.
	 */
	public void setEmail(final String email)
	{
		this.email = email;
	}

	/**
	 * Sets new id.
	 *
	 * @param id New value of id.
	 */
	public void setId(final Long id)
	{
		this.id = id;
	}

	/**
	 * Gets age.
	 *
	 * @return Value of age.
	 */
	public Integer getAge()
	{
		return age;
	}

	/**
	 * Sets new firstname.
	 *
	 * @param firstname New value of firstname.
	 */
	public void setFirstname(final String firstname)
	{
		this.firstname = firstname;
	}

	/**
	 * Sets new birthDate.
	 *
	 * @param birthDate New value of birthDate.
	 */
	public void setBirthDate(final Date birthDate)
	{
		this.birthDate = birthDate;
	}

	/**
	 * Gets birthDate.
	 *
	 * @return Value of birthDate.
	 */
	public Date getBirthDate()
	{
		return birthDate;
	}

	/**
	 * Gets city.
	 *
	 * @return Value of city.
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * Gets lastname.
	 *
	 * @return Value of lastname.
	 */
	public String getLastname()
	{
		return lastname;
	}

	/**
	 * Sets new lastname.
	 *
	 * @param lastname New value of lastname.
	 */
	public void setLastname(final String lastname)
	{
		this.lastname = lastname;
	}

	/**
	 * Sets new city.
	 *
	 * @param city New value of city.
	 */
	public void setCity(final String city)
	{
		this.city = city;
	}

	/**
	 * Gets email.
	 *
	 * @return Value of email.
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Gets id.
	 *
	 * @return Value of id.
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * Sets new userEntity.
	 *
	 * @param userEntity New value of userEntity.
	 */
	public void setUserEntity(final UserEntity userEntity)
	{
		this.userEntity = userEntity;
	}

	/**
	 * Gets userEntity.
	 *
	 * @return Value of userEntity.
	 */
	public UserEntity getUserEntity()
	{
		return userEntity;
	}

	/**
	 * Gets userFriends.
	 *
	 * @return Value of userFriends.
	 */
	public Set<ProfileEntity> getUserFriends()
	{
		return userFriends;
	}

	/**
	 * Sets new userFriends.
	 *
	 * @param userFriends New value of userFriends.
	 */
	public void setUserFriends(Set<ProfileEntity> userFriends)
	{
		this.userFriends = userFriends;
	}
}

