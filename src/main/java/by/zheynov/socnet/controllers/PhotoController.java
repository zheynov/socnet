package by.zheynov.socnet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * PhotoController class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */
@Controller
public class PhotoController
{

	/**
	 * Redirects a list of current users's profiles.
	 *
	 * @param model the model
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/photoes", method = RequestMethod.GET)
	public String loginAsAdmin(final Model model)
	{
		return "/photoes";
	}
}