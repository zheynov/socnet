package by.zheynov.socnet;

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

import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * ProfileDaoTest class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testDaoApplicationContext.xml"})
@TestPropertySource("/DaoTestH2DB.properties")
@Transactional
@WebAppConfiguration
public class ProfileDaoTest
{
	private static final int LIST_SIZE = 1;
	@Autowired
	private ProfileDao profileDao;
	private ProfileEntity profileEntity;

	@Before
	public void profileCreation()
	{
		profileEntity = new ProfileEntity();
		profileEntity.setEmail("profile@test.test");
		profileDao.createProfile(profileEntity);
	}

	@Test
	public void createProfileDaoTest()
	{
		Assert.assertEquals(profileEntity.getEmail(), profileDao.getById(profileEntity.getId()).getEmail());
		Assert.assertEquals(profileEntity.getAge(), profileDao.getById(profileEntity.getId()).getAge());
	}

	@Test
	public void updateProfileDaoTest()
	{
		profileEntity.setEmail("changed@test.test");
		profileDao.updateProfile(profileEntity);

		Assert.assertEquals("changed@test.test", profileDao.getById(profileEntity.getId()).getEmail());
	}

	@Test
	public void deleteProfileDaoTest()
	{
		profileDao.deleteProfile(profileEntity);

		List<ProfileEntity> allTheProfiles = profileDao.getAllTheProfiles();

		Assert.assertEquals(0, allTheProfiles.size());
	}

	@Test
	public void getByIdProfileDaoTest()
	{
		Assert.assertEquals(profileEntity, profileDao.getById(profileEntity.getId()));
	}

	@Test
	public void getAllTheProfilesDaoTest()
	{
		List<ProfileEntity> profileEntityList = profileDao.getAllTheProfiles();

		Assert.assertNotNull(profileEntityList);
		Assert.assertEquals(profileEntity, profileEntityList.get(0));
		Assert.assertEquals(LIST_SIZE, profileEntityList.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void failUpdateTest() throws Exception {
		profileDao.updateProfile(null);
	}

	@After
	public void deleteProfile()
	{
		profileDao.deleteProfile(profileEntity);
	}


}