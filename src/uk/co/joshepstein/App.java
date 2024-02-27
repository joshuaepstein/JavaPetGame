package uk.co.joshepstein;


import lombok.Getter;
import org.pushingpixels.radiance.animation.api.Timeline;
import uk.co.joshepstein.ui.Background;
import uk.co.joshepstein.ui.components.animated.LogoAnimation;
import uk.co.joshepstein.ui.screen.IScreen;
import uk.co.joshepstein.ui.screen.LoadingScreen;
import uk.co.joshepstein.ui.screen.Screen;
import uk.co.joshepstein.utils.Centered;
import uk.co.joshepstein.utils.ImageHelper;
import uk.co.joshepstein.utils.Pair;
import uk.co.joshepstein.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class App {

    private long ticks = 0L;
    private final int width = 1920/2;
    private final int height = 1080/2;
    private JFrame root;
    private JPanel panel;

    private static ImageHelper imageHelper = new ImageHelper();
    private List<IScreen> screens = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        new App();
    }

    public App() {
        Pair<JFrame, JPanel> setup = SwingUtils.setup(root, panel);
        root = setup.first();
        panel = setup.second();

        screens.add(new LoadingScreen());

        for (IScreen screen : screens) {
            screen.onOpen(root, panel);
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (IScreen screen : screens) {
                    if (screen.isLoaded()) screen.onTick(0, root, panel);
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
