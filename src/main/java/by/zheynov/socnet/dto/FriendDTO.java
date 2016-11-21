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
	private ProfileDTO                  friendProfileDTO;
	private FriendRequestApprovalStatus status;

	/**
	 * Sets new friendProfileDTO.
	 *
	 * @param friendProfileDTO New value of friendProfileDTO.
	 */
	public void setFriendProfileDTO(ProfileDTO friendProfileDTO)
	{
		this.friendProfileDTO = friendProfileDTO;
	}

	/**
	 * Sets new profileDTO.
	 *
	 * @param profileDTO New value of profileDTO.
	 */
	public void setProfileDTO(ProfileDTO profileDTO)
	{
		this.profileDTO = profileDTO;
	}

	/**
	 * Gets friendProfileDTO.
	 *
	 * @return Value of friendProfileDTO.
	 */
	public ProfileDTO getFriendProfileDTO()
	{
		return friendProfileDTO;
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
	public void setId(Long id)
	{
		this.id = id;
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
	public void setStatus(FriendRequestApprovalStatus status)
	{
		this.status = status;
	}


	/**
	 * Compares this FriendDTO object to the specified Object o.
	 *
	 * @param o
	 *
	 * @return true if objects are the same, otherwise false
	 */
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
		if (!getFriendProfileDTO().equals(friendDTO.getFriendProfileDTO()))
		{
			return false;
		}
		return getStatus() == friendDTO.getStatus();

	}

	/**
	 * Calculates a hashcode for this object.
	 *
	 * @return the hash
	 */
	@Override
	public int hashCode()
	{
		int result = getId().hashCode();
		result = HASH_NUMBER * result + getProfileDTO().hashCode();
		result = HASH_NUMBER * result + getFriendProfileDTO().hashCode();
		result = HASH_NUMBER * result + getStatus().hashCode();
		return result;
	}
}