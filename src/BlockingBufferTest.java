import java.util.concurrent.*;

public class BlockingBufferTest {

	public static void main(String[] args) throws InterruptedException{
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		Buffer sharedLocation = new BlockingBuffer();
		
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);

	}

}
