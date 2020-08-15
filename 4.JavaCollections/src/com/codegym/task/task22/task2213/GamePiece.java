package com.codegym.task.task22.task2213;

import java.util.Arrays;

public class GamePiece {
    private int x;
    private int y;
    private int[][] matrix;

    public GamePiece(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    void left(){
        x--;
        if(!isCurrentPositionAvailable())
            x++;
        /*
        boolean canMove = true;

        for(int i = 0; i<3; i++){
            if(matrix[i][0]==1 && x==0)
                canMove=false;

        }

        if (canMove){
            if(x-1 >= 0)
                x--;
            else{
                int[][] copyOfMatrix = new int[3][3];
                for(int i = 0; i<3;i++)
                   copyOfMatrix[i][2]=0;

                for(int i=0;i<3;i++)
                    for(int j=0;j<2;j++)
                    copyOfMatrix[i][j] = matrix[i][j+1];


                for(int i=0;i<3;i++)
                    matrix[i] = Arrays.copyOf(copyOfMatrix[i], copyOfMatrix[i].length);
            }
        }*/



    }

    void right(){
        x++;
        if(!isCurrentPositionAvailable())
            x--;
        /*
        boolean canMove = true;

        if (x + 3 < boundaryRight) {
            x++;
            canMove=false;
        } else {
        for (int i = 0; i < 3; i++) {
            if (matrix[i][2] == 1)
                canMove = false;
        }}


        if(canMove) {

                int[][] copyOfMatrix = new int[3][3];
                for (int i = 0; i < 3; i++)
                    copyOfMatrix[i][0] = 0;

                for (int i = 0; i < 3; i++)
                    for (int j = 1; j < 3; j++)
                        copyOfMatrix[i][j] = matrix[i][j - 1];


                for (int i = 0; i < 3; i++)
                    matrix[i] = Arrays.copyOf(copyOfMatrix[i], copyOfMatrix[i].length);
            }*/


    }

    void down(){
        ++this.y;
    }

    void up(){
        --this.y;
    }

    void rotate(){

    }

    void downMaximum(){

    }

    boolean isCurrentPositionAvailable(/*int[][] fieldMatrix*/){
       /* for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if(matrix[i][j]==1)
                    if(y+i < fieldMatrix.length) {
                        if (fieldMatrix[y + i][x + j] == 1) {
                            return false;
                        }
                    } else
                        return false;
            }*/

        return true;
    }

    void land(/*Field field*/){
        // field.matrix sa neupdatuje vo fielde - update tu ak je land
        // matrix reprezentuje uz to co je pevne a nemenne
       /* for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){
                if(matrix[i][j]==1)
                    field.setValue(x+j, y+i, matrix[i][j]);
            }*/
    }
}
