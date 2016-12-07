package by.zheynov.socnet.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import by.zheynov.socnet.dto.PostDTO;
import by.zheynov.socnet.entity.PostEntity;
import by.zheynov.socnet.facade.PostFacade;
import by.zheynov.socnet.service.PostService;

/**
 * PostFacadeImpl claass.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade.impl
 */
@Component("postFacade")

public class PostFacadeImpl implements PostFacade
{
	@Autowired
	PostService postService;

	@Autowired
	ConversionService conversionService;

	/**
	 * Saves.
	 *
	 * @param postDTO the dto
	 * @param file    the file
	 */
	@Override
	public void createPost(final PostDTO postDTO, final MultipartFile file)
	{
		postService.createPost(conversionService.convert(postDTO, PostEntity.class), file);
	}

	/**
	 * Updates.
	 *
	 * @param postDTO the dto
	 */
	@Override
	public void updatePost(final PostDTO postDTO)
	{
		postService.updatePost(conversionService.convert(postDTO, PostEntity.class));
	}

	/**
	 * Deletes.
	 *
	 * @param postDTO the dto
	 */
	@Override
	public void deletePost(final PostDTO postDTO)
	{
		postService.deletePost(conversionService.convert(postDTO, PostEntity.class));

	}

	/**
	 * Retrieves a list of PostDTO objects for wall owner.
	 *
	 * @param wallOwnerProfileID the id
	 *
	 * @return the List<PostDTO>
	 */
	@Override
	public List<PostDTO> getAllThePosts(final Long wallOwnerProfileID)
	{
		List<PostDTO> allThePostsDTO = new ArrayList<>();

		postService.getAllThePosts(wallOwnerProfileID)
		           .forEach(element -> allThePostsDTO.add(conversionService.convert(element, PostDTO.class)));

		return allThePostsDTO;
	}

	/**
	 * Gets PostDTO from database.
	 *
	 * @param postId the id
	 *
	 * @return post dto
	 */
	@Override
	public PostDTO getById(final Long postId)
	{
		return conversionService.convert(postService.getById(postId), PostDTO.class);
	}
}