package com.cgy.lx;


class ThreadDemo extends Thread{
	//ֹͣ��־  �������volatile �ؼ��֣��������ڴ����ǲ��ɼ��ģ����̻߳������Ƶ�ѭ����ȥ
	private volatile boolean flag =true;
	
	@Override
	public void run() {
		System.out.println("���߳̿�ʼ����....");
		while(flag) {
			
		}
		System.out.println("���߳̽�������......");
	}
	
	public void stop1(){
		this.flag =false;
	}
}

/**
 * ��ϰvolatile�ؼ���  �ڴ�ɼ�  ���ܱ�֤ԭ����
 * 2019��5��7��
 * @author chaigy
 *
 */
public class VolatileDemo {
	
	public static void main(String[] args) {
		//��ʼ���߳�
		ThreadDemo t1 = new ThreadDemo();
		t1.start();
		//���߳��������룬ȥ�ı�flag�� ״̬
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//��δ��������߳���ִ�У�����һ�����̣߳�һ�����̵߳��±������ɼ������̲߳���ֹͣ����
		//���ʱ�� ������Ҫ����volatile�ؼ��־Ϳ���
		t1.stop1();
		System.out.println("���߳̽���....");
	}
}
