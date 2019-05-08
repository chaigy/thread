package com.cgy;

/**
 * 测试重排序，但是并不容易测试出来
 * 下面四个步骤，如果1,2步骤发生了重排序，那么3,4的结果将会发生改变
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
		
		System.out.println("主线程结束...");
	}
	
	
	
}
