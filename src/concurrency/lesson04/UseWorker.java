package concurrency.lesson04;

import concurrency.lesson01.Utils;
import concurrency.lesson03.Worker;

public class UseWorker {

	public static void main(String[] args) {

		Worker worker = new Worker();

		worker.execute(() -> {
			Utils.pause(1000);
			System.out.println("hello, world!");
		});

		worker.execute(() -> {
			Utils.pause(1000);
			System.out.println("hello, world!");
		});

		worker.execute(() -> {
			Utils.pause(1000);
			System.out.println("hello, world!");
		});

	}

}
