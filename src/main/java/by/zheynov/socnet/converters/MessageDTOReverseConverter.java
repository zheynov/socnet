package by.zheynov.socnet.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import by.zheynov.socnet.dto.MessageDTO;
import by.zheynov.socnet.entity.MessageEntity;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * MessageDTOReverseConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
@Component
public class MessageDTOReverseConverter implements Converter<MessageDTO, MessageEntity>
{
	public MessageEntity convert(final MessageDTO messageDTO)
	{
		if (messageDTO == null)
		{
			return null;
		}

		MessageEntity messageEntity = new MessageEntity();
		messageEntity.setId(messageDTO.getId());
		messageEntity.setText(messageDTO.getText());
		messageEntity.setMessageDate(messageDTO.getMessageDate());

		ProfileEntity senderProfileEntity = new ProfileEntity();
		senderProfileEntity.setId(messageDTO.getSenderProfileDTO().getProfileID());
		senderProfileEntity.setFirstname(messageDTO.getSenderProfileDTO().getFirstname());
		senderProfileEntity.setLastname(messageDTO.getSenderProfileDTO().getLastname());
		senderProfileEntity.setEmail(messageDTO.getSenderProfileDTO().getEmail());
		senderProfileEntity.setAge(messageDTO.getSenderProfileDTO().getAge());
		senderProfileEntity.setBirthDate(messageDTO.getSenderProfileDTO().getBirthDate());
		senderProfileEntity.setSex(messageDTO.getSenderProfileDTO().getSex());
		senderProfileEntity.setCity(messageDTO.getSenderProfileDTO().getCity());
		senderProfileEntity.setPhoneNumber(messageDTO.getSenderProfileDTO().getPhoneNumber());
		messageEntity.setProfileSenderEntity(senderProfileEntity);

		ProfileEntity destinationProfileEntity = new ProfileEntity();
		destinationProfileEntity.setId(messageDTO.getDestinationProfileDTO().getProfileID());
		destinationProfileEntity.setFirstname(messageDTO.getDestinationProfileDTO().getFirstname());
		destinationProfileEntity.setLastname(messageDTO.getDestinationProfileDTO().getLastname());
		destinationProfileEntity.setEmail(messageDTO.getDestinationProfileDTO().getEmail());
		destinationProfileEntity.setAge(messageDTO.getDestinationProfileDTO().getAge());
		destinationProfileEntity.setBirthDate(messageDTO.getDestinationProfileDTO().getBirthDate());
		destinationProfileEntity.setSex(messageDTO.getDestinationProfileDTO().getSex());
		destinationProfileEntity.setCity(messageDTO.getDestinationProfileDTO().getCity());
		destinationProfileEntity.setPhoneNumber(messageDTO.getDestinationProfileDTO().getPhoneNumber());
		messageEntity.setProfileDestinationEntity(destinationProfileEntity);


		return messageEntity;
	}
}