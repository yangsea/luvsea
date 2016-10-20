package com.ocean.common.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class UtilSignDigest {
	
	private static final String HEX_DIGITS = "0123456789abcdef";

//	private static String token;

	/**
	 * 校验请求的签名是否合法
	 * 
	 * 加密/校验流程： 1. 将token、timestamp、nonce三个参数进行字典序排序 2. 将三个参数字符串拼接成一个字符串进行sha1加密
	 * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean validate(String signature, String timestamp,
			String nonce) {
		// 1. 将token、timestamp、nonce三个参数进行字典序排序
		String token = getToken();
		String[] arrTmp = { token, timestamp, nonce };
		Arrays.sort(arrTmp);
		StringBuffer sb = new StringBuffer();
		// 2.将三个参数字符串拼接成一个字符串进行sha1加密
		for (int i = 0; i < arrTmp.length; i++) {
			sb.append(arrTmp[i]);
		}
		String expectedSignature = encrypt(sb.toString());
		// 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		if (expectedSignature.equals(signature)) {
			return true;
		}
		return false;
	}

	private static String getToken() {
		return "api";
	}

	private static String encrypt(String strSrc) {

		String strDes = null;

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");

			byte[] bt = strSrc.getBytes();
			digest.update(bt);
			strDes = toHexString(digest.digest());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return strDes;
	}
	
	private static String toHexString(byte[] v) {

	    StringBuilder sb = new StringBuilder(v.length * 2);

	    for (int i = 0; i < v.length; i++) {

	        int b = v[i] & 0xFF;

	        sb.append(HEX_DIGITS.charAt(b >>> 4)).append(HEX_DIGITS.charAt(b & 0xF));

	    }

	    return sb.toString();

	}



	/**
	 * 将字节数组转换成16进制字符串
	 * 
	 * @param b
	 * @return
	 */
	private static String byte2hex(byte[] b) {
		StringBuilder sbDes = new StringBuilder();
		String tmp = null;
		for (int i = 0; i < b.length; i++) {
			tmp = (Integer.toHexString(b[i] & 0xFF));
			if (tmp.length() == 1) {
				sbDes.append("0");
			}
			sbDes.append(tmp);
		}
		return sbDes.toString();
	}

	/**
	 * 获取签名
	 * 
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static String getSignature(long timestamp, int nonce) {
		// 1. 将token、timestamp、nonce三个参数进行字典序排序
		String token = getToken();
		String[] arrTmp = { token, timestamp + "", nonce + "" };
		Arrays.sort(arrTmp);
		StringBuffer sb = new StringBuffer();
		// 2.将三个参数字符串拼接成一个字符串进行sha1加密
		for (int i = 0; i < arrTmp.length; i++) {
			sb.append(arrTmp[i]);
		}
		String expectedSignature = encrypt(sb.toString());

		return expectedSignature;
	}
	
	public static void main(String[] args) {
        
	    long b = System.currentTimeMillis();
	    System.out.println(b);
	    String a = getSignature(b, 1);
	    System.out.println(a);
    }

    	

}
