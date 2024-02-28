package uk.co.joshepstein.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class IconToImage {

    Icon icon;
    Image image;


    public IconToImage(Icon icon) {
        this.icon = icon;
        image = iconToImage();
    }

    public Image iconToImage() {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon)icon).getImage();
        } else {
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            BufferedImage image = gc.createCompatibleImage(w, h);
            Graphics2D g = image.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            return image;
        }
    }


    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }
}
