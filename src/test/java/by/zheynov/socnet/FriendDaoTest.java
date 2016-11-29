package by.zheynov.socnet;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.FriendDao;
import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.FriendEntity;
import by.zheynov.socnet.entity.FriendRequestApprovalStatus;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * FriendDaoTest class.
 * Don't forget to use StartTestDaoScript.sql before running.
 * These tests use MySQL DB.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testFriendDaoMySQLAppCOntext.xml"})
@Transactional
@WebAppConfiguration
public class FriendDaoTest
{
	private static final int LIST_SIZE       = 1;
	private static final int EMPTY_LIST_SIZE = 0;

	@Autowired
	ProfileDao profileDao;
	@Autowired
	FriendDao  friendDao;
	private ProfileEntity currentProfileEntity;
	private ProfileEntity friendProfileEntity;

	@Before
	public void friendAndProfilesCreation()
	{
		currentProfileEntity = new ProfileEntity();
		friendProfileEntity = new ProfileEntity();

		profileDao.createProfile(currentProfileEntity);
		profileDao.createProfile(friendProfileEntity);

		friendDao.addFriend(currentProfileEntity, friendProfileEntity);
	}

	@Test
	public void getAllTheFriendsForFriendUserTest()
	{
		List<FriendEntity> friendEntities = friendDao.getAllTheFriendsForFriendUser(friendProfileEntity.getId());

		Assert.assertNotNull(friendEntities);
		Assert.assertEquals(LIST_SIZE, friendEntities.size());
	}

	@Test
	public void getAllTheFriendsTest()
	{
		List<FriendEntity> friendEntities = friendDao.getAllTheFriends(currentProfileEntity.getId());

		Assert.assertNotNull(friendEntities);
		Assert.assertEquals(LIST_SIZE, friendEntities.size());
	}

	@Test
	public void addFriendTest()
	{
		List<FriendEntity> friendEntities = friendDao.getAllTheFriends(currentProfileEntity.getId());

		Assert.assertEquals(currentProfileEntity, friendEntities.get(0).getCurrentProfileEntity());
		Assert.assertEquals(friendProfileEntity, friendEntities.get(0).getFriendProfileEntity());
		Assert.assertNotNull(friendEntities);
		Assert.assertEquals(LIST_SIZE, friendEntities.size());
	}

	@Test
	public void getAllThePendingRequestsTest()
	{
		List<FriendEntity> friendEntities = friendDao.getAllThePendingRequests();

		Assert.assertEquals(FriendRequestApprovalStatus.PENDING_REQUEST, friendEntities.get(0).getStatus());
		Assert.assertNotNull(friendEntities);
		Assert.assertEquals(LIST_SIZE, friendEntities.size());
	}

	@Test
	public void deleteFriendTest()
	{
		friendDao.deleteFriend(currentProfileEntity.getId(), friendProfileEntity.getId());

		List<FriendEntity> friendEntities = friendDao.getAllThePendingRequests();

		Assert.assertNotNull(friendEntities);
		Assert.assertEquals(EMPTY_LIST_SIZE, friendEntities.size());
	}

	@Test
	public void approveFriendRequestTest()
	{
		friendDao.approveFriendRequest(currentProfileEntity.getId(), friendProfileEntity.getId());


		List<FriendEntity> friendEntities = friendDao.getAllTheFriends(currentProfileEntity.getId());

		Assert.assertEquals(FriendRequestApprovalStatus.APPROVED_REQUEST, friendEntities.get(0).getStatus());
		Assert.assertNotNull(friendEntities);
		Assert.assertEquals(LIST_SIZE, friendEntities.size());
	}

	@After
	public void deleteProfiles()
	{
		profileDao.deleteProfile(currentProfileEntity);
		profileDao.deleteProfile(friendProfileEntity);
	}
}