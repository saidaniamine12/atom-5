/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thevpc.gaming.atom.examples.pong.hello.presentation.controller;

import net.thevpc.gaming.atom.examples.pong.hello.model.WelcomeModel;
import net.thevpc.gaming.atom.examples.pong.main.client.engine.MainEngineClient;
import net.thevpc.gaming.atom.examples.pong.main.server.engine.MainEngineServer;
import net.thevpc.gaming.atom.examples.pong.main.shared.model.AppRole;
import net.thevpc.gaming.atom.examples.pong.main.shared.model.AppTransport;
import net.thevpc.gaming.atom.engine.GameEngine;
import net.thevpc.gaming.atom.presentation.DefaultSceneController;
import net.thevpc.gaming.atom.presentation.SceneKeyEvent;

/**
 * @author Taha Ben Salah (taha.bensalah@gmail.com)
 */
public class WelcomeController extends DefaultSceneController {


    public WelcomeController() {
    }

    @Override
    public void keyPressed(SceneKeyEvent e) {
        WelcomeModel model = e.getScene().getSceneEngine().getModel();
        GameEngine game = e.getScene().getGame().getGameEngine();
        switch (e.getKeyCode()) {
            case SPACE: {
                switch (model.getRole()) {
                    case SERVER: {
                        game.setActiveSceneEngine(MainEngineServer.class);
                        break;
                    }
                    case CLIENT: {
                        game.setActiveSceneEngine(MainEngineClient.class);
                        break;
                    }
                }
                break;
            }
            case UP: {
                model.setRole(AppRole.CLIENT);
                break;
            }
            case DOWN: {
                model.setRole(AppRole.SERVER);
                break;
            }
            case F1: {
                model.setTransport(AppTransport.TCP);
                break;
            }
            case F2: {
                model.setTransport(AppTransport.UDP);
                break;
            }
            case F3: {
                model.setTransport(AppTransport.MULTICAST);
                break;
            }
            case F4: {
                model.setTransport(AppTransport.RMI);
                break;
            }
            case F5: {
                model.setTransport(AppTransport.CORBA);
                break;
            }
        }
    }
}
