package com.cgy.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {
	
	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
		
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
