/*
 * Copyright (c) 2024.
 *
 * Joshua Epstein
 */

package uk.co.joshepstein.utils;

import javax.swing.*;
import java.awt.*;

public class SwingUtils {

	public static Pair<JFrame, JPanel> setup(JFrame root, JPanel panelRoot) {
		root = new JFrame();
		root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		root.setSize(1920/2, 1080/2);
		root.setResizable(false);
		root.setTitle("Super Auto Pets 2.0 - Joshua Epstein");
		panelRoot = new JPanel();
		root.add(panelRoot);
		root.setVisible(true);
		showOnScreen(1, root);
		return new Pair<>(root, panelRoot);
	}

	/**
	 * Utility function for when on Home PC as it has 3 screens and the images disappear when moving screens
	 * @param screen Screen number to display on
	 * @param frame Frame to display
	 */
	public static void showOnScreen(int screen, JFrame frame ) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gd = ge.getScreenDevices();
		int width = 0, height = 0;
		if( screen > -1 && screen < gd.length ) {
			width = gd[screen].getDefaultConfiguration().getBounds().width;
			height = gd[screen].getDefaultConfiguration().getBounds().height;
			frame.setLocation(
					((width / 2) - (frame.getSize().width / 2)) + gd[screen].getDefaultConfiguration().getBounds().x,
					((height / 2) - (frame.getSize().height / 2)) + gd[screen].getDefaultConfiguration().getBounds().y
			);
			frame.setVisible(true);
		} else {
			throw new RuntimeException( "No Screens Found" );
		}
	}

}
