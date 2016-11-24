package by.zheynov.socnet.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import by.zheynov.socnet.dto.MessageDTO;
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
@RequestMapping(value = "/messages")
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
	@RequestMapping(value = "/sendmessage/{request}", method = RequestMethod.GET)
	public String beforeSendingMessage(final Model model, @PathVariable(value = "request") final String request)
	{
		UserDTO currentLoggedUserDTO = (UserDTO) RequestSplitter.getUserDTOAndProfileDTO(request).get(0);
		ProfileDTO derstinationProfileDTO = (ProfileDTO) RequestSplitter.getUserDTOAndProfileDTO(request).get(1);

		Long senderProfileID = currentLoggedUserDTO.getProfileDTO().getProfileID();
		Long derstinationProfileID = derstinationProfileDTO.getProfileID();



		//		model.addAttribute("MessageDTO", messageDTO);

		return "/messages/sendmessage";
	}

	/**
	 * Sends a message.
	 *
	 * @param model      the model
	 * @param messageDTO the dto
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/sendmessage", method = RequestMethod.POST)
	public String sendMessage(final Model model, @ModelAttribute("MessageDTO") MessageDTO messageDTO)
	{

		//		model.addAttribute("allTheProfiles", profilesNotFriends);

		return "redirect:/messages/messages";
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