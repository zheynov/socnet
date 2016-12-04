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
	private Long postID;
	private Date postDate;
	private ProfileDTO profileDTO;
	private String text;
	private String photoFileName;

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
	 * Gets photoFileName.
	 *
	 * @return Value of photoFileName.
	 */
	public String getPhotoFileName()
	{
		return photoFileName;
	}

	/**
	 * Sets new profileDTO.
	 *
	 * @param profileDTO New value of profileDTO.
	 */
	public void setProfileDTO(final ProfileDTO profileDTO)
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
	 * Sets new photoFileName.
	 *
	 * @param photoFileName New value of photoFileName.
	 */
	public void setPhotoFileName(final String photoFileName)
	{
		this.photoFileName = photoFileName;
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
		if (!getProfileDTO().equals(postDTO.getProfileDTO()))
		{
			return false;
		}
		if (getText() != null ? !getText().equals(postDTO.getText()) : postDTO.getText() != null)
		{
			return false;
		}
		return getPhotoFileName() != null ? getPhotoFileName().equals(postDTO.getPhotoFileName()) :
						postDTO.getPhotoFileName() == null;

	}

	@Override
	public int hashCode()
	{
		int result = getPostID().hashCode();
		result = HASH_NUMBER * result + getPostDate().hashCode();
		result = HASH_NUMBER * result + getProfileDTO().hashCode();
		result = HASH_NUMBER * result + (getText() != null ? getText().hashCode() : 0);
		result = HASH_NUMBER * result + (getPhotoFileName() != null ? getPhotoFileName().hashCode() : 0);
		return result;
	}
}