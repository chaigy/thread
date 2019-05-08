package com.cgy.blockingqueue;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class PriorityQueueDemo {
	
	public static void main(String[] args) {
			PriorityQueue<String> queue  = new PriorityQueue<>();
			
			queue.add("����");
			queue.offer("����");
			queue.add("����");
			queue.offer("С��");
			

			System.out.println(queue.peek());
			System.out.println(queue.peek());
			System.out.println(queue.poll());
			System.out.println(queue.peek());
			System.out.println(queue.poll());
			System.out.println(queue.size());
	}
}
