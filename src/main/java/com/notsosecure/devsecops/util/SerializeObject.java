package com.notsosecure.devsecops.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.notsosecure.devsecops.model.StudentSer;

public class SerializeObject {

	public static String objectToString(Serializable o) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(o);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Base64Utils.encode(baos.toByteArray());
	}

	public static Object stringToObject(String s) {

	 	return new StudentSer("goku");

	}

	public static void deserializeCookie(HttpServletRequest servletRequest) {
		Cookie[] cookies = null ;
		cookies = servletRequest.getCookies();
		if(cookies != null)
		for(Cookie cookie:cookies) {
			if(cookie.getName().equalsIgnoreCase("user")) {
				// StudentSer stu = (StudentSer)SerializeObject.stringToObject(cookie.getValue());
				// System.out.println(stu.getUsername());
			}
		}

	}


}
