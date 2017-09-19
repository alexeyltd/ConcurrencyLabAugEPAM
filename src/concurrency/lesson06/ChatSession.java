package concurrency.lesson06;

import concurrency.lesson01.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class ChatSession {

	private static AtomicInteger counter = new AtomicInteger(0);

	private final Socket socket;
	private PrintWriter printWriter;
	private long delayMillis = 0;

	{
		int count = counter.incrementAndGet();

		if (count == 1) {
			delayMillis = 5000;
		}

	}


	public ChatSession(Socket socket) {
		this.socket = socket;
	}

	public void process(Consumer<String> broadCaster) {
		try {
			InputStream inputStream = socket.getInputStream();
			Scanner scanner = new Scanner(inputStream);

			OutputStream outputStream = socket.getOutputStream();

			printWriter = new PrintWriter(outputStream);

			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				System.out.println(line);
				broadCaster.accept(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String message) {
		Utils.pause(delayMillis);
		printWriter.println(">> " + message);
		printWriter.flush();
	}
}
