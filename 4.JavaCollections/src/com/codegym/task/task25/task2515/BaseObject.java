package com.codegym.task.task25.task2515;

public abstract class BaseObject {
    private double x, y, radius;
    private boolean isAlive;

    public void move(){};
    public void draw(){};

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isAlive = true;
    }

    public void die(){
        isAlive=false;
    }

    public boolean intersects(BaseObject o){
        double distX = this.x - o.getX();
        double distY = this.y - o.getY();
        double dist = Math.abs(distX) + Math.abs(distY);
        if(dist < Math.max(this.radius, o.getRadius()))
            return true;

        return false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
