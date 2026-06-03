import java.util.concurrent.*;

public class ExecutorCallableDemo {

    public static void main(String[] args)
            throws Exception {

        ExecutorService service =
                Executors.newFixedThreadPool(3);

        Callable<Integer> task1 =
                () -> 10 + 20;

        Callable<Integer> task2 =
                () -> 30 + 40;

        Callable<Integer> task3 =
                () -> 50 + 60;

        Future<Integer> f1 =
                service.submit(task1);

        Future<Integer> f2 =
                service.submit(task2);

        Future<Integer> f3 =
                service.submit(task3);

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());

        service.shutdown();
    }
}