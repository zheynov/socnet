package by.zheynov.socnet.controllers;

import java.util.Date;

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
import by.zheynov.socnet.dto.PostDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.PhotoFacade;
import by.zheynov.socnet.facade.PostFacade;
import by.zheynov.socnet.facade.ProfileFacade;
import by.zheynov.socnet.facade.UserFacade;

/**
 * PostController class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.controllers
 */

@Controller
public class PostController
{

	@Autowired
	private ProfileFacade profileFacade;

	@Autowired
	private UserFacade userFacade;

	@Autowired
	private PostFacade postFacade;

	private ProfileDTO senderProfileDTO;
	private ProfileDTO wallOwnerProfileDTO;

	/**
	 * Redirects user to welcomePage URL.
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/welcomePage", method = RequestMethod.GET)
	public String beforeVisitingWelcomePage(final Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();

		UserDTO userDTO = userFacade.getUserByUsername(userDetail.getUsername());
		ProfileDTO profileDTO = userDTO.getProfileDTO();
		senderProfileDTO = profileDTO;

		model.addAttribute("allThePosts", postFacade.getAllThePosts(profileDTO.getProfileID()));
		model.addAttribute("postDTO", new PostDTO());
		return "/welcome";
	}

	/**
	 * Shows a list of users for post
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/posts/showusers", method = RequestMethod.GET)
	public String showUsersBeforePost(final Model model)
	{
		model.addAttribute("allTheProfiles", profileFacade.getAllTheProfiles());
		return "/posts/postforallpeople";
	}

	/**
	 * Sends a post for chosen user
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/posts/makeapost/{profileID}", method = RequestMethod.GET)
	public String initiateAPost(final Model model, @PathVariable("profileID") final String profileID)
	{
		ProfileDTO wallOwnerProfileDTO = profileFacade.getProfileById(Long.valueOf(profileID));
		this.wallOwnerProfileDTO = wallOwnerProfileDTO;

		PostDTO postDTO = new PostDTO();
		postDTO.setSenderProfileDTO(senderProfileDTO);
		postDTO.setWallOwnerProfileDTO(wallOwnerProfileDTO);

		model.addAttribute("postDTO", postDTO);
		return "/posts/sendpost";
	}

	/**
	 * makes a post.
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/posts/sendapost", method = RequestMethod.POST)
	public String makePost(@ModelAttribute("postDTO") final PostDTO postDTO, @RequestParam("photo") final MultipartFile file)
	{
		postDTO.setSenderProfileDTO(senderProfileDTO);
		postDTO.setWallOwnerProfileDTO(wallOwnerProfileDTO);
		postDTO.setPostDate(new Date());

		postFacade.createPost(postDTO, file);


		return "redirect:/welcomePage";
	}

	/**
	 * makes a post to myself.
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/posts/sendaposttomyself", method = RequestMethod.POST)
	public String makePostToMyself(@ModelAttribute("postDTO") final PostDTO postDTO, @RequestParam("photo") final MultipartFile file)
	{
		postDTO.setSenderProfileDTO(senderProfileDTO);
		postDTO.setWallOwnerProfileDTO(senderProfileDTO);
		postDTO.setPostDate(new Date());
		postFacade.createPost(postDTO, file);
		return "redirect:/welcomePage";
	}

	/**
	 * makes a post.
	 *
	 * @return the URL
	 */
	@RequestMapping(value = "/posts/deleteapost/{postID}", method = RequestMethod.GET)
	public String deletePost(@PathVariable("postID") final String postID)
	{
		PostDTO postToDelete = postFacade.getById(Long.valueOf(postID));
		postFacade.deletePost(postToDelete);

		return "redirect:/welcomePage";
	}

}