package by.zheynov.socnet.dto;

import java.util.Date;

/**
 * PostDTO class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dto
 */
public class PostDTO
{
	private static final int HASH_NUMBER = 31;
	private Long       postID;
	private Date       postDate;
	private ProfileDTO senderProfileDTO;
	private ProfileDTO wallOwnerProfileDTO;
	private String     text;
	private PhotoDTO   photoDTO;

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
	 * Sets new postID.
	 *
	 * @param postID New value of postID.
	 */
	public void setPostID(final Long postID)
	{
		this.postID = postID;
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
	 * Gets postID.
	 *
	 * @return Value of postID.
	 */
	public Long getPostID()
	{
		return postID;
	}

	/**
	 * Sets new postDate.
	 *
	 * @param postDate New value of postDate.
	 */
	public void setPostDate(final Date postDate)
	{
		this.postDate = postDate;
	}

	/**
	 * Gets postDate.
	 *
	 * @return Value of postDate.
	 */
	public Date getPostDate()
	{
		return postDate;
	}

	/**
	 * Gets photoDTO.
	 *
	 * @return Value of photoDTO.
	 */
	public PhotoDTO getPhotoDTO()
	{
		return photoDTO;
	}

	/**
	 * Sets new photoDTO.
	 *
	 * @param photoDTO New value of photoDTO.
	 */
	public void setPhotoDTO(final PhotoDTO photoDTO)
	{
		this.photoDTO = photoDTO;
	}

	/**
	 * Sets new wallOwnerProfileDTO.
	 *
	 * @param wallOwnerProfileDTO New value of wallOwnerProfileDTO.
	 */
	public void setWallOwnerProfileDTO(final ProfileDTO wallOwnerProfileDTO)
	{
		this.wallOwnerProfileDTO = wallOwnerProfileDTO;
	}

	/**
	 * Gets wallOwnerProfileDTO.
	 *
	 * @return Value of wallOwnerProfileDTO.
	 */
	public ProfileDTO getWallOwnerProfileDTO()
	{
		return wallOwnerProfileDTO;
	}

	/**
	 * Sets new senderProfileDTO.
	 *
	 * @param senderProfileDTO New value of senderProfileDTO.
	 */
	public void setSenderProfileDTO(final ProfileDTO senderProfileDTO)
	{
		this.senderProfileDTO = senderProfileDTO;
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

	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof PostDTO))
		{
			return false;
		}

		PostDTO postDTO = (PostDTO) o;

		if (!getPostID().equals(postDTO.getPostID()))
		{
			return false;
		}
		if (!getPostDate().equals(postDTO.getPostDate()))
		{
			return false;
		}
		if (!getSenderProfileDTO().equals(postDTO.getSenderProfileDTO()))
		{
			return false;
		}
		if (!getWallOwnerProfileDTO().equals(postDTO.getWallOwnerProfileDTO()))
		{
			return false;
		}
		if (getText() != null ? !getText().equals(postDTO.getText()) : postDTO.getText() != null)
		{
			return false;
		}
		return getPhotoDTO() != null ? getPhotoDTO().equals(postDTO.getPhotoDTO()) : postDTO.getPhotoDTO() == null;

	}

	@Override
	public int hashCode()
	{
		int result = getPostID().hashCode();
		result = HASH_NUMBER * result + getPostDate().hashCode();
		result = HASH_NUMBER * result + getSenderProfileDTO().hashCode();
		result = HASH_NUMBER * result + getWallOwnerProfileDTO().hashCode();
		result = HASH_NUMBER * result + (getText() != null ? getText().hashCode() : 0);
		result = HASH_NUMBER * result + (getPhotoDTO() != null ? getPhotoDTO().hashCode() : 0);
		return result;
	}
}