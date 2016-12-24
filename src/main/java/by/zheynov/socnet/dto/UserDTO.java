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
	private String     newPassword;
	private boolean    enabled;
	private String     confirmPassword;
	private ProfileDTO profileDTO;
	private RoleDTO    roleDTO;

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
	 * Sets new id.
	 *
	 * @param id New value of id.
	 */
	public void setId(final Long id)
	{
		this.id = id;
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
	public void setRoleDTO(final RoleDTO roleDTO)
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
	public void setUsername(final String username)
	{
		this.username = username;
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
	 * Sets new password.
	 *
	 * @param password New value of password.
	 */
	public void setPassword(final String password)
	{
		this.password = password;
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
	 * Sets new newPassword.
	 *
	 * @param newPassword New value of newPassword.
	 */
	public void setNewPassword(final String newPassword)
	{
		this.newPassword = newPassword;
	}

	/**
	 * Gets newPassword.
	 *
	 * @return Value of newPassword.
	 */
	public String getNewPassword()
	{
		return newPassword;
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
		if (getNewPassword() != null ? !getNewPassword().equals(userDTO.getNewPassword()) : userDTO.getNewPassword() != null)
		{
			return false;
		}
		if (getConfirmPassword() != null ? !getConfirmPassword().equals(userDTO.getConfirmPassword()) :
						userDTO.getConfirmPassword() != null)
		{
			return false;
		}
		if (!getProfileDTO().equals(userDTO.getProfileDTO()))
		{
			return false;
		}
		return getRoleDTO().equals(userDTO.getRoleDTO());

	}

	@Override
	public int hashCode()
	{
		int result = getId().hashCode();
		result = HASH_NUMBER * result + getEmail().hashCode();
		result = HASH_NUMBER * result + getUsername().hashCode();
		result = HASH_NUMBER * result + getPassword().hashCode();
		result = HASH_NUMBER * result + (getNewPassword() != null ? getNewPassword().hashCode() : 0);
		result = HASH_NUMBER * result + (isEnabled() ? 1 : 0);
		result = HASH_NUMBER * result + (getConfirmPassword() != null ? getConfirmPassword().hashCode() : 0);
		result = HASH_NUMBER * result + getProfileDTO().hashCode();
		result = HASH_NUMBER * result + getRoleDTO().hashCode();
		return result;
	}
}