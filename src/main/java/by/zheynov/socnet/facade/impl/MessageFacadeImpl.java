package by.zheynov.socnet.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

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
public class MessageFacadeImpl implements MessageFacade
{
	@Autowired
	private MessageService    messageService;
	@Autowired
	private ConversionService conversionService;

	public MessageEntity createMessage(final MessageDTO messageDTO)
	{
		MessageEntity messageEntity = conversionService.convert(messageDTO, MessageEntity.class);
		return messageService.createMessage(messageEntity);
	}

	public MessageDTO getById(final Long messageId)
	{
		return conversionService.convert(messageService.getById(messageId), MessageDTO.class);
	}

	public List<MessageDTO> getAllTheMessages(final Long senderID)
	{
		List<MessageDTO> allTheMessageDTO = new ArrayList<MessageDTO>();
		for (MessageEntity userEntity : messageService.getAllTheMessages(senderID))
		{
			final MessageDTO convert = conversionService.convert(userEntity, MessageDTO.class);
			allTheMessageDTO.add(convert);
		}
		return allTheMessageDTO;
	}
}