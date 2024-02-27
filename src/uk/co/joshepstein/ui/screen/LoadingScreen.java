/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.ui.screen;

import org.pushingpixels.radiance.animation.api.Timeline;
import uk.co.joshepstein.App;
import uk.co.joshepstein.ui.Background;
import uk.co.joshepstein.ui.components.animated.LogoAnimation;
import uk.co.joshepstein.utils.Centered;
import uk.co.joshepstein.utils.ImageHelper;

import javax.swing.*;
import java.awt.*;
public class LoadingScreen extends Screen {

	JPanel logoPanel = new JPanel();
	LogoAnimation logo = new LogoAnimation();
	ImageIcon logoIcon = new ImageIcon("src/resources/logo.png");
	JLabel logoLabel = new JLabel(logoIcon);
	Timeline logoAnimation = Timeline.builder(logo)
			.addPropertyToInterpolate("opacity", 0f, 1f)
			.addPropertyToInterpolate("scale", 0.2f, 0.7f)
			.setDuration(3000)
			.build();
	private long additionalWaitingTick = 0l;
	public static long additionalWaitingTicks = 120l;

	public LoadingScreen() {
		super("Loading Screen");
	}

	@Override
	public void onOpen(JFrame frame, JPanel rootPanel) {
		super.onOpen(frame, rootPanel);
		System.out.println("Loading Screen Opened");
	}

	@Override
	public void onClose() {
		super.onClose();
		System.out.println("Loading Screen Closed");
	}

	@Override
	public void onTick(long ticks, JFrame frame, JPanel rootPanel) {
		if (logoAnimation.isDone() && this.additionalWaitingTick == 0l) {
			this.additionalWaitingTick = ticks;
		}
		if (this.logoAnimation.isDone() && ticks - this.additionalWaitingTick >= additionalWaitingTicks) {
			this.onClose();
			return;
		}
		float opacity = logo.getOpacity();
		float scale = logo.getScale();
		int width = (int) ((logoIcon.getIconWidth() / 2) * scale);
		int height = (int) ((logoIcon.getIconHeight() / 2) * scale);
		ImageHelper.Image image = new ImageHelper.Image(logoPanel, "src/resources/logo.png", Centered.width(logoPanel, width), Centered.height(logoPanel, height), width, height);
		App.getImageHelper().drawImage(image, opacity);
//		Dimension imageSize = ImageHelper.getImageSize("src/resources/logo.png");
//		logoPanel.setBounds(Centered.width(rootPanel, imageSize.width / 2), Centered.height(rootPanel, imageSize.height / 2), imageSize.width / 2, imageSize.height / 2);
//		logoPanel.setVisible(true);
//		// make sure the new size is not smaller than the size its currently at
//		// if it is then we want to do nothing
//		int currentLogoLabelWidth = logoLabel.getIcon().getIconWidth();
//		int currentLogoLabelHeight = logoLabel.getIcon().getIconHeight();
//		int newLogoLabelWidth = (int) ((imageSize.getWidth() / 2) * logo.getScale());
//		int newLogoLabelHeight = (int) ((imageSize.getHeight() / 2) * logo.getScale());
//		if (newLogoLabelWidth >= currentLogoLabelWidth || newLogoLabelHeight >= currentLogoLabelHeight) {
//			logoLabel.setBounds(Centered.width(logoPanel, newLogoLabelWidth), Centered.height(logoPanel, newLogoLabelHeight), newLogoLabelWidth, newLogoLabelHeight);
//			logoLabel.setIcon(new ImageIcon(logoIcon.getImage().getScaledInstance((int) ((logoIcon.getIconWidth() / 2) * logo.getScale()), (int) ((logoIcon.getIconHeight() / 2) * logo.getScale()), Image.SCALE_SMOOTH)));
//		}

	}

	@Override
	public void display(JFrame frame, JPanel rootPanel) {
		new Background("src/resources/sky.png").paintComponent(rootPanel.getGraphics());

		Dimension imageSize = ImageHelper.getImageSize("src/resources/logo.png");
		logoPanel.setBounds(Centered.width(rootPanel, imageSize.width / 2), Centered.height(rootPanel, imageSize.height / 2), imageSize.width / 2, imageSize.height / 2);
		// Make logoPanel have an invisible background instead of gray
		logoPanel.setOpaque(false);
		logoPanel.setVisible(true);
		logoPanel.setLayout(null);
		logoPanel.repaint();

		rootPanel.add(logoPanel);

//		logoLabel.setBounds(Centered.width(logoPanel, imageSize.width / 2), Centered.height(logoPanel, imageSize.height / 2), imageSize.width / 2, imageSize.height / 2);
//		logoLabel.setIcon(new ImageIcon(logoIcon.getImage().getScaledInstance((int) ((logoIcon.getIconWidth() / 2) * logo.getScale()), (int) ((logoIcon.getIconHeight() / 2) * logo.getScale()), Image.SCALE_SMOOTH)));
//		logoPanel.add(logoLabel);

		logoAnimation.play();
	}
}
