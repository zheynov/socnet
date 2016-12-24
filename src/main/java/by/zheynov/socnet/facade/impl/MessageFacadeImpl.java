package by.zheynov.socnet.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import by.zheynov.socnet.dto.MessageDTO;
import by.zheynov.socnet.entity.MessageEntity;
import by.zheynov.socnet.facade.MessageFacade;
import by.zheynov.socnet.service.MessageService;

/**
 * MessageFacadeImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade.impl
 */
@Component("messageFacade")
public class MessageFacadeImpl implements MessageFacade
{
	@Autowired
	private MessageService    messageService;
	@Autowired
	private ConversionService conversionService;

	/**
	 * Saves.
	 *
	 * @param messageDTO the dto
	 *
	 * @return the dto
	 */
	public MessageEntity createMessage(final MessageDTO messageDTO)
	{
		MessageEntity messageEntity = conversionService.convert(messageDTO, MessageEntity.class);
		return messageService.createMessage(messageEntity);
	}

	/**
	 * Finds By messageId.
	 *
	 * @param messageId the id
	 *
	 * @return the dto
	 */
	public MessageDTO getById(final Long messageId)
	{
		return conversionService.convert(messageService.getById(messageId), MessageDTO.class);
	}

	/**
	 * Retrieves a list of MessageDTO objects.
	 *
	 * @param senderID      the id
	 * @param destinationID the id
	 *
	 * @return the List<MessageDTO>
	 */
	public List<MessageDTO> getAllTheMessages(final Long senderID, final Long destinationID)
	{
		List<MessageDTO> allTheMessageDTO = new ArrayList<>();

		messageService.getAllTheMessages(senderID, destinationID).
						forEach(elem -> allTheMessageDTO.add(conversionService.convert(elem, MessageDTO.class)));

		return allTheMessageDTO;
	}
}