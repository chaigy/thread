package com.cgy.lx;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * ʹ��cyclicBarrier��ʵ�ֶ��̲߳���
 * 2019��5��7��
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
		System.out.println(Thread.currentThread().getName()+":::�������߳�.....��ʼ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			//ÿ���߳�ִ�е���һ����ʱ�����û�дﵽԤ�ڵ������򲻻�����ִ��
			cb.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}	
		System.out.println(Thread.currentThread().getName()+":::�������߳�.....����"+cb.getNumberWaiting());
	}
}

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cb =new CyclicBarrier(5,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("����cyclicBarrier����Ԥ��ֵ��ʱ����ִ�еķ���...");
			}
		});
		
		for(int i=0;i<6;i++) {
			new CyclicBarrierThread(cb).start();
		}
	}

}
