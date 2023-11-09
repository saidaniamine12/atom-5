package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.model.ViewDimension;
import net.thevpc.gaming.atom.presentation.DefaultScene;
import net.thevpc.gaming.atom.presentation.layers.FillScreenGradientLayer;

import java.awt.*;

public class WelcomeScene extends DefaultScene {

    public WelcomeScene() {
        super("WelcomeScene",new ViewDimension(600, 400));
        setTitle("ENISO :: Pong Welcome");
        addLayer(new FillScreenGradientLayer(Color.DARK_GRAY, 0, 0, Color.BLACK, 0, 1));
        addController(new WelcomeSceneController());
    }

}