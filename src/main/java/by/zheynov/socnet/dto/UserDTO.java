package by.zheynov.socnet.dto;

import java.io.Serializable;

/**
 * User's data transfer object.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dto
 */

public class UserDTO implements Serializable
{
	private static final int HASH_NUMBER = 31;
	private Long    id;
	private String  email;
	private String  username;
	private String  password;
	private boolean enabled;
	private String  confirmPassword;
	private Long  profileID;

	/**
	 * Compares this UserDTO object to the specified Object o.
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
		if (!(o instanceof UserDTO))
		{
			return false;
		}

		UserDTO userDTO = (UserDTO) o;

		if (enabled != userDTO.enabled)
		{
			return false;
		}
		if (!id.equals(userDTO.id))
		{
			return false;
		}
		if (!email.equals(userDTO.email))
		{
			return false;
		}
		if (!username.equals(userDTO.username))
		{
			return false;
		}
		return password.equals(userDTO.password);

	}

	/**
	 * Calculates a hashcode for this object.
	 *
	 * @return the hash
	 */
	@Override
	public int hashCode()
	{
		int result = id.hashCode();
		result = HASH_NUMBER * result + email.hashCode();
		result = HASH_NUMBER * result + username.hashCode();
		result = HASH_NUMBER * result + password.hashCode();
		result = HASH_NUMBER * result + (enabled ? 1 : 0);
		return result;
	}

	/**
	 * Sets new enabled.
	 *
	 * @param enabled New value of enabled.
	 */
	public void setEnabled(final boolean enabled)
	{
		this.enabled = enabled;
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
	 * Sets new password.
	 *
	 * @param password New value of password.
	 */
	public void setPassword(final String password)
	{
		this.password = password;
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
	 * Sets new email.
	 *
	 * @param email New value of email.
	 */
	public void setEmail(final String email)
	{
		this.email = email;
	}

	/**
	 * Gets enabled.
	 *
	 * @return Value of enabled.
	 */
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * Gets password.
	 *
	 * @return Value of password.
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * Sets new confirmPassword.
	 *
	 * @param confirmPassword New value of confirmPassword.
	 */
	public void setConfirmPassword(final String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}

	/**
	 * Sets new username.
	 *
	 * @param username New value of username.
	 */
	public void setUsername(final String username)
	{
		this.username = username;
	}

	/**
	 * Gets username.
	 *
	 * @return Value of username.
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * Gets confirmPassword.
	 *
	 * @return Value of confirmPassword.
	 */
	public String getConfirmPassword()
	{
		return confirmPassword;
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
	public void setProfileID(final Long profileID)
	{
		this.profileID = profileID;
	}
}