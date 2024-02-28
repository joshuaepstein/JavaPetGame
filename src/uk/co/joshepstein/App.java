package uk.co.joshepstein;


import uk.co.joshepstein.pets.Tier1Pets;
import uk.co.joshepstein.pets.basic.Pet;
import uk.co.joshepstein.pets.tier1.Ant;
import uk.co.joshepstein.ui.screen.LoadingScreen;
import uk.co.joshepstein.ui.screen.StoreScreen;
import uk.co.joshepstein.ui.screen.impl.IScreen;
import uk.co.joshepstein.utils.ImageHelper;
import uk.co.joshepstein.utils.Pair;
import uk.co.joshepstein.utils.SwingUtils;

import javax.swing.*;
import java.util.Timer;
import java.util.*;

public class App {

    private long ticks = 0L;
    private final int width = 1920/2;
    private final int height = 1080/2;
    private JFrame root;
    private JPanel panel;

    private static ImageHelper imageHelper = new ImageHelper();
    private static Queue<IScreen> screens = new java.util.LinkedList<>();
    private Queue<Pet> pets = new LinkedList<>() {{ add(new Ant()); add(null); add(null); add(null); add(null); }};

    public static void main(String[] args) throws Exception {
        new App();
    }

    public App() {
        Pair<JFrame, JPanel> setup = SwingUtils.setup(root, panel);
        root = setup.first();
        panel = setup.second();

        Tier1Pets.loadAllTextures();

        screens.add(new LoadingScreen());
        screens.add(new StoreScreen(pets));

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (IScreen screen : screens.stream().filter(s -> !s.shouldRemove() && s.isLoaded()).toList()) {
                    if (screen.isLoaded()) screen.onTick(ticks, root, panel);
                }
                if (screens.peek() != null && screens.peek().isLoaded()) {
                    List<IScreen> toRemove = screens.stream().filter(IScreen::shouldRemove).toList();
                    for (IScreen screen : toRemove) {
                        screens.remove(screen);
                    }
                }
                if (screens.peek() != null && !screens.peek().isLoaded()) {
                    App.this.panel.getGraphics().clearRect(0, 0, width, height);
                    panel.removeAll();
                    screens.peek().onOpen(root, panel);
                }
                App.this.ticks++;
            }
        }, 0,  1000 / 60); // 60 FPS

        getImageHelper().drawImages();
    }

    public static ImageHelper getImageHelper() {
        return imageHelper;
    }

    public static Queue<IScreen> getScreens() {
        return screens;
    }

}
