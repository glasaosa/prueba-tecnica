package prueba.guillermo.user.application.service;

import org.springframework.util.DigestUtils;

class PasswordUtils {
	
	private PasswordUtils() { }

	public static String hashPassword(String password) {
		return DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
	}

}
