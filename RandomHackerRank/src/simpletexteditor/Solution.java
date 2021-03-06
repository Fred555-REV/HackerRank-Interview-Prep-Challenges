package simpletexteditor;

import java.io.*;
import java.util.*;

public class Solution {
    public static String output = "";
    public static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //abc
        //
        //xy
        //abc
        //abc
        //abc
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] arr = new String[n];
        for (int j = 0; j < n; j++) {
            arr[j] = scan.nextLine();
        }
//        System.out.println(Arrays.toString(arr));
        for (String arg : arr) {
//            System.out.println(1);
            int length = output.length();
            switch (arg.charAt(0)) {
                case '1':
                    output = output.concat(arg.substring(2));
                    stack.add("1 " + arg.substring(2).length());
                    break;
                case '2':
                    int substringLength = Integer.parseInt(arg.substring(2));
                    stack.add("2 " + output.substring(length-substringLength));
                    output = output.substring(0,length-substringLength);
                    break;
                case '3':
                    System.out.println(output.charAt(Integer.parseInt(arg.substring(2)) - 1));
                    break;
                case '4':
//                    System.out.println(stack);
                    String undoOp = stack.pop();
                    if (undoOp.charAt(0) == '1') {
                        output = output.substring(0,length-Integer.parseInt(undoOp.substring(2)));
                    } else {
                       output = output.concat(undoOp.substring(2));
                    }
                    break;
            }
//            System.out.println(i);
//            System.out.println(output);
        }
        scan.close();
    }

}

/* FIRST ATTEMPT
TEST CASE
8
1 abc
3 3
2 3
1 xy
3 2
4
4
3 1

 */
