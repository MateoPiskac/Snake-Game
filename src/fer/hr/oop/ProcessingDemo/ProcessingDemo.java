package fer.hr.oop.ProcessingDemo;

import processing.core.PApplet;
import processing.core.PShapeSVG;
import processing.core.PVector;

import java.util.LinkedList;
import java.util.ArrayList;

public class ProcessingDemo extends PApplet {
    private LinkedList<Drawable> drawables;
    private LinkedList<IPhysicsObject> physicsObjects;
    private ArrayList<TrackingBall> trackingBalls;
    private double lastFrameTime = 0;
    private double currentFrameTime = 0;
    PVector mouseVector = new PVector();
    private int r = 0, g = 0, b = 0, lastColor = 0;

    @Override
    public void settings() {
        size(800, 600);

    }

    @Override
    public void setup() {
        background(155);
        drawables = new LinkedList<Drawable>();
        physicsObjects = new LinkedList<IPhysicsObject>();
        trackingBalls = new ArrayList<TrackingBall>();
        frameRate(120);
    }

    @Override
    public void draw() {
        elapsedTime();
        background(144, 254, 234);
        chromaColorChange();        //dynamic body color change
        for (Drawable d : drawables) {
            d.drawSelf();
        }
        if (trackingBalls.size() > 0) { //draws the body
            PVector positionTrackerVector = trackingBalls.get(0).drawFollowingFirstSelf(mouseX, mouseY);

            for (int i = 1; i < trackingBalls.size(); i++) {
                TrackingBall t = trackingBalls.get(i);

                positionTrackerVector = t.drawFollowingSelf(positionTrackerVector);
            }
        }

        for (IPhysicsObject p : physicsObjects) {
            p.updateAndDrawSelf(getDeltaTime());
        }
    }

    @Override
    public void mousePressed() {
        if (mouseButton == LEFT) {
            if (trackingBalls.size() == 0) {
                trackingBalls.add(new TrackingBall(this, mouseX, mouseY, 10));
            } else {
                trackingBalls.add(new TrackingBall(this, trackingBalls.get(trackingBalls.size() - 1).x, trackingBalls.get(trackingBalls.size() - 1).y, 10));
            }
        }
        if (mouseButton == RIGHT) {
            physicsObjects.add(new Box(this, mouseX, mouseY, 45, 65));
        }
    }

    private void elapsedTime() {
        lastFrameTime = currentFrameTime;
        currentFrameTime = millis();

    }

    public double getDeltaTime() {
        return ((currentFrameTime - lastFrameTime) / 1000.0);
    }
    void chromaColorChange(){
        if(r<255 && lastColor==2){
            r++;
            b--;
            if(r==255) {
                lastColor=0;
            }
        }
        if(r<=255 && lastColor==0 && g<255){
            r--;
            g++;
            if(g==255)
                lastColor=1;
        }
        if(g<=255 && lastColor==1 && b<255){
            g--;
            b++;
            if(b==255)
                lastColor=2;
        }
        fill(r,g,b);
    }
}
