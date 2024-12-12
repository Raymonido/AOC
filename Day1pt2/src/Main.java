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

        List<Integer> similarity = new ArrayList<>();
        for (int i = 0; i < firstlist.size(); i++) {
            if (secondlist.contains(firstlist.get(i))) {
                int countingelement = firstlist.get(i);
                int count = (int) secondlist.stream().filter(element ->
                        element.equals(countingelement)).count();
                similarity.add(firstlist.get(i) * count);
                System.out.println(count);
            }
        }
        System.out.println(similarity);
        int totaldifference = 0;
        for (Integer difference : similarity) {
            totaldifference += difference;
        }
        System.out.println(totaldifference);
    }
}