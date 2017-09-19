package concurrency.lesson03;

import concurrency.lesson01.Utils;

import java.util.concurrent.atomic.AtomicLong;

public class Runner implements Runnable {

	private volatile boolean stop;

	AtomicLong count = new AtomicLong(0);

	@Override
	public void run() {
		while (!stop) {
			count.incrementAndGet();
		}
		System.out.println("stopped at " + count);
	}

	public void getStop() {
		stop = true;
	}

}
