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
	Timeline logoAnimation = Timeline.builder(logo)
			.addPropertyToInterpolate("opacity", 0f, 1f)
			.addPropertyToInterpolate("scale", 0.2f, 0.7f)
			.setDuration(3000)
			.build();


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

	}

	@Override
	public void onTick(long ticks, JFrame frame, JPanel rootPanel) {
		if (logoAnimation.isDone()) {
			this.onClose();
		}
		float opacity = logo.getOpacity();
		float scale = logo.getScale();
		int width = (int) ((logoIcon.getIconWidth() / 2) * scale);
		int height = (int) ((logoIcon.getIconHeight() / 2) * scale);
		ImageHelper.Image image = new ImageHelper.Image(logoPanel, "src/resources/logo.png", Centered.width(logoPanel, width), Centered.height(logoPanel, height), width, height);
		App.getImageHelper().drawImage(image, opacity);
	}

	@Override
	public void display(JFrame frame, JPanel rootPanel) {
		new Background("src/resources/sky.png").paintComponent(rootPanel.getGraphics());

		Dimension imageSize = ImageHelper.getImageSize("src/resources/logo.png");
		logoPanel.setBounds(Centered.width(rootPanel, imageSize.width / 2), Centered.height(rootPanel, imageSize.height / 2), imageSize.width / 2, imageSize.height / 2);
		logoPanel.setVisible(true);
		logoPanel.setOpaque(true);

		rootPanel.add(logoPanel);

		logoAnimation.play();
	}
}
