package by.zheynov.socnet.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import by.zheynov.socnet.dao.PostDao;
import by.zheynov.socnet.entity.PostEntity;
import by.zheynov.socnet.service.PostService;
import by.zheynov.socnet.utils.PhotoCreationOnHDD;

/**
 * PostServiceImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service.impl
 */
@Service("postService")
public class PostServiceImpl implements PostService
{
	private static final Logger LOGGER = Logger.getLogger(PostServiceImpl.class);

	@Autowired
	private PostDao            postDao;
	@Autowired
	private PhotoCreationOnHDD photoCreationOnHDD;

	/**
	 * Saves.
	 *
	 * @param postEntity the entity
	 * @param photo      the photo
	 *
	 * @return the entity
	 */
	@Transactional
	public PostEntity createPost(final PostEntity postEntity, final MultipartFile photo)
	{
		if (photo.getSize() > 0)
		{
			UUID namePicture = photoCreationOnHDD.createPhotoOnHDD(photo);
			postEntity.setPhotoFileName("photo/" + namePicture + ".jpg");
		}
		LOGGER.info("Added post for profileID " + postEntity.getWallOwnerProfile().getId());
		return postDao.createPost(postEntity);
	}

	/**
	 * Updates.
	 *
	 * @param postEntity the entity
	 */
	@Transactional
	public void updatePost(final PostEntity postEntity)
	{
		LOGGER.info("Updated post with ID " + postEntity.getPostID());
		postDao.updatePost(postEntity);
	}

	/**
	 * Deletes.
	 *
	 * @param postEntity the entity
	 */
	@Transactional
	public void deletePost(final PostEntity postEntity)
	{
		LOGGER.info("Deleted post with ID " + postEntity.getPostID());
		postDao.deletePost(postEntity);
	}

	/**
	 * Retrieves a list of PhotoEntity objects for wall owner.
	 *
	 * @param wallOwnerProfileID the id
	 *
	 * @return the List<PostEntity>
	 */
	@Transactional(readOnly = true)
	public List<PostEntity> getAllThePosts(final Long wallOwnerProfileID)
	{
		LOGGER.info("Got list of posts for profileID " + wallOwnerProfileID);
		return postDao.getAllThePosts(wallOwnerProfileID);
	}

	/**
	 * Gets PostEntity from database.
	 *
	 * @param postId the id
	 *
	 * @return post entity
	 */
	@Transactional(readOnly = true)
	public PostEntity getById(final Long postId)
	{
		LOGGER.info("Got posts with ID " + postId);
		return postDao.getById(postId);
	}
}