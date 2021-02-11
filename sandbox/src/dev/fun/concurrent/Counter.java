package dev.fun.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	
	private final ReentrantLock lock;
	
	private int value;
	
	public int getValue() {
		return value;
	}
	
	public Counter() {
		lock = new ReentrantLock();
		value = 0;
	}
	
	public void add(int n) {
		try {
			lock.lock();
			value += n;
		} finally {
			lock.unlock();
		}
	}

}
