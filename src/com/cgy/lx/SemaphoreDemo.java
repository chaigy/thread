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
		//获取剩余可使用的资源数
		int avaliablePermits = sp.availablePermits();
		if(avaliablePermits>0) {
			System.out.println("还有厕所:"+this.name);
		}else {
			System.out.println("没有厕所:"+this.name);
		}
		try {
			//申请资源	如果没有申请到就阻塞在这里
			sp.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("终于进来了："+this.name);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("我上完厕所了:"+this.name);
		//释放抢占的资源
		sp.release();
	}
	
}

/**
 * 使用semaphore来实现资源的抢占
 * 2019年5月7日
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
