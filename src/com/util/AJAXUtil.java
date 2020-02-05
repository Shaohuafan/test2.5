package com.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class AJAXUtil {
 public static void printString(HttpServletResponse response,String s){
	 response.setCharacterEncoding("utf-8");
	 try {
		PrintWriter out=response.getWriter();
		System.out.println("s:"+s);
		out.print(s);//Êä³ö
		out.flush();
		out.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
