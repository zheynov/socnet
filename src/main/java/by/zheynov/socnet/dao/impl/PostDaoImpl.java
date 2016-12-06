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
					= "FROM PostEntity WHERE profile_sender_id = :profileSenderID AND wall_owner_profile_id = :wallOwnerProfileID";

	@Override
	public PostEntity createPost(final PostEntity postEntity)
	{
		super.save(postEntity);
		return postEntity;
	}

	@Override
	public void updatePost(final PostEntity postEntity)
	{
		super.udate(postEntity);
	}

	@Override
	public void deletePost(final PostEntity postEntity)
	{
		super.delete(postEntity);
	}

	@Override
	public List<PostEntity> getAllThePosts(final Long profileSenderID, final Long wallOwnerProfileID)
	{
		Query query = super.getCurrentSession().createQuery(GET_ALL_POSTS_QUERY);
		query.setParameter("profileSenderID", profileSenderID);
		query.setParameter("wallOwnerProfileID", wallOwnerProfileID);

		return query.list();
	}

	@Override
	public PostEntity getById(final Long postId)
	{
		return (PostEntity) super.getById(PostEntity.class, postId);
	}
}