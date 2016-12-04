package by.zheynov.socnet.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * PhotoDTO class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dto
 */
public class PhotoDTO
{
	private static final int HASH_NUMBER = 31;
	private Long          id;
	private String        photoFileName;
	private MultipartFile photo;
	private ProfileDTO profileDTO;

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
	 * Sets new id.
	 *
	 * @param id New value of id.
	 */
	public void setId(final Long id)
	{
		this.id = id;
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
	 * Gets photoFileName.
	 *
	 * @return Value of photoFileName.
	 */
	public String getPhotoFileName()
	{
		return photoFileName;
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
	public void setPhoto(final MultipartFile photo)
	{
		this.photo = photo;
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
	 * Sets new profileDTO.
	 *
	 * @param profileDTO New value of profileDTO.
	 */
	public void setProfileDTO(final ProfileDTO profileDTO)
	{
		this.profileDTO = profileDTO;
	}

	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof PhotoDTO))
		{
			return false;
		}

		PhotoDTO photoDTO = (PhotoDTO) o;

		if (!getId().equals(photoDTO.getId()))
		{
			return false;
		}
		if (!getPhotoFileName().equals(photoDTO.getPhotoFileName()))
		{
			return false;
		}
		if (!getPhoto().equals(photoDTO.getPhoto()))
		{
			return false;
		}
		return getProfileDTO() != null ? getProfileDTO().equals(photoDTO.getProfileDTO()) : photoDTO.getProfileDTO() == null;

	}

	@Override
	public int hashCode()
	{
		int result = getId().hashCode();
		result = HASH_NUMBER * result + getPhotoFileName().hashCode();
		result = HASH_NUMBER * result + getPhoto().hashCode();
		result = HASH_NUMBER * result + (getProfileDTO() != null ? getProfileDTO().hashCode() : 0);
		return result;
	}
}