package com.hotel.test;

public class demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		demo2.t1("1","2");
		demo2.t1("1","2","3");
		demo2.t1("1","2","3","4");
		demo2.t1("1");
	}
	
	public static void t1(String ...args) {
		for(String a:args) {
			System.out.println(a);
		}
	}

}
