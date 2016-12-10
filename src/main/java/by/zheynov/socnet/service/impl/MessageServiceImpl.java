package by.zheynov.socnet.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.MessageDao;
import by.zheynov.socnet.entity.MessageEntity;
import by.zheynov.socnet.service.MessageService;

/**
 * MessageServiceImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service.impl
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService
{
	private static final Logger LOGGER = Logger.getLogger(MessageServiceImpl.class);

	@Autowired
	private MessageDao messageDao;

	/**
	 * Saves.
	 *
	 * @param messageEntity the entity
	 *
	 * @return the entity
	 */
	@Transactional
	public MessageEntity createMessage(final MessageEntity messageEntity)
	{
		LOGGER.info("Created message from profileID " + messageEntity.getProfileSenderEntity().getId() + " to prfileID " +
						            messageEntity.getProfileDestinationEntity().getId());
		return messageDao.createMessage(messageEntity);

	}

	/**
	 * Finds By messageId.
	 *
	 * @param messageId the id
	 *
	 * @return the entity
	 */
	@Transactional(readOnly = true)
	public MessageEntity getById(final Long messageId)
	{
		LOGGER.info("Got message with ID " + messageId);

		return messageDao.getById(messageId);
	}

	/**
	 * Retrieves a list of MessageEntity objects.
	 *
	 * @param senderID      the id
	 * @param destinationID the id
	 *
	 * @return the List<MessageEntity>
	 */
	@Transactional(readOnly = true)
	public List<MessageEntity> getAllTheMessages(final Long senderID, final Long destinationID)
	{
		LOGGER.info("Got list of messages from profileID  " + senderID + " to profileID " + destinationID);
		return messageDao.getAllTheMessages(senderID, destinationID);
	}

}