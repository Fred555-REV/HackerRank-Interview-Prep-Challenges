package balancedBrackets;

import java.io.*;
import java.math.*;
import java.nio.charset.StandardCharsets;
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
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '{' || current == '[' || current == '(') {
                if (i == s.length() - 1) {
                    return "NO";
                }
                stack.push(current);
            } else {
                if(stack.isEmpty()){
                    return "NO";
                }
                switch (current) {
                    case ']':
                        if (stack.pop() != '[') {
                            return "NO";
                        }
                        break;
                    case '}':
                        if (stack.pop() != '{') {
                            return "NO";
                        }
                        break;
                    case ')':
                        if (stack.pop() != '(') {
                            return "NO";
                        }
                        break;
                    default:
                        return "INVALIDCHARACTER";
                }
            }
        }
        // Write your code here
        if(!stack.isEmpty()){
            return "NO";
        }
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
                String s = scan.nextLine();

                String result = Result.isBalanced(s);

                System.out.println(result);
        });

        scan.close();
    }
}
