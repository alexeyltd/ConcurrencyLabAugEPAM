package concurrency.lesson01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

	public static class Task implements Runnable {

		private long millis;

		public Task() {
			this(1000);
		}

		public Task(long millis) {
			this.millis = millis;
		}

		@Override
		public void run() {
			Utils.pause(millis);
			System.out.println("hello!");
		}

	}

	public static void main(String[] args) {

		System.out.println("start");

//		ExecutorService service = Executors.newSingleThreadExecutor();
//		ExecutorService service = Executors.newFixedThreadPool(2);
		ExecutorService service = Executors.newCachedThreadPool();

		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());

		service.shutdown();

		System.out.println("finish");

	}

}
