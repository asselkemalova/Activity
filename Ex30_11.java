
public class Ex30_11 {
    public static void main(String[] args) {
        final String resource1 = "nkjn";
        final String resource2 = "lll";
        // t1 пытается заблокировать ресурс1, затем ресурс2
        Thread t1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1: заблокированный ресурс 1");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (resource2) {
                        System.out.println("Thread 1: заблокированный ресурс 2");
                    }
                }
            }
        };
        // t2 пытается заблокировать ресурс2, затем ресурс1
        Thread t2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2: заблокированный ресурс 2");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                    synchronized (resource1) {
                        System.out.println("Thread 2: заблокированный ресурс 1");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}

