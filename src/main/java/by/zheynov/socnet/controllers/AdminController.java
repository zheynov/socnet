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
 * Admin's page controller.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */

@Controller
public class AdminController
{
	@Autowired
	private ProfileFacade profileFacade;
	@Autowired
	private UserFacade    userFacade;

	/**
	 * Redirects admin to admin dashboard.
	 *
	 * @param model the model
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String loginAsAdmin(final Model model)
	{
		model.addAttribute("allTheProfiles", profileFacade.getAllTheProfiles());

		return "/adminpage";
	}

	/**
	 * Redirects to user's nanagement page.
	 *
	 * @param model  the model
	 * @param userID the id
	 *
	 * @return userinfo URL
	 */
	@RequestMapping(value = "/manageuserinfo/{userID}", method = RequestMethod.GET)
	public String manageuserInfo(final Model model, @PathVariable(value = "userID") String userID)
	{
		ProfileDTO profileDTO = profileFacade.getProfileById(Long.valueOf(userID));
		for (UserDTO userDTO : userFacade.getAllTheUsers())
		{
			if (userDTO.getId().equals(profileDTO.getProfileID()))
			{
				model.addAttribute("userDTO", userDTO);
			}
		}
		return "/userinfo";
	}

}
