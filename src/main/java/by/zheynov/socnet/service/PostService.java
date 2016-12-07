package by.zheynov.socnet.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import by.zheynov.socnet.entity.PostEntity;

/**
 * PostService interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service
 */
public interface PostService
{
	/**
	 * Saves.
	 *
	 * @param postEntity the entity
	 * @param photo      the file
	 *
	 * @return the entity
	 */
	PostEntity createPost(PostEntity postEntity, MultipartFile photo);

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
	 * Retrieves a list of PhotoEntity objects for wall owner.
	 *
	 * @param wallOwnerProfileID the id
	 *
	 * @return the List<PostEntity>
	 */
	List<PostEntity> getAllThePosts(Long wallOwnerProfileID);

	/**
	 * Gets PostEntity from database.
	 *
	 * @param postId the id
	 *
	 * @return post entity
	 */
	PostEntity getById(Long postId);
}