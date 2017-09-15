package concurrency.lesson01;

import java.util.concurrent.*;

public class CallableExample {

	public static void main(String[] args) {

		Callable<String> callable = () -> {
			Utils.pause(4000);
//			throw new Exception();
			return "hello";
		};

		ExecutorService service = Executors.newSingleThreadExecutor();

		Future<String> stringFuture = service.submit(callable);
		Future<String> stringFuture2 = service.submit(callable);

		System.out.println("task sent");

//		service.execute(() -> {
//			System.out.println("one more");
//		});

//		stringFuture2.cancel(false);

		try {
			String result = stringFuture.get();
			System.out.println(result);
			String result2 = stringFuture2.get();
			System.out.println(result2);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		service.shutdown();

	}

}
