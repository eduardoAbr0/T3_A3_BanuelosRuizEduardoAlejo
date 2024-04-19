import java.util.concurrent.*;

public class SharedBufferTest {
	public static void main(String[] args) throws InterruptedException{
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		Buffer sharedLocation = new UnsynchronizedBuffer();
		
		System.out.println("Accion\t\t\tValor\tSuma de lo producido\tSuma de lo consumido");
		System.out.printf("------\t\t\t-----\t---------------------\t--------------------%n%n");
		
		executorService.execute(new Producer(sharedLocation));
		executorService.execute(new Consumer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}
}
