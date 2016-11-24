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
	private static final String GET_ALL_THE_MESSAGES_QUERY = "FROM MessageEntity " + "WHERE senderID = :senderID ORDER BY messagedate DESC";

	/**
	 * Saves.
	 *
	 * @param messageEntity the entity
	 *
	 * @return the entity
	 */
	public MessageEntity createMessage(final MessageEntity messageEntity)
	{
		MessageEntity newMessageEntity = new MessageEntity();
		newMessageEntity.setDialogEntity(messageEntity.getDialogEntity());
		newMessageEntity.setProfileEntity(messageEntity.getProfileEntity());
		newMessageEntity.setMessageDate(messageEntity.getMessageDate());
		newMessageEntity.setText(messageEntity.getText());

		super.save(newMessageEntity);
		return newMessageEntity;
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