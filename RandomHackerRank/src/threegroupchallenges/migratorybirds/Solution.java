package threegroupchallenges.migratorybirds;
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

class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int bird : arr) {
            if(!map.containsKey(bird)){
                map.put(bird, 1);
            } else {
                map.put(bird, 1+map.get(bird));
            }
        }
        int answer = 0;
        for (int bird : map.keySet()) {
            if(answer == 0 || map.get(bird) > map.get(answer)){
                answer = bird;
            }
        }
        return answer;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int arrCount = Integer.parseInt(scan.nextLine().trim());

        List<Integer> arr = Stream.of(scan.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.migratoryBirds(arr);

       scan.close();
    }
}
