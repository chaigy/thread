package com.cgy.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueDemo {

	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueue<String> queue =new LinkedBlockingQueue<>();
		
		queue.add("张三");
		queue.offer("李四");
		queue.add("王五");
		queue.offer("小七", 2, TimeUnit.SECONDS);
		
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.size());
	}

}
