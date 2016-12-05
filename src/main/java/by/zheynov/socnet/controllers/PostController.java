package by.zheynov.socnet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.zheynov.socnet.dto.PostDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.PhotoFacade;

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

	/**
	 * Redirects user to welcomePage URL.
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/welcomePage", method = RequestMethod.GET)
	public String beforeVisitingWelcomePage(final Model model)
	{
		model.addAttribute("postDTO", new PostDTO());
		model.addAttribute("userDTO", new UserDTO());
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

		return "redirect/welcomePage";
	}

}