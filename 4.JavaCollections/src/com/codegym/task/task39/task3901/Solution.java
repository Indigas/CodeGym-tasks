package com.codegym.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Unique substrings

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if(s == null || s.equals(""))
            return 0;

        String[] znaky = s.split("");
        List<String> check = new ArrayList<>();
        int maxLength=0;

        for(int i = 0; i< znaky.length; i++){
            check.clear();

            for(int j = i; j<znaky.length; j++)
            if(!check.contains(znaky[j])){
                check.add(znaky[j]);
            } else {
                break;
            }

            if(check.size() > maxLength)
                maxLength = check.size();
        }


        return maxLength;
    }
}
