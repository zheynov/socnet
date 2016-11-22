package by.zheynov.socnet.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class FriendEntity implements Serializable
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "main_profile_id")
	private ProfileEntity currentProfileEntity;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "friends_profile_id")
	private ProfileEntity friendProfileEntity;

	@Column(name = "friend_request_status")
	@Enumerated(EnumType.STRING)
	private FriendRequestApprovalStatus status;

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
	 * Gets friendProfileEntity.
	 *
	 * @return Value of friendProfileEntity.
	 */
	public ProfileEntity getFriendProfileEntity()
	{
		return friendProfileEntity;
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
	 * Sets new currentProfileEntity.
	 *
	 * @param currentProfileEntity New value of currentProfileEntity.
	 */
	public void setCurrentProfileEntity(final ProfileEntity currentProfileEntity)
	{
		this.currentProfileEntity = currentProfileEntity;
	}

	/**
	 * Sets new friendProfileEntity.
	 *
	 * @param friendProfileEntity New value of friendProfileEntity.
	 */
	public void setFriendProfileEntity(final ProfileEntity friendProfileEntity)
	{
		this.friendProfileEntity = friendProfileEntity;
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
	 * Gets status.
	 *
	 * @return Value of status.
	 */
	public FriendRequestApprovalStatus getStatus()
	{
		return status;
	}

	/**
	 * Sets new status.
	 *
	 * @param status New value of status.
	 */
	public void setStatus(final FriendRequestApprovalStatus status)
	{
		this.status = status;
	}
}