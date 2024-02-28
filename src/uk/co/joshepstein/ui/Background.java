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
	private boolean scaleForWidth = false;

	public Background(String resourceLocation) {
		this.resourceLocation = resourceLocation;
	}

	public Background(String resourceLocation, boolean scaleForWidth) {
		this.resourceLocation = resourceLocation;
		this.scaleForWidth = scaleForWidth;
	}

	@Override
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
		java.awt.Image image = new ImageIcon(resourceLocation).getImage();
		if (scaleForWidth) {
					if (image.getWidth(this) > 1920/2) {
			g2.scale(1920/2.0 / image.getWidth(this), 1920/2.0 / image.getWidth(this));
		} else {
			g2.scale((double) image.getWidth(this) / 1920/2.0, (double) image.getWidth(this) / 1920/2.0);
		}
		} else{
			if (image.getHeight(this) > 1080/2) {
				g2.scale(1080/2.0 / image.getHeight(this), 1080/2.0 / image.getHeight(this));
			} else {
				g2.scale((double) image.getHeight(this) / 1080/2.0, (double) image.getHeight(this) / 1080/2.0);
			}
		}

//		g2.drawImage(image, 0, 0, this);
		// draw the image behind all other components
		g2.drawImage(image, 0, 0, this);
		g2.dispose();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
}
