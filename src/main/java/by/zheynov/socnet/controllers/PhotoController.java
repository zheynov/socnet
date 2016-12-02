package by.zheynov.socnet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import by.zheynov.socnet.dto.PhotoDTO;
import by.zheynov.socnet.facade.PhotoFacade;

/**
 * PhotoController class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */
@Controller
public class PhotoController
{
	@Autowired
	PhotoFacade photoFacade;

	/**
	 * Redirects a list of current users's profiles.
	 *
	 * @param model the model
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/photoes", method = RequestMethod.GET)
	public String visitPhotoMenuItem(final Model model)
	{
		model.addAttribute("photoDTO", new PhotoDTO());
		model.addAttribute("allThePhotos", photoFacade.getAllThePhotos());
		model.addAttribute("homedir", System.getProperty("user.home"));




		return "/photoes";
	}

	//

	@RequestMapping(value = "/photoupload", method = RequestMethod.POST)
	public String uploadPhoto(@ModelAttribute("photoDTO") final PhotoDTO photoDTO, @RequestParam("photo") final MultipartFile file)
	{
		photoFacade.createPhoto(photoDTO, file);
		return "redirect:/photoes";
	}

}