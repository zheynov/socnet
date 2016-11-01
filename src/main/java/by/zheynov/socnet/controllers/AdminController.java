package by.zheynov.socnet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Admin's page controller.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */

@Controller
public class AdminController
{

	/**
	 * Redirects user to showAllUsers URL.
	 *
	 * @param model the model
	 * @param request the request
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String loginAsAdmin(final Model model, final HttpServletRequest request)
	{
		return "/showAllUsers";
	}
}
