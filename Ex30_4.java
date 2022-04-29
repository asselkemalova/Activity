import java.util.concurrent.*;
       // Inside our main class, we defined sum and AddOne which implements Runnable so it could run on a thread.
       //  We will create a pool of 1000 threads and run them. Every thread will add 1 to our Integer.
       // We will run the program 10 times.
       // Here is our main class:
public class Ex30_4 {
    private static Integer sum = new Integer();
    public static void main(String[] args) {
        for(int j=0;j<10;j++) {
            sum=new Integer();
            ExecutorService executor = Executors.newFixedThreadPool(1000);
            for(int i = 0;i < 1000;i++){
                executor.execute(new AddOne());
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            System.out.println(sum.get());
        }
    }
    public static class AddOne implements Runnable{
        public void run() {
            sum.add(1);
        }

    }
    //First, we need to define our wrapper class
    public static class Integer {
        private int sum = 0 ;
        public void add(int x) {
            sum += x;
        }
        public int get(){
            return  sum;
        }
    }
}
