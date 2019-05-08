package com.cgy.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo extends Thread{

	private ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args) {
	new ReentrantLockDemo().start();
	}
	
	@Override
	public void run() {
		set();
	}
	
	public void get() {
		lock.lock();
		System.out.println("����get����....");
		lock.unlock();
	}
	
	public void set() {
		lock.lock();
		System.out.println("����set����...");
		get();
		lock.unlock();
	}

}
