package by.zheynov.socnet.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.ProfileFacade;
import by.zheynov.socnet.facade.UserFacade;
import by.zheynov.socnet.service.RequestSplitter;

/**
 * Message controller class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */
@Controller
public class MessageController
{
	@Autowired
	private ProfileFacade profileFacade;

	@Autowired
	private UserFacade userFacade;

	/**
	 * Shows all the users.
	 *
	 * @param model the model
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public String showAllTheFriends(final Model model)
	{
		model.addAttribute("allThePeople", profileFacade.getAllTheProfiles());

		return "messages/messages";
	}

	/**
	 * Redirects a list of current users's profiles.
	 *
	 * @param model   the model
	 * @param request the username
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/messages/sendmessage/{request}", method = RequestMethod.GET)
	public String showAllThePeople(final Model model, @PathVariable(value = "request") final String request)
	{
		UserDTO currentLoggedUserDTO = (UserDTO) RequestSplitter.getUserDTOAndProfileDTO(request).get(0);
		ProfileDTO destinationProfileDTO = (ProfileDTO) RequestSplitter.getUserDTOAndProfileDTO(request).get(1);



//		model.addAttribute("allTheProfiles", profilesNotFriends);

		return "/messages/showmessages";
	}

}