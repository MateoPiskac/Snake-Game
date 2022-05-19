package fer.hr.oop.ProcessingDemo;

import processing.core.PApplet;
import processing.core.PVector;

public class TrackingBall {
    float easing =  0.15f;
    float x,y;
    protected PVector position = new PVector();
    protected Circle circle;

    public TrackingBall(PApplet pApplet, float x, float y, double radius) {
        circle = new Circle(pApplet, x, y, 40);
        this.x = x;
        this.y = y;
    }

    public PVector drawFollowingFirstSelf(float mouseX, float mouseY) {
        return drawFollowingSelf(new PVector(mouseX, mouseY));
    }

    public PVector drawFollowingSelf(PVector positionTracker) {
        float dx = positionTracker.x - x;
        x += dx * easing;
        float dy = positionTracker.y - y;
        y += dy * easing;
        circle.drawSelf(x, y);
        position.x=x;
        position.y=y;
        return position;
    }
}

