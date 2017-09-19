package concurrency.lesson03;

import concurrency.lesson01.Utils;

public class RunnerExample {

	public static void main(String[] args) {

		System.out.println("start");

		Runner runner = new Runner();

		new Thread(runner).start();

		Utils.pause(5000);

		runner.getStop();

	}


}
