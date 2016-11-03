package by.zheynov.socnet.validators;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import by.zheynov.socnet.dto.ProfileDTO;

/**
 * ProfileFieldsValidator.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.validators
 */
@Component("profileValidator")
public class ProfileFieldsValidator implements Validator
{
	private static final int CITY_MAX_LENGTH = 30;

	/**
	 * Determines if ProfileDTO.class represented by aClass.
	 *
	 * @param aClass the class
	 *
	 * @return boolean value
	 */
	public boolean supports(final Class<?> aClass)
	{
		return ProfileDTO.class.isAssignableFrom(aClass);
	}

	/**
	 * Validates entered data from profile fileds.
	 *
	 * @param targret the targret
	 * @param errors  the errors
	 */
	public void validate(final Object targret, final Errors errors)
	{
		final ProfileDTO profileDTO = (ProfileDTO) targret;

		final String firstname = profileDTO.getFirstname();
		final String lastname = profileDTO.getLastname();
		final String email = profileDTO.getEmail();
		final String city = profileDTO.getCity();
		final String sex = profileDTO.getSex();
		final String phoneNumber = profileDTO.getPhoneNumber();
		final Date birthDate;

		if (!StringUtils.isEmpty(firstname) && !FieldsValidator.isValidNameFormat(firstname))
		{
			errors.rejectValue("firstname", "profile.page.field.text.name", "Incorrect name format.");
		}

		if (!StringUtils.isEmpty(lastname) && !FieldsValidator.isValidNameFormat(lastname))
		{
			errors.rejectValue("lastname", "profile.page.field.text.name", "Incorrect name format.");
		}

		if (!StringUtils.isEmpty(email) && !FieldsValidator.isValidEmailAddress(email))
		{
			errors.rejectValue("email", "registration.page.text.validation.emailisnotcorrect", "Email isn't valid");
		}

		if (!StringUtils.isEmpty(phoneNumber) && !FieldsValidator.isValidPhone(phoneNumber))
		{
			errors.rejectValue("phoneNumber", "profile.page.field.text.phonenumber", "phoneNumber isn't valid");
		}

		if (profileDTO.getAge() != null)
		{
			if ((profileDTO.getAge() < 0 || profileDTO.getAge() > 160))
			{
				errors.rejectValue("age", "profile.page.field.text.age", "age format isn't valid");
			}
		}

		else if (!StringUtils.isEmpty(city) && (city.length() > CITY_MAX_LENGTH))

		{
			errors.rejectValue("city", "profile.page.field.text.city", "City name is too long");
		}

		if (profileDTO.getBirthDate() != null)
		{
			birthDate = profileDTO.getBirthDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = dateFormat.format(birthDate);

			if (!FieldsValidator.isValidDateFormat(dateString) && !dateString.equals(""))
			{
				errors.rejectValue("birthDate", "profile.page.field.text.birthDate", "Incorrect birthdate");
			}
		}

	}
}