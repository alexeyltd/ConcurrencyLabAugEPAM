package concurrency.lesson01;

public class Utils {

	public static void pause(long millis) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
