/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ImageHelper {

	private List<Image> images;
	private static final List<Image> cachedImages = new ArrayList<>();

	public ImageHelper() {
		this.images = new ArrayList<>();
	}

	public static Dimension getImageSize(String s) {
		ImageIcon imageIcon = new ImageIcon(s);
		if (imageIcon.getIconWidth() == -1 || imageIcon.getIconHeight() == -1) {
			throw new IllegalArgumentException("Invalid image: " + s);
		}
		return new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight());
	}

	public void addImage(JPanel panel, String resourceLocation, int x, int y, int width, int height) {
		images.add(new Image(panel, resourceLocation, x, y, width, height));
	}

	public List<Image> getImages() {
		return images;
	}

	public void drawImages() {
		for (Image image : images) {
			if (cachedImages.contains(image)) continue;
			cachedImages.add(image);
			image.panel.getGraphics().drawImage(new ImageIcon(image.resourceLocation).getImage(), image.x, image.y, image.width, image.height, image.panel);
		}
	}

	public void drawImage(Image image) {
		image.panel.getGraphics().drawImage(new ImageIcon(image.resourceLocation).getImage(), image.x, image.y, image.width, image.height, image.panel);
	}

	public void drawImage(Image image, float opacity) {
		Graphics2D g2d = (Graphics2D) image.panel.getGraphics();
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
		g2d.setComposite(ac);
		g2d.drawImage(new ImageIcon(image.resourceLocation).getImage(), image.x, image.y, image.width, image.height, image.panel);
		g2d.dispose();
	}

	public void add(Image image) {
		images.add(image);
	}

	public static class Image {
		public JPanel panel;
		public String resourceLocation;
		public int x;
		public int y;
		public int width;
		public int height;

		public Image(JPanel panel, String resourceLocation, int x, int y, int width, int height) {
			this.panel = panel;
			this.resourceLocation = resourceLocation;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public void setHeight(int height) {
			this.height = height;
		}
	}

	public void repaint(Image image) {
		images.remove(image);
		images.add(image);
	}

	public void remove(Image image) {
		images.remove(image);
		cachedImages.remove(image);
	}

}
