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
import javax.persistence.Table;

/**
 * FriendEntity class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.entity
 */
@Entity
@Table(name = "friend")
public class FriendEntity
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "main_profile_id")
	private ProfileEntity currentProfileEntity;

	@Column(name = "friends_profile_id")
	private ProfileEntity friendProfileEntity;

	@Column(name = "status")
	private boolean status;

	/**
	 * Sets new friendProfileEntity.
	 *
	 * @param friendProfileEntity New value of friendProfileEntity.
	 */
	public void setFriendProfileEntity(ProfileEntity friendProfileEntity)
	{
		this.friendProfileEntity = friendProfileEntity;
	}

	/**
	 * Gets friendProfileEntity.
	 *
	 * @return Value of friendProfileEntity.
	 */
	public ProfileEntity getFriendProfileEntity()
	{
		return friendProfileEntity;
	}

	/**
	 * Sets new status.
	 *
	 * @param status New value of status.
	 */
	public void setStatus(boolean status)
	{
		this.status = status;
	}

	/**
	 * Gets status.
	 *
	 * @return Value of status.
	 */
	public boolean isStatus()
	{
		return status;
	}

	/**
	 * Sets new currentProfileEntity.
	 *
	 * @param currentProfileEntity New value of currentProfileEntity.
	 */
	public void setCurrentProfileEntity(ProfileEntity currentProfileEntity)
	{
		this.currentProfileEntity = currentProfileEntity;
	}

	/**
	 * Gets currentProfileEntity.
	 *
	 * @return Value of currentProfileEntity.
	 */
	public ProfileEntity getCurrentProfileEntity()
	{
		return currentProfileEntity;
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
	 * Gets id.
	 *
	 * @return Value of id.
	 */
	public Long getId()
	{
		return id;
	}
}