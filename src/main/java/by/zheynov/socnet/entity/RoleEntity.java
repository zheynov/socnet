package by.zheynov.socnet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

/**
 * User's role Entity class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.entity
 */

@Entity
@Table(name = "user_roles")
public class RoleEntity implements Serializable
{
	private static final int TABLE_COLUMN_MAX_LENGTH = 45;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", length = TABLE_COLUMN_MAX_LENGTH)
	private String username;

	@Column(name = "role", length = TABLE_COLUMN_MAX_LENGTH)
	private String role;

	/**
	 * Constructor for 	RoleEntity.
	 */
	public RoleEntity()
	{
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
	 * Gets username.
	 *
	 * @return Value of username.
	 */
	public String getUsername()
	{
		return username;
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
	 * Sets new id.
	 *
	 * @param id New value of id.
	 */
	public void setId(final Long id)
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
	public void setRole(final String role)
	{
		this.role = role;
	}
}
