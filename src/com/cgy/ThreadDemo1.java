package com.cgy;

/**
 * �����߳�join����
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
					System.out.println("�������߳�..."+Thread.currentThread().getName()+i);
				}
			}
		},"���Կ���");
		thread.setDaemon(true);
		thread.start();
		//thread.join();
		for(int i=0;i<=10;i++) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("����main�߳�..."+Thread.currentThread().getName()+i);
		}
		
		System.out.println("main�߳�ִ�����.....");
	}
}
