package by.zheynov.socnet.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * PostDTO class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dto
 */
public class PostDTO
{
	private static final int HASH_NUMBER = 31;
	private Long          postID;
	private Date          postDate;
	private ProfileDTO    senderProfileDTO;
	private ProfileDTO    wallOwnerProfileDTO;
	private String        text;
	private String        photoFileName;
	private MultipartFile photo;

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
		if (!getText().equals(postDTO.getText()))
		{
			return false;
		}
		if (!getPhotoFileName().equals(postDTO.getPhotoFileName()))
		{
			return false;
		}
		return getPhoto().equals(postDTO.getPhoto());

	}

	@Override
	public int hashCode()
	{
		int result = getPostID().hashCode();
		result = HASH_NUMBER * result + getPostDate().hashCode();
		result = HASH_NUMBER * result + getSenderProfileDTO().hashCode();
		result = HASH_NUMBER * result + getWallOwnerProfileDTO().hashCode();
		result = HASH_NUMBER * result + getText().hashCode();
		result = HASH_NUMBER * result + getPhotoFileName().hashCode();
		result = HASH_NUMBER * result + getPhoto().hashCode();
		return result;
	}

	/**
	 * Gets photo.
	 *
	 * @return Value of photo.
	 */
	public MultipartFile getPhoto()
	{
		return photo;
	}

	/**
	 * Sets new photo.
	 *
	 * @param photo New value of photo.
	 */
	public void setPhoto(MultipartFile photo)
	{
		this.photo = photo;
	}

	/**
	 * Sets new photoFileName.
	 *
	 * @param photoFileName New value of photoFileName.
	 */
	public void setPhotoFileName(String photoFileName)
	{
		this.photoFileName = photoFileName;
	}

	/**
	 * Gets photoFileName.
	 *
	 * @return Value of photoFileName.
	 */
	public String getPhotoFileName()
	{
		return photoFileName;
	}
}