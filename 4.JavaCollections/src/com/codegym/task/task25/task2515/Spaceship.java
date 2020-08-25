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

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {
        this.x += this.dx;

        this.checkBorders(radius*2, Space.game.getWidth()-radius*2, radius*2, Space.game.getHeight()-radius*2);
    }

    public void fire(){
        Rocket rcLeft = new Rocket(this.x-2, this.y);
        Rocket rcRight = new Rocket(this.x+2, this.y);

        Space.game.getRockets().add(rcLeft);
        Space.game.getRockets().add(rcRight);
    }
}
