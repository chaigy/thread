package com.cgy.blockingqueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {

	public static void main(String[] args) {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		
		queue.add("����");
		queue.offer("����");
		queue.add("����");
		
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.size());
		
	}

}
