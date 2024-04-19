import java.util.concurrent.*;

public class SyncronizedBufferTest {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		Buffer sharedLocation = new SyncronizedBuffer();
		
		System.out.printf("%-40s%s\t\t%s%n%-40s%s%n%n", "Operacion","Buffer", "Ocupado", "---------", "------\t\t--------");
		
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}

}
