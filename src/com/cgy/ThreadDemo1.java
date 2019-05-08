package com.cgy;

/**
 * 测试线程join方法
 * @author chaigy
 *
 */
public class ThreadDemo1 {
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread= new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<=10;i++) {
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("我是子线程..."+Thread.currentThread().getName()+i);
				}
			}
		},"测试看看");
		thread.setDaemon(true);
		thread.start();
		//thread.join();
		for(int i=0;i<=10;i++) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("我是main线程..."+Thread.currentThread().getName()+i);
		}
		
		System.out.println("main线程执行完毕.....");
	}
}
