package com.codegym.task.task25.task2515;

public class Bomb extends BaseObject{

    public Bomb(double x, double y) {
        super(x, y, 1);
    }

    @Override
    public void move() {
        this.y++;
    }

    @Override
    public void draw(Canvas canvas){
        canvas.setPoint(this.x, this.y, 'B');
    }


}
