package concurrency.lesson01;

public class ThreadStopExamples {

	public static X x = new X();

	public static void main(String[] args) {

		Thread thread = new Thread(() -> {
			ExecutorExample.Task task = new ExecutorExample.Task();
			while (!Thread.interrupted()) {
				x.change();
			}
			System.out.println("interrupted!");
		});

		thread.start();

		Utils.pause(5000);

		thread.interrupt();
	}

}

class X {

	private int x;
	private int y;

	public void change() {
		y += 100;
		x -= 100;
	}

}
