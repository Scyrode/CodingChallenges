import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        String dayOfProgrammer = "";
        if (year < 1918) {
            if (year % 4 == 0) {
                dayOfProgrammer = "12.09." + Integer.toString(year);
            } else {
                dayOfProgrammer = "13.09." + Integer.toString(year);
            }
        } else if (year == 1918) {
            int day = 12 + 13;
            if (year % 4 == 0) {
                dayOfProgrammer = Integer.toString(day) + ".09." + Integer.toString(year);
            } else {
                dayOfProgrammer = Integer.toString(day+1) + ".09." + Integer.toString(year);
            }
        } else {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                dayOfProgrammer = "12.09." + Integer.toString(year);
            } else {
                dayOfProgrammer = "13.09." + Integer.toString(year);
            }
        }

        return dayOfProgrammer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
