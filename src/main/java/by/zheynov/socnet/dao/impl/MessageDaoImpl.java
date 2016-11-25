package by.zheynov.socnet.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.MessageDao;
import by.zheynov.socnet.entity.MessageEntity;

/**
 * MessageDaoImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */
@Transactional
public class MessageDaoImpl extends AbstractBaseDAO implements MessageDao
{
	private static final String GET_ALL_THE_MESSAGES_QUERY = "FROM MessageEntity " +
					"WHERE senderID = :senderID AND destinationID = :destinationID OR senderID = :destinationID AND destinationID = :senderID ORDER BY messagedate DESC";

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
	 * @param senderID      the id
	 * @param destinationID the id
	 *
	 * @return the List<MessageEntity>
	 */
	public List<MessageEntity> getAllTheMessages(final Long senderID, final Long destinationID)
	{
		Query query = super.getCurrentSession().createQuery(GET_ALL_THE_MESSAGES_QUERY);
		query.setParameter("senderID", senderID);
		query.setParameter("destinationID", destinationID);
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