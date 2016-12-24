package by.zheynov.socnet.facade;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import by.zheynov.socnet.dto.PostDTO;

/**
 * PostFacade interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade
 */
public interface PostFacade
{
	/**
	 * Saves.
	 *
	 * @param file    the file
	 * @param postDTO the dto
	 */
	void createPost(PostDTO postDTO, MultipartFile file);

	/**
	 * Updates.
	 *
	 * @param postDTO the dto
	 */
	void updatePost(PostDTO postDTO);

	/**
	 * Deletes.
	 *
	 * @param postDTO the dto
	 */
	void deletePost(PostDTO postDTO);

	/**
	 * Retrieves a list of PostDTO objects for wall owner.
	 *
	 * @param wallOwnerProfileID the id
	 *
	 * @return the List<PostDTO>
	 */
	List<PostDTO> getAllThePosts(Long wallOwnerProfileID);

	/**
	 * Gets PostDTO from database.
	 *
	 * @param postId the id
	 *
	 * @return post dto
	 */
	PostDTO getById(Long postId);
}