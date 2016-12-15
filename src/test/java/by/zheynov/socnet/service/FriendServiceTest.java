package by.zheynov.socnet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import by.zheynov.socnet.entity.FriendEntity;
import by.zheynov.socnet.entity.FriendRequestApprovalStatus;
import by.zheynov.socnet.entity.MessageEntity;
import by.zheynov.socnet.entity.ProfileEntity;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * MessageServiceTest class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service
 */
@RunWith(MockitoJUnitRunner.class)
public class FriendServiceTest
{
	private FriendService      friendService;
	private FriendEntity       friendEntity;
	private List<FriendEntity> friendEntityList;
	private ProfileEntity      sender;
	private ProfileEntity      friend;

	@Before
	public void messageAndProfilesCreation()
	{
		sender = mock(ProfileEntity.class);
		friend = mock(ProfileEntity.class);
		friendService = mock(FriendService.class);
		friendEntity = mock(FriendEntity.class);

		friendEntity.setCurrentProfileEntity(sender);
		friendEntity.setFriendProfileEntity(friend);
		friendEntity.setStatus(FriendRequestApprovalStatus.PENDING_REQUEST);

		friendEntityList = new ArrayList<>();
		friendEntityList.add(friendEntity);

		// getAllThePendingFriendRequestForUserTest()
		given(friendService.getAllThePendingFriendRequestForUser(sender.getId())).willReturn(friendEntityList);
		// getAllTheMessagesServiceTest()
		when(friendService.getAllThePendingRequests()).thenReturn(friendEntityList);
	}

	@Test()
	public void getAllThePendingFriendRequestForUserTest()
	{
		List<FriendEntity> newFriendEntityList = friendService.getAllThePendingFriendRequestForUser(sender.getId());
		Assert.assertEquals(newFriendEntityList, friendEntityList);
		Assert.assertEquals(friendEntity, friendEntityList.get(0));
	}

	@Test()
	public void getAllThePendingRequestsTest()
	{
		List<FriendEntity> newFriendEntityList = friendService.getAllThePendingRequests();
		FriendEntity gotFriendEntity = newFriendEntityList.get(0);

		Assert.assertEquals(newFriendEntityList, friendEntityList);
		Assert.assertEquals(friendEntity, gotFriendEntity);
		Assert.assertEquals(gotFriendEntity.getCurrentProfileEntity(), sender);
		Assert.assertEquals(gotFriendEntity.getFriendProfileEntity(), friend);
		Assert.assertEquals(gotFriendEntity.getStatus(), FriendRequestApprovalStatus.PENDING_REQUEST);
	}

}