package com.cgy.lx;

import java.util.concurrent.CountDownLatch;

/**
 * 使用countDownLatch来实现，主线程在子线程结束之后再去执行，
 * 	1.使用join
 * 	2.使用wait/notify
 * 	3.使用countdownlatch
 * 2019年5月7日
 * @author chaigy
 *
 */
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		//初始化两个
		CountDownLatch cdl = new  CountDownLatch(2);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("我是子线程1...开始");
				cdl.countDown();
				System.out.println("我是子线程1...结束");
			}
		}).start();;
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("我是子线程2...开始");
				cdl.countDown();
				System.out.println("我是子线程2...结束");
			}
		}).start();;
		System.out.println("我是主线程.......开始");
		cdl.await();
		System.out.println("我是主线程.......结束");
		
		
		
		
		
		
		
	}

}
