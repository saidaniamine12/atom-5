/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thevpc.gaming.atom.engine.collisiontasks;

import net.thevpc.gaming.atom.model.CollisionSides;
import net.thevpc.gaming.atom.model.ModelPoint;
import net.thevpc.gaming.atom.model.Tile;
import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.model.Sprite;

/**
 * Object that store Collision info between the sprite and a Wall Tile (getWall()!=Tile.NO_WALLS)
 *
 * @author Taha Ben Salah (taha.bensalah@gmail.com)
 */
public class TileCollision extends Collision {

    private Tile tile;
    private CollisionSides tileCollisionSides;

    public TileCollision(SceneEngine engine, Tile tile, CollisionSides tileCollisionSides, Sprite sprite, CollisionSides spriteCollisionSides, ModelPoint lastValidPosition, ModelPoint nextValidPosition) {
        super(engine, sprite, spriteCollisionSides, lastValidPosition, nextValidPosition);
        this.tile = tile;
        this.tileCollisionSides = tileCollisionSides;
    }

    public Tile getTile() {
        return tile;
    }

    public CollisionSides getTileCollisionSides() {
        return tileCollisionSides;
    }

    @Override
    public String toString() {
        return "TileCollision{" + "sprite=" + getSprite() + "::" + getSpriteCollisionSides()
                + ", location=" + getLastValidPosition()
                + " => " + getSprite().getLocation()
                + " => " + getNextValidLocation()
                + ", tile=" + tile + "::" + tileCollisionSides + '}';
    }
}
