package com.codegym.task.task25.task2515;

public class Rocket extends BaseObject {

    public Rocket(double x, double y) {
        super(x, y, 1);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(this.x, this.y, 'R');
    }

    @Override
    public void move() {
        this.y--;
    }
}
