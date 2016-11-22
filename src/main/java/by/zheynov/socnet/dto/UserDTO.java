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
	private RoleDTO    roleDTO;

	/**
	 * Sets new confirmPassword.
	 *
	 * @param confirmPassword New value of confirmPassword.
	 */
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}

	/**
	 * Sets new id.
	 *
	 * @param id New value of id.
	 */
	public void setId(Long id)
	{
		this.id = id;
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
	 * Gets enabled.
	 *
	 * @return Value of enabled.
	 */
	public boolean isEnabled()
	{
		return enabled;
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
	 * Gets profileDTO.
	 *
	 * @return Value of profileDTO.
	 */
	public ProfileDTO getProfileDTO()
	{
		return profileDTO;
	}

	/**
	 * Sets new roleDTO.
	 *
	 * @param roleDTO New value of roleDTO.
	 */
	public void setRoleDTO(RoleDTO roleDTO)
	{
		this.roleDTO = roleDTO;
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
	 * Gets password.
	 *
	 * @return Value of password.
	 */
	public String getPassword()
	{
		return password;
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
	 * Gets email.
	 *
	 * @return Value of email.
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Gets roleDTO.
	 *
	 * @return Value of roleDTO.
	 */
	public RoleDTO getRoleDTO()
	{
		return roleDTO;
	}

	/**
	 * Sets new username.
	 *
	 * @param username New value of username.
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * Sets new profileDTO.
	 *
	 * @param profileDTO New value of profileDTO.
	 */
	public void setProfileDTO(ProfileDTO profileDTO)
	{
		this.profileDTO = profileDTO;
	}

	/**
	 * Sets new password.
	 *
	 * @param password New value of password.
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * Sets new enabled.
	 *
	 * @param enabled New value of enabled.
	 */
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

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
		if (!password.equals(userDTO.password))
		{
			return false;
		}
		if (confirmPassword != null ? !confirmPassword.equals(userDTO.confirmPassword) : userDTO.confirmPassword != null)
		{
			return false;
		}
		if (!profileDTO.equals(userDTO.profileDTO))
		{
			return false;
		}
		return roleDTO.equals(userDTO.roleDTO);

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
		result = HASH_NUMBER * result + (confirmPassword != null ? confirmPassword.hashCode() : 0);
		result = HASH_NUMBER * result + profileDTO.hashCode();
		result = HASH_NUMBER * result + roleDTO.hashCode();
		return result;
	}
}