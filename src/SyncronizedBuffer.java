
public class SyncronizedBuffer implements Buffer {
	private int buffer = -1;
	private boolean occupied = false;

	@Override
	public synchronized void blockingPut(int value) throws InterruptedException {
		while (occupied) {
			System.out.println("Productor intenta escribir.");
			displayState("Buffer lleno. Productor espera.");
			wait();
		}

		buffer = value;

		occupied = true;

		displayState("Productor escribe " + buffer);

		notifyAll();
	}

	@Override
	public synchronized int blockingGet() throws InterruptedException {
		while (!occupied) {
			System.out.println("Consumidor intenta leer.");
			displayState("Buffer vacio. Consumidor espera.");
			wait();
		}

		occupied = false;

		displayState("Consumidor lee " + buffer);

		notifyAll();

		return buffer;
	}

	private synchronized void displayState(String operation) {
		System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
	}

}
