package by.zheynov.socnet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

/**
 * User's role Entity class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.entity
 */

@Entity
@Table(name = "user_role")
public class RoleEntity implements Serializable
{
	private static final int TABLE_COLUMN_MAX_LENGTH = 45;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "role", length = TABLE_COLUMN_MAX_LENGTH)
	private String role;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleEntity")
	private List<UserEntity> users;

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

	/**
	 * Gets users.
	 *
	 * @return Value of users.
	 */
	public List<UserEntity> getUsers()
	{
		return users;
	}

	/**
	 * Sets new users.
	 *
	 * @param users New value of users.
	 */
	public void setUsers(List<UserEntity> users)
	{
		this.users = users;
	}
}
