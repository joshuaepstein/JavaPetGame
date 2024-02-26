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

	public void addImage(String resourceLocation, int x, int y, int width, int height) {
		images.add(new Image(resourceLocation, x, y, width, height));
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

	public void add(Image image) {
		images.add(image);
	}

	public record Image(JPanel panel, String resourceLocation, int x, int y, int width, int height) {
	}

	public void repaint(Image image) {
		images.remove(image);
		images.add(image);

	}

}
