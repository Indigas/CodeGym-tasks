package com.codegym.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        Color old=null;
        try {
            old = image[y][x];
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }

        if(old == desiredColor)
            return false;

        changeColor(image, x, y, desiredColor, old);

        return true;
    }

    private void changeColor(Color[][] image, int x, int y, Color desiredColor, Color oldColor){
        try {
            if(oldColor == image[y][x]){
                image[y][x] = desiredColor;
            } else
                return;

        } catch (ArrayIndexOutOfBoundsException e){
            return;
        }

        changeColor(image, x-1, y, desiredColor, oldColor);
        changeColor(image, x+1, y, desiredColor, oldColor);
        changeColor(image, x, y-1, desiredColor, oldColor);
        changeColor(image, x, y+1, desiredColor, oldColor);

    }

    public void printImage(Color[][] image){
        paintFill(image, 2,1,Color.BLUE);

        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[i].length; j++){
                System.out.print(image[i][j]);
                System.out.print(" ");
            }
        System.out.println();}
    }
}
