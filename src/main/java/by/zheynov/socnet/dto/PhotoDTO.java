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
	private Long          id;
	private String        photoFileName;
	private MultipartFile photo;

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
	public void setId(Long id)
	{
		this.id = id;
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
}