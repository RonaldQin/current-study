package com.ronaldqinbiao.ch2;

public class JoinMain {
	public volatile static int i = 0;

	public static class AddThread extends Thread {
		@Override
		public void run() {
			for (i = 0; i < 1000000; i++)
				;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AddThread at = new AddThread();
		at.start();
		at.join(); // join()方法的本质是让调用线程wait()方法在当前线程对象实例上。当线程执行完成后，被等待的线程会在退出前调用 notifyAll()
					// 方法通知所有的等待线程继续执行。因此，值得注意的一点是：不要在应用程序中，在Thread对象实例上使用雷士wait()方法或者notify()方法等，因为这很有可能会影响系统API的工作，或者被系统API所影响。
		System.out.println(i);
	}
}
