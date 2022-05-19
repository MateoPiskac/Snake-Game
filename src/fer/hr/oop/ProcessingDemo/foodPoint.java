package fer.hr.oop.ProcessingDemo;

import processing.core.PApplet;

public class foodPoint extends Circle {
    float x, y;
    int radius = 10;
    public foodPoint(PApplet pApplet, float x, float y, int radius) {
        super(pApplet, x, y, radius);
    }
}
