package by.zheynov.socnet;

import java.util.List;

import org.junit.Assert;
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

/**
 * FriendDaoTest class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Transactional
@WebAppConfiguration
public class FriendDaoTest
{
	@Autowired
	ProfileDao profileDao;

	@Autowired
	FriendDao friendDao;


	@Test
	public void createFriendDaoTest()
	{
		FriendEntity newProfileEntity = new FriendEntity();



		//List<FriendEntity> allTheProfiles = friendDao.getAllTheFriends();

		//Assert.assertEquals(newProfileEntity.getAge(), allTheProfiles.get(0).getAge());
	}
}