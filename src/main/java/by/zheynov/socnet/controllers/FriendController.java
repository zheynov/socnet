package by.zheynov.socnet.controllers;

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

/**
 * FriendController class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */

@Controller
public class FriendController
{
	@Autowired
	private ProfileFacade profileFacade;
	@Autowired
	private UserFacade    userFacade;

	/**
	 * Redirects a list of current users's profiles.
	 *
	 * @param model the model
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String loginAsAdmin(final Model model)
	{
		model.addAttribute("allTheProfiles", profileFacade.getAllTheProfiles());
		return "/friends";
	}

	/**
	 * Adds user to frinds list.
	 *
	 * @param model               the model
	 * @param friendRequestString the String value
	 *
	 * @return friends URL
	 */
	@RequestMapping(value = "/addfriend/{friendRequest}", method = RequestMethod.GET)
	public String manageuserInfo(final Model model, @PathVariable(value = "friendRequest") final String friendRequestString)
	{
		String[] twoWordsFromfriendRequestString = friendRequestString.split("&");
		String currentUsername = twoWordsFromfriendRequestString[0];
		String newFriendID = twoWordsFromfriendRequestString[1];

		UserDTO currentUserDTO = userFacade.getUserByUsername(currentUsername);

		ProfileDTO newFriendProfileDTO = profileFacade.getProfileById(Long.valueOf(newFriendID));

		profileFacade.addFriend(currentUserDTO.getProfileDTO(), newFriendProfileDTO);

		return "redirect:/friends";
	}

}