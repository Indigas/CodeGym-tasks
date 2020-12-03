package com.codegym.task.task22.task2210;

/* 
StringTokenizer

*/

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        List<String> vysledok = new ArrayList<>();

        while(st.hasMoreTokens()){
            vysledok.add(st.nextToken());
        }

        return vysledok.toArray(new String[0]);
    }
}
