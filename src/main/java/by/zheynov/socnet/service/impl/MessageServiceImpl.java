package by.zheynov.socnet.service.impl;

import java.util.List;

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
public class MessageServiceImpl implements MessageService
{
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
		return messageDao.createMessage(messageEntity);
	}

	/**
	 * Finds By messageId.
	 *
	 * @param messageId the id
	 *
	 * @return the entity
	 */
	@Transactional
	public MessageEntity getById(final Long messageId)
	{
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
	@Transactional
	public List<MessageEntity> getAllTheMessages(final Long senderID, final Long destinationID)
	{
		return messageDao.getAllTheMessages(senderID, destinationID);
	}

	/**
	 * Sets new messageDAO.
	 *
	 * @param messageDao New value of messageDAO.
	 */
	public void setMessageDao(final MessageDao messageDao)
	{
		this.messageDao = messageDao;
	}
}