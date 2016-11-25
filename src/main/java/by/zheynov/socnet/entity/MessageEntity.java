package by.zheynov.socnet.entity;

import java.io.Serializable;
import java.util.Date;

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
 * Message Entity class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.entity
 */
@Entity
@Table(name = "message")
public class MessageEntity implements Serializable
{
	private static final int TABLE_COLUMN_MAX_TEXT_LENGTH = 1024;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "messagedate")
	private Date messageDate;

	@Column(name = "text", length = TABLE_COLUMN_MAX_TEXT_LENGTH)
	private String text;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "senderID")
	private ProfileEntity profileSenderEntity;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "destinationID")
	private ProfileEntity profileDestinationEntity;

	/**
	 * Gets messageDate.
	 *
	 * @return Value of messageDate.
	 */
	public Date getMessageDate()
	{
		return messageDate;
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
	 * Sets new text.
	 *
	 * @param text New value of text.
	 */
	public void setText(final String text)
	{
		this.text = text;
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
	 * Sets new messageDate.
	 *
	 * @param messageDate New value of messageDate.
	 */
	public void setMessageDate(final Date messageDate)
	{
		this.messageDate = messageDate;
	}


	/**
	 * Gets text.
	 *
	 * @return Value of text.
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * Sets new profileDestinationEntity.
	 *
	 * @param profileDestinationEntity New value of profileDestinationEntity.
	 */
	public void setProfileDestinationEntity(ProfileEntity profileDestinationEntity)
	{
		this.profileDestinationEntity = profileDestinationEntity;
	}

	/**
	 * Sets new profileSenderEntity.
	 *
	 * @param profileSenderEntity New value of profileSenderEntity.
	 */
	public void setProfileSenderEntity(ProfileEntity profileSenderEntity)
	{
		this.profileSenderEntity = profileSenderEntity;
	}

	/**
	 * Gets profileDestinationEntity.
	 *
	 * @return Value of profileDestinationEntity.
	 */
	public ProfileEntity getProfileDestinationEntity()
	{
		return profileDestinationEntity;
	}

	/**
	 * Gets profileSenderEntity.
	 *
	 * @return Value of profileSenderEntity.
	 */
	public ProfileEntity getProfileSenderEntity()
	{
		return profileSenderEntity;
	}
}