/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thevpc.gaming.atom.engine.maze;

/**
 * Tile Decorator called by Maze Generator to decorate generated Tiles
 *
 * @author Taha Ben Salah (taha.bensalah@gmail.com)
 */
public interface MazeTypeDecorator {
    public int decorate(int tileX,int tileY, boolean obstacle);
}
