package com.cgy.lx;


class ThreadDemo extends Thread{
	//停止标志  如果不加volatile 关键字，变量在内存中是不可见的，子线程会无限制的循环下去
	private volatile boolean flag =true;
	
	@Override
	public void run() {
		System.out.println("子线程开始工作....");
		while(flag) {
			
		}
		System.out.println("子线程结束工作......");
	}
	
	public void stop1(){
		this.flag =false;
	}
}

/**
 * 练习volatile关键字  内存可见  不能保证原子性
 * 2019年5月7日
 * @author chaigy
 *
 */
public class VolatileDemo {
	
	public static void main(String[] args) {
		//开始子线程
		ThreadDemo t1 = new ThreadDemo();
		t1.start();
		//主线程休眠两秒，去改变flag的 状态
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//这段代码是主线程在执行，所以一个主线程，一个子线程导致变量不可见，子线程不会停止下来
		//这个时候 我们需要加上volatile关键字就可以
		t1.stop1();
		System.out.println("主线程结束....");
	}
}
