package by.zheynov.socnet.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.PostDao;
import by.zheynov.socnet.entity.PostEntity;

/**
 * PostDaoImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */
@Repository("postDao")
@Transactional
public class PostDaoImpl extends AbstractBaseDAO implements PostDao
{

	private static final String GET_ALL_POSTS_QUERY
					= "FROM PostEntity WHERE wall_owner_profile_id = :wallOwnerProfileID ORDER BY postDate DESC";

	/**
	 * Saves.
	 *
	 * @param postEntity the entity
	 *
	 * @return the entity
	 */
	@Override
	public PostEntity createPost(final PostEntity postEntity)
	{
		super.save(postEntity);
		return postEntity;
	}

	/**
	 * Updates.
	 *
	 * @param postEntity the entity
	 */
	@Override
	public void updatePost(final PostEntity postEntity)
	{
		super.udate(postEntity);
	}

	/**
	 * Deletes.
	 *
	 * @param postEntity the entity
	 */
	@Override
	public void deletePost(final PostEntity postEntity)
	{
		super.delete(postEntity);
	}

	/**
	 * Retrieves a list of PhotoEntity objects for wall owner.
	 *
	 * @param wallOwnerProfileID the id
	 *
	 * @return the List<PostEntity>
	 */
	@Override
	public List<PostEntity> getAllThePosts(final Long wallOwnerProfileID)
	{
		Query query = super.getCurrentSession().createQuery(GET_ALL_POSTS_QUERY);
		query.setParameter("wallOwnerProfileID", wallOwnerProfileID);

		return query.list();
	}

	/**
	 * Gets PostEntity from database.
	 *
	 * @param postId the id
	 *
	 * @return post entity
	 */
	@Override
	public PostEntity getById(final Long postId)
	{
		return (PostEntity) super.getById(PostEntity.class, postId);
	}
}