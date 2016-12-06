package by.zheynov.socnet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.zheynov.socnet.dto.PhotoDTO;
import by.zheynov.socnet.dto.PostDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.PhotoFacade;
import by.zheynov.socnet.facade.ProfileFacade;

/**
 * PostController class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */

@Controller
public class PostController
{
	@Autowired
	PhotoFacade photoFacade;

	@Autowired
	ProfileFacade profileFacade;

	/**
	 * Redirects user to welcomePage URL.
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/welcomePage", method = RequestMethod.GET)
	public String beforeVisitingWelcomePage(final Model model)
	{

		model.addAttribute("allThePosts", profileFacade.getAllTheProfiles());
		return "/welcome";
	}

	/**
	 * makes a post.
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/makeapost", method = RequestMethod.POST)
	public String makePost(final Model model, @ModelAttribute("postDTO") PostDTO postDTO)
	{



		PhotoDTO photoDTO = new PhotoDTO();



		return "redirect/welcomePage";
	}

}