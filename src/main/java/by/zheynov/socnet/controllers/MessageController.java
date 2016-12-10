package by.zheynov.socnet.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.zheynov.socnet.dto.MessageDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.MessageFacade;
import by.zheynov.socnet.facade.ProfileFacade;
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
	private ProfileFacade                    profileFacade;
	@Autowired
	private MessageFacade                    messageFacade;
	@Autowired
	private RequestSplitterForUserAndProfile requestSplitterForUserAndProfile;

	private ProfileDTO tempDestinationProfileDTO;
	private ProfileDTO tempSenderProfileDTO;

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

		MessageDTO messageDTO = new MessageDTO();
		tempDestinationProfileDTO = destinationProfileDTO;
		tempSenderProfileDTO = senderProfileDTO;
		messageDTO.setMessageDate(new Date());

		model.addAttribute("destinationProfileDTO", tempDestinationProfileDTO);

		model.addAttribute("MessageDTO", messageDTO);
		model.addAttribute(
						"allTheMessages",
						messageFacade.getAllTheMessages(senderProfileDTO.getProfileID(), destinationProfileDTO.getProfileID())
		);

		return "/messages/sendmessage";
	}

	/**
	 * Sends a message.
	 *
	 * @param model      the model
	 * @param messageDTO the dto
	 * @param result     the result
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/sendmessage", method = RequestMethod.POST)
	public String sendMessage(final Model model, @ModelAttribute("MessageDTO") final MessageDTO messageDTO,
	                          final BindingResult result)
	{
		messageDTO.setSenderProfileDTO(tempSenderProfileDTO);
		messageDTO.setDestinationProfileDTO(tempDestinationProfileDTO);
		messageFacade.createMessage(messageDTO);

		model.addAttribute(
						"allTheMessages",
						messageFacade.getAllTheMessages(tempSenderProfileDTO.getProfileID(), tempDestinationProfileDTO.getProfileID())
		);

		return "redirect:/messages/beforesendmessage/" + tempSenderProfileDTO.getUserDTO().getUsername() + "&" +
						tempDestinationProfileDTO.getProfileID();
	}

	/**
	 * @param binder the binder
	 */

	@InitBinder
	protected void initBinder(final WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}