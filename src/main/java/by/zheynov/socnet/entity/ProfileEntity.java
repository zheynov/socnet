package by.zheynov.socnet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Profile Entity class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.entity
 */
@Entity
@Table(name = "profile")
public class ProfileEntity implements Serializable
{
	private static final int TABLE_COLUMN_MAX_LENGTH = 64;

	// OneToOne with UserEntity
	@OneToOne(mappedBy = "profileEntity", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private UserEntity userEntity;

	// OneToOne with PhotoEntity
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profileEntity")
	private Set<PhotoEntity> photos;

	// OneToMany with FriendEntity
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "currentProfileEntity")
	private Set<FriendEntity> currentProfileFriends = new HashSet<FriendEntity>();

	// OneToMany with FriendEntity
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "friendProfileEntity")
	private Set<FriendEntity> friendProfileFriends = new HashSet<FriendEntity>();

	// OneToMany with MessageEntity
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profileSenderEntity")
	private Set<MessageEntity> senderMessages = new HashSet<MessageEntity>();

	// OneToMany with MessageEntity
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profileDestinationEntity")
	private Set<MessageEntity> destinationMessages = new HashSet<MessageEntity>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profileSender")
	private List<PostEntity> sentPostsFromSender;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wallOwnerProfile")
	private List<PostEntity> wallOwnerPosts;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstname", length = TABLE_COLUMN_MAX_LENGTH)
	private String firstname;

	@Column(name = "lastname", length = TABLE_COLUMN_MAX_LENGTH)
	private String lastname;

	@Column(name = "email", length = TABLE_COLUMN_MAX_LENGTH)
	private String email;

	@Column(name = "birthDate", length = TABLE_COLUMN_MAX_LENGTH)
	private Date birthDate;

	@Column(name = "age", length = TABLE_COLUMN_MAX_LENGTH)
	private Integer age;

	@Column(name = "sex", length = TABLE_COLUMN_MAX_LENGTH)
	private String sex;

	@Column(name = "city", length = TABLE_COLUMN_MAX_LENGTH)
	private String city;

	@Column(name = "phoneNumber", length = TABLE_COLUMN_MAX_LENGTH)
	private String phoneNumber;

	/**
	 * Constructor for ProfileEntity.
	 */
	public ProfileEntity()
	{
	}

	/**
	 * Gets sex.
	 *
	 * @return Value of sex.
	 */
	public String getSex()
	{
		return sex;
	}

	/**
	 * Sets new sex.
	 *
	 * @param sex New value of sex.
	 */
	public void setSex(final String sex)
	{
		this.sex = sex;
	}

	/**
	 * Gets firstname.
	 *
	 * @return Value of firstname.
	 */
	public String getFirstname()
	{
		return firstname;
	}

	/**
	 * Sets new age.
	 *
	 * @param age New value of age.
	 */
	public void setAge(final Integer age)
	{
		this.age = age;
	}

	/**
	 * Sets new phoneNumber.
	 *
	 * @param phoneNumber New value of phoneNumber.
	 */
	public void setPhoneNumber(final String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets phoneNumber.
	 *
	 * @return Value of phoneNumber.
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * Sets new email.
	 *
	 * @param email New value of email.
	 */
	public void setEmail(final String email)
	{
		this.email = email;
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
	 * Gets age.
	 *
	 * @return Value of age.
	 */
	public Integer getAge()
	{
		return age;
	}

	/**
	 * Sets new firstname.
	 *
	 * @param firstname New value of firstname.
	 */
	public void setFirstname(final String firstname)
	{
		this.firstname = firstname;
	}

	/**
	 * Sets new birthDate.
	 *
	 * @param birthDate New value of birthDate.
	 */
	public void setBirthDate(final Date birthDate)
	{
		this.birthDate = birthDate;
	}

	/**
	 * Gets birthDate.
	 *
	 * @return Value of birthDate.
	 */
	public Date getBirthDate()
	{
		return birthDate;
	}

	/**
	 * Gets city.
	 *
	 * @return Value of city.
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * Gets lastname.
	 *
	 * @return Value of lastname.
	 */
	public String getLastname()
	{
		return lastname;
	}

	/**
	 * Sets new lastname.
	 *
	 * @param lastname New value of lastname.
	 */
	public void setLastname(final String lastname)
	{
		this.lastname = lastname;
	}

	/**
	 * Sets new city.
	 *
	 * @param city New value of city.
	 */
	public void setCity(final String city)
	{
		this.city = city;
	}

	/**
	 * Gets email.
	 *
	 * @return Value of email.
	 */
	public String getEmail()
	{
		return email;
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
	 * Sets new userEntity.
	 *
	 * @param userEntity New value of userEntity.
	 */
	public void setUserEntity(final UserEntity userEntity)
	{
		this.userEntity = userEntity;
	}

	/**
	 * Gets userEntity.
	 *
	 * @return Value of userEntity.
	 */
	public UserEntity getUserEntity()
	{
		return userEntity;
	}

	/**
	 * Sets new senderMessages.
	 *
	 * @param senderMessages New value of senderMessages.
	 */
	public void setSenderMessages(final Set<MessageEntity> senderMessages)
	{
		this.senderMessages = senderMessages;
	}

	/**
	 * Gets senderMessages.
	 *
	 * @return Value of senderMessages.
	 */
	public Set<MessageEntity> getSenderMessages()
	{
		return senderMessages;
	}

	/**
	 * Gets destinationMessages.
	 *
	 * @return Value of destinationMessages.
	 */
	public Set<MessageEntity> getDestinationMessages()
	{
		return destinationMessages;
	}

	/**
	 * Sets new destinationMessages.
	 *
	 * @param destinationMessages New value of destinationMessages.
	 */
	public void setDestinationMessages(final Set<MessageEntity> destinationMessages)
	{
		this.destinationMessages = destinationMessages;
	}

	/**
	 * Sets new friendProfileFriends.
	 *
	 * @param friendProfileFriends New value of friendProfileFriends.
	 */
	public void setFriendProfileFriends(final Set<FriendEntity> friendProfileFriends)
	{
		this.friendProfileFriends = friendProfileFriends;
	}

	/**
	 * Gets currentProfileFriends.
	 *
	 * @return Value of currentProfileFriends.
	 */
	public Set<FriendEntity> getCurrentProfileFriends()
	{
		return currentProfileFriends;
	}

	/**
	 * Sets new currentProfileFriends.
	 *
	 * @param currentProfileFriends New value of currentProfileFriends.
	 */
	public void setCurrentProfileFriends(final Set<FriendEntity> currentProfileFriends)
	{
		this.currentProfileFriends = currentProfileFriends;
	}

	/**
	 * Gets friendProfileFriends.
	 *
	 * @return Value of friendProfileFriends.
	 */
	public Set<FriendEntity> getFriendProfileFriends()
	{
		return friendProfileFriends;
	}

	/**
	 * Sets new photos.
	 *
	 * @param photos New value of photos.
	 */
	public void setPhotos(final Set<PhotoEntity> photos)
	{
		this.photos = photos;
	}

	/**
	 * Gets photos.
	 *
	 * @return Value of photos.
	 */
	public Set<PhotoEntity> getPhotos()
	{
		return photos;
	}

	/**
	 * Sets new sentPostsFromSender.
	 *
	 * @param sentPostsFromSender New value of sentPostsFromSender.
	 */
	public void setSentPostsFromSender(final List<PostEntity> sentPostsFromSender)
	{
		this.sentPostsFromSender = sentPostsFromSender;
	}

	/**
	 * Gets sentPostsFromSender.
	 *
	 * @return Value of sentPostsFromSender.
	 */
	public List<PostEntity> getSentPostsFromSender()
	{
		return sentPostsFromSender;
	}

	/**
	 * Sets new wallOwnerPosts.
	 *
	 * @param wallOwnerPosts New value of wallOwnerPosts.
	 */
	public void setWallOwnerPosts(final List<PostEntity> wallOwnerPosts)
	{
		this.wallOwnerPosts = wallOwnerPosts;
	}

	/**
	 * Gets wallOwnerPosts.
	 *
	 * @return Value of wallOwnerPosts.
	 */
	public List<PostEntity> getWallOwnerPosts()
	{
		return wallOwnerPosts;
	}

}