package com.string;

public class stringBuffer {

	public static void main(String[] args) {
		String s1=new String("abc");
		String s2=new String("abc");
		System.out.println(s1.equals(s2));
		StringBuffer sb1=new StringBuffer("abc");
		StringBuffer sb2=new StringBuffer("abc");
		System.out.println(sb1.equals(sb2));
		
		String s11="a";
		String s22="b";
		String s3=s11+s22;
		System.out.println(s3);
		new StringBuffer("abc");
		new StringBuffer("abc");

	}

}
