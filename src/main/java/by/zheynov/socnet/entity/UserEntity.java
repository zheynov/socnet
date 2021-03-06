package by.zheynov.socnet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;

/**
 * UserEntity class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.entity
 */

@Entity
@Table(name = "user")
public class UserEntity implements Serializable
{
	private static final int TABLE_COLUMN_MAX_LENGTH = 64;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email", length = TABLE_COLUMN_MAX_LENGTH)
	private String email;

	@Column(name = "username", length = TABLE_COLUMN_MAX_LENGTH, unique = true)
	private String username;

	@Column(name = "password", length = TABLE_COLUMN_MAX_LENGTH)
	private String password;

	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "profileID")
	private ProfileEntity profileEntity;

	@Column(name = "enabled")
	private boolean enabled;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "roleID")
	private RoleEntity roleEntity;

	/**
	 * Constructor for UserEntity.
	 */
	public UserEntity()
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
	 * Sets new profileEntity.
	 *
	 * @param profileEntity New value of profileEntity.
	 */
	public void setProfileEntity(final ProfileEntity profileEntity)
	{
		this.profileEntity = profileEntity;
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
	 * Gets profileEntity.
	 *
	 * @return Value of profileEntity.
	 */
	public ProfileEntity getProfileEntity()
	{
		return profileEntity;
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
	 * Gets enabled.
	 *
	 * @return Value of enabled.
	 */
	public boolean isEnabled()
	{
		return enabled;
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
	 * Gets password.
	 *
	 * @return Value of password.
	 */
	public String getPassword()
	{
		return password;
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
	 * Sets new enabled.
	 *
	 * @param enabled New value of enabled.
	 */
	public void setEnabled(final boolean enabled)
	{
		this.enabled = enabled;
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
	 * Gets roleEntity.
	 *
	 * @return Value of roleEntity.
	 */
	public RoleEntity getRoleEntity()
	{
		return roleEntity;
	}

	/**
	 * Sets new roleEntity.
	 *
	 * @param roleEntity New value of roleEntity.
	 */
	public void setRoleEntity(final RoleEntity roleEntity)
	{
		this.roleEntity = roleEntity;
	}
}

