package comparatorSorting;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //My fave ... comparing
        Scanner scan = new Scanner(System.in);
        List<Object> data = new ArrayList();
        //enter amount of players
        int n = Integer.parseInt(scan.nextLine());

        for(int i = 0; i < n ;i++){
            String input = scan.nextLine();
            String[] inputSplit = input.split(" ");
            String name = inputSplit[0];
            int score = Integer.parseInt(inputSplit[1]);
            data.add(List.of(name,score));
        }


    }
}
