package by.zheynov.socnet.entity;

import javax.persistence.*;

import java.io.Serializable;

/**
 * Created by ZheynovVV on 28.10.2016.
 */

@Entity
@Table(name = "user_roles")
public class RoleEntity implements Serializable
{
	public RoleEntity()
	{
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/*    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
			@JoinColumn(name = "login")*/
	@Column(name = "login", length = 45)
	private String login;

	@Column(name = "role", length = 45)
	private String role;

	public Long getId()
	{
		return id;
	}

	public void setId(final Long id)
	{
		this.id = id;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(final String login)
	{
		this.login = login;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(final String role)
	{
		this.role = role;
	}
}
