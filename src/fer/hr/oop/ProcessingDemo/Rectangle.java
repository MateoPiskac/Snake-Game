package fer.hr.oop.ProcessingDemo;

import processing.core.PApplet;

public class    Rectangle extends Drawable{
    protected double x,y,width,height;
    public Rectangle(PApplet pApplet, double x, double y, double width, double height){
        super(pApplet);
        this.x=x - width/2;
        this.y=y - height/2;
        this.width=width;
        this.height=height;
    }

    @Override
    public void drawSelf() {
        pApplet.rect((float)x,(float)y,(float)width,(float)height);
    }

}
