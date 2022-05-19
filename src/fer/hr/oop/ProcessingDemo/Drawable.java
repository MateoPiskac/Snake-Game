package fer.hr.oop.ProcessingDemo;

import processing.core.PApplet;

public abstract class Drawable {
    PApplet pApplet;

    public Drawable(PApplet pApplet){
        this.pApplet=pApplet;
    }

    public abstract void drawSelf();

}
