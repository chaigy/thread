package com.cgy.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueDemo {

	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueue<String> queue =new LinkedBlockingQueue<>();
		
		queue.add("����");
		queue.offer("����");
		queue.add("����");
		queue.offer("С��", 2, TimeUnit.SECONDS);
		
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.size());
	}

}
