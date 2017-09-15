package concurrency.lesson03;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreRegulator {

	public static final Random random = new Random();
	private static final int MAX = 1_000_000;

	public static double[] generate() {
		double[] data = new double[MAX];
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextDouble();
		}
		return data;
	}

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(2);

		Semaphore semaphore = new Semaphore(4);

		while (true) {
			double[] data = generate();
			semaphore.acquireUninterruptibly();
			service.submit(() -> {
				double sum = 0;
				for (int i = 0; i < data.length; i++) {
					sum += data[i];
				}
				semaphore.release();
			});

		}

	}

}
