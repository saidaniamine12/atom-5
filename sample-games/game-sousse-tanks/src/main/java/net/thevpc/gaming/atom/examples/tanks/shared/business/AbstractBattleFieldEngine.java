/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thevpc.gaming.atom.examples.tanks.shared.business;

import net.thevpc.gaming.atom.engine.DefaultSceneEngine;

/**
 *
 * @author vpc
 */
public abstract class AbstractBattleFieldEngine extends DefaultSceneEngine {

    public abstract void rotateLeft(int playerId);

    public abstract void rotateRight(int playerId);

    public abstract void fire(int playerId);
}
