package multithreading.runnable;

public class ExampleOne {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("We are now in new thread: " + Thread.currentThread().getName());
            System.out.println("Priority: " + Thread.currentThread().getPriority());
        });

        thread.setName("New Worker Thread");

        thread.setUncaughtExceptionHandler((thread1, throwable)
                -> System.out.println("Error:  " + thread1.getName() + throwable.getMessage()));

        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");

        thread.start();

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");

    }
}
