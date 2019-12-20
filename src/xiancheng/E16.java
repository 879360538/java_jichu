package xiancheng;

import java.util.*;

public class E16 {

	public static void main(String[] args) {
		List<Object>goods=new ArrayList<>();
		long start=System.currentTimeMillis();
		Thread thread1=new Thread(()->{
			int num=0;
			while(System.currentTimeMillis()-start<=30) {
				goods.add("商品" +num);
				System.out.println("生产商品"+num);
			}
		},"生产者");
		Thread thread2=new Thread(()->{
			int num=0;
			while(System.currentTimeMillis()-start<=30) {
				goods.remove("商品"+num);
				System.out.println("消费商品"+num);
			}
		},"消费者");
		thread1.start();
		thread2.start();
	}

}
