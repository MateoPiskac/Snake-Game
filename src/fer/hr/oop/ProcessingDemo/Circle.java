package fer.hr.oop.ProcessingDemo;

import processing.core.PApplet;

public class Circle extends Drawable{
    protected double x,y,radius;
    PApplet applet;
    public Circle(PApplet applet, double x, double y, double radius){
        super(applet);
        this.x=x;
        this.y=y;
        this.radius=radius;
    }

    @Override
    public void drawSelf() {
        pApplet.circle((float)x, (float)y, (float) radius);
    }

    public void drawSelf(float x, float y) {
        pApplet.circle(x, y, (float) radius);
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
