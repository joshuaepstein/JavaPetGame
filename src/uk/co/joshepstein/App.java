package uk.co.joshepstein;


import org.jdesktop.core.animation.timing.Animator;
import uk.co.joshepstein.ui.Background;
import uk.co.joshepstein.utils.Centered;
import uk.co.joshepstein.utils.ImageHelper;
import uk.co.joshepstein.utils.Pair;
import uk.co.joshepstein.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

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
        ImageHelper.Image image = new ImageHelper.Image("src/resources/logo.png", Centered.width(panel, imageSize.width / 2), Centered.height(panel, imageSize.height / 2), imageSize.width / 2, imageSize.height / 2);
        imageHelper.add(image);

        getImageHelper().drawImages(panel);
    }

    public ImageHelper getImageHelper() {
        return imageHelper;
    }

}
