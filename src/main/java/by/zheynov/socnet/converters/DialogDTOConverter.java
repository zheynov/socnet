package by.zheynov.socnet.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

import by.zheynov.socnet.dto.DialogDTO;
import by.zheynov.socnet.dto.MessageDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.DialogEntity;
import by.zheynov.socnet.entity.MessageEntity;

/**
 * DialogDTOConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
public class DialogDTOConverter implements Converter<DialogEntity, DialogDTO>
{
	public DialogDTO convert(final DialogEntity dialogEntity)
	{
		if (dialogEntity == null)
		{
			return null;
		}

		DialogDTO dialogDTO = new DialogDTO();
		dialogDTO.setId(dialogEntity.getId());

		Set<MessageEntity> messages = dialogEntity.getMessages();
		Set<MessageDTO> messagesDTO = new HashSet<MessageDTO>();

		for (MessageEntity messageEntity : messages)
		{
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

			DialogDTO dialogDTOOfMessage = new DialogDTO();
			dialogDTO.setId(messageEntity.getDialogEntity().getId());

			messageDTO.setDialogDTO(dialogDTOOfMessage);

			messagesDTO.add(messageDTO);

		}

		dialogDTO.setMessages(messagesDTO);

		return null;
	}
}