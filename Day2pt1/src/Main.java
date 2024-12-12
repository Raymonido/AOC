import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
       File file = new File("/home/f04089/Projects/AOC/AOC/Day2pt1/input/input.txt");
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
        for (List<Integer> lineNumber : lineNumbers) {
            if (isValidLine(lineNumber)) {
                safe++;
            } else {
                System.out.println(lineNumber + "Ist nicht gut!");
            }
        }

        System.out.println(safe);
    }
    public static boolean isValidLine(List<Integer> line) {
        boolean isDescending = true;
        boolean isAscending = true ;
        for (int i = 0; i < line.size()-1; i++) {
            int diff = line.get(i + 1) - line.get(i);
            if (Math.abs(diff) > 3 || diff == 0) {
                return false;
            }
            if (diff > 0) {
                isDescending = false;
            }
            if (diff < 0) {
                isAscending = false;
            }
        }
        return isAscending || isDescending;
    }
}