package by.zheynov.socnet.validators;

/**
 * Email's validator class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.validators
 */

class FieldsValidator
{
	/**
	 * Cheks user's email.
	 *
	 * @param email the email
	 *
	 * @return true if email matches the email format, otherwise false
	 */
	static boolean isValidEmailAddress(final String email)
	{
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\." +
						"[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * Validates date format.
	 *
	 * @param date the date
	 *
	 * @return true if date matches date format, otherwise false
	 */
	static boolean isValidDateFormat(final String date)
	{
		//date format: 		yyyy-MM-dd:
		String ePattern = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(date);
		return m.matches();
	}

	/**
	 * Validates name format.
	 *
	 * @param anyName the name
	 *
	 * @return true if name matches name format, otherwise false
	 */
	static boolean isValidNameFormat(final String anyName)
	{
		//name starts with a letter
		String ePattern = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(anyName);
		return m.matches();
	}

	/**
	 * Validates phone format.
	 *
	 * @param phone the phone
	 *
	 * @return true if phone matches phone format, otherwise false
	 */
	static boolean isValidPhone(final String phone)
	{
		//name starts with a letter
		String ePattern = "/\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})/";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(phone);
		return m.matches();
	}

}
