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
	@Column(name = "username", length = 45)
	private String username;

	@Column(name = "role", length = 45)
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
