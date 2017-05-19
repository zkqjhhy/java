package com.jhhy.road.util;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;

public class CryptOperator {
	

	public static String encrypt(String message, String key){
		
		try {
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
			IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
	        byte[] encryptbyte = cipher.doFinal(message.getBytes());
	        return DatatypeConverter.printBase64Binary(encryptbyte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new String();
		}
	}
	
	public static String decrypt(String message,String key) throws Exception {


        //byte[] bytesrc =convertHexString(message);
		byte[] bytesrc = DatatypeConverter.parseBase64Binary(message);
       // Log.d("decrypt", bytesrc+"");
		try{
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
			IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
			cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
			byte[] retByte = cipher.doFinal(bytesrc);
			return new String(retByte);
		}catch(Exception e){
			e.printStackTrace();
			return new String();
		}
        
    }
}
