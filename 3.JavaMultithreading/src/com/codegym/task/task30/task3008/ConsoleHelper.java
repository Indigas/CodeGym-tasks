package com.codegym.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        while(true){
            try{
                String message = reader.readLine();

                if(message != null)
                    return message;
            } catch (IOException e){
                System.out.println("An error occurred while trying to enter text. Try again.");
            }
        }
    }

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(readString().trim());
            } catch (NumberFormatException e) {
                writeMessage("An error while trying to enter a number. Try again.");
            }
        }
    }

}
