package org.penta.work.boostrap.port.utils;

import java.util.Base64;

public class EncryptionUtil {

	public static String encrypt(String salt) {
		
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedString = encoder.encodeToString(salt.getBytes());
		return encryptedString;
	}
	
	public static String decrypt(String encryptedString) {
		
		Base64.Decoder decoder = Base64.getDecoder();
		String decryptedString = new String(decoder.decode(encryptedString)); 
		return decryptedString;
	}
}
