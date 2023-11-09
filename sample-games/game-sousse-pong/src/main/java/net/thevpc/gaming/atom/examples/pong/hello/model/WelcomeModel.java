/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.thevpc.gaming.atom.examples.pong.hello.model;

import net.thevpc.gaming.atom.examples.pong.main.shared.model.AppRole;
import net.thevpc.gaming.atom.examples.pong.main.shared.model.AppTransport;
import net.thevpc.gaming.atom.model.DefaultSceneEngineModel;

/**
 * @author Taha Ben Salah (taha.bensalah@gmail.com)
 */
public class WelcomeModel extends DefaultSceneEngineModel {

    private AppRole role = AppRole.SERVER;
    private AppTransport transport = AppTransport.TCP;

    public WelcomeModel() {
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }

    public AppTransport getTransport() {
        return transport;
    }

    public void setTransport(AppTransport transport) {
        this.transport = transport;
    }
}
