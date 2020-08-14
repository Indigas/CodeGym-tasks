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

    boolean isCurrentPositionAvailable(){
        return true;
    }

    void land(){

    }
}
