package com.cgy.lx;

import java.util.concurrent.CountDownLatch;

/**
 * ʹ��countDownLatch��ʵ�֣����߳������߳̽���֮����ȥִ�У�
 * 	1.ʹ��join
 * 	2.ʹ��wait/notify
 * 	3.ʹ��countdownlatch
 * 2019��5��7��
 * @author chaigy
 *
 */
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		//��ʼ������
		CountDownLatch cdl = new  CountDownLatch(2);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("�������߳�1...��ʼ");
				cdl.countDown();
				System.out.println("�������߳�1...����");
			}
		}).start();;
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("�������߳�2...��ʼ");
				cdl.countDown();
				System.out.println("�������߳�2...����");
			}
		}).start();;
		System.out.println("�������߳�.......��ʼ");
		cdl.await();
		System.out.println("�������߳�.......����");
		
		
		
		
		
		
		
	}

}
