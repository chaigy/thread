package com.cgy.blockingqueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;



class Thread01 extends Thread{
	private SynchronousQueue<String> queue ;
	Thread01(SynchronousQueue<String> queue){
		this.queue = queue;
	}
	@Override
	public void run() {
		int count=0;
		while(true) {
			try {
				TimeUnit.SECONDS.sleep(1L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("插入数据："+(++count));
			queue.add("name"+count);
		}
		
	}
}
/**
 * 使用SynchronousQueue 可以实现一遍插入一遍读的功能
 * 2019年5月8日
 * @author chaigy
 *
 */
public class SynchroizedQueueDemo {
	public static void main(String[] args) throws InterruptedException {
		SynchronousQueue<String> queue =new SynchronousQueue<>();
		new Thread01(queue).start();;
		while(true) {
			System.out.println("消费数据："+queue.take());
		}
	}
}
