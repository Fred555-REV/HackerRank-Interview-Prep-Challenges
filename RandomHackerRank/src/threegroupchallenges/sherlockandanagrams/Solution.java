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
        int pairs = 0;
        for (int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            int freq = freqMap.get(letter);
            if (i + 1 < s.length() && freq > 1) {
                freqMap.put(letter, freq - 1);
                pairs++;
                // abcbapoia
                String substring = s.substring(i, s.indexOf(letter, i));
                String substring2 = s.substring(i+1,s.indexOf(letter,i));
                Arrays.sort(substring.toCharArray());
                Arrays.sort(substring2.toCharArray());
                if(substring.equals(substring2)){
                    pairs++;
                }
                //TODO prob makethis into a loop to check non-symmetrical anagrams
                // ifai iafi not checked, cdcd as well
                //
            }

        }
        return pairs;
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
