package by.zheynov.socnet.dao;

import java.util.List;

import by.zheynov.socnet.entity.PostEntity;

/**
 * Post Dao interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao
 */
public interface PostDao
{
	/**
	 * Saves.
	 *
	 * @param postEntity the entity
	 *
	 * @return the entity
	 */
	PostEntity createPost(PostEntity postEntity);

	/**
	 * Updates.
	 *
	 * @param postEntity the entity
	 */
	void updatePost(PostEntity postEntity);

	/**
	 * Deletes.
	 *
	 * @param postEntity the entity
	 */
	void deletePost(PostEntity postEntity);

	/**
	 * Retrieves a list of PhotoEntity objects.
	 *
	 * @param profileSenderID    the id
	 * @param wallOwnerProfileID the id
	 *
	 * @return the List<PostEntity>
	 */
	List<PostEntity> getAllThePosts(Long profileSenderID, Long wallOwnerProfileID);

	/**
	 * Gets PostEntity from database.
	 *
	 * @param postId the id
	 *
	 * @return post entity
	 */
	PostEntity getById(Long postId);
}