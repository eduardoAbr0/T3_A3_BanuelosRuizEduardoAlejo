import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer{
	private final ArrayBlockingQueue<Integer> buffer;
	
	public BlockingBuffer() {
		buffer = new ArrayBlockingQueue<Integer>(1);
	}

	@Override
	public void blockingPut(int value) throws InterruptedException {
		buffer.put(value);
		System.out.printf("%s%2d\t%s%d%n", "Productor escribe ", value,"Buffer células ocupadas: ", buffer.size());
		
	}

	@Override
	public synchronized int blockingGet() throws InterruptedException {
		int readValue = buffer.take();
		System.out.printf("%s %2d\t%s%d%n", "Consumidor lee ",readValue, "Buffer células ocupadas: ", buffer.size());
		return readValue;
	}
	
	
	
}
