package com.cgy.blockingqueue;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class PriorityQueueDemo {
	
	public static void main(String[] args) {
			PriorityQueue<String> queue  = new PriorityQueue<>();
			
			queue.add("张三");
			queue.offer("李四");
			queue.add("王五");
			queue.offer("小七");
			

			System.out.println(queue.peek());
			System.out.println(queue.peek());
			System.out.println(queue.poll());
			System.out.println(queue.peek());
			System.out.println(queue.poll());
			System.out.println(queue.size());
	}
}
