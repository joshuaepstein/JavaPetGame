package uk.co.joshepstein.ui;

import javax.swing.*;
import java.awt.*;

public class EmptyPanel extends JPanel{

    private static final long serialVersionUID = 1L;

    public EmptyPanel() {
        super();
        init();
    }

    @Override
    public boolean isOptimizedDrawingEnabled() {
        return false;
    }


    public void init(){
        LayoutManager overlay = new OverlayLayout(this);
        this.setLayout(overlay);

        ImagePanel iPanel = new ImagePanel(new IconToImage(new ImageIcon("src/resources/sky.png")).getImage());
        iPanel.setLayout(new BorderLayout());
        this.add(iPanel);
        iPanel.setOpaque(false);
    }
}