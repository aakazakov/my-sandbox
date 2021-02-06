package dev.fun.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	
	private final ReentrantLock lock = new ReentrantLock();
	
	private int value;
	
	public void add(int n) {
		lock.lock();
		value += n;
		System.out.println(value);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		lock.unlock();
	}

}
