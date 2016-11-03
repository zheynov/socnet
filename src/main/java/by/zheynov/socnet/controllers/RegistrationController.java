package by.zheynov.socnet.controllers;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.UserFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Registration page controller.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */

@Controller
public class RegistrationController
{
	@Autowired
	@Qualifier("registrationValidator")
	private Validator  registrationValidator;
	@Autowired
	private UserFacade userFacade;

	/**
	 * Adds UserDTO object to model.
	 *
	 * @param model the model
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String initRegistration(final Model model)
	{
		model.addAttribute("userDTO", new UserDTO());
		return "/registration";
	}

	/**
	 * Controls user's registration process and redirects to the specified URL
	 * if registration is successful.
	 *
	 * @param model   the model
	 * @param userDTO the userDTO
	 * @param result  the result
	 *
	 * @return the URL
	 */

	@RequestMapping(value = "/registrationComplete", method = RequestMethod.POST)
	public String displayRegistration(final Model model,
	                                  @ModelAttribute("userDTO") final UserDTO userDTO, final BindingResult result)
	{

		registrationValidator.validate(userDTO, result);

		if (result.hasErrors())
		{
			return "/registration";
		}

		if (!userFacade.isUsernameExists(userDTO.getUsername()))
		{
			if (!userFacade.isEmailExists(userDTO.getEmail()))
			{

				userFacade.createUser(userDTO);
				return "loginpage";

			}
			else
			{
				model.addAttribute("pageNotification", "email");
				return "/registration";
			}
		}
		else
		{
			model.addAttribute("pageNotification", "username");
			return "/registration";
		}
	}

	/**
	 * Redirects user to alltheusers.jsp.
	 *
	 * @param model the model
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/showAllUsers", method = RequestMethod.GET)
	public String showAllTheUsers(final Model model)
	{
		model.addAttribute("userDTO", new UserDTO());
		model.addAttribute("allTheUsers", userFacade.getAllTheUsers());
		return "/alltheusers";
	}
}
