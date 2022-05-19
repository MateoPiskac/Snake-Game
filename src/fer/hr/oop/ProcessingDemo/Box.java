package fer.hr.oop.ProcessingDemo;

import processing.core.PApplet;

public class Box extends Rectangle implements IPhysicsObject{
    private double velocity=0;
    public Box(PApplet applet, double x, double y, double width, double height) {
        super(applet, x, y, width, height);

    }

    @Override
    public void updateAndDrawSelf(double deltaTime) {
        if(y> pApplet.height-height && velocity>=0){
            //velocity-=45;
            velocity*=-1;
            //velocity=0;
        } else {
            final double GRAVITY = 150.0;
            velocity += GRAVITY * deltaTime;
            y += velocity * deltaTime;
        }

        super.drawSelf();
    }
    }

