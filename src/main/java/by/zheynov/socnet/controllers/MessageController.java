package by.zheynov.socnet.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.zheynov.socnet.dto.DialogDTO;
import by.zheynov.socnet.dto.MessageDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.DialogFacade;
import by.zheynov.socnet.facade.MessageFacade;
import by.zheynov.socnet.facade.ProfileFacade;
import by.zheynov.socnet.facade.UserFacade;
import by.zheynov.socnet.utils.RequestSplitterForUserAndProfile;

/**
 * Message controller class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */
@Controller
@RequestMapping(value = "/messages")
public class MessageController
{
	@Autowired
	private ProfileFacade profileFacade;
	@Autowired
	private DialogFacade  dialogFacade;
	@Autowired
	private UserFacade    userFacade;
	@Autowired
	private MessageFacade messageFacade;
	@Autowired
	RequestSplitterForUserAndProfile requestSplitterForUserAndProfile;

	private DialogDTO dialogDTO;

	/**
	 * Shows all the users.
	 *
	 * @param model the model
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showAllTheFriends(final Model model)
	{
		model.addAttribute("allThePeople", profileFacade.getAllTheProfiles());
		return "/messages/messages";
	}

	/*
	 * Prepares data for sending a message.
	 *
	 * @param model   the model
	 * @param request the currentLoggedUserDTO+derstinationProfileDTO
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/beforesendmessage/{request}", method = RequestMethod.GET)
	public String beforeSendingMessage(final Model model, @PathVariable(value = "request") final String request)
	{
		UserDTO currentLoggedUserDTO = (UserDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(request).get(0);

		ProfileDTO destinationProfileDTO = (ProfileDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(request).get(1);
		ProfileDTO senderProfileDTO = currentLoggedUserDTO.getProfileDTO();

		// TODO need to implement method for dialog existing check


		DialogDTO newDialogDTO = new DialogDTO();
		Set<ProfileDTO> profiles = new HashSet<ProfileDTO>();
		profiles.add(destinationProfileDTO);
		profiles.add(senderProfileDTO);
		newDialogDTO.setProfiles(profiles);

		dialogFacade.createDialog(newDialogDTO);

		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setDialogDTO(newDialogDTO);

		dialogDTO = newDialogDTO;

		model.addAttribute("MessageDTO", messageDTO);

		return "/messages/sendmessage";
	}

	/**
	 * Sends a message.
	 *
	 * @param model      the model
	 * @param messageDTO the dto
	 * @param username   the username
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/sendmessage/{username}", method = RequestMethod.POST)
	public String sendMessage(final Model model, @ModelAttribute("MessageDTO") MessageDTO messageDTO,
	                          @PathVariable(value = "username") final String username)
	{
		UserDTO currentLoggedUserDTO = userFacade.getUserByUsername(username);
		messageDTO.setMessageDate(new Date());
		messageDTO.setProfileDTO(currentLoggedUserDTO.getProfileDTO());
		messageDTO.setDialogDTO(dialogDTO);

		messageFacade.createMessage(messageDTO);

		model.addAttribute("allTheMessages", messageFacade.getAllTheMessages(currentLoggedUserDTO.getProfileDTO().getProfileID()));

		return "/messages/sendmessage";
	}

	/**
	 * @param binder the binder
	 */

	@InitBinder
	protected void initBinder(final WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}