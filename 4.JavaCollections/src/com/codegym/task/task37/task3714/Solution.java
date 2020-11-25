package com.codegym.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Ancient Rome

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman numeral to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        try {
            System.out.println("Conversion result: " + romanToInteger(romanString));
        } catch (IllegalArgumentException e){
            System.out.println("Wrong roman numeral.");
        }
    }

    public static int romanToInteger(String s) {
        String[] oneByOne = s.toUpperCase().split("");
        int vysledok=0;
        int position=0;

        for(String b : oneByOne){
            if(decide(oneByOne, position))
                vysledok += AncientRome.valueOf(b).getNumber();
            else
                vysledok -= AncientRome.valueOf(b).getNumber();

            position++;
        }

        return vysledok;
    }

    private static boolean decide(String[] s, int position){
        if(s.length == 1)
            return true;

        int a = AncientRome.valueOf(s[position]).getNumber();
        int b;
        try {
            b = AncientRome.valueOf(s[position + 1]).getNumber();
        } catch (ArrayIndexOutOfBoundsException e){
            return true;
        }

        return a >= b;
    }

    enum AncientRome {
        I (1),
        V (5),
        X (10),
        L (50),
        C (100),
        D (500),
        M (1000);

        private final int hodnota;

        AncientRome(int hodnota) {
            this.hodnota = hodnota;
        }

        int getNumber(){
            return hodnota;
        }
    }
}
