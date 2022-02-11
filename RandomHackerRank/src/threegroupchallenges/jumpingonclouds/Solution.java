package threegroupchallenges.jumpingonclouds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        for (int i = 0; i < c.length; i += k) {
            energy--;
            if (c[i] == 1) {
                energy -= 2;
            }
        }
        return energy;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        String[] nk = scan.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scan.nextLine().split(" ");
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        scan.close();
    }
}
