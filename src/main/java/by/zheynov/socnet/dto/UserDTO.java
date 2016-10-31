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
	private Long    id;
	private String  email;
	private String  username;
	private String  password;
	private boolean enabled;
	private String  confirmPassword;

	public Long getId()
	{
		return id;
	}

	public void setId(final Long id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(final String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public void setEnabled(final boolean enabled)
	{
		this.enabled = enabled;
	}

	public String getConfirmPassword()
	{
		return confirmPassword;
	}

	public void setConfirmPassword(final String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
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

	@Override
	public int hashCode()
	{
		int result = id.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + username.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + (enabled ? 1 : 0);
		return result;
	}
}