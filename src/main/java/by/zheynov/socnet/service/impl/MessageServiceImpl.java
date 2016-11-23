package by.zheynov.socnet.service.impl;

import java.util.List;

import by.zheynov.socnet.dao.DialogDAO;
import by.zheynov.socnet.dao.MessageDAO;
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
	private MessageDAO messageDAO;

	/**
	 * Saves.
	 *
	 * @param messageEntity the entity
	 *
	 * @return the entity
	 */
	public MessageEntity createMessage(final MessageEntity messageEntity)
	{
		return messageDAO.createMessage(messageEntity);
	}

	/**
	 * Finds By messageId.
	 *
	 * @param messageId the id
	 *
	 * @return the entity
	 */
	public MessageEntity getById(final Long messageId)
	{
		return messageDAO.getById(messageId);
	}

	/**
	 * Retrieves a list of MessageEntity objects.
	 *
	 * @param senderID the id
	 *
	 * @return the List<MessageEntity>
	 */
	public List<MessageEntity> getAllTheMessages(final Long senderID)
	{
		return messageDAO.getAllTheMessages(senderID);
	}

	/**
	 * Sets new messageDAO.
	 *
	 * @param messageDAO New value of messageDAO.
	 */
	public void setMessageDAO(MessageDAO messageDAO)
	{
		this.messageDAO = messageDAO;
	}
}