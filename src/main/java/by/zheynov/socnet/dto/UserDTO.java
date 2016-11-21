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
	private Long       id;
	private String     email;
	private String     username;
	private String     password;
	private boolean    enabled;
	private String     confirmPassword;
	private ProfileDTO profileDTO;

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

		if (isEnabled() != userDTO.isEnabled())
		{
			return false;
		}
		if (!getId().equals(userDTO.getId()))
		{
			return false;
		}
		if (!getEmail().equals(userDTO.getEmail()))
		{
			return false;
		}
		if (!getUsername().equals(userDTO.getUsername()))
		{
			return false;
		}
		if (!getPassword().equals(userDTO.getPassword()))
		{
			return false;
		}
		return getProfileDTO().equals(userDTO.getProfileDTO());

	}

	/**
	 * Calculates a hashcode for this object.
	 *
	 * @return the hash
	 */
	@Override
	public int hashCode()
	{
		int result = getId().hashCode();
		result = HASH_NUMBER * result + getEmail().hashCode();
		result = HASH_NUMBER * result + getUsername().hashCode();
		result = HASH_NUMBER * result + getPassword().hashCode();
		result = HASH_NUMBER * result + (isEnabled() ? 1 : 0);
		result = HASH_NUMBER * result + getProfileDTO().hashCode();
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
	 * Sets new profileDTO.
	 *
	 * @param profileDTO New value of profileDTO.
	 */
	public void setProfileDTO(final ProfileDTO profileDTO)
	{
		this.profileDTO = profileDTO;
	}

	/**
	 * Gets profileDTO.
	 *
	 * @return Value of profileDTO.
	 */
	public ProfileDTO getProfileDTO()
	{
		return profileDTO;
	}
}