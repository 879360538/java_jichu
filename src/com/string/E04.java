package com.string;

public class E04 {

	public static void main(String[] args) {
		String s=" http: // localhost:8080 ";
		System.out.println("去除字符串两端空格后的结果："+s.trim());
		System.out.println("去除字符串中所有空格后的结果:"+s.replace(" ",""));
		
	}

}
