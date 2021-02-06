package dev.fun.concurrent;

public class Fun {

	public static void main(String[] args) {
		
		PingPong pp = new PingPong();
		
		new Thread(() -> {
			while (true) {
				pp.ping();
			}
		}).start();
		
		new Thread(() -> {
			while (true) {
				pp.pong();
			}
		}).start();
		
//			Counter counter = new Counter();
//		
//			new Thread(() -> counter.add(2)).start();
//			new Thread(() -> counter.add(-2)).start();
//			new Thread(() -> counter.add(5)).start();
//			new Thread(() -> counter.add(-5)).start();
//			new Thread(() -> counter.add(1)).start();
//			new Thread(() -> counter.add(-1)).start();
//			new Thread(() -> counter.add(3)).start();
//			new Thread(() -> counter.add(-3)).start();
		
	}
	
}
