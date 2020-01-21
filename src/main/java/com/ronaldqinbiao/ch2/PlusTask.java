package com.ronaldqinbiao.ch2;

public class PlusTask implements Runnable {

	static volatile int i = 0;

	@Override
	public void run() {
		for (int k = 0; k < 10000; k++) {
			i++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new PlusTask());
			threads[i].start();
		}
		for (int i = 0; i < 10; i++) {
			threads[i].join();
		}
		System.out.println(i);
	}

}
