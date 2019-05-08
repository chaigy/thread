package com.cgy.lx;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 使用cyclicBarrier来实现多线程并发
 * 2019年5月7日
 * @author chaigy
 *
 */

class CyclicBarrierThread extends Thread{
	private CyclicBarrier cb;
	
	
	CyclicBarrierThread(CyclicBarrier cb){
		this.cb=cb;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+":::我是子线程.....开始");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			//每个线程执行到这一步的时候，如果没有达到预期的量，则不会往下执行
			cb.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}	
		System.out.println(Thread.currentThread().getName()+":::我是子线程.....结束"+cb.getNumberWaiting());
	}
}

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cb =new CyclicBarrier(5,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("我是cyclicBarrier到达预期值的时候，先执行的方法...");
			}
		});
		
		for(int i=0;i<6;i++) {
			new CyclicBarrierThread(cb).start();
		}
	}

}
