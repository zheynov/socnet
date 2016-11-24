package by.zheynov.socnet.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

import by.zheynov.socnet.dto.DialogDTO;
import by.zheynov.socnet.dto.MessageDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.DialogEntity;
import by.zheynov.socnet.entity.MessageEntity;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.UserEntity;

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

		//setting MessageDTOs to DialogDTO object

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

			UserDTO userDTO = new UserDTO();
			userDTO.setProfileDTO(profileDTO);
			userDTO.setId(messageEntity.getProfileEntity().getUserEntity().getId());
			userDTO.setUsername(messageEntity.getProfileEntity().getUserEntity().getUsername());
			userDTO.setPassword(messageEntity.getProfileEntity().getUserEntity().getPassword());
			userDTO.setEmail(messageEntity.getProfileEntity().getUserEntity().getEmail());
			userDTO.setEnabled(messageEntity.getProfileEntity().getUserEntity().isEnabled());

			profileDTO.setUserDTO(userDTO);

			messageDTO.setProfileDTO(profileDTO);

			DialogDTO dialogDTOOfMessage = new DialogDTO();
			dialogDTO.setId(messageEntity.getDialogEntity().getId());

			messageDTO.setDialogDTO(dialogDTOOfMessage);

			messagesDTO.add(messageDTO);
		}

		dialogDTO.setMessages(messagesDTO);


		//setting ProfileDTOs to DialogDTO object
		Set<ProfileEntity> profileEntities = dialogEntity.getProfiles();
		Set<ProfileDTO> profileDTOs = new HashSet<ProfileDTO>();

		for (ProfileEntity profileEntity : profileEntities)
		{

			ProfileDTO profileDTO = new ProfileDTO();

			profileDTO.setProfileID(profileEntity.getId());
			profileDTO.setFirstname(profileEntity.getFirstname());
			profileDTO.setLastname(profileEntity.getLastname());
			profileDTO.setEmail(profileEntity.getEmail());
			profileDTO.setBirthDate(profileEntity.getBirthDate());
			profileDTO.setAge(profileEntity.getAge());
			profileDTO.setSex(profileEntity.getSex());
			profileDTO.setCity(profileEntity.getCity());
			profileDTO.setPhoneNumber(profileEntity.getPhoneNumber());

			UserDTO userDTO = new UserDTO();
			UserEntity userEntity = profileEntity.getUserEntity();

			userDTO.setProfileDTO(profileDTO);
			userDTO.setId(userEntity.getId());
			userDTO.setUsername(userEntity.getUsername());
			userDTO.setPassword(userEntity.getPassword());
			userDTO.setEmail(userEntity.getEmail());
			userDTO.setEnabled(userEntity.isEnabled());

			profileDTO.setUserDTO(userDTO);
			profileDTOs.add(profileDTO);

		}
		dialogDTO.setProfiles(profileDTOs);

		return dialogDTO;
	}
}