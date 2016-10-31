package by.zheynov.socnet.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Login page controller.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */

@Controller
public class LoginController
{

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) final String error,
	                    @RequestParam(value = "logout", required = false) final String logout, final Model model,
	                    final HttpServletRequest request)
	{

		if (error != null)
		{
			model.addAttribute("error", "Invalid username and password!");
		}
		if (logout != null)
		{
			model.addAttribute("msg", "You've been logged out successfully.");
		}

		//login form for update page
		//if login error, get the targetUrl from session again.
		String targetUrl = getRememberMeTargetUrlFromSession(request);
		if (StringUtils.hasText(targetUrl))
		{
			model.addAttribute("targetUrl", targetUrl);
			model.addAttribute("loginUpdate", true);
		}

		return "/loginpage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model)
	{
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken))
		{
			final UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());
		}
		return "/error/403";
	}

	/**
	 * gets targetURL from session
	 */
	private String getRememberMeTargetUrlFromSession(final HttpServletRequest request)
	{
		String targetUrl = "";
		HttpSession session = request.getSession(false);
		if (session != null)
		{
			targetUrl = session.getAttribute("targetUrl") == null ? "" : session.getAttribute("targetUrl").toString();
		}
		return targetUrl;
	}
}
