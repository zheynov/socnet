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
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@Transactional
@WebAppConfiguration
public class UserDaoTest
{
	@Autowired
	ProfileDao profileDao;
	@Autowired
	UserDao    userDao;

	@Test
	public void createUserDaoTest()
	{
		ProfileEntity profileEntity = new ProfileEntity();
		UserEntity userEntity = userAndProfileCreation(profileEntity);

		List<UserEntity> allTheUsers = userDao.getAllTheUsers();

		Assert.assertEquals(profileEntity, allTheUsers.get(0).getProfileEntity());
		Assert.assertEquals(userEntity.getRoleEntity(), allTheUsers.get(0).getRoleEntity());
		Assert.assertEquals(userEntity.getUsername(), allTheUsers.get(0).getUsername());
	}

	@Test
	public void updateUserDaoTest()
	{
		ProfileEntity newProfileEntity = new ProfileEntity();
		UserEntity userEntity = userAndProfileCreation(newProfileEntity);

		userEntity.setEmail("changed@email.test");

		List<UserEntity> allTheUsers = userDao.getAllTheUsers();

		Assert.assertEquals("changed@email.test", allTheUsers.get(0).getEmail());
	}

	@Test
	public void getUserByUsernameTest()
	{
		ProfileEntity newProfileEntity = new ProfileEntity();
		UserEntity userEntity = userAndProfileCreation(newProfileEntity);

		Assert.assertEquals("testUserName", userDao.getUserByUsername("testUserName").getUsername());
	}


	private UserEntity userAndProfileCreation(ProfileEntity profileEntity)
	{
		profileEntity.setEmail("test@test.test");

		UserEntity newUserEntity = new UserEntity();

		newUserEntity.setProfileEntity(profileEntity);
		newUserEntity.setEmail("test@test.test");
		newUserEntity.setEnabled(true);

		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setId(2L);
		roleEntity.setRole("ROLE_USER");
		newUserEntity.setRoleEntity(roleEntity);

		newUserEntity.setUsername("testUserName");
		newUserEntity.setPassword("testUserPassword");

		profileDao.createProfile(profileEntity);
		userDao.createUser(newUserEntity);

		return newUserEntity;
	}

}