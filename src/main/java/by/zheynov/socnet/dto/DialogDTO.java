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

	//private Set<ProfileDTO> profiles = new HashSet<ProfileDTO>();

	private Set<MessageDTO> messages = new HashSet<MessageDTO>();

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
	 * Gets profiles.
	 *
	 * @return Value of profiles.
	 */
/*	public Set<ProfileDTO> getProfiles()
	{
		return profiles;
	}*/

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
/*	public void setProfiles(Set<ProfileDTO> profiles)
	{
		this.profiles = profiles;
	}*/

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
	public void setMessages(Set<MessageDTO> messages)
	{
		this.messages = messages;
	}
}