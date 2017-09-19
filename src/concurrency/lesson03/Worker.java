package concurrency.lesson03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

public class Worker implements Executor {

	private Queue<Runnable> tasks = new LinkedList<>();

	private void process() {
		while (true) {
			Runnable task = null;
			synchronized (tasks) {
				while (tasks.isEmpty()) {
					try {
						tasks.wait();
					} catch (InterruptedException e) { //to deal with spurious wakeup
						e.printStackTrace();
					}
				}
				task = tasks.poll();
			}
			if (task != null) {
				task.run();
			}
		}
	}


	public Worker() {
		new Thread(this::process).start();
	}

	@Override
	public void execute(Runnable task) {
		synchronized (tasks)  {
			tasks.offer(task);
			tasks.notify();
		}
	}

}
