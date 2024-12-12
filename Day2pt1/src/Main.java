import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
       File file = new File("/home/f04089/Projects/AOC/Day2pt1/input/input.txt");
        Scanner sc = new Scanner(file);
        List<List<Integer>> lineNumbers = new ArrayList<List<Integer>>();
        List<String> lines = new ArrayList<String>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            List<Integer> row = new ArrayList<>();
            String[] number = line.split(" ");
            for (String s : number) {
                row.add(Integer.parseInt(s));
            }
            lineNumbers.add(row);
        }
        int safe = 0;
        for (int i = 0; i < lineNumbers.size(); i++) {
            for (int j = 0; j < lineNumbers.get(i).size(); j++) {
                if (lineNumbers.get(i).get(j) < lineNumbers.get(i).get(j += 1) && lineNumbers.get(i).get(j) - lineNumbers.get(i).get(j += 1) <= 3) {
                    System.out.println(lineNumbers.get(i));
                    safe++;
                }

            }
        }
        System.out.println(safe);
    }
}