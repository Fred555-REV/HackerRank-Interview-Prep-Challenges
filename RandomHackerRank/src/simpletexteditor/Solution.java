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
        for (int i = 0; i < arr.length; i++) {
//            System.out.println(1);
            String arg = arr[i];
            char op = arg.charAt(0);
            // String input = arg.substring(2);
            switch (op) {
                case '1':
//                    output.append(arg.substring(2));
                    output+=arg.substring(2);
                    stack.add("1 "+arg.substring(2).length());
                    break;
                case '2':
                    String deletedString = output.substring(output.length()-arg.substring(2).length());
                    output.replace(deletedString,"");
                    stack.add("2 "+deletedString);
                    break;
                case '3':
                    System.out.println(output.charAt(Integer.parseInt(arg.substring(2)) - 1));
                    break;
                case '4':
                    undo();
                    break;
            }
//            System.out.println(i);
//            System.out.println(output.toString());
        }
        scan.close();
    }

//    public static void append(String s) {
//        output.append(s);
//        stack.add("1 "+s.length());
//    }
//
//    public static void delete(int start) {
//        String deletedString = output.substring(output.length() - start, output.length());
//        output.delete(output.length() - start, output.length());
//        stack.add("2 "+deletedString);
//    }

    public static void undo() {
//        System.out.println(stack);
        String arg = stack.pop();
        if (arg.charAt(0)=='1') {
            output = output.substring(0,output.length() -Integer.parseInt(arg.substring(2)));
        } else {
            output+=(arg.substring(2));
        }
//        System.out.println(stack);
    }

}
/* FIRST ATTEMPT


 */
