
public class UnsynchronizedBuffer implements Buffer{
	private int buffer = -1;

	@Override
	public void blockingPut(int value) throws InterruptedException {
		System.out.printf("Productor escribe\t%2d", value);
		buffer = value;
	}

	@Override
	public int blockingGet() throws InterruptedException {
		System.out.printf("Consumidor lee\t\t%2d", buffer);
		return buffer;
	}
	
}
