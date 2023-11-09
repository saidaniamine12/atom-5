package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.annotations.AtomScene;
import net.thevpc.gaming.atom.annotations.AtomSceneEngine;
import net.thevpc.gaming.atom.annotations.Inject;
import net.thevpc.gaming.atom.annotations.OnSceneStarted;
import net.thevpc.gaming.atom.debug.AdjustViewController;
import net.thevpc.gaming.atom.engine.DefaultSceneEngine;
import net.thevpc.gaming.atom.presentation.Scene;
import net.thevpc.gaming.atom.presentation.layers.Layers;

import java.awt.*;
@AtomScene(
        id = "welcome",
        title = "Welcome Amine",
        tileWidth = 50,
        tileHeight = 50

)
@AtomSceneEngine(
        id="welcome",
        columns = 10,
        rows = 10,
        fps = 1
)
public class WelcomeSceneEngine extends DefaultSceneEngine {
    @Inject
    private Scene scene;

    @OnSceneStarted
    public void init() {
        scene.addLayer(Layers.fillScreen(Color.CYAN));
        scene.addLayer(Layers.fillBoardImage("/welcome.jpg"));
        scene.addLayer(Layers.debug());
        scene.addController(new WelcomeSceneController());

        //click on space to go to the next scene
        //scene.addController(new WelcomeSceneController().setSpace());

        scene.addController(new AdjustViewController());


    }

}
