package fer.hr.oop.ProcessingDemo;

import processing.core.PApplet;
import processing.core.PVector;

public class LeadingBall {
    private float x,y;
    private float easing = 0.1f;
    PVector position;
    PApplet pApplet;

    public PVector drawFollowingFirstSelf(float mouseX, float mouseY) {
        float targetX = mouseX;
        float dx = targetX - x;
        x += dx * easing;
        float targetY = mouseY;
        float dy = targetY - y;
        y += dy * easing;
        pApplet.circle(x, y, 45);
        position.x=x;
        position.y=y;
        return position;
    }




}
