package com.codegym.task.task22.task2213;

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

    }

    void right(){

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

    boolean isCurrentPositionAvailable(int[][] fieldMatrix){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (fieldMatrix[y + i][x + j] == 1 &&
                        matrix[i][j] == 1) {
                    //up();
                    return false;
                }
            }

        return true;
    }

    void land(Field field){
        // field.matrix sa neupdatuje vo fielde - update tu ak je land
        // matrix reprezentuje uz to co je pevne a nemenne
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){
                if(matrix[i][j]==1)
                    field.setValue(x+j, y+i, matrix[i][j]);
            }
    }
}
