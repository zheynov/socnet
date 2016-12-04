package by.zheynov.socnet.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * ExceptionsController class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */
/*@EnableWebMvc
@ControllerAdvice*/
public class ExceptionsController
{
	@ExceptionHandler(Exception.class)
	public String handleIOException(Exception ex, Model model) {
		model.addAttribute("ex", ex);
		return "/error/exceptionpage";
	}
}