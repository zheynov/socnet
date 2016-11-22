package by.zheynov.socnet.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Dialog Entity class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.entity
 */
@Entity
@Table(name = "dialog")
public class DialogEntity implements Serializable
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "dialogs")
	private Set<ProfileEntity> profiles = new HashSet<ProfileEntity>();

	// OneToMany with MessageEntity
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dialogEntity")
	private Set<MessageEntity> messages = new HashSet<MessageEntity>();

	/**
	 * Sets new profiles.
	 *
	 * @param profiles New value of profiles.
	 */
	public void setProfiles(final Set<ProfileEntity> profiles)
	{
		this.profiles = profiles;
	}

	/**
	 * Sets new messages.
	 *
	 * @param messages New value of messages.
	 */
	public void setMessages(final Set<MessageEntity> messages)
	{
		this.messages = messages;
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
	 * Gets profiles.
	 *
	 * @return Value of profiles.
	 */
	public Set<ProfileEntity> getProfiles()
	{
		return profiles;
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
	 * Gets messages.
	 *
	 * @return Value of messages.
	 */
	public Set<MessageEntity> getMessages()
	{
		return messages;
	}
}