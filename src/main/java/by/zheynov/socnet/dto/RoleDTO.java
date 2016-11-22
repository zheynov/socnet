package by.zheynov.socnet.dto;

import java.io.Serializable;


/**
 * Role data transfer object.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dto
 */
public class RoleDTO implements Serializable
{
	private Long id;
	private String role;

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
	 * Sets new id.
	 *
	 * @param id New value of id.
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * Gets role.
	 *
	 * @return Value of role.
	 */
	public String getRole()
	{
		return role;
	}

	/**
	 * Sets new role.
	 *
	 * @param role New value of role.
	 */
	public void setRole(String role)
	{
		this.role = role;
	}
}