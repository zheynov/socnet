package by.zheynov.socnet.facade;

import java.util.List;

import by.zheynov.socnet.dto.MessageDTO;
import by.zheynov.socnet.entity.MessageEntity;

/**
 * MessageFacade interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade
 */
public interface MessageFacade
{

	/**
	 * Saves.
	 *
	 * @param messageDTO the dto
	 *
	 * @return the dto
	 */
	MessageEntity createMessage(MessageDTO messageDTO);

	/**
	 * Finds By messageId.
	 *
	 * @param messageId the id
	 *
	 * @return the dto
	 */
	MessageDTO getById(Long messageId);

	/**
	 * Retrieves a list of MessageDTO objects.
	 *
	 * @param senderID the id
	 *
	 * @return the List<MessageDTO>
	 */
	List<MessageDTO> getAllTheMessages(Long senderID);
}