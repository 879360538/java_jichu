package com.string;

public class E10 {

	public static void main(String[] args) {
		long startTime=System.currentTimeMillis();
		long sum=0;
		for(long i=0;i<10000000000l;i++) {
			sum+=i;
		}
		long endTime=System.currentTimeMillis();
		System.out.println("程序运行时间为:"+(endTime-startTime)+"毫秒");
	}

}
