package by.zheynov.socnet.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	private ProfileFacade profileFacade;
	@Autowired
	private MessageFacade messageFacade;
	@Autowired
	private RequestSplitterForUserAndProfile requestSplitterForUserAndProfile;

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
	* @param session the session
	*
	* @return the URL
	*/
	@RequestMapping(value = "/beforesendmessage/{request}", method = RequestMethod.GET)
	public String beforeSendingMessage(final Model model, @PathVariable(value = "request") final String request,
	                                   final HttpSession session)
	{
		UserDTO currentLoggedUserDTO = (UserDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(request).get(0);

		ProfileDTO destinationProfileDTO = (ProfileDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(request).get(1);
		ProfileDTO senderProfileDTO = currentLoggedUserDTO.getProfileDTO();

		MessageDTO messageDTO = new MessageDTO();

		session.setAttribute("destinationProfileDTO", destinationProfileDTO);
		session.setAttribute("senderProfileDTO", senderProfileDTO);

		model.addAttribute("senderProfileDTO", senderProfileDTO);
		model.addAttribute("destinationProfileDTO", destinationProfileDTO);

		model.addAttribute("MessageDTO", messageDTO);
		model.addAttribute("allTheMessages",
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
	 * @param session    the session
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/sendmessage", method = RequestMethod.POST)
	public String sendMessage(final Model model, @ModelAttribute("MessageDTO") final MessageDTO messageDTO,
	                          final BindingResult result, final HttpSession session)
	{
		messageDTO.setMessageDate(new Date());

		messageDTO.setSenderProfileDTO((ProfileDTO) session.getAttribute("senderProfileDTO"));
		messageDTO.setDestinationProfileDTO((ProfileDTO) session.getAttribute("destinationProfileDTO"));

		messageFacade.createMessage(messageDTO);

		model.addAttribute("allTheMessages",
		                   messageFacade.getAllTheMessages(messageDTO.getSenderProfileDTO().getProfileID(),
		                                                   messageDTO.getDestinationProfileDTO().getProfileID()
		                   )
		);

		return "redirect:/messages/beforesendmessage/" + messageDTO.getSenderProfileDTO().getUserDTO().getUsername() + "&" +
						messageDTO.getDestinationProfileDTO().getProfileID();
	}

}