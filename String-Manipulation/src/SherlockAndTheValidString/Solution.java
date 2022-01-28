package SherlockAndTheValidString;

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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        Map<Character,Integer> charFreq = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char letter = s.charAt(i);
            if(charFreq.containsKey(letter)){
                charFreq.put(letter,(1+charFreq.get(letter)));
            }else{
                charFreq.put(letter,1);
            }
        }
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(Character key:charFreq.keySet()){
            int amount = charFreq.get(key);
            if(freqMap.containsKey(amount)){
                freqMap.put(amount,(1+freqMap.get(amount)));
            }else {
                freqMap.put(amount,1);
            }
        }
        if(freqMap.size()>2){
            return "NO";
        }else if(freqMap.size()==1){
            return "YES";
        }
        int changeable = 0;
        int prevNum = -1;
        for(int key:freqMap.keySet()){

            if(prevNum==-1){
                prevNum = key;
            } else {
                if(Math.abs(key-prevNum) > 1){
                    return "NO";
                }
            }

            if(freqMap.get(key)>1){
                changeable++;
            }
        }
        if(changeable>1){
            return "NO";
        }

        return "YES";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
