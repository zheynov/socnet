package by.zheynov.socnet.dao;

import java.util.List;

import by.zheynov.socnet.entity.MessageEntity;

/**
 * MessageDao interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao
 */
public interface MessageDao
{
	/**
	 * Saves.
	 *
	 * @param messageEntity the entity
	 *
	 * @return the entity
	 */
	MessageEntity createMessage(MessageEntity messageEntity);

	/**
	 * Finds By messageId.
	 *
	 * @param messageId the id
	 *
	 * @return the entity
	 */
	MessageEntity getById(Long messageId);

	/**
	 * Retrieves a list of MessageEntity objects.
	 *
	 * @param senderID the id
	 * @return the List<MessageEntity>
	 */
	List<MessageEntity> getAllTheMessages(Long senderID);
}