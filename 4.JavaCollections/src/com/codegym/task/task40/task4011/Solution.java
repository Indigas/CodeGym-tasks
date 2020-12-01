package com.codegym.task.task40.task4011;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* 
URL properties

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
    }

    public static void decodeURLString(String s) throws MalformedURLException {

        try{
            URL url = new URL(s);
            //HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("File: " + url.getFile());
            System.out.println("Host: " + url.getHost());
            System.out.println("Path: " + url.getPath());
            System.out.println("Port: " + String.valueOf(url.getPort()));
            System.out.println("Default port: " + String.valueOf(url.getDefaultPort()));
            System.out.println("Query: " + url.getQuery());
            System.out.println("Ref: " + url.getRef());



            //connection.disconnect();

        }catch (MalformedURLException e){
            System.out.println("Parameter " + s + " is not a valid URL.");
        }

    }
}

