package concurrency.lesson02;

import concurrency.lesson01.Utils;

public class StarvationExample {

	public static class Counter {

		private int count;
		private Object mutex = new Object();

		public void inc() {
			synchronized (mutex) {
				count++;
			}
		}

		public int get() {
			synchronized (mutex) {
				return count;
			}
		}

	}

	public static void main(String[] args) {

		Counter counter = new Counter();

		new Thread(() -> {
			while (true) {
				Utils.pause(1000);
				counter.inc();
			}
		}).start();

		new Thread(() -> {
			while (true) {
				Utils.pause(1500);
				System.out.println(counter.get());
			}
		}).start();

		Utils.pause(10000);

		synchronized (counter) {
			Utils.pause(1000000);
		}

	}



}
