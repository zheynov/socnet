package by.zheynov.socnet.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.RestObject;
import by.zheynov.socnet.facade.ProfileFacade;

/**
 * RestUserController class.
 *
 * @author Vadim Zheynov <walder@tut.by>
 * @package by.zheynov.socnet.controllers
 */
@RestController
@RequestMapping("userprofile")
public class RestUserController
{
	@Autowired
	private ProfileFacade profileFacade;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public RestObject getProfileInJSON(@PathVariable Long id)
	{
		RestObject restObject = getRestObject(profileFacade.getProfileById(id));

		return restObject;
	}

	@RequestMapping(value = "/{id}.xml", method = RequestMethod.GET, produces = "application/xml; charset=UTF-8")
	public RestObject getProfileInXML(@PathVariable Long id)
	{
		return getRestObject(profileFacade.getProfileById(id));
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<RestObject> getProfileInJSON()
	{
		List<RestObject> result = new ArrayList<>();

		profileFacade.getAllTheProfiles().stream().map(this::getRestObject).forEach(result::add);

		return result;
	}



	private RestObject getRestObject(ProfileDTO profileDTO)
	{
		RestObject restObject = new RestObject();

		restObject.setProfileID(profileDTO.getProfileID());
		restObject.setBirthDate(profileDTO.getBirthDate());
		restObject.setCity(profileDTO.getCity());
		restObject.setEmail(profileDTO.getEmail());
		restObject.setAge(profileDTO.getAge());
		restObject.setFirstname(profileDTO.getFirstname());
		restObject.setLastname(profileDTO.getLastname());
		restObject.setPhoneNumber(profileDTO.getPhoneNumber());
		restObject.setSex(profileDTO.getSex());

		return restObject;
	}

}