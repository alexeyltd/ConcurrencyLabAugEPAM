package concurrency.lesson02;

import concurrency.lesson01.Utils;

public class RaceConditionExample {

	public static int count;
	public static Object mutes = new Object();

	public static class Counter implements Runnable {

		private static final int MAX = 20;

		@Override
		public void run() {
			for (int i = 0; i < MAX; i++) {
				Utils.pause(1000);
				synchronized (Counter.class) {
					count++;
				}
				System.out.println(count);
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		Thread thread1 = new Thread(new Counter());
		thread1.start();
		Thread thread2 = new Thread(new Counter());
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println(count);

	}

}
