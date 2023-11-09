package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.engine.DefaultSceneEngine;
import net.thevpc.gaming.atom.presentation.DefaultScene;

public class WelcomeEngine extends DefaultSceneEngine {

    public WelcomeEngine() {
        setModel(new WelcomeModel());
    }
}
