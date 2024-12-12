import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/home/f04089/Projects/AOC/Day1/Files/file1.txt");
        Scanner scanner = new Scanner(file);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        List<Integer> firstlist = new ArrayList<>();
        for (int i = 0; i < list.size(); i += 2) {
            firstlist.add(list.get(i));
        }
        Collections.sort(firstlist);
        System.out.println(firstlist);


        List<Integer> secondlist = new ArrayList<>();
        for (int i = 1; i < list.size(); i += 2) {
            secondlist.add(list.get(i));
        }
        Collections.sort(secondlist);
        System.out.println(secondlist);

        List<Integer> differences = new ArrayList<>();
        for (int i = 0; i < firstlist.size(); i++) {
            differences.add(Math.abs(firstlist.get(i) - secondlist.get(i)));
        }
        System.out.println(differences);
        int totaldifference = 0;
        for (Integer difference : differences) {
            totaldifference += difference;
        }
        System.out.println(totaldifference);
    }
}