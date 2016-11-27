package by.zheynov.socnet;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * ProfileDaoTest.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Transactional
@Rollback()
public class ProfileDaoTest
{
	@Autowired
	ProfileDao profileDao;

	@Test
	public void createProfileDaoTest()
	{
		ProfileEntity newProfileEntity = new ProfileEntity();

		newProfileEntity.setEmail("profile@test.test");
		newProfileEntity.setAge(33);

		profileDao.createProfile(newProfileEntity);

		List<ProfileEntity> allTheProfiles = profileDao.getAllTheProfiles();

		Assert.assertEquals(newProfileEntity.getEmail(), allTheProfiles.get(0).getEmail());
		Assert.assertEquals(newProfileEntity.getAge(), allTheProfiles.get(0).getAge());
	}

}