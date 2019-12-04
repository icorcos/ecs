package com.interfaceb2b.ecs.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtils {

	private static final SecureRandom RAND = new SecureRandom();
	private static final int ITERATIONS = 65536;
	private static final int KEY_LENGTH = 512;
	private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

	public static String encode(String value) throws UnsupportedEncodingException {
		Base64.Encoder e = Base64.getEncoder();
		return e.encodeToString(value.getBytes("utf-8"));
	}

	public static String decode(String encrypted) throws UnsupportedEncodingException {
		byte[] b = Base64.getDecoder().decode(encrypted);
		return new String(b, "utf-8");
	}

	public static Optional<String> generateSalt(final int length) {
		if (length < 1) {
			System.err.println("error in generateSalt: length must be > 0");
			return Optional.empty();
		}

		byte[] salt = new byte[length];
		RAND.nextBytes(salt);

		return Optional.of(Base64.getEncoder().encodeToString(salt));
	}

	public static Optional<String> hashPassword(String password, String salt) {
		char[] chars = password.toCharArray();
		byte[] bytes = salt.getBytes();

		PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

		Arrays.fill(chars, Character.MIN_VALUE);

		try {
			SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
			byte[] securePassword = fac.generateSecret(spec).getEncoded();
			return Optional.of(Base64.getEncoder().encodeToString(securePassword));

		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			System.err.println("Exception encountered in hashPassword()");
			return Optional.empty();

		} finally {
			spec.clearPassword();
		}
	}

	public static boolean verifyPassword(String password, String key, String salt) {
		Optional<String> optEncrypted = hashPassword(password, salt);
		if (!optEncrypted.isPresent()) {
			return false;
		}
			
		return optEncrypted.get().equals(key);
	}
	
	public static void main(String[] args) {
		//String salt = PasswordUtils.generateSalt(512).get();
		//System.out.println(salt);
		//String pwd = "Lakeshow32!";
		//String key = PasswordUtils.hashPassword(pwd, salt).get();
		//System.out.println(key);
		
		boolean result = PasswordUtils.verifyPassword("Lakeshow32!", "I0UK7SIEdNFgYL579i5Z8b+xZ80l2ldWQIbSeKeABYuJZJqFrFZZ95X7IBMgR2+8RaTrWSy4UcUPkHx55dQ4wQ==", "ydqsUCS2lh1sBf8ixhouzurkdu5SxB+utQCFGTxZYW4LO4aLOaDcN1/TCk3DBS315hqbyHk1p1F8ZFL3JrgU93t9twdkuguB4Ac5qnkDawvrED9ucL8WYUHj4Rv5wprTC/J4GzecxZTw1rhQHu1pn05KSde8WueKkxH4kmevHcubo1YoxxaRmmCsJa13XFMK+S8oA1E5pj+58IlaJ4/Da1Qa2zcHKVsNArRhxKW9TggUMabMnX4UkBRXDH7d1+WMAJtopGO2GAZKTlKjZ9Q7Akua6nFQdbaXfYXVgx3X+NcV03UIf+7DidvO+54OhIJ3pEw1883v2JiIEMm/UHSK7jLBoUCs+Uedtrm868I+3ZGgPRmFYjWm58tB1BwbhH6fwJbA4+RX9TUBm4vRtHijsM1ZBocisnA8Py6oV42flUk7rdLGzebYiEtaecCcPtKYrDqq6HRVCk9zY4s8PzGncGDr8R6GjuJW3EP9ixgogfpgfXn11m2urimlMzR3vJN3C7CBvsm/D+9wFSDreRRqxv7H5hZN7pyVNh587r9sF7w1SfmXxzfM/TzVBqftlJLOAaK4b4q9FuOsLpyFeUUQNQ5bLGA1/WKlP3eKZqIc0jEGwgeM9pT3O6S/bw4u1QXEuTY367sKI7Quozq8OZEBLnEdVlr2d12v7r75lY2otFk=");
		System.out.println("Password match: "+result);
	}

}
