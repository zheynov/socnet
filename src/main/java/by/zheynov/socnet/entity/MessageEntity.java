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
	private ProfileEntity profileEntity;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "dialogID")
	private DialogEntity dialogEntity;

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
	 * Sets new profileEntity.
	 *
	 * @param profileEntity New value of profileEntity.
	 */
	public void setProfileEntity(final ProfileEntity profileEntity)
	{
		this.profileEntity = profileEntity;
	}

	/**
	 * Gets dialogEntity.
	 *
	 * @return Value of dialogEntity.
	 */
	public DialogEntity getDialogEntity()
	{
		return dialogEntity;
	}

	/**
	 * Sets new dialogEntity.
	 *
	 * @param dialogEntity New value of dialogEntity.
	 */
	public void setDialogEntity(final DialogEntity dialogEntity)
	{
		this.dialogEntity = dialogEntity;
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
	 * Gets profileEntity.
	 *
	 * @return Value of profileEntity.
	 */
	public ProfileEntity getProfileEntity()
	{
		return profileEntity;
	}
}