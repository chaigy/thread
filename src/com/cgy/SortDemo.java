package com.cgy;

/**
 * ���������򣬵��ǲ������ײ��Գ���
 * �����ĸ����裬���1,2���跢������������ô3,4�Ľ�����ᷢ���ı�
 * @author chaigy
 *
 */
public class SortDemo {
	private  static int a = 0;
		
	private static  boolean flag=false;
	public static void main(String[] args) {
	
		new Thread(new Runnable() {
			@Override
			public void run() {
				flag=true;//1
				a=1;//2
				
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				if(flag) {//3
				System.out.println(a);//4	
				}
				
			}
		}).start();
		
		System.out.println("���߳̽���...");
	}
	
	
	
}
