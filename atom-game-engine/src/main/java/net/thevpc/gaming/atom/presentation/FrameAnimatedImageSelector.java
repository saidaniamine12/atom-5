package net.thevpc.gaming.atom.presentation;

import net.thevpc.gaming.atom.model.Sprite;

/**
 * Created with IntelliJ IDEA.
 * User: vpc
 * Date: 8/18/13
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class FrameAnimatedImageSelector implements SpriteViewImageSelector {
    public static final SpriteViewImageSelector INSTANCE = new FrameAnimatedImageSelector();

    @Override
    public int getImageIndex(Sprite sprite, Scene scene, long frame, int imagesCount) {
        return (int) (frame % imagesCount);
    }
}
