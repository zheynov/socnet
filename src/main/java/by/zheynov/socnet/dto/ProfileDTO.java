package by.zheynov.socnet.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Profile data transfer object.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dto
 */

public class ProfileDTO implements Serializable
{
	private static final int HASH_NUMBER = 31;
	private Long    profileID;
	private String  firstname;
	private String  lastname;
	private String  email;
	private Date    birthDate;
	private Integer age;
	private String  sex;
	private String  city;
	private String  phoneNumber;
	private UserDTO userDTO;

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
	 * Gets firstname.
	 *
	 * @return Value of firstname.
	 */
	public String getFirstname()
	{
		return firstname;
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
	 * Gets lastname.
	 *
	 * @return Value of lastname.
	 */
	public String getLastname()
	{
		return lastname;
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
	 * Sets new phoneNumber.
	 *
	 * @param phoneNumber New value of phoneNumber.
	 */
	public void setPhoneNumber(final String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
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
	 * Gets sex.
	 *
	 * @return Value of sex.
	 */
	public String getSex()
	{
		return sex;
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
	 * Sets new lastname.
	 *
	 * @param lastname New value of lastname.
	 */
	public void setLastname(final String lastname)
	{
		this.lastname = lastname;
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
	 * Gets email.
	 *
	 * @return Value of email.
	 */
	public String getEmail()
	{
		return email;
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
	 * Gets phoneNumber.
	 *
	 * @return Value of phoneNumber.
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * Sets new profileID.
	 *
	 * @param profileID New value of profileID.
	 */
	public void setProfileID(final Long profileID)
	{
		this.profileID = profileID;
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
	 * Sets new firstname.
	 *
	 * @param firstname New value of firstname.
	 */
	public void setFirstname(final String firstname)
	{
		this.firstname = firstname;
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
	 * Compares this ProfileDTO object to the specified one - Object o.
	 *
	 * @param o
	 *
	 * @return true if objects are the same, otherwise false
	 */
	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof ProfileDTO))
		{
			return false;
		}

		ProfileDTO that = (ProfileDTO) o;

		if (!getProfileID().equals(that.getProfileID()))
		{
			return false;
		}
		if (getFirstname() != null ? !getFirstname().equals(that.getFirstname()) : that.getFirstname() != null)
		{
			return false;
		}
		if (getLastname() != null ? !getLastname().equals(that.getLastname()) : that.getLastname() != null)
		{
			return false;
		}
		if (!getEmail().equals(that.getEmail()))
		{
			return false;
		}
		if (getBirthDate() != null ? !getBirthDate().equals(that.getBirthDate()) : that.getBirthDate() != null)
		{
			return false;
		}
		if (getAge() != null ? !getAge().equals(that.getAge()) : that.getAge() != null)
		{
			return false;
		}
		if (getSex() != null ? !getSex().equals(that.getSex()) : that.getSex() != null)
		{
			return false;
		}
		if (getCity() != null ? !getCity().equals(that.getCity()) : that.getCity() != null)
		{
			return false;
		}
		if (getPhoneNumber() != null ? !getPhoneNumber().equals(that.getPhoneNumber()) : that.getPhoneNumber() != null)
		{
			return false;
		}
		return getUserDTO().equals(that.getUserDTO());

	}

	/**
	 * Calculates a hashcode for this object.
	 *
	 * @return the hash
	 */
	@Override
	public int hashCode()
	{
		int result = getProfileID().hashCode();
		result = HASH_NUMBER * result + (getFirstname() != null ? getFirstname().hashCode() : 0);
		result = HASH_NUMBER * result + (getLastname() != null ? getLastname().hashCode() : 0);
		result = HASH_NUMBER * result + getEmail().hashCode();
		result = HASH_NUMBER * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
		result = HASH_NUMBER * result + (getAge() != null ? getAge().hashCode() : 0);
		result = HASH_NUMBER * result + (getSex() != null ? getSex().hashCode() : 0);
		result = HASH_NUMBER * result + (getCity() != null ? getCity().hashCode() : 0);
		result = HASH_NUMBER * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
		result = HASH_NUMBER * result + getUserDTO().hashCode();
		return result;
	}

	/**
	 * Gets userDTO.
	 *
	 * @return Value of userDTO.
	 */
	public UserDTO getUserDTO()
	{
		return userDTO;
	}

	/**
	 * Sets new userDTO.
	 *
	 * @param userDTO New value of userDTO.
	 */
	public void setUserDTO(final UserDTO userDTO)
	{
		this.userDTO = userDTO;
	}
}
