package by.zheynov.socnet.dao;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.entity.MessageEntity;
import by.zheynov.socnet.entity.PostEntity;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * PostDaoTest class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testDaoApplicationContext.xml"})
@TestPropertySource("/DaoTestH2DB.properties")
@Transactional
@WebAppConfiguration
public class PostDaoTest
{
	private static final int  LIST_SIZE = 1;
	private static final Date postDate  = new Date();

	@Autowired
	PostDao    postDao;
	@Autowired
	ProfileDao profileDao;

	private ProfileEntity senderProfileEntity;
	private ProfileEntity wallOwnerProfileEntity;
	private PostEntity    postEntity;

	@Before
	public void messageAndProfilesCreation()
	{
		senderProfileEntity = new ProfileEntity();
		senderProfileEntity.setEmail("sender@test.test");

		wallOwnerProfileEntity = new ProfileEntity();
		wallOwnerProfileEntity.setEmail("wallowner@test.test");

		postEntity = new PostEntity();
		postEntity.setProfileSender(senderProfileEntity);
		postEntity.setWallOwnerProfile(wallOwnerProfileEntity);

		postEntity.setPhotoFileName("/photo/test.jsp");

		postEntity.setPostDate(postDate);
		postEntity.setText("test_text");

		profileDao.createProfile(senderProfileEntity);
		profileDao.createProfile(wallOwnerProfileEntity);
		postDao.createPost(postEntity);
	}

	@Test
	public void createPostDaoTest()
	{
		Assert.assertEquals(senderProfileEntity, postDao.getById(postEntity.getPostID()).getProfileSender());
		Assert.assertEquals(wallOwnerProfileEntity, postDao.getById(postEntity.getPostID()).getWallOwnerProfile());
		Assert.assertEquals(postEntity.getPhotoFileName(), postDao.getById(postEntity.getPostID()).getPhotoFileName());
		Assert.assertEquals(postEntity.getText(), postDao.getById(postEntity.getPostID()).getText());
		Assert.assertEquals(postEntity.getPostDate(), postDao.getById(postEntity.getPostID()).getPostDate());
	}

	@Test
	public void updatePostDaoTest()
	{
		postEntity.setText("newtext");
		postEntity.setPhotoFileName("newname");
		postDao.updatePost(postEntity);

		Assert.assertEquals(postEntity.getText(), postDao.getById(postEntity.getPostID()).getText());
		Assert.assertEquals(postEntity.getPhotoFileName(), postDao.getById(postEntity.getPostID()).getPhotoFileName());
	}

	@Test
	public void getPostByIdTest()
	{
		Assert.assertEquals(postEntity, postDao.getById(postEntity.getPostID()));
	}

	@Test
	public void getAllThePostsTest()
	{
		List<PostEntity> allTheDaoPosts = postDao.getAllThePosts(wallOwnerProfileEntity.getId());
		Assert.assertNotNull(allTheDaoPosts);
		Assert.assertEquals(postEntity, allTheDaoPosts.get(0));
		Assert.assertEquals(LIST_SIZE, allTheDaoPosts.size());
	}

	@Test
	public void deletePostDaoTest()
	{
		postDao.deletePost(postEntity);

		List<PostEntity> allTheDaoPosts = postDao.getAllThePosts(wallOwnerProfileEntity.getId());

		Assert.assertEquals(0, allTheDaoPosts.size());
	}

	@Test()
	public void failsTest()
	{
		Assert.assertNotEquals(new Date(), postDao.getById(postEntity.getPostID()).getPostDate());
		Assert.assertNotEquals("testNotEquualsTest", postDao.getById(postEntity.getPostID()).getText());
		Assert.assertNotEquals(wallOwnerProfileEntity, postDao.getById(postEntity.getPostID()).getProfileSender());
		Assert.assertNotEquals(senderProfileEntity, postDao.getById(postEntity.getPostID()).getWallOwnerProfile());
		Assert.assertNotEquals("/photo/incorrect.jsp", postDao.getById(postEntity.getPostID()).getPhotoFileName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void failGetByIdTest() throws Exception
	{
		postDao.getById(null);
	}

	@After
	public void deleteUSerAndProfile()
	{
		profileDao.deleteProfile(senderProfileEntity);
		profileDao.deleteProfile(wallOwnerProfileEntity);
		postDao.deletePost(postEntity);
	}

}