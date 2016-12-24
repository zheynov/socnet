package by.zheynov.socnet.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import by.zheynov.socnet.entity.MessageEntity;

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
public class MessageServiceTest
{
	private static final long senderProfileId      = 1L;
	private static final long destinationProfileId = 2L;
	private static final Date today                = new Date();

	private MessageService      messageService;
	private MessageEntity       messageEntity;
	private List<MessageEntity> messageEntityList;

	@Before
	public void messageAndProfilesCreation()
	{
		messageService = mock(MessageService.class);
		messageEntity = mock(MessageEntity.class);

		messageEntity.setText("this is a test message!!");
		messageEntity.setMessageDate(today);

		messageEntityList = new ArrayList<>();
		messageEntityList.add(messageEntity);

		// внести даннве в объект

		given(messageService.createMessage(messageEntity)).willReturn(messageEntity); // createMessageServiceTest()
		given(messageService.getById(anyLong())).willReturn(messageEntity); // getMessageByIdServiceTest()
		when(messageService.getAllTheMessages(anyLong(), anyLong())).thenReturn(messageEntityList); // getAllTheMessagesServiceTest()
	}

	@Test()
	public void createMessageServiceTest()
	{
		MessageEntity newMessageEntity = messageService.createMessage(messageEntity);
		Assert.assertEquals(newMessageEntity, messageEntity);
	}

	@Test()
	public void getMessageByIdServiceTest()
	{
		Assert.assertEquals(messageEntity, messageService.getById(messageEntity.getId()));
		Assert.assertEquals(messageEntity.getText(), messageService.getById(messageEntity.getId()).getText());
		Assert.assertEquals(messageEntity.getMessageDate(), messageService.getById(messageEntity.getId()).getMessageDate());
	}

	@Test()
	public void getAllTheMessagesServiceTest()
	{
		Assert.assertEquals(messageEntity, messageService.getAllTheMessages(senderProfileId, destinationProfileId).get(0));
		Assert.assertNotNull(messageService.getAllTheMessages(senderProfileId, destinationProfileId));
	}

	@Test()
	public void deleteMessagesServiceTest()
	{

	}

}