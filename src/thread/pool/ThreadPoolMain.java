package thread.pool;

public class ThreadPoolMain {

    public static void main(String[] args) {

        ThreadPool threadPool = new ThreadPool(3, 10);

        for (int i=0; i<10; i++) {
            int taskNo = i;
            threadPool.execute(() -> {
                String message = Thread.currentThread().getName()
                        + ": Task " + taskNo;
                System.out.println(message);
            });
        }

        threadPool.waitTillAllTasksFinished();
        threadPool.stop();
    }
}
