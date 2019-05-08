package com.cgy.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"��������");
	}
	
}


public class ThreadPoolDemo {
	
	
	public static void main(String[] args) {
		MyThread thread = new MyThread();
//		cacheThreadPool(thread);
//		fixThreadPool(thread);
//		ScheduledThreadPool(thread);
		singleThreadExecutor(thread);
	}
	//ʹ�ÿɻ�����̳߳�
	public static void cacheThreadPool(Runnable run){
		ExecutorService threadPool = Executors.newCachedThreadPool();
		for(int i=0;i<=5;i++) {
			threadPool.execute(run);	
		}
		
		threadPool.shutdown();
	}
	
	//ʹ�ù̶����ȵ��̳߳�
	public static void fixThreadPool(Runnable run){
		ExecutorService fixThreadPool = Executors.newFixedThreadPool(2);
		for(int i=0;i<=5;i++) {
			fixThreadPool.execute(run);
		}
		fixThreadPool.shutdown();
	}
	
	//ʹ�ÿ�����ִ�е��߳�
	public static void ScheduledThreadPool(Runnable run) {
		ScheduledExecutorService scheduledThreadPool
		= Executors.newScheduledThreadPool(2);
		//ÿ��ִ��һ��
		scheduledThreadPool.scheduleWithFixedDelay(run, 0, 1000, TimeUnit.MILLISECONDS);
	}
	
	//ʹ�õ��̳߳�����������
	public static void singleThreadExecutor(Runnable run) {
		
		ExecutorService single = Executors.newSingleThreadExecutor();
		for(int i=0;i<=5;i++) {
			single.execute(run);
		}
		single.shutdown();
	}
	
}

