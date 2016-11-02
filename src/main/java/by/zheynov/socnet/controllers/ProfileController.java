package by.zheynov.socnet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.ProfileFacade;
import by.zheynov.socnet.facade.UserFacade;

/**
 * Profile controller class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */
@Controller
public class ProfileController
{
	@Autowired
	private ProfileFacade profileFacade;
	@Autowired
	private UserFacade    userFacade;

	/**
	 * Redirects user to profile page.
	 *
	 * @param model the model
	 *
	 * @return profilepage URL
	 */
	@RequestMapping(value = "/beforeprofilepage", method = RequestMethod.GET)
	public String beforeVisitingProfilePage(final Model model)
	{
		addProfileDTOToModel(model);
		return "/profilepage";
	}

	/**
	 * Edits user's profile.
	 *
	 * @param model the model
	 *
	 * @return profilepage URL
	 */
	@RequestMapping(value = "/profileedit", method = RequestMethod.GET)
	public String initProfileEdition(final Model model)
	{
		addProfileDTOToModel(model);

		return "/profileeditpage";
	}

	/**
	 * Edits user's profile.
	 *
	 * @param model      the model
	 * @param profileDTO the profileDTO
	 *
	 * @return profilepage URL
	 */
	@RequestMapping(value = "/editprofile", method = RequestMethod.GET)
	public String editProfile(final Model model, @ModelAttribute("profileDTO")final ProfileDTO profileDTO)
	{
		profileFacade.updateProfile(profileDTO);

		model.addAttribute("profileDTO", profileDTO);

		return "/profilepage";
	}

	/**
	 * Adds profile to model.
	 *
	 * @param model the model
	 */
	private void addProfileDTOToModel(final Model model)
	{
		//Retrieves current username
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDTO userDTO = userFacade.getUserByUsername(user.getUsername());

		ProfileDTO profileDTO = profileFacade.getProfileById(userDTO.getProfileID());
		model.addAttribute("profileDTO", profileDTO);
	}

}