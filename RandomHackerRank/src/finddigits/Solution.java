package finddigits;

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
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int findDigits(int n) {
        // Write your code here
        int count = 0;
        String s = Integer.toString(n);
        for(String digit : s.split("")){
            int num = Integer.parseInt(digit);
            if(num==0){
                continue;
            }
            if(n%num==0){
                count++;
            }
        }
        return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int t = Integer.parseInt(scan.nextLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(scan.nextLine().trim());

                int result = Result.findDigits(n);

                System.out.println(result);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        scan.close();
    }
}
