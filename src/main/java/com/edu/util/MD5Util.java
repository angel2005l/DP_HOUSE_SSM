package com.edu.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public final class MD5Util {

	/**
	 * 获得密码密文
	 * @param Passwd
	 * @return
	 */
	public static final String getMD5EncryptPass(String Passwd, byte[] randomSalt) {
		// 加密密码
		String EncryptPass = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(randomSalt);
			md.update(Passwd.getBytes("utf-8"));
			EncryptPass = myEncoding(md.digest());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			System.err.println(e.getMessage());
			return "";
		} 
		// System.out.println(EncryptPass);
		return EncryptPass;
	}

	/**
	 * 生成随机盐值
	 * @return
	 */
	public static final String getRandomSalt() {
		byte[] salt = new byte[16];
		SecureRandom random = new SecureRandom();
		random.nextBytes(salt);
		return myEncoding(salt);
	}
	/**
	 * 
	 * @Title: check   
	 * @Description: 校验密码密文
	 * @param: @param str
	 * @param: @param salt
	 * @param: @param checkedStr
	 * @param: @return 
	 * @author: MR.H
	 * @return: boolean      
	 * @throws
	 */
	public static final boolean check(String str, String salt, String checkedStr) {
		if (checkedStr.equals(getMD5EncryptPass(str, salt.getBytes()))) {
			return true;
		}
		return false;
	}

	/**
	 * 对加密密文进行格式编码
	 * @param encoding
	 * @return
	 */
	private static final String myEncoding(byte[] encoding) {
		char hexDigits[] = {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		int encodeLength = encoding.length;
		char Encrytion[] = new char[encodeLength * 2];
		int indexEncryt = 0;
		for (int i = 0; i < encodeLength; i++) {
			byte byteTemp = encoding[i];
			Encrytion[indexEncryt++] = hexDigits[byteTemp >>> 4 & 0xf];
			Encrytion[indexEncryt++] = hexDigits[byteTemp & 0xf];
		}
		return String.valueOf(Encrytion);
	}

}
