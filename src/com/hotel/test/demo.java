package com.hotel.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class demo {
	public static void main(String[] args) {
		String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
		Long currentmill = System.currentTimeMillis();
		System.out.println(currentDate);
		System.out.println(currentmill+ "   "+currentDate+currentmill%100);
		System.out.println(Integer.MAX_VALUE);
		String id = "";
		//员工id每天不能多于100个
		do {
			id = new SimpleDateFormat("yyyyMMdd").format(new Date()) + System.currentTimeMillis()%100; 
		}while(false);
		System.out.println(id);
		
		String te = null ;
		if(te==null) {
			System.out.println("11111");
		}
	}
}
