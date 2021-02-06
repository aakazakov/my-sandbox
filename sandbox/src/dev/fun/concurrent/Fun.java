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
		
	}
	
}
