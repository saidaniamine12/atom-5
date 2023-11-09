package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.engine.GameEngine;
import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.presentation.DefaultSceneController;
import net.thevpc.gaming.atom.presentation.KeyCode;
import net.thevpc.gaming.atom.presentation.KeyCodeSet;
import net.thevpc.gaming.atom.presentation.SceneKeyEvent;

import java.util.Objects;

public class WelcomeSceneController extends DefaultSceneController{


    public WelcomeSceneController() {

    }

    @Override
    public void keyPressed(SceneKeyEvent e) {
        WelcomeSceneEngineModel model = e.getScene().getSceneEngine().getModel();
        GameEngine game = e.getScene().getGame().getGameEngine();
        if (Objects.requireNonNull(e.getKeyCode()) == KeyCode.SPACE) {
            game.setActiveSceneEngine(HelloWorldScene.class);

            }
        }
}

