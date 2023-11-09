package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.annotations.*;
import net.thevpc.gaming.atom.debug.AdjustViewController;
import net.thevpc.gaming.atom.debug.DebugLayer;
import net.thevpc.gaming.atom.engine.DefaultSceneEngine;
import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.engine.SpriteFilter;
import net.thevpc.gaming.atom.engine.SpritesByName;
import net.thevpc.gaming.atom.engine.maintasks.MoveToPointSpriteMainTask;
import net.thevpc.gaming.atom.model.*;
import net.thevpc.gaming.atom.model.Point;
import net.thevpc.gaming.atom.presentation.*;
import net.thevpc.gaming.atom.presentation.components.SLabel;
import net.thevpc.gaming.atom.presentation.layers.Layers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * Created by vpc on 9/23/16.
 */
@AtomScene(
        id = "hello",
        title = "Hello World",
        tileWidth = 50,
        tileHeight = 50

)
@AtomSceneEngine(
        id="hello",
        columns = 10,
        rows = 10,
        fps = 25
)
public class HelloWorldScene extends DefaultSceneEngine {

    @Inject
    private Scene scene;
    @Inject
    private SceneEngine sceneEngine;

    @OnSceneStarted
    private void init() {

        scene.addLayer(Layers.fillBoardImage("/naruto.jpg"));
        scene.addLayer(Layers.fillScreen(Color.CYAN));
        scene.addLayer(Layers.debug());
        JFrame frame = new JFrame("Hello World");

        scene.addController(new SpriteController2(SpriteFilter.byName("Ball1")).setArrowKeysLayout());

        scene.addController(new SpriteController2(SpriteFilter.byName("Ball2")).setESDFLayout());
        scene.addController(new AdjustViewController());
        scene.addComponent(
                new SLabel("Click CTRL-D to switch debug mode, use Arrows to move the ball")
                .setLocation(Point.ratio(0.5f,0.5f))
        );
        scene.addComponent(
                new SLabel("   vies:" + aChaqueTic())
                        .setLocation(Point.ratio(0.0f,0.0f))
        );

        scene.setSpriteView(SpriteFilter.byName("Ball1"), new ImageSpriteView("/pngegg.png", 4, 4));
        //scene.setSpriteView(SpriteFilter.byName("Ball2"), new ImageSpriteView("/ball.png", 8, 4));
        scene.setSpriteView(SpriteFilter.byName("Ball2"), new DefaultSpriteView() {
            @Override
            public void draw(SpriteDrawingContext context) {
                Graphics2D graphics = context.getGraphics();
                Shape spriteShape = context.getSpriteShape();
                graphics.setColor(Color.MAGENTA);
                graphics.fill(spriteShape);
            }
        });

        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("X = " + e.getX() + " Y = " + e.getY());
                MoveToPointSpriteMainTask moveToPointSpriteMainTask = new MoveToPointSpriteMainTask(new ModelPoint(e.getX(), e.getY()), 0.2, true);
                moveToPointSpriteMainTask.nextFrame(sceneEngine, sceneEngine.getSprites().get(0));
            }
        };

        scene.toComponent().addMouseListener(adapter);


    }


    @OnNextFrame
    public int  aChaqueTic(){
        SpritesByName spritesByName = new SpritesByName("Ball1");
        List<Sprite> spriteList = spritesByName.find(sceneEngine);
        return spriteList.get(0).getLife();

    }

}
