package xiancheng;

import java.util.concurrent.*;

class Mythread4 implements Callable<Object>{
	
	@Override
	public Object call() throws Exception {
		int i=0;
		while(i++<5) {
			System.out.println(Thread.currentThread().getName()+"的call()方法在运行");
		}
		return i;
	}
	
}

public class E18 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Mythread4 mythread4=new Mythread4();
		ExecutorService executor =Executors.newCachedThreadPool();
		Future<Object>result1=executor.submit(mythread4);
		Future<Object>result2=executor.submit(mythread4);
		executor.shutdown();
		System.out.println("thread-1返回结果:"+result1.get());
		System.out.println("thread-2返回结果:"+result2.get());
	}

}
