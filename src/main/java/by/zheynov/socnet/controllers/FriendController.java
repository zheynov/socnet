package by.zheynov.socnet.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.zheynov.socnet.dto.FriendDTO;
import by.zheynov.socnet.dto.MessageDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.FriendFacade;
import by.zheynov.socnet.facade.ProfileFacade;
import by.zheynov.socnet.facade.UserFacade;
import by.zheynov.socnet.utils.RequestSplitterForUserAndProfile;

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
	private UserFacade userFacade;
	@Autowired
	private FriendFacade friendFacade;
	@Autowired
	private RequestSplitterForUserAndProfile requestSplitterForUserAndProfile;

	/**
	 * Redirects a list of current users's profiles.
	 *
	 * @param model                 the model
	 * @param currentLoggedUsername the username
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/friends/allthepeople/{currentLoggedUsername}", method = RequestMethod.GET)
	public String showAllThePeople(final Model model,
	                               @PathVariable(value = "currentLoggedUsername") final String currentLoggedUsername)
	{
		UserDTO currentLoggedUserDTO = userFacade.getUserByUsername(currentLoggedUsername);

		Set<ProfileDTO> profilesNotFriends
						= profileFacade.getAllTheProfilesOfNonPendingAndNotFriends(currentLoggedUserDTO.getProfileDTO().getProfileID(),
						                                                           currentLoggedUsername
		);

		model.addAttribute("allTheProfiles", profilesNotFriends);

		return "/friends/allthepeople";
	}

	/**
	 * Redirects user to managefriends URL.
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String redirectToManageFriends()
	{
		return "friends/managefriends";
	}

	/**
	 * Shows user all the added friends.
	 *
	 * @param model                 the model
	 * @param currentLoggedUsername the username
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/friends/allthefriends/{currentLoggedUsername}", method = RequestMethod.GET)
	public String showAllTheFriends(final Model model,
	                                @PathVariable(value = "currentLoggedUsername") final String currentLoggedUsername)
	{
		UserDTO currentLoggedUserDTO = userFacade.getUserByUsername(currentLoggedUsername);

		model.addAttribute("allTheFriends", profileFacade.getAllTheProfilesOfFriends(currentLoggedUserDTO.getId()));

		return "/friends/allthefriends";
	}

	/**
	 * Deletes user's friend.
	 *
	 * @param model         the model
	 * @param deleterequest the request
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/friends/delete/friend/{deleterequest}", method = RequestMethod.GET)
	public String deleteFriend(final Model model, @PathVariable(value = "deleterequest") final String deleterequest)
	{
		UserDTO currentLoggedUserDTO = (UserDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(deleterequest).get(0);
		ProfileDTO friendProfileDTO = (ProfileDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(deleterequest).get(1);

		friendFacade.deleteFriend(currentLoggedUserDTO.getProfileDTO().getProfileID(), friendProfileDTO.getProfileID());

		model.addAttribute("allTheFriends", profileFacade.getAllTheProfilesOfFriends(currentLoggedUserDTO.getId()));

		return "/friends/allthefriends";
	}

	/**
	 * Adds user to frinds list.
	 *
	 * @param friendRequestString the String value
	 *
	 * @return friends URL
	 */
	@RequestMapping(value = "/friends/addfriend/{friendRequest}", method = RequestMethod.GET)
	public String manageFriendInfo(@PathVariable(value = "friendRequest") final String friendRequestString)
	{
		UserDTO currentLoggedUserDTO = (UserDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(friendRequestString).get
						(0);
		ProfileDTO newFriendProfileDTO = (ProfileDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(friendRequestString)
		                                                                              .get(1);

		friendFacade.addFriend(currentLoggedUserDTO.getProfileDTO(), newFriendProfileDTO);

		return "redirect:/friends";
	}

	/**
	 * Redirects a list of current users's profiles.
	 *
	 * @param model                 the model
	 * @param currentLoggedUsername the username
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/friends/pendingrequests/{username}", method = RequestMethod.GET)
	public String showPendingRequests(final Model model, @PathVariable(value = "username") final String currentLoggedUsername)
	{
		UserDTO currentLoggedUserDTO = userFacade.getUserByUsername(currentLoggedUsername);
		Set<FriendDTO> pendingFriends = friendFacade.getAllThePendingFriendRequest(currentLoggedUserDTO.getProfileDTO()
		                                                                                               .getProfileID());
		model.addAttribute("allThePendingRequests", pendingFriends);
		return "/friends/pendingrequests";
	}

	/**
	 * Approves friend request.
	 *
	 * @param approveRequestString the approveRequestString
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/friends/approve/{approveRequestString}", method = RequestMethod.GET)
	public String approvePendingRequests(@PathVariable(value = "approveRequestString") final String approveRequestString)
	{
		UserDTO currentLoggedUserDTO = (UserDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(approveRequestString)
		                                                                         .get(0);
		ProfileDTO newFriendProfileDTO = (ProfileDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(approveRequestString)
		                                                                              .get(1);

		friendFacade.approveFriendRequest(currentLoggedUserDTO.getId(), newFriendProfileDTO.getProfileID());

		return "redirect:/friends/";
	}

	/**
	 * Rejects friend request.
	 *
	 * @param rejectRequest the usernale
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/friends/reject/{username}", method = RequestMethod.GET)
	public String rejectPendingRequests(@PathVariable(value = "username") final String rejectRequest)
	{
		UserDTO currentLoggedUserDTO = (UserDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(rejectRequest).get(0);
		ProfileDTO newFriendProfileDTO = (ProfileDTO) requestSplitterForUserAndProfile.getUserDTOAndProfileDTO(rejectRequest).get(1);

		friendFacade.rejectFriendRequest(currentLoggedUserDTO.getId(), newFriendProfileDTO.getProfileID());

		return "redirect:/friends/";
	}

	/**
	 * Redirects to search page.
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/friends/searchfriends/", method = RequestMethod.GET)
	public String visitSearchPage(final Model model)
	{
		model.addAttribute("messageDTO", new MessageDTO());
		return "/friends/searchfriends";
	}

	/**
	 * Finds all the users.
	 *
	 * @param messageDTO the dto
	 * @param model   the model
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/friends/searchfriends/", method = RequestMethod.POST)
	public String searchFriend(@ModelAttribute("messageDTO") final MessageDTO messageDTO, final Model model)
	{
		List<ProfileDTO> profilesNotFriends = null;

		if (messageDTO != null && messageDTO.getText().trim().length() > 0)
		{
			profilesNotFriends = profileFacade.getAllTheProfilesOneParameter(messageDTO.getText().trim());
		}

		model.addAttribute("allTheProfiles", profilesNotFriends);
		model.addAttribute("messageDTO", new MessageDTO());
		return "/friends/searchfriends";
	}

}