package com.cgy.lx;

import java.util.concurrent.Semaphore;

class Wc extends Thread{
	private String name;
	
	private Semaphore sp;
	
	Wc(String name,Semaphore sp){
		this.name=name;
		this.sp=sp;
	}
	
	@Override
	public void run() {
		//��ȡʣ���ʹ�õ���Դ��
		int avaliablePermits = sp.availablePermits();
		if(avaliablePermits>0) {
			System.out.println("���в���:"+this.name);
		}else {
			System.out.println("û�в���:"+this.name);
		}
		try {
			//������Դ	���û�����뵽������������
			sp.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("���ڽ����ˣ�"+this.name);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�����������:"+this.name);
		//�ͷ���ռ����Դ
		sp.release();
	}
	
}

/**
 * ʹ��semaphore��ʵ����Դ����ռ
 * 2019��5��7��
 * @author chaigy
 *
 */
public class SemaphoreDemo {
	public static void main(String[] args) {
		Semaphore sp =new Semaphore(2);
		for(int i=1;i<=10;i++) {
			new Wc("thread-"+i,sp).start();
		}
		
	}
}
