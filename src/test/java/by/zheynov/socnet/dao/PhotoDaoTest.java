package by.zheynov.socnet.dao;

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

import by.zheynov.socnet.entity.PhotoEntity;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * PhotoDaoTest class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testDaoApplicationContext.xml"})
@TestPropertySource("/DaoTestH2DB.properties")
@Transactional
@WebAppConfiguration
public class PhotoDaoTest
{
	private static final int LIST_SIZE = 1;
	@Autowired
	PhotoDao   photoDao;
	@Autowired
	ProfileDao profileDao;

	private ProfileEntity profileEntity;
	private PhotoEntity   photoEntity;

	@Before
	public void messageAndProfilesCreation()
	{
		profileEntity = new ProfileEntity();
		profileEntity.setEmail("sender@test.test");

		photoEntity = new PhotoEntity();
		photoEntity.setProfileEntity(profileEntity);
		photoEntity.setPhotoFileName("/photo/test.jsp");

		profileDao.createProfile(profileEntity);
		photoDao.createPhoto(photoEntity);
	}

	@Test
	public void createPhotoDaoTest()
	{
		Assert.assertEquals(profileEntity, photoDao.getById(photoEntity.getId()).getProfileEntity());
		Assert.assertEquals(photoEntity.getPhotoFileName(), photoDao.getById(photoEntity.getId()).getPhotoFileName());
	}

	@Test
	public void getPhototByIdTest()
	{
		Assert.assertEquals(photoEntity, photoDao.getById(photoEntity.getId()));
	}

	@Test
	public void getAllThePhotosTest()
	{
		List<PhotoEntity> allTheDaoPhotos = photoDao.getAllThePhotos(profileEntity.getId());
		Assert.assertNotNull(allTheDaoPhotos);
		Assert.assertEquals(photoEntity, allTheDaoPhotos.get(0));
		Assert.assertEquals(LIST_SIZE, allTheDaoPhotos.size());
	}

	@Test
	public void deletePhotoDaoTest()
	{
		photoDao.deletePhoto(photoEntity);
		List<PhotoEntity> allTheDaoPhotos = photoDao.getAllThePhotos(profileEntity.getId());

		Assert.assertEquals(0, allTheDaoPhotos.size());
	}

	@Test()
	public void failsTest()
	{
		Assert.assertNotEquals(new ProfileEntity(), photoDao.getById(photoEntity.getId()).getProfileEntity());
		Assert.assertNotEquals("/photo/incorrect.jsp", photoDao.getById(photoEntity.getId()).getPhotoFileName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void failGetByIdTest() throws Exception
	{
		photoDao.getById(null);
	}

	@After
	public void deleteUSerAndProfile()
	{
		profileDao.deleteProfile(profileEntity);
		photoDao.deletePhoto(photoEntity);
	}

}