package com.java.fazalcode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.binary.Base64OutputStream;

/**
 * @author Tatarao voleti
 * @date   04-Dec-2013
 *
 */
public class Base64Encode {

	public static void main(String[] args) {
		
		String str="Hello world Sharan,How are you?";
		
		System.out.println("Source Data ********** "+str);
		
		byte enc[]=Base64.encodeBase64(str.getBytes());
		String baseEncode= new String(enc);
		
		System.out.println("Encoded Source Data ****** "+baseEncode);
		
		byte []dec=Base64.decodeBase64(baseEncode.getBytes());
		String baseDecode= new String(dec);
		
		System.out.println("Decoded Data ****** "+baseDecode);
		
		try {
			Base64OutputStream b= new Base64OutputStream(new FileOutputStream("some.txt"));
			b.write(str.getBytes());
			b.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis=new FileInputStream("some.txt");
			int len;
			byte fileData[]=new byte[1024];
			Base64InputStream b=new Base64InputStream(fis);
			String decodeFileDate="";
			while((len=b.read(fileData))!=-1)
			{
				for(int i=0;i<len;i++){
				    decodeFileDate = decodeFileDate+String.valueOf((char)fileData[i]);
				}
			}
			System.out.println("Decoded File Data ****** "+decodeFileDate);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
