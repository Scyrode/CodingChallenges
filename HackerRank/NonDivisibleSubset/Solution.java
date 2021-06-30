import java.io.*;
import java.math.*;
import java.security.*;
import java.security.KeyStore.Entry;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // create a map that its keys are the index of each element in list 's' and
        // initialise its value '(s.size() - 1)'. Then for each Integer in 's', add
        // it against every other Integer in the list and see if the result is
        // divisible by 'k' or not. If so, then subtract '1' from the value in the
        // map that corresponds to its index.
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < s.size(); i++) {
            map.put(i, s.size()-1);
        }

        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.size(); j++) {
                if (i != j) {
                    if ((s.get(i) + s.get(j)) % k == 0) {
                        map.replace(i, map.get(i), map.get(i) - 1);
                    }
                }
            }
        }

        // test
        System.out.println("index, successes");
        map.forEach((key, value) -> System.out.println("index: " + key + ", successes: " + value));

        Map<Integer, Integer> occurences = new HashMap<Integer, Integer>();
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (occurences.containsKey(entry.getValue())) {
                occurences.replace(entry.getValue(), occurences.get(entry.getValue()), occurences.get(entry.getValue()) + 1);
            } else {
                occurences.put(entry.getValue(), 1);
            }
        }

        // test
        System.out.println("maxSuccess, frequency");
        occurences.forEach((key, value) -> System.out.println("maxSuccess: " + key + ", frequency: " + value));

        int maxFrequency = Integer.MIN_VALUE;
        int successOfMaxFrequency = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : occurences.entrySet()) {
            if (entry.getValue() > maxFrequency && entry.getKey() < s.size()-1) {
                maxFrequency = entry.getValue();
                successOfMaxFrequency = entry.getKey();
            }
        }

        // test
        System.out.println("SuccessOfMaxFrequency: " + successOfMaxFrequency + ", MaxFrequency: " + maxFrequency);

        for (Map.Entry<Integer, Integer> entry : occurences.entrySet()) {
            if (entry.getKey() > successOfMaxFrequency) {
                maxFrequency += entry.getValue();
            }
        }

        return maxFrequency;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
