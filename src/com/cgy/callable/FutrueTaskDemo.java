package com.cgy.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class T1 implements Callable<String>{

	@Override
	public String call() throws Exception {
		Thread.sleep(1500);
		return "我是线程1的结果";
	}
	
}

class T2 implements Callable<String>{

	@Override
	public String call() throws Exception {
		Thread.sleep(3000);
		return "我是线程2的结果";
	}
	
}

public class FutrueTaskDemo {

	public static void main(String[] args) {
			long start = System.currentTimeMillis();
			FutureTask<String> f1 =new FutureTask<>(new T1());
			FutureTask<String> f2 =new FutureTask<>(new T2());
			new Thread(f1).start();
			new Thread(f2).start();
			
			try {
				String v1 = f1.get();
				String v2 = f2.get();
				
				System.out.println("v1:"+v1+",v2:"+v2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			long end = System.currentTimeMillis();
			
			System.out.println(end-start);
			
			
	}

}
