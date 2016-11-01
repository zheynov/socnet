package by.zheynov.socnet.validators;

/**
 * Email's validator class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.validators
 */

class EmailValidator
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
}
