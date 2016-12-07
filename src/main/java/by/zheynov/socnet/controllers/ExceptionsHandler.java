package by.zheynov.socnet.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ExceptionsHandler class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */
/*@EnableWebMvc
@ControllerAdvice*/
public class ExceptionsHandler
{
	@ExceptionHandler(Exception.class)
	public String handleIOException(Exception ex, Model model) {
		model.addAttribute("ex", ex);
		return "/error/exceptionpage";
	}
}