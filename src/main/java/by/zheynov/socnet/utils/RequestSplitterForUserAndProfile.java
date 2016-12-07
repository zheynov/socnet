package by.zheynov.socnet.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.ProfileFacade;
import by.zheynov.socnet.facade.UserFacade;

/**
 * RequestSplitter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service
 */
@Component()
public class RequestSplitterForUserAndProfile
{
	@Autowired
	private ProfileFacade profileFacade;
	@Autowired
	private UserFacade    userFacade;

	/**
	 * Recieves a String request and make a list of 2 objects.
	 *
	 * @param request the String request
	 *
	 * @return a map of two objects
	 */
	public List<Object> getUserDTOAndProfileDTO(final String request)
	{
		List<Object> result = new ArrayList<Object>();

		String[] twoValuesFromDeleteRequest = request.split("&");
		String currentLoggedUsername = twoValuesFromDeleteRequest[0];
		Long friendProfileId = Long.valueOf(twoValuesFromDeleteRequest[1]);

		UserDTO currentLoggedUserDTO = userFacade.getUserByUsername(currentLoggedUsername);
		ProfileDTO friendProfileDTO = profileFacade.getProfileById(friendProfileId);

		result.add(currentLoggedUserDTO);
		result.add(friendProfileDTO);

		return result;
	}
}