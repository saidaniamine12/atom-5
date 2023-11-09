/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thevpc.gaming.atom.engine.maintasks;

import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.model.ModelPoint;
import net.thevpc.gaming.atom.model.ModelVector;
import net.thevpc.gaming.atom.model.Sprite;
import net.thevpc.gaming.atom.util.GeometryUtils;

/**
 * move the sprite according to its own direction and speed
 *
 * @author Taha Ben Salah (taha.bensalah@gmail.com)
 */
public class JumpSpriteMainTask implements MotionSpriteMainTask {

    private double startAngle = 1;
    private boolean moving;
    //    private double mass = 1;
    private double gravity = 0.004;
    //    private double speed = 0;
    private ModelVector velocity;
//    private ModelVector gravity = ModelVector.newCartesien(0, .3);

    public JumpSpriteMainTask(double startAngle) {
        this.startAngle = startAngle;
    }

    @Override
    public boolean isMoving() {
        return moving;
    }

    public boolean nextFrame(SceneEngine scene, Sprite sprite) {
        if (velocity == null) {
            velocity = ModelVector.newAngular(sprite.getSpeed(), startAngle);
        } else {
            velocity = ModelVector.newCartesien(velocity.getX(), velocity.getY() + gravity);
        }
        if (velocity.getAmplitude() != 0) {
//        velocity=velocity.mul(0.9);
            sprite.setDirection(velocity.getDirection());
            ModelPoint stepPoint = GeometryUtils.nextLinePoint(sprite.getLocation(), velocity.getDirection(), velocity.getAmplitude());
            sprite.setLocation(stepPoint);
            moving = sprite.getSpeed() != 0;
            return true;
        }
        moving = false;
        velocity = null;
        return false;
    }

    public ModelPoint[] getMovePath() {
        return null;
    }
}
