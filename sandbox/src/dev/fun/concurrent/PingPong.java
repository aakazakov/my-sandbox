package dev.fun.concurrent;

public class PingPong {
	
	private boolean flag;
	
	public synchronized void ping() {
		while (flag) {
			try {
				Thread.sleep(1000);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}		
		System.out.println("ping ");
		flag = true;
		notifyAll();
	}
	
	public synchronized void pong() {
		while (!flag) {
			try {
				Thread.sleep(1000);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			} 
		}
		System.out.println("pong ");
		flag = false;
		notifyAll();
	}
	
}
