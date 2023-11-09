package net.thevpc.gaming.helloworld;


import net.thevpc.gaming.atom.Atom;
import net.thevpc.gaming.atom.presentation.Game;

/**
 * Hello world!
 */
public class HelloWorld {

    public static void main(String[] args) {
        Game game = Atom.createGame();

        //game.addScene(new WelcomeScene(), new WelcomeEngine());
        //game.addScene(new DefaultScene(), new HelloWorldScene());
        game.start();
        //create and start the game
    }
}
