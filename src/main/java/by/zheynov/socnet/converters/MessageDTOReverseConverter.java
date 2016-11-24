package by.zheynov.socnet.converters;

import org.springframework.core.convert.converter.Converter;

import by.zheynov.socnet.dto.MessageDTO;
import by.zheynov.socnet.entity.DialogEntity;
import by.zheynov.socnet.entity.MessageEntity;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * MessageDTOReverseConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
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

		ProfileEntity profileEntity = new ProfileEntity();
		profileEntity.setId(messageDTO.getProfileDTO().getProfileID());
		profileEntity.setFirstname(messageDTO.getProfileDTO().getFirstname());
		profileEntity.setLastname(messageDTO.getProfileDTO().getLastname());
		profileEntity.setEmail(messageDTO.getProfileDTO().getEmail());
		profileEntity.setAge(messageDTO.getProfileDTO().getAge());
		profileEntity.setBirthDate(messageDTO.getProfileDTO().getBirthDate());
		profileEntity.setSex(messageDTO.getProfileDTO().getSex());
		profileEntity.setCity(messageDTO.getProfileDTO().getCity());
		profileEntity.setPhoneNumber(messageDTO.getProfileDTO().getPhoneNumber());
		messageEntity.setProfileEntity(profileEntity);

		DialogEntity dialogEntity = new DialogEntity();
		dialogEntity.setId(messageDTO.getDialogDTO().getId());
		messageEntity.setDialogEntity(dialogEntity);

		return messageEntity;
	}
}