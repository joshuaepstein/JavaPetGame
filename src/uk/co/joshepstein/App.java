package uk.co.joshepstein;


import org.pushingpixels.radiance.animation.api.Timeline;
import uk.co.joshepstein.ui.Background;
import uk.co.joshepstein.ui.components.animated.LogoAnimation;
import uk.co.joshepstein.utils.Centered;
import uk.co.joshepstein.utils.ImageHelper;
import uk.co.joshepstein.utils.Pair;
import uk.co.joshepstein.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class App {

    private final int width = 1920/2;
    private final int height = 1080/2;
    private JFrame root;
    private JPanel panel;

    private ImageHelper imageHelper;

    public static void main(String[] args) throws Exception {
        new App();
    }

    public App() {
        this.imageHelper = new ImageHelper();

        Pair<JFrame, JPanel> setup = SwingUtils.setup(root, panel);
        root = setup.first();
        panel = setup.second();

        new Background("src/resources/sky.png").paintComponent(panel.getGraphics());

        Dimension imageSize = ImageHelper.getImageSize("src/resources/logo.png");
        JPanel logoPanel = new JPanel();
        logoPanel.setBounds(Centered.width(panel, imageSize.width / 2), Centered.height(panel, imageSize.height / 2), imageSize.width / 2, imageSize.height / 2);
        logoPanel.setVisible(true);
        logoPanel.setOpaque(true);

        panel.add(logoPanel);
        LogoAnimation logo = new LogoAnimation();
        ImageIcon logoIcon = new ImageIcon("src/resources/logo.png");

        Timeline logoAnimation = Timeline.builder(logo)
                .addPropertyToInterpolate("opacity", 0f, 1f)
                .addPropertyToInterpolate("scale", 0.2f, 0.7f)
                .setDuration(3000)
                .build();

        logoAnimation.play();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (logoAnimation.isDone()) {
                    timer.cancel();
                }
                float opacity = logo.getOpacity();
                float scale = logo.getScale();
                int width = (int) ((logoIcon.getIconWidth() / 2) * scale);
                int height = (int) ((logoIcon.getIconHeight() / 2) * scale);
                ImageHelper.Image image = new ImageHelper.Image(logoPanel, "src/resources/logo.png", Centered.width(logoPanel, width), Centered.height(logoPanel, height), width, height);
                imageHelper.drawImage(image, opacity);
            }
        }, 0, 10);

        getImageHelper().drawImages();
    }

    public ImageHelper getImageHelper() {
        return imageHelper;
    }

}
