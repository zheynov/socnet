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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.access.method.P;

/**
 * PostEntity class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.entity
 */

@Entity
@Table(name = "post")
public class PostEntity implements Serializable
{
	private static final int MAX_TEXT_LENGTH = 1024;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postID;

	@Column(name = "date")
	private Date postDate;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_sender_id")
	private ProfileEntity profileSender;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "wall_owner_profile_id")
	private ProfileEntity wallOwnerProfile;

	@Column(name = "text", length = MAX_TEXT_LENGTH)
	private String text;

	@Column(name = "photo_file_name")
	private String photoFileName;

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
	 * Gets postID.
	 *
	 * @return Value of postID.
	 */
	public Long getPostID()
	{
		return postID;
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
	 * Sets new postID.
	 *
	 * @param postID New value of postID.
	 */
	public void setPostID(final Long postID)
	{
		this.postID = postID;
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
	 * Sets new postDate.
	 *
	 * @param postDate New value of postDate.
	 */
	public void setPostDate(final Date postDate)
	{
		this.postDate = postDate;
	}



	/**
	 * Sets new profileSender.
	 *
	 * @param profileSender New value of profileSender.
	 */
	public void setProfileSender(final ProfileEntity profileSender)
	{
		this.profileSender = profileSender;
	}

	/**
	 * Gets profileSender.
	 *
	 * @return Value of profileSender.
	 */
	public ProfileEntity getProfileSender()
	{
		return profileSender;
	}

	/**
	 * Gets wallOwnerProfile.
	 *
	 * @return Value of wallOwnerProfile.
	 */
	public ProfileEntity getWallOwnerProfile()
	{
		return wallOwnerProfile;
	}

	/**
	 * Sets new wallOwnerProfile.
	 *
	 * @param wallOwnerProfile New value of wallOwnerProfile.
	 */
	public void setWallOwnerProfile(final ProfileEntity wallOwnerProfile)
	{
		this.wallOwnerProfile = wallOwnerProfile;
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