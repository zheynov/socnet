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
 * PostEntity class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.entity
 */

@Entity
@Table(name = "post")
public class PostEntity implements Serializable
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postID;

	@Column(name = "date")
	private Date postDate;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "userID")
	private UserEntity userID;

	@Column(name = "text", length = 256)
	private String text;

	@Column(name = "photo")
	private String photo;

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
	public void setText(String text)
	{
		this.text = text;
	}

	/**
	 * Sets new photo.
	 *
	 * @param photo New value of photo.
	 */
	public void setPhoto(String photo)
	{
		this.photo = photo;
	}

	/**
	 * Sets new postID.
	 *
	 * @param postID New value of postID.
	 */
	public void setPostID(Long postID)
	{
		this.postID = postID;
	}

	/**
	 * Gets userID.
	 *
	 * @return Value of userID.
	 */
	public UserEntity getUserID()
	{
		return userID;
	}

	/**
	 * Sets new userID.
	 *
	 * @param userID New value of userID.
	 */
	public void setUserID(UserEntity userID)
	{
		this.userID = userID;
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
	 * Gets photo.
	 *
	 * @return Value of photo.
	 */
	public String getPhoto()
	{
		return photo;
	}

	/**
	 * Sets new postDate.
	 *
	 * @param postDate New value of postDate.
	 */
	public void setPostDate(Date postDate)
	{
		this.postDate = postDate;
	}
}