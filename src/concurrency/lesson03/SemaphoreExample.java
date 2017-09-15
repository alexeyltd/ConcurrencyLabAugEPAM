package concurrency.lesson03;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreExample {

	public static class Counter {

		private int count;
		private Semaphore sem = new Semaphore(1);

		public void inc() {
			sem.acquireUninterruptibly();
			try	{
				count++;
			} finally {
				sem.release();
			}

		}

		public int get() {
			sem.acquireUninterruptibly();
			try	{
				return count;
			} finally {
				sem.release();
			}

		}

	}

	public static void main(String[] args) {



	}

}
