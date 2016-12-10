package by.zheynov.socnet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import by.zheynov.socnet.dto.PhotoDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.PhotoFacade;
import by.zheynov.socnet.facade.UserFacade;

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
	private PhotoFacade photoFacade;

	@Autowired
	private UserFacade userFacade;

	/**
	 * Redirects a list of current users's profiles.
	 *
	 * @param model the model
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/photos", method = RequestMethod.GET)
	public String visitPhotoMenuItem(final Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		UserDTO userDTO = userFacade.getUserByUsername(userDetail.getUsername());
		ProfileDTO profileDTO = userDTO.getProfileDTO();

		model.addAttribute("photoDTO", new PhotoDTO());
		model.addAttribute("allThePhotos", photoFacade.getAllThePhotos(profileDTO.getProfileID()));
		model.addAttribute("homedir", System.getProperty("user.home").replaceAll("\\\\", "/"));

		return "/photos";
	}

	/**
	 * Uploads a photo.
	 *
	 * @param photoDTO             the dto
	 * @param file                 the MultipartFile file
	 * @param currenLoggedUserName the MultipartFile username
	 *
	 * @return photos url
	 */
	@RequestMapping(value = "/photos/photoupload/{currenLoggedUserName}", method = RequestMethod.POST)
	public String uploadPhoto(@ModelAttribute("photoDTO") final PhotoDTO photoDTO, @RequestParam("photo") final MultipartFile file,
	                          @PathVariable(value = "currenLoggedUserName") final String currenLoggedUserName)
	{
		UserDTO userDTO = userFacade.getUserByUsername(currenLoggedUserName);
		ProfileDTO profileDTO = userDTO.getProfileDTO();

		photoDTO.setProfileDTO(profileDTO);

		photoFacade.createPhoto(photoDTO, file);
		return "redirect:/photos";
	}

	/**
	 * Deletes a photo.
	 *
	 * @param photoID the id
	 *
	 * @return photos url
	 */
	@RequestMapping(value = "/photos/delete/{photoID}", method = RequestMethod.GET)
	public String deletePhoto(@PathVariable(value = "photoID") final String photoID)
	{
		PhotoDTO photoDTO = photoFacade.getById(Long.valueOf(photoID));
		photoFacade.deletePhoto(photoDTO);
		return "redirect:/photos";
	}

}