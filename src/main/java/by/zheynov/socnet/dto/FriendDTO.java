package by.zheynov.socnet.dto;

import java.io.Serializable;

import by.zheynov.socnet.entity.FriendRequestApprovalStatus;

/**
 * FriendDTO class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dto
 */
public class FriendDTO implements Serializable
{
	private static final int HASH_NUMBER = 31;
	private Long                        id;
	private ProfileDTO                  profileDTO;
	private Long                        friendProfileId;
	private FriendRequestApprovalStatus status;

	/**
	 * Sets new status.
	 *
	 * @param status New value of status.
	 */
	public void setStatus(final FriendRequestApprovalStatus status)
	{
		this.status = status;
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
	 * Sets new friendProfileId.
	 *
	 * @param friendProfileId New value of friendProfileId.
	 */
	public void setFriendProfileId(final Long friendProfileId)
	{
		this.friendProfileId = friendProfileId;
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
	 * Gets id.
	 *
	 * @return Value of id.
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * Gets friendProfileId.
	 *
	 * @return Value of friendProfileId.
	 */
	public Long getFriendProfileId()
	{
		return friendProfileId;
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
	 * Sets new id.
	 *
	 * @param id New value of id.
	 */
	public void setId(final Long id)
	{
		this.id = id;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof FriendDTO))
		{
			return false;
		}

		FriendDTO friendDTO = (FriendDTO) o;

		if (!getId().equals(friendDTO.getId()))
		{
			return false;
		}
		if (!getProfileDTO().equals(friendDTO.getProfileDTO()))
		{
			return false;
		}
		if (!getFriendProfileId().equals(friendDTO.getFriendProfileId()))
		{
			return false;
		}
		return getStatus() == friendDTO.getStatus();

	}

	@Override
	public int hashCode()
	{
		int result = getId().hashCode();
		result = HASH_NUMBER * result + getProfileDTO().hashCode();
		result = HASH_NUMBER * result + getFriendProfileId().hashCode();
		result = HASH_NUMBER * result + getStatus().hashCode();
		return result;
	}
}