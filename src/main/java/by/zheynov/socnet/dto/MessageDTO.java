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
	private ProfileDTO profileDTO;
	private DialogDTO  dialogDTO;

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
	 * Gets profileDTO.
	 *
	 * @return Value of profileDTO.
	 */
	public ProfileDTO getProfileDTO()
	{
		return profileDTO;
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
	 * Sets new dialogDTO.
	 *
	 * @param dialogDTO New value of dialogDTO.
	 */
	public void setDialogDTO(DialogDTO dialogDTO)
	{
		this.dialogDTO = dialogDTO;
	}

	/**
	 * Gets dialogDTO.
	 *
	 * @return Value of dialogDTO.
	 */
	public DialogDTO getDialogDTO()
	{
		return dialogDTO;
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
	 * Gets text.
	 *
	 * @return Value of text.
	 */
	public String getText()
	{
		return text;
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
		if (getProfileDTO() != null ? !getProfileDTO().equals(that.getProfileDTO()) : that.getProfileDTO() != null)
		{
			return false;
		}
		return getDialogDTO() != null ? getDialogDTO().equals(that.getDialogDTO()) : that.getDialogDTO() == null;

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
		result = HASH_NUMBER * result + (getProfileDTO() != null ? getProfileDTO().hashCode() : 0);
		result = HASH_NUMBER * result + (getDialogDTO() != null ? getDialogDTO().hashCode() : 0);
		return result;
	}
}