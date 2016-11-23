package by.zheynov.socnet.dao.impl;

import java.util.List;

import org.hibernate.query.Query;

import by.zheynov.socnet.dao.MessageDAO;
import by.zheynov.socnet.entity.MessageEntity;

/**
 * MessageDAOImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */
public class MessageDAOImpl extends AbstractBaseDAO implements MessageDAO
{
	private static final String GET_ALL_THE_MESSAGES_QUERY = "FROM MessageEntity " + "WHERE senderID = :senderID";

	/**
	 * Saves.
	 *
	 * @param messageEntity the entity
	 *
	 * @return the entity
	 */
	public MessageEntity createMessage(final MessageEntity messageEntity)
	{
		super.save(messageEntity);
		return messageEntity;
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
		Query query = super.getCurrentSession().createQuery(GET_ALL_THE_MESSAGES_QUERY);
		query.setParameter("senderID", senderID);
		return query.list();
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
		return super.getCurrentSession().get(MessageEntity.class, messageId);
	}
}