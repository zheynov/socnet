package by.zheynov.socnet.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Message Entity class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.entity
 */
@Entity
@Table(name = "message")
public class MessageEntity
{
	private static final int TABLE_COLUMN_MAX_TEXT_LENGTH = 1024;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "senderID")
	private Long senderID;

	@Column(name = "destinationID")
	private Long destinationID;

	@Column(name = "messagedate")
	private Date messageDate;

	@Column(name = "text", length = TABLE_COLUMN_MAX_TEXT_LENGTH)
	private String text;

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
	 * Sets new senderID.
	 *
	 * @param senderID New value of senderID.
	 */
	public void setSenderID(final Long senderID)
	{
		this.senderID = senderID;
	}

	/**
	 * Gets destinationID.
	 *
	 * @return Value of destinationID.
	 */
	public Long getDestinationID()
	{
		return destinationID;
	}

	/**
	 * Sets new destinationID.
	 *
	 * @param destinationID New value of destinationID.
	 */
	public void setDestinationID(final Long destinationID)
	{
		this.destinationID = destinationID;
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
	 * Gets messageDate.
	 *
	 * @return Value of messageDate.
	 */
	public Date getMessageDate()
	{
		return messageDate;
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
	 * Gets senderID.
	 *
	 * @return Value of senderID.
	 */
	public Long getSenderID()
	{
		return senderID;
	}
}