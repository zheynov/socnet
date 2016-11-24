package by.zheynov.socnet.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

import by.zheynov.socnet.dto.DialogDTO;
import by.zheynov.socnet.dto.MessageDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.DialogEntity;
import by.zheynov.socnet.entity.MessageEntity;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * DialogDTOReverseConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
public class DialogDTOReverseConverter implements Converter<DialogDTO, DialogEntity>
{
	public DialogEntity convert(final DialogDTO dialogDTO)
	{
		if (dialogDTO == null)
		{
			return null;
		}

		DialogEntity dialogEntity = new DialogEntity();

		dialogEntity.setId(dialogDTO.getId());

		//setting messageEntities to DialogEntity objects

		Set<MessageEntity> allTheMessageEntities = new HashSet<MessageEntity>();
		Set<MessageDTO> allTheMessagesDTO = dialogDTO.getMessages();

		for (MessageDTO messageDTO : allTheMessagesDTO)
		{
			MessageEntity messageEntity = new MessageEntity();

			messageEntity.setId(messageDTO.getId());
			messageEntity.setMessageDate(messageDTO.getMessageDate());
			messageEntity.setText(messageDTO.getText());

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

			DialogEntity dialogEntityFromDTO = new DialogEntity();
			dialogEntityFromDTO.setId(messageDTO.getDialogDTO().getId());
			messageEntity.setDialogEntity(dialogEntityFromDTO);

			allTheMessageEntities.add(messageEntity);
		}
		dialogEntity.setMessages(allTheMessageEntities);

		//setting ProfileEntities to DialogEntity objects

		Set<ProfileEntity> profileEntities = new HashSet<ProfileEntity>();
		Set<ProfileDTO> profileDTOs = dialogDTO.getProfiles();

		for (ProfileDTO profileDTO : profileDTOs)
		{
			final ProfileEntity profileEntity = new ProfileEntity();

			profileEntity.setId(profileDTO.getProfileID());
			profileEntity.setFirstname(profileDTO.getFirstname());
			profileEntity.setLastname(profileDTO.getLastname());
			profileEntity.setEmail(profileDTO.getEmail());
			profileEntity.setAge(profileDTO.getAge());
			profileEntity.setBirthDate(profileDTO.getBirthDate());
			profileEntity.setSex(profileDTO.getSex());
			profileEntity.setCity(profileDTO.getCity());
			profileEntity.setPhoneNumber(profileDTO.getPhoneNumber());

			profileEntities.add(profileEntity);
		}
		dialogEntity.setProfiles(profileEntities);

		return dialogEntity;
	}
}