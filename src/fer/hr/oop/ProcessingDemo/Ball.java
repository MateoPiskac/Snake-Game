package fer.hr.oop.ProcessingDemo;

import processing.core.PApplet;

public class Ball extends Circle implements IPhysicsObject{
    private double velocity=0;
    public Ball(PApplet applet, double x, double y, double radius) {
        super(applet, x, y, radius);

    }

    @Override
    public void updateAndDrawSelf(double deltaTime) {
        if(y> pApplet.height-radius && velocity>0){
            velocity*=-1;
        }else {

            final double GRAVITY = 150.0;
            velocity += GRAVITY * deltaTime;
            y += velocity * deltaTime;
        }
        super.drawSelf();
    }
}
