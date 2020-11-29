package com.codegym.task.task39.task3905;

/* 
Fill 'er up

*/

public class Solution {
    static Color[][] ab =
    {
        {
            Color.RED, Color.GREEN, Color.GREEN, Color.GREEN, Color.RED
        },
        {
            Color.RED, Color.GREEN, Color.GREEN, Color.GREEN, Color.RED
        },
        {
            Color.RED, Color.GREEN, Color.GREEN, Color.GREEN, Color.RED
        }
    };
    public static void main(String[] args) {
        PhotoPaint pp = new PhotoPaint();
        pp.printImage(ab);
    }
}
