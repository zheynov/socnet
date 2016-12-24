package by.zheynov.socnet.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ExceptionsHandler class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */
public class ExceptionsHandler
{
	/**
	 * Intercept exceptions.
	 *
	 * @param ex    the exception
	 * @param model the model
	 *
	 * @return the URL
	 */
	@ExceptionHandler(Exception.class)
	public String handleIOException(final Exception ex, final Model model)
	{
		model.addAttribute("ex", ex);
		return "/error/exceptionpage";
	}

	/*@EnableWebMvc
@ControllerAdvice*/
}