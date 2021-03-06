package com.ronaldqinbiao.ch2;

public class DaemonDemo {
	public static class DaemonT extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.println("I am alive");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new DaemonT();
		t.setDaemon(true); // 设置守护线程必须在线程start之前。
		t.start();
		Thread.sleep(2000);
	}
}
