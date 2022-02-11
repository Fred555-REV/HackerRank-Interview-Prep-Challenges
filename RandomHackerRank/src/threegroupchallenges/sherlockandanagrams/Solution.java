package threegroupchallenges.sherlockandanagrams;

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
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
/*
Test Cases

2
abba
abcd
4
0
2

2
ifailuhkqq
kkkk
3
10
 */

    public static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (String letter : s.split("")) {
            if (!freqMap.containsKey(letter)) {
                freqMap.put(letter, 1);
            } else {
                freqMap.put(letter, 1 + freqMap.get(letter));
            }
        }
        for (int i = 0; i < s.length(); i++) {

        }
        return 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int q = Integer.parseInt(scan.nextLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = scan.nextLine();

                int result = Result.sherlockAndAnagrams(s);

                System.out.println(result);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        scan.close();
    }
}
