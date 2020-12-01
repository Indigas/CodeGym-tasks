package com.codegym.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* 
Sending a GET request via a socket

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://codegym.cc/social.html"));
    }

    public static void getSite(URL url) {
        try{
        Socket socket = new Socket(url.getHost(), url.getDefaultPort());

        OutputStream outputStream = socket.getOutputStream();
        String gg = "GET " + url.getPath();
        outputStream.write(gg.getBytes());
        outputStream.flush();

        InputStream is = socket.getInputStream();

        int byt;

        while((byt = is.read()) != -1){
            System.out.print((char) byt);
        }



        socket.close();
        outputStream.close();
        is.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}