package by.zheynov.socnet.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * .
 *
 * @author Vadim Zheynov <walder@tut.by>
 * @package by.zheynov.socnet.dto
 */
@XmlRootElement(name = "Profile")
public class RestObject
{
	private Long    profileID;
	private String  firstname;
	private String  lastname;
	private String  email;
	private Date    birthDate;
	private Integer age;
	private String  sex;
	private String  city;
	private String  phoneNumber;

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
	 * Sets new lastname.
	 *
	 * @param lastname New value of lastname.
	 */
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
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
	 * Gets sex.
	 *
	 * @return Value of sex.
	 */
	public String getSex()
	{
		return sex;
	}

	/**
	 * Sets new firstname.
	 *
	 * @param firstname New value of firstname.
	 */
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
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
	 * Gets age.
	 *
	 * @return Value of age.
	 */
	public Integer getAge()
	{
		return age;
	}

	/**
	 * Sets new age.
	 *
	 * @param age New value of age.
	 */
	public void setAge(Integer age)
	{
		this.age = age;
	}

	/**
	 * Sets new email.
	 *
	 * @param email New value of email.
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Gets profileID.
	 *
	 * @return Value of profileID.
	 */
	public Long getProfileID()
	{
		return profileID;
	}

	/**
	 * Sets new profileID.
	 *
	 * @param profileID New value of profileID.
	 */
	public void setProfileID(Long profileID)
	{
		this.profileID = profileID;
	}

	/**
	 * Sets new sex.
	 *
	 * @param sex New value of sex.
	 */
	public void setSex(String sex)
	{
		this.sex = sex;
	}

	/**
	 * Sets new phoneNumber.
	 *
	 * @param phoneNumber New value of phoneNumber.
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
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
	 * Sets new birthDate.
	 *
	 * @param birthDate New value of birthDate.
	 */
	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
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
	 * Sets new city.
	 *
	 * @param city New value of city.
	 */
	public void setCity(String city)
	{
		this.city = city;
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
}