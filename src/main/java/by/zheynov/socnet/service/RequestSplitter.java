package by.zheynov.socnet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.ProfileFacade;
import by.zheynov.socnet.facade.UserFacade;

/**
 * .
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service
 */
@Component
public class RequestSplitter
{
	@Autowired
	private static ProfileFacade profileFacade;
	@Autowired
	private static UserFacade    userFacade;

	/**
	 * Recieves a String request and make alist of 2 objects.
	 *
	 * @param request the String request
	 *
	 * @return a map of two objects
	 */
	public static List<Object> getUserDTOAndProfileDTO(final String request)
	{
		List<Object> result = new ArrayList<Object>();

		String[] twoValuesFromDeleteRequest = request.split("&");
		String currentLoggedUsername = twoValuesFromDeleteRequest[0];
		String friendProfileId = twoValuesFromDeleteRequest[1];

		UserDTO currentLoggedUserDTO = userFacade.getUserByUsername(currentLoggedUsername);
		ProfileDTO friendProfileDTO = profileFacade.getProfileById(Long.valueOf(friendProfileId));

		result.add(currentLoggedUserDTO);
		result.add(friendProfileDTO);

		return result;
	}
}