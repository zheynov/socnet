package by.zheynov.socnet.service;

/**
 * Created by ZheynovVV on 27.10.2016.
 */
public class PasswordEncoding {
    // Passwqord encoding
    public static String encodePassword(String password) {
        return String.valueOf(password.hashCode() ^ 2);
    }
}
