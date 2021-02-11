package dev.fun.concurrent;

public class PingPong {
	
	private boolean flag;
	
	public synchronized void ping() {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		System.out.println("ping ");
		flag = true;
		notifyAll();
	}
	
	public synchronized void pong() {
		while (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		System.out.println("pong ");
		flag = false;
		notifyAll();
	}
	
}
