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
import by.zheynov.socnet.dao.UserDao;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.RoleEntity;
import by.zheynov.socnet.entity.UserEntity;

/**
 * UserDaoTest class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testDaoApplicationContext.xml"})
@TestPropertySource("/DaoTestH2DB.properties")
@Transactional
@WebAppConfiguration
public class UserDaoTest
{
	private static final int LIST_SIZE = 1;

	@Autowired
	private ProfileDao profileDao;
	@Autowired
	private UserDao    userDao;

	private UserEntity    userEntity;
	private RoleEntity    roleEntity;
	private ProfileEntity profileEntity;

	@Before
	public void userAndProfileCreation()
	{
		profileEntity = new ProfileEntity();
		profileEntity.setEmail("test@test.test");

		userEntity = new UserEntity();

		userEntity.setProfileEntity(profileEntity);
		userEntity.setEmail("test@test.test");
		userEntity.setEnabled(true);

		roleEntity = new RoleEntity();
		roleEntity.setId(2L);
		roleEntity.setRole("ROLE_USER");
		userEntity.setRoleEntity(roleEntity);

		userEntity.setUsername("testUserName");
		userEntity.setPassword("testUserPassword");

		profileDao.createProfile(profileEntity);
		userDao.createUser(userEntity);
	}

	@Test
	public void createUserDaoTest()
	{
		Assert.assertEquals(profileEntity, userDao.getById(userEntity.getId()).getProfileEntity());
		Assert.assertEquals(roleEntity, userDao.getById(userEntity.getId()).getRoleEntity());
		Assert.assertEquals(userEntity.getEmail(), userDao.getById(userEntity.getId()).getEmail());
		Assert.assertEquals(userEntity.getUsername(), userDao.getById(userEntity.getId()).getUsername());
		Assert.assertEquals(userEntity.getPassword(), userDao.getById(userEntity.getId()).getPassword());
	}

	@Test
	public void updateUserDaoTest()
	{
		userEntity.setEmail("changed@email.test");
		userDao.updateUser(userEntity);
		Assert.assertEquals(userEntity.getEmail(), userDao.getById(userEntity.getId()).getEmail());
	}

	@Test
	public void getUserByUsernameTest()
	{
		Assert.assertEquals(userEntity.getUsername(), userDao.getUserByUsername("testUserName").getUsername());
	}

	@Test
	public void getUserByIdTest()
	{
		Assert.assertEquals(userEntity, userDao.getById(userEntity.getId()));
	}

	@Test
	public void getAllTheUsersTest()
	{
		List<UserEntity> allTheDaoUsers = userDao.getAllTheUsers();
		Assert.assertNotNull(allTheDaoUsers);
		Assert.assertEquals(userEntity, allTheDaoUsers.get(0));
		Assert.assertEquals(LIST_SIZE, allTheDaoUsers.size());
	}

	@After
	public void deleteUSerAndProfile()
	{
		profileDao.deleteProfile(profileEntity);
		userDao.deleteUser(userEntity);
	}
}