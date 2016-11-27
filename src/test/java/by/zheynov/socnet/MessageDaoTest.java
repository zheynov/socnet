package by.zheynov.socnet;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
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
@Transactional
@WebAppConfiguration
public class MessageDaoTest
{
	@Autowired
	MessageDao messageDao;
	@Autowired
	ProfileDao profileDao;

	@Test
	public void createMessageDaoTest()
	{
		MessageEntity messageEntity = messageAndProfilesCreation();

		List<MessageEntity> allTheMessages = messageDao.getAllTheMessages(messageEntity.getProfileSenderEntity().getId(),
		                                                                  messageEntity.getProfileDestinationEntity().getId()
		);
		Assert.assertEquals(messageEntity.getText(), allTheMessages.get(0).getText());
	}

	@Test
	public void getByIdMessageDaoTest()
	{
		MessageEntity messageEntity = messageAndProfilesCreation();

		List<MessageEntity> allTheMessages = messageDao.getAllTheMessages(messageEntity.getProfileSenderEntity().getId(),
		                                                                  messageEntity.getProfileDestinationEntity().getId()
		);
		MessageEntity messageEntityForCompare = messageDao.getById(allTheMessages.get(0).getId());

		Assert.assertEquals(messageEntity, messageEntityForCompare);
	}

	private MessageEntity messageAndProfilesCreation()
	{
		ProfileEntity senderProfileEntity = new ProfileEntity();
		senderProfileEntity.setEmail("senderProfile@test.test");
		profileDao.createProfile(senderProfileEntity);

		ProfileEntity destinationProfileEntity = new ProfileEntity();
		destinationProfileEntity.setEmail("destinationProfile@test.test");
		profileDao.createProfile(senderProfileEntity);

		MessageEntity messageEntity = new MessageEntity();
		messageEntity.setProfileSenderEntity(senderProfileEntity);
		messageEntity.setProfileDestinationEntity(destinationProfileEntity);
		messageEntity.setMessageDate(new Date());
		messageEntity.setText("Test message");

		messageDao.createMessage(messageEntity);

		return messageEntity;
	}
}