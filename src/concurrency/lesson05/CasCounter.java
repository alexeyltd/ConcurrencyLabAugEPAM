package concurrency.lesson05;

public class CasCounter {

	private SimulateCas value;

	public int getValue() {
		return value.get();
	}

	public int inc() {
		int v;
		do {
			v = value.get();
		} while (v != value.compareAndSwap(v, v + 1));
		return v + 1;
	}

}
