/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.ui;

import javax.swing.*;
import java.awt.*;

public class Background extends JComponent {

	private final String resourceLocation;

	public Background(String resourceLocation) {
		this.resourceLocation = resourceLocation;
	}

	@Override
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
		java.awt.Image image = new ImageIcon(resourceLocation).getImage();
		// the image height is 2048 but the height of the window is 1920/2 - so we need to scale it
		g2.scale(0.75, 0.75);
		g2.drawImage(image, 0, 0, this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
}
