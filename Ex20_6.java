
import java.util.Iterator;
import java.util.LinkedList;
public class Ex20_6 {
    static Integer size = 5000000;
    private static final boolean Print = false;
    public static void main(String[] args) {
        LinkedList<Integer> testList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            testList.add(i);
        }
        System.out.println("Start Iterator test");
        double time1 = testIterator(testList);
        System.out.println("\nIterator completed in " + time1 + " seconds.");

        System.out.println("Start get method iteration test");
        double time2 = getIndex(testList);
        System.out.println("Get method iteration completed in " + time2 + " seconds.");
    }
    static double testIterator(LinkedList<Integer> list) {
        Iterator<Integer> listIterator = list.iterator();
        long startTime = System.currentTimeMillis();
        while (listIterator.hasNext()) {
            Integer i = listIterator.next();
            if (Print) {
                System.out.println(i + " ");
            }
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        return time / 1000.00;
    }

    static double getIndex(LinkedList<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            Integer j = list.get(i);
            if (Print) {
                System.out.println(j + " ");
            }
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        return time / 1000.00;
    }
}