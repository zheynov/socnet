package by.zheynov.socnet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * PhotoEntity class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.entity
 */
@Entity
@Table(name = "photo")
public class PhotoEntity
{
	private static final int MAX_TEXT_LENGTH = 64;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "photo_file_name", length = MAX_TEXT_LENGTH)
	private String photoFileName;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "profileID")
	private ProfileEntity profileEntity;

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
	 * Gets photoFileName.
	 *
	 * @return Value of photoFileName.
	 */
	public String getPhotoFileName()
	{
		return photoFileName;
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
	 * Gets profileEntity.
	 *
	 * @return Value of profileEntity.
	 */
	public ProfileEntity getProfileEntity()
	{
		return profileEntity;
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
}