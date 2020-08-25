package com.codegym.task.task25.task2515;

public class Spaceship extends BaseObject {
    private double dx = 0d;

    public Spaceship(double x, double y) {
        super(x, y, 3);
    }

    public void moveLeft(){
        this.dx = -1;
    }

    public void moveRight(){
        this.dx = 1;
    }
}
