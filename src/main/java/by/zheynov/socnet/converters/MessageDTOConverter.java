package by.zheynov.socnet.converters;

import org.springframework.core.convert.converter.Converter;

import by.zheynov.socnet.dto.DialogDTO;
import by.zheynov.socnet.dto.MessageDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.MessageEntity;

/**
 * MessageDTOConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
public class MessageDTOConverter implements Converter<MessageEntity, MessageDTO>
{
	public MessageDTO convert(final MessageEntity messageEntity)
	{
		if (messageEntity == null)
		{
			return null;
		}

		MessageDTO messageDTO = new MessageDTO();

		messageDTO.setId(messageEntity.getId());
		messageDTO.setMessageDate(messageEntity.getMessageDate());
		messageDTO.setText(messageEntity.getText());

		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setProfileID(messageEntity.getProfileEntity().getId());
		profileDTO.setFirstname(messageEntity.getProfileEntity().getFirstname());
		profileDTO.setLastname(messageEntity.getProfileEntity().getLastname());
		profileDTO.setEmail(messageEntity.getProfileEntity().getEmail());
		profileDTO.setBirthDate(messageEntity.getProfileEntity().getBirthDate());
		profileDTO.setAge(messageEntity.getProfileEntity().getAge());
		profileDTO.setSex(messageEntity.getProfileEntity().getSex());
		profileDTO.setCity(messageEntity.getProfileEntity().getCity());
		profileDTO.setPhoneNumber(messageEntity.getProfileEntity().getPhoneNumber());
		messageDTO.setProfileDTO(profileDTO);

		DialogDTO dialogDTO = new DialogDTO();
		dialogDTO.setId(messageEntity.getDialogEntity().getId());
		messageDTO.setDialogDTO(dialogDTO);

		return messageDTO;
	}
}