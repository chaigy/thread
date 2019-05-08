package com.cgy;

public class TestEnveriment {
	public static void main(String[] args) {
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		
		System.out.println(availableProcessors);
	}
}
