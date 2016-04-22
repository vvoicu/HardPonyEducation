package tools;

import java.security.SecureRandom;

public class RandomStringGenerator {

	public static SecureRandom random = new SecureRandom();

	public static enum Mode {
		ALPHA, ALPHANUMERIC, NUMERIC, ALPHANUMERICLOWERCASE
	}

	public static String generateRandomString(int length, Mode mode) {

		StringBuffer buffer = new StringBuffer();
		String characters = "";

		switch (mode) {

		case ALPHA:
			characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			break;

		case ALPHANUMERIC:
			characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			break;

		case ALPHANUMERICLOWERCASE:
			characters = "abcdefghijklmnopqrstuvwxyz1234567890";
			break;

		case NUMERIC:
			characters = "1234567890";
			break;
		}

		int charactersLength = characters.length();

		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}

}