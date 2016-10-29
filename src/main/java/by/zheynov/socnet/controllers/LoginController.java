package by.zheynov.socnet.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController
{

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) final String error,
	                    @RequestParam(value = "logout", required = false) final String logout, final Model model, final HttpServletRequest request)
	{
		if (error != null)
		{
			model.addAttribute("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null)
		{
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "/loginpage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accessDenied()
	{
		final ModelAndView model = new ModelAndView();
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken))
		{
			final UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("/error/403");
		return model;
	}

	private String getErrorMessage(final HttpServletRequest request, final String key)
	{
		final Exception exception = (Exception) request.getSession().getAttribute(key);

		String error;
		if (exception instanceof BadCredentialsException)
		{
			error = "Invalid username and password!";
		}
		else if (exception instanceof LockedException)
		{
			error = exception.getMessage();
		}
		else
		{
			error = "Invalid username and password!";
		}
		return error;
	}

}
