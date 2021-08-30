import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        new Thread(() -> System.out.println("different thread..." + Thread.currentThread().getName())).start();
        executorService.submit(() -> System.out.println("different executor..." + Thread.currentThread().getName()));
        executorService.shutdown();
        CompletableFuture<String> completableFuture = CompletableFuture
                                .supplyAsync(() -> "In completable future..." + Thread.currentThread().getName());
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
