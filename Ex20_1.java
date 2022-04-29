
import java.io.*;
import java.security.InvalidParameterException;
import java.util.*;

public class Ex20_1 {
    public static void main(String[] args) throws Exception {
//week 10 коллекция очередь
        if (args.length != 1)
            throw new InvalidParameterException("Usage: W filename");
        File file = new File(args[0]);
        if (!file.isFile())
            throw new FileNotFoundException(file.getName() + " is not a file");
        PriorityQueue<String> pQueue = new PriorityQueue<>(1000, String.CASE_INSENSITIVE_ORDER);

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {

            String s;
            while ((s = in.readLine()) != null) {

                String[] words = getValidWords(s);
                for (String word : words) {
                    pQueue.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }

        while (pQueue.size() > 0) {
            System.out.println(pQueue.poll() );
        }

    }

    public static String[] getValidWords(String s) {
        s = s.replaceAll("[0-9]\\p{L}+", ""); //Удаляет любое слово, начинающееся с цифры
        s = s.replaceAll("\\s+", " "); //обрезает лишние пробелы " " до " "
        return s.split(" ");
    }

}