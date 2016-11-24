package by.zheynov.socnet.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * DialogDTO class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dto
 */
public class DialogDTO implements Serializable
{
	private Long id;
	private static final int             HASH_NUMBER = 31;
	private              Set<ProfileDTO> profiles    = new HashSet<ProfileDTO>();
	private              Set<MessageDTO> messages    = new HashSet<MessageDTO>();

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
	 * Gets profiles.
	 *
	 * @return Value of profiles.
	 */
	public Set<ProfileDTO> getProfiles()
	{
		return profiles;
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
	 * Sets new profiles.
	 *
	 * @param profiles New value of profiles.
	 */
	public void setProfiles(final Set<ProfileDTO> profiles)
	{
		this.profiles = profiles;
	}

	/**
	 * Gets messages.
	 *
	 * @return Value of messages.
	 */
	public Set<MessageDTO> getMessages()
	{
		return messages;
	}

	/**
	 * Sets new messages.
	 *
	 * @param messages New value of messages.
	 */
	public void setMessages(final Set<MessageDTO> messages)
	{
		this.messages = messages;
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
		if (!(o instanceof DialogDTO))
		{
			return false;
		}

		DialogDTO dialogDTO = (DialogDTO) o;

		if (getId() != null ? !getId().equals(dialogDTO.getId()) : dialogDTO.getId() != null)
		{
			return false;
		}
		if (getProfiles() != null ? !getProfiles().equals(dialogDTO.getProfiles()) : dialogDTO.getProfiles() != null)
		{
			return false;
		}
		return getMessages() != null ? getMessages().equals(dialogDTO.getMessages()) : dialogDTO.getMessages() == null;

	}

	/**
	 * Calculates a hashcode for this object.
	 *
	 * @return the hash
	 */
	@Override
	public int hashCode()
	{
		int result = getId() != null ? getId().hashCode() : 0;
		result = HASH_NUMBER * result + (getProfiles() != null ? getProfiles().hashCode() : 0);
		result = HASH_NUMBER * result + (getMessages() != null ? getMessages().hashCode() : 0);
		return result;
	}
}