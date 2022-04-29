import java.util.*;
public class Ex21_1 {
    public static void main(String[] args) {
        LinkedHashSet<String> n1 = new LinkedHashSet<>();
        LinkedHashSet<String> n2 = new LinkedHashSet<>();
        n1.add("Assel");
        n1.add("Gaukhar");
        n1.add("Gulnaz");
        n2.add("Assel");
        n2.add("Nurdana");
        n2.add("Samal");
        n2.add("Gulnaz");
        LinkedHashSet<String> lhs1 = new LinkedHashSet<>();
        lhs1.addAll(n1);
        LinkedHashSet<String> lhs2 = new LinkedHashSet<>();
        lhs2.addAll(n2);

        n1.addAll(n2);
        System.out.println("Union: " + n1);

        LinkedHashSet<String> copyNames1 = new LinkedHashSet<String>(lhs1);
        copyNames1.retainAll(n2);
        System.out.println("Intersection: " + copyNames1);

        n1.removeAll(copyNames1);
        System.out.println("Difference: " + n1);
    }

}