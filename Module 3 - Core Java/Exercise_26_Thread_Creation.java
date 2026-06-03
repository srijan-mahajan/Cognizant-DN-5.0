class MyThread implements Runnable {

    String message;

    MyThread(String message) {
        this.message = message;
    }

    public void run() {

        for(int i = 1; i <= 5; i++) {

            System.out.println(
                message + " : " + i
            );

            try {
                Thread.sleep(500);
            }
            catch(Exception e) {}
        }
    }
}

public class ThreadDemo {

    public static void main(String[] args) {

        Thread t1 =
            new Thread(
                new MyThread("Thread 1")
            );

        Thread t2 =
            new Thread(
                new MyThread("Thread 2")
            );

        t1.start();
        t2.start();
    }
}