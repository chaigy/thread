package com.cgy.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"，在运行");
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
	//使用可缓存的线程池
	public static void cacheThreadPool(Runnable run){
		ExecutorService threadPool = Executors.newCachedThreadPool();
		for(int i=0;i<=5;i++) {
			threadPool.execute(run);	
		}
		
		threadPool.shutdown();
	}
	
	//使用固定长度的线程池
	public static void fixThreadPool(Runnable run){
		ExecutorService fixThreadPool = Executors.newFixedThreadPool(2);
		for(int i=0;i<=5;i++) {
			fixThreadPool.execute(run);
		}
		fixThreadPool.shutdown();
	}
	
	//使用可周期执行的线程
	public static void ScheduledThreadPool(Runnable run) {
		ScheduledExecutorService scheduledThreadPool
		= Executors.newScheduledThreadPool(2);
		//每秒执行一次
		scheduledThreadPool.scheduleWithFixedDelay(run, 0, 1000, TimeUnit.MILLISECONDS);
	}
	
	//使用单线程池来处理任务
	public static void singleThreadExecutor(Runnable run) {
		
		ExecutorService single = Executors.newSingleThreadExecutor();
		for(int i=0;i<=5;i++) {
			single.execute(run);
		}
		single.shutdown();
	}
	
}

