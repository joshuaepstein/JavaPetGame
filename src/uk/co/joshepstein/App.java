package uk.co.joshepstein;


import uk.co.joshepstein.ui.screen.IScreen;
import uk.co.joshepstein.ui.screen.LoadingScreen;
import uk.co.joshepstein.utils.ImageHelper;
import uk.co.joshepstein.utils.Pair;
import uk.co.joshepstein.utils.SwingUtils;

import javax.swing.*;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class App {

    private long ticks = 0L;
    private final int width = 1920/2;
    private final int height = 1080/2;
    private JFrame root;
    private JPanel panel;

    private static ImageHelper imageHelper = new ImageHelper();
    private Queue<IScreen> screens = new java.util.LinkedList<>();

    public static void main(String[] args) throws Exception {
        new App();
    }

    public App() {
        Pair<JFrame, JPanel> setup = SwingUtils.setup(root, panel);
        root = setup.first();
        panel = setup.second();

        screens.add(new LoadingScreen());
        screens.add(new LoadingScreen());
        screens.add(new LoadingScreen());
        screens.add(new LoadingScreen());

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

}
