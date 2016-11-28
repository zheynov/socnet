package by.zheynov.socnet;

import java.util.Date;
import java.util.List;

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

import by.zheynov.socnet.dao.MessageDao;
import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.MessageEntity;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * MessageDaoTest class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
@TestPropertySource("/dbh2.properties")
@Transactional
@WebAppConfiguration
public class MessageDaoTest
{
	@Autowired
	MessageDao messageDao;
	@Autowired
	ProfileDao profileDao;

	private ProfileEntity senderProfileEntity;
	private ProfileEntity destinationProfileEntity;
	private MessageEntity messageEntity;

	@Before
	public void messageAndProfilesCreation()
	{
		senderProfileEntity = new ProfileEntity();
		senderProfileEntity.setEmail("senderProfile@test.test");
		profileDao.createProfile(senderProfileEntity);

		destinationProfileEntity = new ProfileEntity();
		destinationProfileEntity.setEmail("destinationProfile@test.test");
		profileDao.createProfile(senderProfileEntity);

		messageEntity = new MessageEntity();
		messageEntity.setProfileSenderEntity(senderProfileEntity);
		messageEntity.setProfileDestinationEntity(destinationProfileEntity);
		messageEntity.setMessageDate(new Date());
		messageEntity.setText("Test message");

		messageDao.createMessage(messageEntity);
	}

	@Test
	public void createMessageDaoTest()
	{
		Assert.assertEquals(messageEntity.getText(), messageDao.getById(messageEntity.getId()).getText());
	}

	@Test
	public void getByIdMessageDaoTest()
	{
		MessageEntity messageEntityForCompare = messageDao.getById(messageEntity.getId());

		Assert.assertEquals(messageEntity, messageEntityForCompare);
	}

	@Test
	public void getAllTheMessagesDaoTest()
	{
		List<MessageEntity> messageEntities = messageDao.getAllTheMessages(senderProfileEntity.getId(),
		                                                                   destinationProfileEntity.getId()
		);

		Assert.assertNotNull(messageEntities);
		Assert.assertEquals(messageEntity, messageEntities.get(0));
	}

}