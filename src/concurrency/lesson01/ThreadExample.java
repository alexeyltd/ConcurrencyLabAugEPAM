package concurrency.lesson01;

public class ThreadExample {

	public static void main(String[] args) {

		Thread thread = new Thread() {
			@Override
			public void run() {
				System.out.println("Hello World!");
			}
		};

		thread.start();

		Runnable task = () -> {
			System.out.println("hello!");
		};

		thread = new Thread(task);

		thread.start();

	}

}
