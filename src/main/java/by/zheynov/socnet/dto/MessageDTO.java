package by.zheynov.socnet.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * MessageDTO class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dto
 */
public class MessageDTO implements Serializable
{
	private static final int HASH_NUMBER = 31;
	private Long       id;
	private Date       messageDate;
	private String     text;
	private ProfileDTO senderProfileDTO;
	private ProfileDTO destinationProfileDTO;

	/**
	 * Sets new messageDate.
	 *
	 * @param messageDate New value of messageDate.
	 */
	public void setMessageDate(Date messageDate)
	{
		this.messageDate = messageDate;
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
	 * Sets new text.
	 *
	 * @param text New value of text.
	 */
	public void setText(String text)
	{
		this.text = text;
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
	 * Gets destinationProfileDTO.
	 *
	 * @return Value of destinationProfileDTO.
	 */
	public ProfileDTO getDestinationProfileDTO()
	{
		return destinationProfileDTO;
	}

	/**
	 * Gets senderProfileDTO.
	 *
	 * @return Value of senderProfileDTO.
	 */
	public ProfileDTO getSenderProfileDTO()
	{
		return senderProfileDTO;
	}

	/**
	 * Sets new senderProfileDTO.
	 *
	 * @param senderProfileDTO New value of senderProfileDTO.
	 */
	public void setSenderProfileDTO(ProfileDTO senderProfileDTO)
	{
		this.senderProfileDTO = senderProfileDTO;
	}

	/**
	 * Sets new destinationProfileDTO.
	 *
	 * @param destinationProfileDTO New value of destinationProfileDTO.
	 */
	public void setDestinationProfileDTO(ProfileDTO destinationProfileDTO)
	{
		this.destinationProfileDTO = destinationProfileDTO;
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
		if (!(o instanceof MessageDTO))
		{
			return false;
		}

		MessageDTO that = (MessageDTO) o;

		if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null)
		{
			return false;
		}
		if (getMessageDate() != null ? !getMessageDate().equals(that.getMessageDate()) : that.getMessageDate() != null)
		{
			return false;
		}
		if (getText() != null ? !getText().equals(that.getText()) : that.getText() != null)
		{
			return false;
		}
		if (getSenderProfileDTO() != null ? !getSenderProfileDTO().equals(that.getSenderProfileDTO()) :
						that.getSenderProfileDTO() != null)
		{
			return false;
		}
		return getDestinationProfileDTO() != null ? getDestinationProfileDTO().equals(that.getDestinationProfileDTO()) :
						that.getDestinationProfileDTO() == null;

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
		result = HASH_NUMBER * result + (getMessageDate() != null ? getMessageDate().hashCode() : 0);
		result = HASH_NUMBER * result + (getText() != null ? getText().hashCode() : 0);
		result = HASH_NUMBER * result + (getSenderProfileDTO() != null ? getSenderProfileDTO().hashCode() : 0);
		result = HASH_NUMBER * result + (getDestinationProfileDTO() != null ? getDestinationProfileDTO().hashCode() : 0);
		return result;
	}
}